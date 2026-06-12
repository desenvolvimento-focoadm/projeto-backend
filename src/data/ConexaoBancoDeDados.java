package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsável por estabelecer e fornecer a conexão com o banco de dados PostgreSQL.
 */
public class ConexaoBancoDeDados {
	
	/**
	 * Define as credenciais do banco e utiliza DriverManager para abrir a conexão.
	 * Retorna um objeto Connection ou null em caso de falha.
	 */
	public static Connection obterConexao() {

		String url = "jdbc:postgresql://localhost:5432/Escola";
		String usuario = "postgres";
		String senha = "cmF5YW4=";

		Connection conexao = null;

		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			System.out.println("Não foi possivel obter conexão!");
			System.out.println("Erro " + e.getMessage());
		}
		return conexao;
	}
}