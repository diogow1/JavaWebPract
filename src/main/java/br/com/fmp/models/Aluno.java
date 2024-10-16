package br.com.fmp.models;

public class Aluno {
	private Integer id;
	private String nome;
	private String curso;
	private Integer ano;
	
	public Aluno(Integer id, String nome, String curso, Integer ano) {
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.ano = ano;
	}
	
	public Integer getId() {
		return this.id;
	}

	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCurso() {
		return this.curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public Integer getAno() {
		return this.ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
