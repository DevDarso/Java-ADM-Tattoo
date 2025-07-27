package admtattoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InfoDAO {

    public static boolean adicionarInfo(Informacao i) {
        String sql = "INSERT INTO adicional (idAgenda, sessao, duracao, nota, observacao) VALUES (?, ?, ?, ?, ?)";
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            ps = conn.getConexao().prepareStatement(sql);

            ps.setInt(1, i.getIdAgenda());
            ps.setInt(2, i.getSessao());
            ps.setString(3, i.getDuracao());
            ps.setString(4, i.getNota());
            ps.setString(5, i.getObservacao());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao adicionar informações no banco de dados: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return false;
    }

    public static Informacao buscarInfoPeloId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Informacao informacao = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT idAgenda, sessao, duracao, nota, observacao FROM adicional WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                informacao = new Informacao();

                informacao.setIdAgenda(rs.getInt("idAgenda"));
                informacao.setSessao(rs.getInt("sessao"));
                informacao.setDuracao(rs.getString("duracao"));
                informacao.setNota(rs.getString("nota"));
                informacao.setObservacao(rs.getString("observacao"));

            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar informações por ID: " + e.getMessage());
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
        return informacao;
    }

    public List<Informacao> buscarInfoPeloIdAgenda(int idAgenda) {
        List<Informacao> lista = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Informacao informacao = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT "
                    + "    ag.idAgenda, "
                    + "    ag.idCliente, "
                    + "    ap.idProfissional, "
                    + "    a.sessao, "
                    + "    a.duracao, "
                    + "    a.nota, "
                    + "    a.observacao, "
                    + "    c.nome AS nomeCliente, "
                    + "    f.nome AS nomeFuncionario, "
                    + "    ap.papel AS tipoFuncionario "
                    + " FROM "
                    + "    agenda ag "
                    + " JOIN cadastro c ON ag.idCliente = c.id "
                    + " JOIN agenda_participantes ap ON ag.idAgenda = ap.idAgenda "
                    + " JOIN cadastro f ON ap.idProfissional = f.id "
                    + " JOIN adicional a ON ag.idAgenda = a.idAgenda "
                    + " WHERE ag.idAgenda = ?";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            rs = ps.executeQuery();

            while (rs.next()) {
                Informacao i = new Informacao();
                i.setIdAgenda(rs.getInt("idAgenda"));
                i.setSessao(rs.getInt("sessao"));
                i.setDuracao(rs.getString("duracao"));
                i.setNota(rs.getString("nota"));
                i.setObservacao(rs.getString("observacao"));
                i.setNomeCliente(rs.getString("nomeCliente"));
                i.setNomeFuncionario(rs.getString("nomeFuncionario"));
                i.setTipoFuncionario(rs.getString("tipoFuncionario"));

                lista.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static boolean atualizarInfo(Informacao info) {

        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "UPDATE adicional SET sessao = ?, duracao = ?, nota = ?, observacao = ? WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, info.getSessao());
            ps.setString(2, info.getDuracao());
            ps.setString(3, info.getNota());
            ps.setString(4, info.getObservacao());
            ps.setInt(5, info.getIdAgenda());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar informações: " + ex.getMessage());
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

    public static boolean excluirInfo(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "DELETE FROM adicional WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir informações: " + ex.getMessage());
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

    // Busca o próximo número de sessão para um cliente (começa em 1 se for a primeira sessão)
    public static int buscarProximaSessao(int idCliente) {
        System.out.println("[DEBUG] - ID recebido em InfoDAO: " + idCliente);
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int proximaSessao = 1;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            String sql = """
            SELECT COALESCE(
                (SELECT a.sessao 
                 FROM adicional a
                 WHERE a.idAgenda = (
                     SELECT MAX(ag.idAgenda) 
                     FROM agenda ag
                     WHERE ag.idCliente = ?
                     AND ag.idAgenda < (SELECT MAX(idAgenda) FROM agenda WHERE idCliente = ?)
                 )), 
                0) + 1 AS proximaSessao
            """;

            ps = conn.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setInt(2, idCliente);// Repete o parâmetro para a segunda condição
            rs = ps.executeQuery();

            if (rs.next()) {
                proximaSessao = rs.getInt("proximaSessao");

            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar próxima sessão: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.desconectar();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return proximaSessao;
    }

    public static List<Informacao> buscarInfoPeloIdCliente(int idCliente) {
        List<Informacao> lista = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Informacao informacao = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT "
                    + "    a.idAgenda, "
                    + "    a.data, "
                    + "    a.hora, "
                    + "    cf.nome AS nome_funcionario, "
                    + "    ap.tipoServico, "
                    + "    ad.nota "
                    + "FROM  "
                    + "    agenda a "
                    + "INNER JOIN  "
                    + "    agenda_participantes ap ON a.idAgenda = ap.idAgenda "
                    + "INNER JOIN  "
                    + "    cadastro cf ON ap.idProfissional = cf.id "
                    + "INNER JOIN  "
                    + "    adicional ad ON a.idAgenda = ad.idAgenda "
                    + "WHERE a.idCliente = ? "
                    + "ORDER BY  "
                    + "    a.data  ";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                Informacao i = new Informacao();
                i.setIdAgenda(rs.getInt("idAgenda"));
                i.setData(rs.getString("data"));
                i.setHora(rs.getString("hora"));
                i.setNomeFuncionario(rs.getString("nome_funcionario"));
                i.setTipoServico(rs.getString("tipoServico"));
                i.setNota(rs.getString("nota"));

                lista.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Informacao> buscarInfoPorPeriodo(int idCliente, LocalDate dataInicial, LocalDate dataFinal) {
        List<Informacao> lista = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT "
                    + "    a.idAgenda, "
                    + "    a.data, "
                    + "    a.hora, "
                    + "    cf.nome AS nome_funcionario, "
                    + "    ap.tipoServico, "
                    + "    ad.nota "
                    + "FROM  "
                    + "    agenda a "
                    + "INNER JOIN  "
                    + "    agenda_participantes ap ON a.idAgenda = ap.idAgenda "
                    + "INNER JOIN  "
                    + "    cadastro cf ON ap.idProfissional = cf.id "
                    + "INNER JOIN  "
                    + "    adicional ad ON a.idAgenda = ad.idAgenda "
                    + "WHERE a.idCliente = ? "
                    + "AND a.data BETWEEN ? AND ? "
                    + "ORDER BY  "
                    + "    a.data DESC";  // Ordena da data mais recente para a mais antiga

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setDate(2, java.sql.Date.valueOf(dataInicial));
            ps.setDate(3, java.sql.Date.valueOf(dataFinal));

            rs = ps.executeQuery();

            while (rs.next()) {
                Informacao informacao = new Informacao();
                informacao.setIdAgenda(rs.getInt("idAgenda"));
                informacao.setData(rs.getString("data"));
                informacao.setHora(rs.getString("hora"));
                informacao.setNomeFuncionario(rs.getString("nome_funcionario"));
                informacao.setTipoServico(rs.getString("tipoServico"));
                informacao.setNota(rs.getString("nota"));

                lista.add(informacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public static LocalDate buscarDataMaisAntiga(int idCliente) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate dataMaisAntiga = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT MIN(data) AS menor_data FROM agenda WHERE idCliente = ?";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
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

    public static LocalDate buscarDataMaisRecente(int idCliente) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate dataMaisRecente = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT MAX(data) AS maior_data FROM agenda WHERE idCliente = ?";

            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
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
