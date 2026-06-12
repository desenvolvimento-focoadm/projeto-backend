package model;

/**
 * Representa a entidade principal do domínio do projeto.
 * É um POJO (Plain Old Java Object) que encapsula as informações de um estudante.
 */
public class Estudante {

	private String nome;
	private String curso;

	public Estudante(String nome, String curso) {
		this.nome = nome;
		this.curso = curso;
	}

	public Estudante() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}