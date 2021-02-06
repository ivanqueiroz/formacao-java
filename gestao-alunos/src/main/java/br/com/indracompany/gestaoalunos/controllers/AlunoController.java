package br.com.indracompany.gestaoalunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.indracompany.gestaoalunos.model.Aluno;
import br.com.indracompany.gestaoalunos.repository.Alunos;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private Alunos alunos;

	@PostMapping
	public String salvar(Aluno aluno) {
		this.alunos.save(aluno);
		return "redirect:/alunos";
	}

	@GetMapping
	public ModelAndView listar() {
		ModelAndView retorno = new ModelAndView("ListarAlunos");
		retorno.addObject("alunos", alunos.findAll());
		retorno.addObject(new Aluno());
		return retorno;
	}

}
