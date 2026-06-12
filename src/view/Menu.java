package view;

import java.util.Scanner;

import data.BancoDeDados;

/**
 * Interface baseada em console (CLI) responsável pela interação direta com o usuário,
 * exibindo opções e coletando as escolhas de navegação.
 */
public class Menu {

	private BancoDeDados bd;
	private Scanner scanner;

	public Menu(BancoDeDados bd, Scanner scanner) {
		this.bd = bd;
		this.scanner = scanner;
	}

	/**
	 * Contém o loop principal de execução do programa e estrutura switch-case
	 * para roteamento das opções do usuário (CRUD e Listagens).
	 */
	public void start() {

		int opcaoDentro;
		int opcaoFora = 0;

		while (opcaoFora != 5) {
			opcaoDentro = 0;

			System.out.println("");
			System.out.println("     ****** Gerenciamento de Estudantes ******");
			System.out.println("     *                                       *");
			System.out.println("     *        1 -> Adicionar estudante       *");
			System.out.println("     *        2 -> Editar estudante          *");
			System.out.println("     *        3 -> Remover estudante         *");
			System.out.println("     *        4 -> Listar estudantes         *");
			System.out.println("     *        5 -> Sair                      *");
			System.out.println("     *                                       *");
			System.out.println("     *****************************************");
			System.out.print("\nEscolha uma das opções acima: ");

			try {
				opcaoDentro = scanner.nextInt();
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("\nOpção inválida, tente novamente!");
				continue;
			}

			switch (opcaoDentro) {
			case 1:
				String selecao = "";
				scanner.nextLine();
				do {
					System.out.print("Deseja realmente adicionar um estudante? (S/N): ");
					selecao = scanner.nextLine();
					if (selecao.equalsIgnoreCase("S")) {
						System.out.println("");
						bd.adicionarEstudante();
						break;
					} else if (selecao.equalsIgnoreCase("N")) {
						break;
					} else {
						System.out.println("\nOpção inválida, tente novamente!\n");
					}
				} while (!selecao.equals("N"));

			case 2:
				int opcaoEdit = 0;
				System.out.println("");
				System.out.println("1. Editar nome do estudante!");
				System.out.println("2. Editar curso do estudante!");
				System.out.println("3. Editar nome e curso do estudante!");
				System.out.println("4. Voltar ao menu!");
				System.out.print("\nEscolha a opção desejada: ");
				try {
					opcaoEdit = scanner.nextInt();
					if (opcaoEdit == 1) {
						bd.editarEstudanteNome();
					} else if (opcaoEdit == 2) {
						bd.editarEstudanteCurso();
					} else if (opcaoEdit == 3) {
						bd.editarEstudanteNomeECurso();
					} else if (opcaoEdit == 4) {
						break;
					} else {
						System.out.println("\nOpção inválida, tente novamente!");
					}
				} catch (Exception e) {
					scanner.nextLine();
					System.out.println("\nOpção inválida, tente novamente!");
					continue;
				}
				break;

			case 3:
				int opcaoRemove = 0;
				System.out.println("");
				System.out.println("1. Remover estudante por nome!");
				System.out.println("2. Remover estudante por ID!");
				System.out.println("3. Remover todos os estudantes de um curso!");
				System.out.println("4. Voltar ao menu!");
				System.out.print("\nEscolha a opção desejada: ");
				try {
					opcaoRemove = scanner.nextInt();
					if (opcaoRemove == 1) {
						bd.removerEstudanteNome();
					} else if (opcaoRemove == 2) {
						bd.removerEstudanteId();
					} else if (opcaoRemove == 3) {
						bd.removerEstudantesCurso();
					} else if (opcaoRemove == 4) {
						break;
					} else {
						System.out.println("\nOpção inválida, tente novamente!");
					}
				} catch (Exception e) {
					scanner.nextLine();
					System.out.println("\nOpção inválida, tente novamente!");
					continue;
				}
				break;

			case 4:
				int opcaoListar = 0;
				System.out.println("");
				System.out.println("1. Listar todos os estudantes!");
				System.out.println("2. Listar um estudante pelo nome!");
				System.out.println("3. Listar todos os estudantes de um curso!");
				System.out.println("4. Voltar ao menu!");
				System.out.print("\nEscolha a opção desejada: ");
				try {
					opcaoListar = scanner.nextInt();
					if (opcaoListar == 1) {
						bd.listarEstudantes();
					} else if (opcaoListar == 2) {
						bd.listarOEstudantesPorNome();
					} else if (opcaoListar == 3) {
						bd.listarEstudantesPorCurso();
					} else if (opcaoListar == 4) {
						break;
					} else {
						System.out.println("\nOpção inválida, tente novamente!");
					}
				} catch (Exception e) {
					scanner.nextLine();
					System.out.println("\nOpção inválida, tente novamente!");
					continue;
				}
				break;

			case 5:
                opcaoFora = 5;
                break;

			default:
				System.out.println("\nOpção inválida, tente novamente!");
				break;
			}
		}
		scanner.close();
	}
}