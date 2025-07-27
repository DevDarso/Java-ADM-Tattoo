package admtattoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public static ArrayList<Servico> listarTodos() {
        ArrayList<Servico> listaServico = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM servico";
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico();

                servico.setIdServico(rs.getInt("idServico"));
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setValor(rs.getDouble("valor"));

                listaServico.add(servico);
            }
        } catch (SQLException se) {
            System.err.println("Erro ao listar serviços: " + se.getMessage());
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
        return listaServico;
    }

    public static boolean salvarNovo(Servico s) {
        String sql = "INSERT INTO servico (nomeServico, valor) VALUES (?,?)";
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            ps = conn.getConexao().prepareStatement(sql);

            ps.setString(1, s.getNomeServico());
            ps.setDouble(2, s.getValor());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Serviço adicionado com sucesso!");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao adicionar no banco de dados: " + ex.getMessage());
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

    public static boolean excluir(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "DELETE FROM servico WHERE idServico = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir serviço: " + ex.getMessage());
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

    public static List<Servico> buscarPorServicoNoComboBox() {
        List<Servico> servicos = new ArrayList<>();

        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM servico";
            ps = conexao.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setValor(rs.getDouble("valor"));

                servicos.add(servico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar por serviço/produto: " + ex.getMessage());
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

        return servicos;
    }
}
