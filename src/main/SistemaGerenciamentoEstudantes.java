package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import data.BancoDeDados;
import data.ConexaoBancoDeDados;
import data.CriadorDeTabelas;
import view.Menu;

/**
 * Ponto de entrada (Entry point) da aplicação.
 * Responsável por inicializar as dependências, orquestrar a execução do sistema
 * e garantir o desligamento seguro das conexões.
 */
public class SistemaGerenciamentoEstudantes {

	/**
	 * Inicializa a conexão com banco, injeta dependências e exibe a interface do Menu.
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexao = ConexaoBancoDeDados.obterConexao();
		Scanner scanner = new Scanner(System.in);
		CriadorDeTabelas cdt = new CriadorDeTabelas();
		BancoDeDados bd = new BancoDeDados(conexao, scanner);
		
		if (conexao != null) {
			cdt.construirTabelas(conexao);
			Menu m = new Menu(bd, scanner);
			m.start();
		} else {
			System.out.println("Falha na conexão!");
		}
		try {
            conexao.close();
            System.out.println("\nConexão com o Banco de Dados encerrada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Programa finalizado!");
        System.exit(0);
	}
}