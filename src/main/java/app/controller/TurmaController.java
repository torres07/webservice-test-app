package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Turma;
import app.model.Aluno;

@RestController
public class TurmaController {
	@RequestMapping("turmas/example")
	public List<Turma> exampleTurma(Model model){
		List<Turma> turmas = new ArrayList<>();
		
		Turma turmaEx = new Turma("Artes", 1001);
		turmaEx.getAlunos().add(new Aluno("Pedro", 3737));
		
		turmas.add(turmaEx);
		turmas.add(new Turma("Matemática", 1001));
		turmas.add(new Turma("Português", 1002));
		
		return turmas;
	}
}
