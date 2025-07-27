package admtattoo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class CadastroDAO {

    public static ArrayList<Cadastro> listarTodos() {
        ArrayList<Cadastro> listaCadastros = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM cadastro ORDER BY nome ASC";

            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cadastro cadastro = new Cadastro();

                cadastro.setId(rs.getInt("id"));
                cadastro.setStatus(rs.getString("status"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setCnpj(rs.getString("cnpj"));
                cadastro.setNascimento(rs.getString("data"));
                cadastro.setTel(rs.getString("tel"));
                cadastro.setCep(rs.getString("cep"));
                cadastro.setRua(rs.getString("rua"));
                cadastro.setNumero(rs.getString("numero"));
                cadastro.setBairro(rs.getString("bairro"));
                cadastro.setCfal(rs.getString("local"));
                cadastro.setCidade(rs.getString("cidade"));
                cadastro.setEmail(rs.getString("email"));

                listaCadastros.add(cadastro);
            }
        } catch (SQLException se) {
            System.err.println("Erro ao listar cadastros: " + se.getMessage());
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
        return listaCadastros;
    }

    public static boolean cadastrar(Cadastro c) {
        String sql = "INSERT INTO cadastro (status, nome, cpf, cnpj, data, tel, cep, rua, numero, bairro, local, cidade, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ConexaoJDBC conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConexaoJDBC();
            conn.conectar();
            ps = conn.getConexao().prepareStatement(sql);

            ps.setString(1, c.getStatus());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getCnpj());
            ps.setString(5, c.getNascimento());
            ps.setString(6, c.getTel());
            ps.setString(7, c.getCep());
            ps.setString(8, c.getRua());
            ps.setString(9, c.getNumero());
            ps.setString(10, c.getBairro());
            ps.setString(11, c.getCfal());
            ps.setString(12, c.getCidade());
            ps.setString(13, c.getEmail());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar no banco de dados: " + ex.getMessage());
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
            String sql = "DELETE FROM cadastro WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir cadastro: " + ex.getMessage());
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

    public static List<Cadastro> buscarPorNome(String nome) {
        List<Cadastro> cadastros = new ArrayList<>();
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM cadastro WHERE nome LIKE ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Cadastro cadastro = new Cadastro();

                cadastro.setId(rs.getInt("id"));
                cadastro.setStatus(rs.getString("status"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setCnpj(rs.getString("cnpj"));
                cadastro.setNascimento(rs.getString("nascimento"));
                cadastro.setTel(rs.getString("tel"));
                cadastro.setCep(rs.getString("cep"));
                cadastro.setRua(rs.getString("rua"));
                cadastro.setNumero(rs.getString("numero"));
                cadastro.setBairro(rs.getString("bairro"));
                cadastro.setCfal(rs.getString("cfal"));
                cadastro.setCidade(rs.getString("cidade"));
                cadastro.setEmail(rs.getString("email"));

                cadastros.add(cadastro);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar por nome: " + ex.getMessage());
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
        return cadastros;
    }

    public static Cadastro buscarPorId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cadastro cadastro = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT * FROM cadastro WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                cadastro = new Cadastro();

                cadastro.setId(rs.getInt("id"));
                cadastro.setStatus(rs.getString("status"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setCnpj(rs.getString("cnpj"));
                cadastro.setNascimento(rs.getString("data"));
                cadastro.setTel(rs.getString("tel"));
                cadastro.setCep(rs.getString("cep"));
                cadastro.setRua(rs.getString("rua"));
                cadastro.setNumero(rs.getString("numero"));
                cadastro.setBairro(rs.getString("bairro"));
                cadastro.setCfal(rs.getString("local"));
                cadastro.setCidade(rs.getString("cidade"));
                cadastro.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cadastro por ID: " + e.getMessage());
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
        return cadastro;
    }
//    Método para exibir o nome em AtualizarAgenda

    public Cadastro buscarNomePeloId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cadastro cadastro = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT id, nome, cpf, cnpj FROM cadastro WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                cadastro = new Cadastro();

                cadastro.setId(rs.getInt("id"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setCnpj(rs.getString("cnpj"));

            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cadastro por ID: " + e.getMessage());
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
        return cadastro;
    }
//    retorna somente o nome

    public String buscarNomeComId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String nome = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT nome FROM cadastro WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar nome por ID: " + e.getMessage());
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
        return nome;
    }
//retorna somente a data

    public String buscarDataComId(int id) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String data = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT data FROM cadastro WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                data = rs.getString("data");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar data por ID: " + e.getMessage());
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
        return data;
    }

    public static boolean atualizar(Cadastro cadastro) {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "UPDATE cadastro SET status = ?, nome = ?, cpf = ?, cnpj = ?, data = ?, tel = ?, cep = ?, rua = ?, "
                    + "numero = ?, bairro = ?, local = ?, cidade = ?, email = ? WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, cadastro.getStatus());
            ps.setString(2, cadastro.getNome());
            ps.setString(3, cadastro.getCpf());
            ps.setString(4, cadastro.getCnpj());
            ps.setString(5, cadastro.getNascimento());
            ps.setString(6, cadastro.getTel());
            ps.setString(7, cadastro.getCep());
            ps.setString(8, cadastro.getRua());
            ps.setString(9, cadastro.getNumero());
            ps.setString(10, cadastro.getBairro());
            ps.setString(11, cadastro.getCfal());
            ps.setString(12, cadastro.getCidade());
            ps.setString(13, cadastro.getEmail());
            ps.setInt(14, cadastro.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar cadastro: " + ex.getMessage());
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

    // retorna lista com mesmo status
    public static List<Cadastro> buscarPorStatus(String tipo) {
        List<Cadastro> cadastros = new ArrayList<>();

        // Se o tipo for "Todos", chama listarTodos() e retorna diretamente
        if (tipo.equalsIgnoreCase("Todos")) {
            return listarTodos();
        }

        // Validação do tipo permitido
        if (!tipo.equalsIgnoreCase("Cliente")
                && !tipo.equalsIgnoreCase("Todos")
                && !tipo.equalsIgnoreCase("Fornecedor")
                && !tipo.equalsIgnoreCase("Funcionário")) {
            System.err.println("Tipo de cadastro inválido: " + tipo);
            return cadastros; // Retorna lista vazia sem consultar o banco
        }

        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM cadastro WHERE status = ? ORDER BY nome ASC";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipo);

            rs = ps.executeQuery();

            while (rs.next()) {
                Cadastro cadastro = new Cadastro();

                cadastro.setId(rs.getInt("id"));
                cadastro.setStatus(rs.getString("status"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setCnpj(rs.getString("cnpj"));
                cadastro.setNascimento(rs.getString("data"));
                cadastro.setTel(rs.getString("tel"));
                cadastro.setCep(rs.getString("cep"));
                cadastro.setRua(rs.getString("rua"));
                cadastro.setNumero(rs.getString("numero"));
                cadastro.setBairro(rs.getString("bairro"));
                cadastro.setCfal(rs.getString("local"));
                cadastro.setCidade(rs.getString("cidade"));
                cadastro.setEmail(rs.getString("email"));

                cadastros.add(cadastro);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar por Status: " + ex.getMessage());
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

        return cadastros;
    }
// Retorna o status de um único cadastro identificado pelo id

    public static String buscarStatusPorId(int id) {
        String status = null;
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT status FROM cadastro WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);  // Corrigido: usando o parâmetro id

            rs = ps.executeQuery();

            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar status: " + ex.getMessage());
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

        return status;
    }

    public static List<Cadastro> buscarPorFuncionariosComboBox() {
        List<Cadastro> cadastros = new ArrayList<>();

        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT id,nome FROM cadastro WHERE status = 'Funcionário' "
                    + "ORDER BY nome ASC";
            ps = conexao.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setNome(rs.getString("nome"));
                cadastro.setId(rs.getInt("id"));
                cadastros.add(cadastro);
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

        return cadastros;
    }

    public List<Cadastro> buscarAniversariantesDoMes(int mes) {
        List<Cadastro> cadastros = new ArrayList<>();

        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM cadastro WHERE MONTH(data) = ? ORDER BY nome ASC";
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, mes);

            rs = ps.executeQuery();

            while (rs.next()) {
                Cadastro cadastro = new Cadastro();

                cadastro.setId(rs.getInt("id"));
                cadastro.setStatus(rs.getString("status"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setCnpj(rs.getString("cnpj"));
                cadastro.setNascimento(rs.getString("data"));
                cadastro.setTel(rs.getString("tel"));
                cadastro.setCep(rs.getString("cep"));
                cadastro.setRua(rs.getString("rua"));
                cadastro.setNumero(rs.getString("numero"));
                cadastro.setBairro(rs.getString("bairro"));
                cadastro.setCfal(rs.getString("local"));
                cadastro.setCidade(rs.getString("cidade"));
                cadastro.setEmail(rs.getString("email"));

                cadastros.add(cadastro);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar por aniversariantes: " + ex.getMessage());
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

        return cadastros;
    }
    // método que será usado para buscar o último ID e setar em TelaFormResponsa caso usuario
    // tenha menos de 18 anos

    public static int buscarUltimoId() {
        ConexaoJDBC conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;

        try {
            conexao = new ConexaoJDBC();
            conexao.conectar();
            String sql = "SELECT id FROM cadastro ORDER BY id DESC LIMIT 1";
            ps = conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (Exception e) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return id;
    }
}
