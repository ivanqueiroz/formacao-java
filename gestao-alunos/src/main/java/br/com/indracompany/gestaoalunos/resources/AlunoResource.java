package br.com.indracompany.gestaoalunos.resources;

import br.com.indracompany.gestaoalunos.model.Aluno;
import br.com.indracompany.gestaoalunos.repository.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/alunos")
public class AlunoResource {

    @Autowired
    private Alunos alunosRepository;

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        alunosRepository.save(aluno);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

}
