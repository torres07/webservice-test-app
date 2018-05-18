package app.model;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int matricula;
    private ArrayList<Turma> turmas;

    public Aluno(String nome, int matricula) {
        this.matricula = matricula;
        this.nome = nome;
        this.setTurmas(new ArrayList<Turma>());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}
	
    @Override
    public String toString() {
        return this.nome + " - " + this.matricula;
    }
}
