package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Garante que a estrutura necessária do banco de dados (tabelas) exista antes de iniciar as operações.
 */
public class CriadorDeTabelas {
	
	/**
	 * Recebe a conexão ativa com o banco, obtém o script SQL e executa a criação da tabela.
	 */
	public void construirTabelas(Connection conexao) {

		String sql = BancoDeDados.criarSql();

		try {
			Statement statement = conexao.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Tabela criada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro na criação da tabela!");
			System.out.println("Erro: " + e.getMessage());
		}
	}
}