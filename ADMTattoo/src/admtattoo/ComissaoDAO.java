package admtattoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComissaoDAO {

    public static List<ComissaoDTO> listarComissoesDetalhadas() {
        List<ComissaoDTO> lista = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
        SELECT
            ap.idAgenda,
            ap.idProfissional AS idFuncionario,
            ap.tipoServico,
            a.data,
            a.hora,
            c.valor,
            c.porcentagem AS porcento,
            c.total AS valorCalculado
        FROM 
            agenda_participantes ap
        INNER JOIN 
            comissao c ON ap.idAgenda = c.idAgenda 
                       AND ap.idProfissional = c.idProfissional
        INNER JOIN
            agenda a ON ap.idAgenda = a.idAgenda
        WHERE 
            a.status = 'Atendido'
        ORDER BY 
            a.data DESC, a.hora, ap.idAgenda
        """;
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("DEBUG - Dados lidos do banco:");
            while (rs.next()) {
                ComissaoDTO dto = new ComissaoDTO(
                        rs.getInt("idAgenda"),
                        rs.getInt("idFuncionario"),
                        rs.getString("tipoServico"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getDouble("valor"),
                        rs.getInt("porcento"),
                        rs.getDouble("valorCalculado")
                );
                lista.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar comissões : " + e);
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

    public static List<ComissaoDTO> listarComissoesSemValoresZerados() {
        List<ComissaoDTO> lista = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
        SELECT
                ap.idAgenda,
                ap.idProfissional AS idFuncionario,
                ap.tipoServico,
                a.data,
                a.hora,
                c.valor,
                c.porcentagem AS porcento,
                c.total AS valorCalculado
            FROM 
                agenda_participantes ap
            INNER JOIN 
                comissao c ON ap.idAgenda = c.idAgenda 
                           AND ap.idProfissional = c.idProfissional
            INNER JOIN
                agenda a ON ap.idAgenda = a.idAgenda
            WHERE 
                a.status = 'Atendido'
                AND c.total != 0.0
            ORDER BY 
                a.data DESC, a.hora, ap.idAgenda
        """;
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ComissaoDTO dto = new ComissaoDTO(
                        rs.getInt("idAgenda"),
                        rs.getInt("idFuncionario"),
                        rs.getString("tipoServico"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getDouble("valor"),
                        rs.getInt("porcento"),
                        rs.getDouble("valorCalculado")
                );

                lista.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar comissões : " + e);
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

    public static Comissao buscarComissao(int idAgenda, int idFuncionario) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comissao comissao = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM comissao WHERE idAgenda = ? AND idProfissional = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            ps.setInt(2, idFuncionario);
            rs = ps.executeQuery();

            if (rs.next()) {
                comissao = new Comissao();
                comissao.setIdAgenda(rs.getInt("idAgenda"));
                comissao.setIdProfissional(rs.getInt("idProfissional"));
                comissao.setValor(rs.getDouble("valor"));
                comissao.setPorcentagem(rs.getInt("porcentagem"));
                comissao.setTotal(rs.getDouble("total"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar comissão: " + e.getMessage());
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

        return comissao;
    }
    // verificar se tem necessidade deste método

    public static boolean salvarPorcentoColaborador(Informacao i) {
        String sql = """
        INSERT INTO agenda_participantes (idAgenda, idProfissional, porcento, papel, valor, tipoServico)
        VALUES (?, ?, ?, ?, ?, ?)
    """;
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            ps = conn.getConexao().prepareStatement(sql);

            ps.setInt(1, i.getIdAgenda());
            ps.setInt(2, i.getIdColaborador());
            ps.setInt(3, i.getPorcentoColaborador());
            ps.setString(4, "Colaborador");
            ps.setDouble(5, i.getValor());  // valor do colaborador
            ps.setString(6, i.getTipoServico()); // tipo de serviço do colaborador

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar porcentagem do colaborador: " + ex.getMessage());
            return false;
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
    }

    public static boolean inserirComissao(Comissao c) {
        if (c.getValor() < 0 || c.getPorcentagem() < 0) {
            System.err.println("[ERRO] Valores inválidos para nova comissão!");
            return false;
        }
        String sql = "INSERT INTO comissao (idAgenda, idProfissional, valor, porcentagem, total) VALUES (?, ?, ?, ?, ?)";
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            ps = conn.getConexao().prepareStatement(sql);

            ps.setInt(1, c.getIdAgenda());
            ps.setInt(2, c.getIdProfissional());
            ps.setDouble(3, c.getValor());
            ps.setDouble(4, c.getPorcentagem());
            ps.setDouble(5, c.getValorCalculado());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Comissão salva com sucesso!");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar comissão no banco de dados: " + ex.getMessage());
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

    public static boolean atualizarValores(Comissao comissao) {
        if (comissao.getValor() < 0 || comissao.getPorcentagem() < 0) {
            System.err.println("[ERRO] Valores inválidos para cálculo de comissão!");
            System.err.println("Valor: " + comissao.getValor() + " | Porcentagem: " + comissao.getPorcentagem());
            return false; // Impede a execução do UPDATE se os valores forem inválidos
        }
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "UPDATE comissao SET valor = ?, porcentagem = ?, total = ? WHERE idAgenda = ? AND idProfissional = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setDouble(1, comissao.getValor());
            ps.setInt(2, comissao.getPorcentagem());
            ps.setDouble(3, comissao.getValorCalculado());
            ps.setInt(4, comissao.getIdAgenda());
            ps.setInt(5, comissao.getIdProfissional());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar valores: " + ex.getMessage());
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

    public static boolean existeComissao(int idAgenda, int idProfissional) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT 1 FROM comissao WHERE idAgenda = ? AND idProfissional = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idAgenda);
            ps.setInt(2, idProfissional);
            rs = ps.executeQuery();
            existe = rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao verificar comissão: " + e.getMessage());
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

    public static int buscarPorcentagem(int idAgenda, int idProfissional) {
        int porcentagem = 0;
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT porcentagem FROM comissao WHERE id_agenda = ? AND id_profissional = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, idAgenda);
            ps.setInt(2, idProfissional);
            rs = ps.executeQuery();
            if (rs.next()) {
                porcentagem = rs.getInt("porcentagem");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar porcentagem: " + e.getMessage());
        }
        return porcentagem;
    }

    public static boolean excluir(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "DELETE FROM comissao WHERE idAgenda = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir comissão: " + ex.getMessage());
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

}
