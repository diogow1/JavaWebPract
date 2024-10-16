package br.com.fmp.models;

public class Nota {
	private Integer id;
	private Integer alunoId;
	private String disciplina;
	private Double nota;
	
	public Nota(Integer id, Integer alunoId, String disciplina, Double nota) {
		this.id = id;
		this.alunoId = alunoId;
		this.disciplina = disciplina;
		this.nota = nota;
		
	}
	
	
	
	public Integer getId() {
		return id;
	}


	public Integer getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
