package admtattoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Types;
import java.util.List;

public class FuncionarioDAO {

    public static ArrayList<Funcionario> listarTodos() {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = """
                         SELECT 
                             f.idFuncionario,
                             c.nome,
                             f.cargo,
                             f.data_entrada,
                             f.status,
                             f.data_saida
                        FROM 
                            funcionario f
                        INNER JOIN
                            cadastro c
                        WHERE f.idFuncionario = c.id
                        ORDER BY c.nome ASC
                         """;
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario func = new Funcionario();

                func.setIdProfissional(rs.getInt("idFuncionario"));
                func.setNome(rs.getString("nome"));
                func.setCargo(rs.getString("cargo"));
                func.setDataEntrada(rs.getString("data_entrada"));
                func.setStatus(rs.getBoolean("status"));
                func.setDataSaida(rs.getString("data_saida"));

                listaFuncionario.add(func);
            }
        } catch (SQLException se) {
            System.err.println("Erro ao listar funcionários: " + se.getMessage());
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
        return listaFuncionario;
    }

    public static Funcionario buscarPorId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Funcionario func = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                func = new Funcionario();

                func.setIdProfissional(rs.getInt("idFuncionario"));
                func.setCargo(rs.getString("cargo"));
                func.setDataEntrada(rs.getString("data_entrada"));
                func.setStatus(rs.getBoolean("status"));
                func.setDataSaida(rs.getString("data_saida"));
                func.setSenha(rs.getString("senha"));

            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionário pelo ID: " + e.getMessage());
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
        return func;
    }

    public static boolean salvarNovo(Funcionario f) throws SQLException {
        String sql = "INSERT INTO funcionario (idFuncionario, cargo, data_entrada, status, data_saida) VALUES (?,?,?,?,?)";
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            ps = conn.getConexao().prepareStatement(sql);

            ps.setInt(1, f.getIdProfissional());
            ps.setString(2, f.getCargo());
            ps.setObject(3, LocalDate.now()); // Insere a data atual diretamente
            ps.setBoolean(4, f.isStatus());

            if (f.getDataSaida() != null) {
                ps.setObject(5, f.getDataSaida());
            } else {
                ps.setNull(5, Types.DATE);
            }

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionário adicionado com sucesso!");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao adicionar funcionário no banco de dados: " + ex.getMessage());
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

    public static boolean atualizar(Funcionario f) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "UPDATE funcionario SET cargo = ?, data_entrada = ?, data_saida = ?, status = ?, senha = ?"
                    + " WHERE idFuncionario = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            // Formata as datas
            String entradaSQL = DateUtils.formatarStringParaSQL(f.getDataEntrada());
            String saidaSQL = f.getDataSaida() != null
                    ? DateUtils.formatarStringParaSQL(f.getDataSaida()) : null;

            if (entradaSQL == null) {
                throw new IllegalArgumentException("Formato de data de entrada inválido");
            }

            ps.setString(1, f.getCargo());
            ps.setString(2, entradaSQL);

            if (saidaSQL != null) {
                ps.setString(3, saidaSQL);
            } else {
                ps.setNull(3, Types.VARCHAR);
            }
            ps.setBoolean(4, f.isStatus());
            ps.setString(5, f.getSenha());
            ps.setInt(6, f.getIdProfissional());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (IllegalArgumentException ex) {
            System.err.println("Erro de validação: " + ex.getMessage());
            return false;
        } catch (SQLException ex) {
            System.err.println("Erro de banco de dados: " + ex.getMessage());
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

    public static List<Funcionario> buscarPorAtivosInativosComboBox() {
        List<Funcionario> funcionarios = new ArrayList<>();

        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT "
                    + " 	f.idFuncionario, "
                    + "     c.nome "
                    + "FROM "
                    + "     cadastro c "
                    + "INNER JOIN "
                    + "     funcionario f ON c.id = f.idFuncionario "
                    + "ORDER BY c.nome ASC";

            ps = conexao.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdProfissional(rs.getInt("idFuncionario"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar por Funcionários: " + ex.getMessage());
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

        return funcionarios;
    }

    public Funcionario autenticar(int idFuncionario, String senha) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Funcionario func = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM funcionario WHERE idFuncionario = ? AND senha = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idFuncionario);
            ps.setString(2, senha);
            rs = ps.executeQuery();

            if (rs.next()) {
                boolean status = rs.getBoolean("status");
                if (!status) {
                    return null;
                }
                func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setIdProfissional(rs.getInt("idFuncionario"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setStatus(status);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar por Funcionários: " + ex.getMessage());
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

        return func;
    }
}
