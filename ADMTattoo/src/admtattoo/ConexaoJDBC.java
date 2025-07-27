package admtattoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

    private Connection conexao;

    public ConexaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    ConexaoJDBC() {
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void conectar() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/adm_tattoo", "root", "Devdarso2025");
            System.out.println("Sucesso na conexão");

        } catch (ClassNotFoundException cn) {
            System.out.println("Falha ao conectar com banco" + cn);
        } catch (SQLException sql) {
            System.out.println("Erro de SQL" + sql);
        }
    }

    public void desconectar() {
        try {
            if (conexao != null) {
                conexao.close();
                System.out.println("Desconectado");
            }
        } catch (SQLException sql) {
            System.out.println("Erro ao desconectar do banco de dados" + sql);
        }
    }

}
