package app.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private int id;
    private List<Aluno> alunos;
    
    public Turma(String nome, int id) {
    	this.nome = nome;
    	this.id = id;
    	setAlunos(new ArrayList<>());
	}
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
