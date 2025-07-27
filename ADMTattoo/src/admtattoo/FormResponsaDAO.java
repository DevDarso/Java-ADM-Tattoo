package admtattoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormResponsaDAO {

    public static FormResponsa buscarFormularioPorId(int idFormulario) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FormResponsa formulario = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM formulario WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idFormulario);
            rs = ps.executeQuery();

            if (rs.next()) {
                formulario = new FormResponsa();
                formulario.setId(rs.getInt("id"));
                formulario.setIdCliente(rs.getInt("idCliente"));
                formulario.setTitulo(rs.getString("titulo"));
                formulario.setCabecalho(rs.getString("cabecalho"));
                formulario.setQuestionario(rs.getString("questionario"));
                formulario.setEmpresa(rs.getString("empresa"));
                formulario.setCidade(rs.getString("cidade"));
                formulario.setRodape(rs.getString("rodape"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar formulário: " + e.getMessage());
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

        return formulario;
    }

    public static boolean atualizarFormulario(FormResponsa form) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean atualizado = false;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            // Verifica se já existe um formulário com este ID
            String checkSql = "SELECT id FROM formulario WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(checkSql);
            ps.setInt(1, form.getId());
            rs = ps.executeQuery();

            boolean existe = rs.next();
            rs.close();
            ps.close();

            if (existe) {
                String updateSql = "UPDATE formulario SET titulo = ?, cabecalho = ?, questionario = ?, cidade = ?, empresa = ?, rodape = ?, idCliente = ? WHERE id = ?";
                ps = conexao.getConexao().prepareStatement(updateSql);
                ps.setString(1, form.getTitulo());
                ps.setString(2, form.getCabecalho());
                ps.setString(3, form.getQuestionario());
                ps.setString(4, form.getCidade());
                ps.setString(5, form.getEmpresa());
                ps.setString(6, form.getRodape());
                ps.setInt(7, form.getIdCliente());
                ps.setInt(8, form.getId());
            } else {
                String insertSql = "INSERT INTO formulario (idCliente, titulo, cabecalho, questionario, cidade, empresa, rodape) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = conexao.getConexao().prepareStatement(insertSql);
                ps.setInt(1, form.getIdCliente());
                ps.setString(2, form.getTitulo());
                ps.setString(3, form.getCabecalho());
                ps.setString(4, form.getQuestionario());
                ps.setString(5, form.getCidade());
                ps.setString(6, form.getEmpresa());
                ps.setString(7, form.getRodape());
            }

            int linhasAfetadas = ps.executeUpdate();
            atualizado = linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir/atualizar formulário: " + e.getMessage());
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

        return atualizado;
    }

    public static FormResponsa buscarUltimoFormulario() {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FormResponsa form = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            // Consulta o maior ID da tabela
            String sql = "SELECT * FROM formulario WHERE id = (SELECT MAX(id) FROM formulario)";
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                form = new FormResponsa();
                form.setId(rs.getInt("id"));
                form.setIdCliente(rs.getInt("idCliente"));
                form.setTitulo(rs.getString("titulo"));
                form.setCabecalho(rs.getString("cabecalho"));
                form.setQuestionario(rs.getString("questionario"));
                form.setCidade(rs.getString("cidade"));
                form.setEmpresa(rs.getString("empresa"));
                form.setRodape(rs.getString("rodape"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar último formulário: " + e.getMessage());
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

        return form;
    }

    public static ArrayList<FormResponsa> listarTodos() {
        ArrayList<FormResponsa> listaFormularios = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM formulario";
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                FormResponsa f = new FormResponsa();

                f.setId(rs.getInt("id"));
                f.setIdCliente(rs.getInt("idCliente"));
                f.setTitulo(rs.getString("titulo"));
                f.setCabecalho(rs.getString("cabecalho"));
                f.setQuestionario(rs.getString("questionario"));
                f.setEmpresa(rs.getString("empresa"));
                f.setCidade(rs.getString("cidade"));
                f.setRodape(rs.getString("rodape"));

                listaFormularios.add(f);
            }
        } catch (SQLException se) {
            System.err.println("Erro ao listar formulários: " + se.getMessage());
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
        return listaFormularios;
    }

    public static ArrayList<FormResponsa> listarFormularioID(int idCliente) {
        ArrayList<FormResponsa> listaFormularios = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM formulario WHERE idCliente = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                FormResponsa f = new FormResponsa();

                f.setId(rs.getInt("id"));
                f.setIdCliente(rs.getInt("idCliente"));
                f.setTitulo(rs.getString("titulo"));
                f.setCabecalho(rs.getString("cabecalho"));
                f.setQuestionario(rs.getString("questionario"));
                f.setEmpresa(rs.getString("empresa"));
                f.setCidade(rs.getString("cidade"));
                f.setRodape(rs.getString("rodape"));

                listaFormularios.add(f);
            }
        } catch (SQLException se) {
            System.err.println("Erro ao listar formulários para o cliente ID " + idCliente + ": " + se.getMessage());
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
                System.err.println("Erro ao fechar recursos no listarFormularioID: " + e.getMessage());
            }
        }

        return listaFormularios;
    }

    public static boolean excluir(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "DELETE FROM formulario WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir formulário: " + ex.getMessage());
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
