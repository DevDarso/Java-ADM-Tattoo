package admtattoo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AgendaDAO {

    public static List<Agenda> listarTodos() {
        List<Agenda> listaAgenda = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT "
                + "    a.idAgenda, "
                + "    a.idCliente, "
                + "    a.data, "
                + "    a.hora, "
                + "    a.sinal, "
                + "    a.status, "
                + "    a.permiteColaborador, "
                + "    ap.idProfissional, "
                + "    ap.tipoServico, "
                + "    ap.papel, "
                + "    c.valor "
                + "FROM "
                + "    agenda a "
                + "JOIN "
                + "    agenda_participantes ap ON a.idAgenda = ap.idAgenda "
                + "LEFT JOIN "
                + "    comissao c ON a.idAgenda = c.idAgenda AND ap.idProfissional = c.idProfissional "
                + "ORDER BY "
                + "    a.data DESC, a.hora, a.idAgenda"; //, ap.papel

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("idAgenda"));
                agenda.setIdCliente(rs.getInt("idCliente"));
                agenda.setDataAgendada(rs.getString("data"));
                agenda.setHorario(rs.getString("hora"));
                agenda.setSinal(rs.getDouble("sinal"));
                agenda.setStatus(rs.getString("status"));
                agenda.setPermiteColaborador(rs.getBoolean("permiteColaborador"));

                Participante p = new Participante();
                p.setIdProfissional(rs.getInt("idProfissional"));
                p.setTipoServico(rs.getString("tipoServico"));
                p.setPapel(rs.getString("papel"));

                Comissao c = new Comissao();
                c.setIdAgenda(rs.getInt("idAgenda"));
                c.setIdProfissional(rs.getInt("idProfissional"));
                c.setValor(rs.getDouble("valor")); // pode ser null

                agenda.setParticipantes(new ArrayList<>(List.of(p)));
                agenda.setComissoes(new ArrayList<>(List.of(c)));

                listaAgenda.add(agenda);

            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar agendas: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }

        return listaAgenda;
    }

    //    Método para iniciar agenda sempre listando os agendados primeiro
    public static List<Agenda> listarAgendados() {
        List<Agenda> lista = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
    SELECT 
        a.idAgenda,
        a.idCliente,
        a.data,
        a.hora,
        a.sinal,
        a.status,
        a.permiteColaborador,
        ap.idProfissional,
        ap.papel,
        ap.tipoServico,
        c.valor,
        c.porcentagem,
        c.total
    FROM agenda a
    JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
    LEFT JOIN comissao c 
        ON a.idAgenda = c.idAgenda 
        AND ap.idProfissional = c.idProfissional
    WHERE a.status = ?
    ORDER BY a.data DESC, a.hora DESC, a.idAgenda DESC
""";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, "Agendado");
            rs = ps.executeQuery();

            while (rs.next()) {

                Agenda ag = new Agenda();
                ag.setId(rs.getInt("idAgenda"));
                ag.setIdCliente(rs.getInt("idCliente"));
                ag.setDataAgendada(rs.getString("data"));
                ag.setHorario(rs.getString("hora"));
                ag.setSinal(rs.getDouble("sinal"));
                ag.setStatus(rs.getString("status"));
                ag.setPermiteColaborador(rs.getBoolean("permiteColaborador"));

                Participante p = new Participante();
                p.setIdAgenda(rs.getInt("idAgenda"));
                p.setIdProfissional(rs.getInt("idProfissional"));
                p.setPapel(rs.getString("papel"));
                p.setTipoServico(rs.getString("tipoServico"));

                Comissao c = new Comissao();
                c.setIdAgenda(rs.getInt("idAgenda"));
                c.setIdProfissional(rs.getInt("idProfissional"));
                c.setValor(rs.getDouble("valor"));
                c.setPorcentagem(rs.getInt("porcentagem"));
                c.setTotal(rs.getDouble("total"));

                // Associar listas (mesmo com 1 item por enquanto)
                ag.setParticipantes(List.of(p));
                ag.setComissoes(List.of(c));

                lista.add(ag);

                System.out.println("Agendamento encontrado: ID = " + ag.getId() + ", Profissional = " + p.getIdProfissional());
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar agendados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return lista;
    }
//Método para listar o último agendamento confirmado na tela InfoAdicional

    public static ArrayList<AgendaDTO> listarUltimoCadastro() {
        ArrayList<AgendaDTO> listaAgenda = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
                SELECT 
                a.idAgenda,
                a.idCliente,
                a.data,
                a.hora,
                ap.idProfissional,
                ap.tipoServico,
                c.valor
            FROM agenda a
            JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
            LEFT JOIN comissao c ON a.idAgenda = c.idAgenda
            WHERE a.idAgenda = (
                SELECT MAX(a2.idAgenda) 
                FROM agenda a2 
                WHERE a2.status = 'Atendido'
            )
            AND a.status = 'Atendido'
            LIMIT 1
        """;

            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("DEBUG - Valor direto do ResultSet: " + rs.getDouble("valor"));
                System.out.println("DEBUG - Tipo do valor: " + rs.getObject("valor").getClass().getName());

                AgendaDTO dto = new AgendaDTO(
                        rs.getInt("idAgenda"),
                        rs.getInt("idCliente"),
                        rs.getInt("idProfissional"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getString("tipoServico"),
                        rs.getDouble("valor")
                );

                System.out.println("DEBUG - Valor no DTO: " + dto.getValor());
                double valor = rs.getDouble("valor");
                if (rs.wasNull()) {
                    System.out.println("AVISO: Valor é NULL no banco de dados");
                    valor = 0.0; // Ou outro valor padrão
                }

                listaAgenda.add(dto);

            }

        } catch (SQLException se) {
            System.err.println("Erro ao listar último agendamento: " + se.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return listaAgenda;
    }
    //Método para listar o último agendamento na tela observação

    public static ArrayList<AgendaDTO> listarUltimoAgendamento() {
        ArrayList<AgendaDTO> listaAgenda = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
                SELECT 
                a.idAgenda,
                a.idCliente,
                a.data,
                a.hora,
                ap.idProfissional,
                ap.tipoServico,
                c.valor
            FROM agenda a
            JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
            LEFT JOIN comissao c ON a.idAgenda = c.idAgenda
            WHERE a.idAgenda = (
                SELECT MAX(a2.idAgenda) 
                FROM agenda a2 
                WHERE a2.status = 'Agendado'
            )
            AND a.status = 'Agendado'
            LIMIT 1
        """;

            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("DEBUG - Valor direto do ResultSet: " + rs.getDouble("valor"));
                System.out.println("DEBUG - Tipo do valor: " + rs.getObject("valor").getClass().getName());

                AgendaDTO dto = new AgendaDTO(
                        rs.getInt("idAgenda"),
                        rs.getInt("idCliente"),
                        rs.getInt("idProfissional"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getString("tipoServico"),
                        rs.getDouble("valor")
                );

                listaAgenda.add(dto);

            }

        } catch (SQLException se) {
            System.err.println("Erro ao listar último agendamento: " + se.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return listaAgenda;
    }
    // agendamento com colaborador

    public static boolean agendar(Agenda a) throws SQLException {
        ConexaoJDBC conn = null;
        PreparedStatement psAgenda = null;
        PreparedStatement psComissao = null;
        PreparedStatement psParticipante = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            conn.getConexao().setAutoCommit(false); // Início da transação

            //Inserir na tabela agenda
            String sqlAgenda = "INSERT INTO agenda (idCliente, data, hora, sinal, status, permiteColaborador) VALUES (?, ?, ?, ?, ?, ?)";
            psAgenda = conn.getConexao().prepareStatement(sqlAgenda, Statement.RETURN_GENERATED_KEYS);
            psAgenda.setInt(1, a.getIdCliente());
            psAgenda.setString(2, a.getDataAgendada());
            psAgenda.setString(3, a.getHorario());
            psAgenda.setDouble(4, a.getSinal());
            psAgenda.setString(5, a.getStatus());
            psAgenda.setBoolean(6, a.isPermiteColaborador());

            int rowsAgenda = psAgenda.executeUpdate();
            if (rowsAgenda == 0) {
                throw new SQLException("Erro ao inserir agenda.");
            }

            //Recuperar o ID da agenda
            int idAgenda;
            try ( ResultSet rs = psAgenda.getGeneratedKeys()) {
                if (rs.next()) {
                    idAgenda = rs.getInt(1);
                } else {
                    throw new SQLException("Erro ao obter ID da agenda.");
                }
            }

            //Inserir os participantes na tabela agenda_participantes
            String sqlParticipante = "INSERT INTO agenda_participantes (idAgenda, idProfissional, papel, tipoServico) VALUES (?, ?, ?, ?)";
            psParticipante = conn.getConexao().prepareStatement(sqlParticipante);

            for (Participante p : a.getParticipantes()) {
                psParticipante.setInt(1, idAgenda);
                psParticipante.setInt(2, p.getIdProfissional());
                psParticipante.setString(3, p.getPapel());
                psParticipante.setString(4, p.getTipoServico());
                psParticipante.addBatch();
            }
            psParticipante.executeBatch();

            //Inserir as comissões na tabela comissao
            String sqlComissao = "INSERT INTO comissao (idAgenda, idProfissional, valor, porcentagem, total, tipoServico) VALUES (?, ?, ?, ?, ?, ?)";
            psComissao = conn.getConexao().prepareStatement(sqlComissao);

            for (Comissao c : a.getComissoes()) {
                psComissao.setInt(1, idAgenda);
                psComissao.setInt(2, c.getIdProfissional());
                psComissao.setDouble(3, c.getValor());
                psComissao.setInt(4, c.getPorcentagem());
                psComissao.setDouble(5, c.getTotal());
                psComissao.setString(6, c.getTipoServico());
                psComissao.addBatch();
            }
            psComissao.executeBatch();

            //Commit
            conn.getConexao().commit();
            return true;

        } catch (SQLException ex) {
            if (conn != null && conn.getConexao() != null) {
                conn.getConexao().rollback();
            }
            System.err.println("Erro ao inserir agenda completa: " + ex.getMessage());
            throw ex;

        } finally {
            try {
                if (psParticipante != null) {
                    psParticipante.close();
                }
                if (psComissao != null) {
                    psComissao.close();
                }
                if (psAgenda != null) {
                    psAgenda.close();
                }
                if (conn != null) {
                    conn.getConexao().setAutoCommit(true);
                    conn.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    // agendar principal sem colaborador
    public static boolean agendarSemColab(Agenda a) throws SQLException {
        ConexaoJDBC conn = null;
        PreparedStatement psAgenda = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            conn.getConexao().setAutoCommit(false); // Início da transação

            // Inserir na tabela agenda
            String sqlAgenda = "INSERT INTO agenda (idCliente, data, hora, sinal, valor, status, permiteColaborador) VALUES (?, ?, ?, ?, ?, ?, ?)";
            psAgenda = conn.getConexao().prepareStatement(sqlAgenda, Statement.RETURN_GENERATED_KEYS);
            psAgenda.setInt(1, a.getIdCliente());
            psAgenda.setString(2, a.getDataAgendada());
            psAgenda.setString(3, a.getHorario());
            psAgenda.setDouble(4, a.getSinal());
            psAgenda.setDouble(5, a.getValor());
            psAgenda.setString(6, a.getStatus());
            psAgenda.setBoolean(7, a.isPermiteColaborador());

            int rowsAgenda = psAgenda.executeUpdate();
            if (rowsAgenda == 0) {
                throw new SQLException("Erro ao inserir agendamento.");
            }

            conn.getConexao().commit();
            return true;

        } catch (SQLException ex) {
            if (conn != null && conn.getConexao() != null) {
                conn.getConexao().rollback();
            }
            System.err.println("Erro ao inserir agenda completa: " + ex.getMessage());
            throw ex;

        } finally {
            try {
                if (psAgenda != null) {
                    psAgenda.close();
                }
                if (conn != null) {
                    conn.getConexao().setAutoCommit(true);
                    conn.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

//    Retorna lista de agendamentos filtrando pelo ID
    public static ArrayList<Agenda> buscarPorFuncionario(int idFuncionario) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Agenda> lista = new ArrayList<>();

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
    SELECT a.idAgenda, a.idCliente, a.data, a.hora, a.sinal, a.status, a.permiteColaborador,
           ap.idProfissional, ap.papel, ap.tipoServico,
           c.valor, c.porcentagem, c.total
    FROM agenda a
    JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
    LEFT JOIN comissao c ON a.idAgenda = c.idAgenda AND ap.idProfissional = c.idProfissional
    WHERE ap.idProfissional = ?
    ORDER BY a.data DESC, a.hora DESC
""";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idFuncionario);
            rs = ps.executeQuery();

            Map<Integer, Agenda> agendaMap = new HashMap<>();

            while (rs.next()) {
                int idAgenda = rs.getInt("idAgenda");
                Agenda agenda = agendaMap.get(idAgenda);

                if (agenda == null) {
                    agenda = new Agenda();
                    agenda.setId(idAgenda);
                    agenda.setIdCliente(rs.getInt("idCliente"));
                    agenda.setDataAgendada(rs.getString("data"));
                    agenda.setHorario(rs.getString("hora"));
                    agenda.setSinal(rs.getDouble("sinal"));
                    agenda.setStatus(rs.getString("status"));
                    agenda.setPermiteColaborador(rs.getBoolean("permiteColaborador"));
                    agendaMap.put(idAgenda, agenda);
                }

                Participante participante = new Participante();
                participante.setIdProfissional(rs.getInt("idProfissional"));
                participante.setPapel(rs.getString("papel"));
                participante.setTipoServico(rs.getString("tipoServico"));
                agenda.adicionarParticipante(participante);

                Comissao comissao = new Comissao();
                comissao.setIdProfissional(rs.getInt("idProfissional"));
                comissao.setValor(rs.getDouble("valor"));
                comissao.setPorcentagem(rs.getInt("porcentagem"));
                comissao.setTotal(rs.getDouble("total"));
                agenda.adicionarComissao(comissao);
            }

            lista.addAll(agendaMap.values());

        } catch (SQLException e) {
            System.err.println("Erro ao buscar agendamentos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return lista;
    }

    public static ArrayList<Agenda> buscarPorCliente(int idCliente) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Agenda> lista = new ArrayList<>();

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = """
            SELECT a.idAgenda, a.idCliente, a.data, a.hora, a.sinal, a.status, a.permiteColaborador,
                   ap.idProfissional, ap.papel, ap.tipoServico,
                   c.valor, c.porcentagem, c.total
            FROM agenda a
            LEFT JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
            LEFT JOIN comissao c ON a.idAgenda = c.idAgenda AND ap.idProfissional = c.idProfissional
            WHERE a.idCliente = ?
            ORDER BY a.data DESC, a.hora DESC, a.idAgenda
        """;

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            Map<Integer, Agenda> mapaAgenda = new LinkedHashMap<>();

            while (rs.next()) {
                int idAgenda = rs.getInt("idAgenda");
                Agenda agenda = mapaAgenda.get(idAgenda);

                if (agenda == null) {
                    agenda = new Agenda();
                    agenda.setId(idAgenda);
                    agenda.setIdCliente(rs.getInt("idCliente"));
                    agenda.setDataAgendada(rs.getString("data"));
                    agenda.setHorario(rs.getString("hora"));
                    agenda.setSinal(rs.getDouble("sinal"));
                    agenda.setStatus(rs.getString("status"));
                    agenda.setPermiteColaborador(rs.getBoolean("permiteColaborador"));

                    mapaAgenda.put(idAgenda, agenda);
                }

                int idProfissional = rs.getInt("idProfissional");
                if (!rs.wasNull()) {
                    Participante participante = new Participante();
                    participante.setIdProfissional(idProfissional);
                    participante.setPapel(rs.getString("papel"));
                    participante.setTipoServico(rs.getString("tipoServico"));

                    agenda.adicionarParticipante(participante);

                    Comissao comissao = new Comissao();
                    comissao.setIdAgenda(idAgenda);
                    comissao.setIdProfissional(idProfissional);
                    comissao.setValor(rs.getDouble("valor"));
                    comissao.setPorcentagem(rs.getInt("porcentagem"));
                    comissao.setTotal(rs.getDouble("total"));

                    agenda.adicionarComissao(comissao);
                }
            }

            lista.addAll(mapaAgenda.values());

        } catch (SQLException e) {
            System.err.println("Erro ao buscar agendamentos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return lista;
    }
//    Retorna apenas um agendamento selecionado

    public static Agenda buscarPorId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Agenda agenda = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = """
            SELECT a.idAgenda, a.idCliente, a.data, a.hora, a.sinal, a.status, a.permiteColaborador,
                   ap.idProfissional, ap.papel, ap.tipoServico,
                   c.valor, c.porcentagem, c.total
            FROM agenda a
            LEFT JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
            LEFT JOIN comissao c ON a.idAgenda = c.idAgenda AND ap.idProfissional = c.idProfissional
            WHERE a.idAgenda = ?
        """;

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (agenda == null) {
                    agenda = new Agenda();
                    agenda.setId(rs.getInt("idAgenda"));
                    agenda.setIdCliente(rs.getInt("idCliente"));
                    agenda.setDataAgendada(rs.getString("data"));
                    agenda.setHorario(rs.getString("hora"));
                    agenda.setSinal(rs.getDouble("sinal"));
                    agenda.setStatus(rs.getString("status"));
                    agenda.setPermiteColaborador(rs.getBoolean("permiteColaborador"));
                }

                int idProfissional = rs.getInt("idProfissional");
                if (!rs.wasNull()) {
                    Participante participante = new Participante();
                    participante.setIdProfissional(idProfissional);
                    participante.setPapel(rs.getString("papel"));
                    participante.setTipoServico(rs.getString("tipoServico"));

                    agenda.adicionarParticipante(participante);

                    Comissao comissao = new Comissao();
                    comissao.setIdAgenda(id);
                    comissao.setIdProfissional(idProfissional);
                    comissao.setValor(rs.getDouble("valor"));
                    comissao.setPorcentagem(rs.getInt("porcentagem"));
                    comissao.setTotal(rs.getDouble("total"));

                    agenda.adicionarComissao(comissao);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar agendamento por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return agenda;
    }
// valida autorização para adicionar colaborador

    public static boolean atualizarFuncionarioExtra(int idAgenda, boolean valor) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "UPDATE agenda SET permiteColaborador = ? WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setBoolean(1, valor);
            ps.setInt(2, idAgenda);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar permiteColaborador: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public static boolean atualizar(Agenda agenda) {
        ConexaoJDBC conexao = null;
        PreparedStatement psAgenda = null;
        PreparedStatement psParticipante = null;
        PreparedStatement psComissao = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            // Atualiza tabela agenda
            String sqlAgenda = "UPDATE agenda SET data = ?, hora = ?, sinal = ?, status = ?, permiteColaborador = ? WHERE idAgenda = ?";
            psAgenda = conexao.getConexao().prepareStatement(sqlAgenda);
            psAgenda.setString(1, agenda.getDataAgendada());
            psAgenda.setString(2, agenda.getHorario());
            psAgenda.setDouble(3, agenda.getSinal());
            psAgenda.setString(4, agenda.getStatus());
            psAgenda.setBoolean(5, agenda.isPermiteColaborador());
//        psAgenda.setInt(6, agenda.getIdFuncionario());
            psAgenda.setInt(6, agenda.getId()); // idAgenda
            psAgenda.executeUpdate();
            System.out.println("Status atualizado no banco com sucesso: " + agenda.getStatus());

// Atualiza agenda_participantes (tipoServico e papel)
            if (agenda.getParticipantes() != null) {
                String sqlParticipante = "UPDATE agenda_participantes SET tipoServico = ?, papel = ? WHERE idAgenda = ? AND idProfissional = ?";
                psParticipante = conexao.getConexao().prepareStatement(sqlParticipante);

                for (Participante p : agenda.getParticipantes()) {
                    psParticipante.setString(1, p.getTipoServico());
                    psParticipante.setString(2, p.getPapel());
                    psParticipante.setInt(3, agenda.getId());
                    psParticipante.setInt(4, p.getIdProfissional());
                    psParticipante.executeUpdate();
                }
            }

            // Atualiza comissao (valor, porcentagem, total)
            if (agenda.getComissoes() != null) {
                String sqlComissao = "UPDATE comissao SET valor = ?, porcentagem = ?, total = ? WHERE idAgenda = ? AND idProfissional = ?";
                psComissao = conexao.getConexao().prepareStatement(sqlComissao);

                for (Comissao c : agenda.getComissoes()) {
                    psComissao.setDouble(1, c.getValor());
                    psComissao.setInt(2, c.getPorcentagem());
                    psComissao.setDouble(3, c.getTotal());
                    psComissao.setInt(4, agenda.getId());
                    psComissao.setInt(5, c.getIdProfissional());
                    psComissao.executeUpdate();
                }
            }

            return true;

        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar agenda: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (psComissao != null) {
                    psComissao.close();
                }
                if (psParticipante != null) {
                    psParticipante.close();
                }
                if (psAgenda != null) {
                    psAgenda.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public Agenda buscarSituacaoPeloId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Agenda agenda = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT status FROM agenda WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                agenda = new Agenda();

                agenda.setStatus(rs.getString("status"));

            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar status pelo ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return agenda;
    }

    public Agenda listarAgenda(boolean porUltimoItem, Integer idEspecifico) throws SQLException {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Agenda agenda = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql;
            if (porUltimoItem) {
                sql = """
                SELECT a.idAgenda, a.idCliente, a.data, a.hora, a.sinal, a.status, a.permiteColaborador,
                       ap.idProfissional, ap.tipoServico, ap.papel,
                       c.valor, c.porcentagem, c.total
                FROM agenda a
                JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
                JOIN comissao c ON a.idAgenda = c.idAgenda AND ap.idProfissional = c.idProfissional
                ORDER BY a.idAgenda DESC
                LIMIT 1
            """;
            } else {
                sql = """
                SELECT a.idAgenda, a.idCliente, a.data, a.hora, a.sinal, a.status, a.permiteColaborador,
                       ap.idProfissional, ap.tipoServico, ap.papel,
                       c.valor, c.porcentagem, c.total
                FROM agenda a
                JOIN agenda_participantes ap ON a.idAgenda = ap.idAgenda
                JOIN comissao c ON a.idAgenda = c.idAgenda AND ap.idProfissional = c.idProfissional
                WHERE a.idAgenda = ?
            """;
            }

            ps = conexao.getConexao().prepareStatement(sql);
            if (!porUltimoItem && idEspecifico != null) {
                ps.setInt(1, idEspecifico);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                if (agenda == null) {
                    agenda = new Agenda();
                    agenda.setId(rs.getInt("idAgenda"));
                    agenda.setIdCliente(rs.getInt("idCliente"));
                    agenda.setDataAgendada(rs.getString("data"));
                    agenda.setHorario(rs.getString("hora"));
                    agenda.setSinal(rs.getDouble("sinal"));
                    agenda.setStatus(rs.getString("status"));
                    agenda.setPermiteColaborador(rs.getBoolean("permiteColaborador"));
                }

                Participante participante = new Participante();
                participante.setIdAgenda(agenda.getId());
                participante.setIdProfissional(rs.getInt("idProfissional"));
                participante.setTipoServico(rs.getString("tipoServico"));
                participante.setPapel(rs.getString("papel"));
                agenda.adicionarParticipante(participante);

                Comissao comissao = new Comissao();
                comissao.setIdAgenda(agenda.getId());
                comissao.setIdProfissional(rs.getInt("idProfissional"));
                comissao.setValor(rs.getDouble("valor"));
                comissao.setPorcentagem(rs.getInt("porcentagem"));
                comissao.setTotal(rs.getDouble("total"));
                agenda.adicionarComissao(comissao);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar agendamento: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return agenda;
    }

// Seleciona o último ID para setar informações em InfoAdicional que abre ao finalizar agendamento.
    public static int buscarUltimoId() {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ultimoId = -1;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT MAX(idAgenda) AS ultimo FROM agenda";
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ultimoId = rs.getInt("ultimo");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar último ID da agenda: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return ultimoId;
    }
// Método para inserir participante na tabela agenda_participantes

    public static boolean inserirParticipante(int idAgenda, int idProfissional, String papel, String tipoServico) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
            INSERT INTO agenda_participantes 
            (idAgenda, idProfissional, papel, tipoServico)
            VALUES (?, ?, ?, ?)
        """;

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            ps.setInt(2, idProfissional);
            ps.setString(3, papel);
            ps.setString(4, tipoServico);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir participante: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
// busca o funcionário para atualizar agenda

    public static int buscarIdFuncionarioPorAgenda(int idAgenda) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idFuncionario = -1;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT idProfissional FROM agenda_participantes WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            rs = ps.executeQuery();

            if (rs.next()) {
                idFuncionario = rs.getInt("idProfissional");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionário do agendamento: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return idFuncionario;
    }

    public static int buscarIdClientePorAgenda(int idAgenda) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idCliente = -1;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT idCliente FROM agenda WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            rs = ps.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente do agendamento: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return idCliente;
    }

    public static boolean atualizarParticipante(int idAgenda, int idProfissional, String tipoServico) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = """
            UPDATE agenda_participantes
            SET tipoServico = ?, idProfissional = ?,
            WHERE idAgenda = ? AND idProfissional = ?""";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipoServico);
            ps.setInt(2, idAgenda);
            ps.setInt(3, idProfissional);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar participante: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
// confirma se o profissional existe no banco de dados

    private static boolean profissionalExiste(int idProfissional, Connection conexao) throws SQLException {
        String sql = "SELECT id FROM cadastro WHERE id = ?";
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idProfissional);
            try ( ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public static Participante carregarParticipante(int idAgenda, int idFuncionario) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Participante p = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = """
            SELECT idAgenda, idProfissional, papel, tipoServico 
            FROM agenda_participantes 
            WHERE idAgenda = ? AND idProfissional = ?
        """;

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            ps.setInt(2, idFuncionario);
            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Participante();
                p.setIdAgenda(rs.getInt("idAgenda"));
                p.setIdProfissional(rs.getInt("idProfissional"));
                p.setPapel(rs.getString("papel"));
                p.setTipoServico(rs.getString("tipoServico"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao carregar participante: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return p;
    }

    public static boolean atualizarFuncionario(int idAgenda, int idNovoProfissional, int idAntigoProfissional, String tipoServico) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "UPDATE agenda_participantes SET idProfissional = ?, tipoServico = ? "
                    + "WHERE idAgenda = ? AND idProfissional = ? AND papel = 'Principal'";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idNovoProfissional);
            ps.setString(2, tipoServico);
            ps.setInt(3, idAgenda);
            ps.setInt(4, idAntigoProfissional); // Agora sim: usa o ID antigo

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar participante principal: " + e.getMessage());
            return false;
        }
    }

    public static boolean participanteExiste(int idAgenda, int idProfissional, String papel) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT 1 FROM agenda_participantes WHERE idAgenda = ? AND idProfissional = ? AND papel = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            ps.setInt(2, idProfissional);
            ps.setString(3, papel);
            rs = ps.executeQuery();
            existe = rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao verificar participante: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ignored) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ignored) {
            }
            if (conexao != null) {
                conexao.desconectar();
            }
        }

        return existe;

    }

    public static void removerParticipantePorTipo(int idAgenda, String tipo) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "DELETE FROM agenda_participantes WHERE idAgenda = ? AND tipoServico = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, idAgenda);
            ps.setString(2, tipo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao remover participante por tipo: " + e.getMessage());
        }
    }

    public static boolean atualizarTipoServico(int idAgenda, int idProfissional, String tipoServico) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "UPDATE agenda_participantes SET tipoServico = ? "
                    + "WHERE idAgenda = ? AND idProfissional = ? AND papel = 'Principal'";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipoServico);
            ps.setInt(2, idAgenda);
            ps.setInt(3, idProfissional);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tipo de serviço: " + e.getMessage());
            return false;
        } finally {
            if (ps != null) try {
                ps.close();
            } catch (SQLException ignore) {
            }
            if (conexao != null) {
                conexao.desconectar();
            }
        }
    }
// método utilizado no botão histórico em cadastro

    public static List<Agenda> buscarAgendamentosPorId(int id, String tipo) {
        if ("Cliente".equalsIgnoreCase(tipo)) {
            return buscarPorCliente(id);
        } else {
            return buscarPorFuncionario(id);
        }
    }

    //  Busca a data mais antiga (menor data) existente na tabela agenda ou null se não houver registros    
    public static LocalDate buscarDataMaisAntiga() {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate dataMaisAntiga = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT MIN(data) AS menor_data FROM agenda";

            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next() && rs.getDate("menor_data") != null) {
                dataMaisAntiga = rs.getDate("menor_data").toLocalDate();
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar data mais antiga: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return dataMaisAntiga;
    }

    // Busca a data mais recente (maior data) existente na tabela agenda ou null se não houver registros
    public static LocalDate buscarDataMaisRecente() {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate dataMaisRecente = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT MAX(data) AS maior_data FROM agenda";

            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next() && rs.getDate("maior_data") != null) {
                dataMaisRecente = rs.getDate("maior_data").toLocalDate();
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar data mais recente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return dataMaisRecente;
    }
}
