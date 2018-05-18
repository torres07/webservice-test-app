package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Aluno;

@RestController
public class AlunoController {
	@RequestMapping("/alunos/example")
	public List<Aluno> alunoExample(Model model) {
		List<Aluno> alunos = new ArrayList<>();
		Aluno example1 = new Aluno("Pedro", 101);
		Aluno example2 = new Aluno("Lucas", 102);
		
		alunos.add(example1);
		alunos.add(example2);
		
		return alunos;
	}
	

}
