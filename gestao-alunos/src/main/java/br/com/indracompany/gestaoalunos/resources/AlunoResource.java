package br.com.indracompany.gestaoalunos.resources;

import br.com.indracompany.gestaoalunos.model.Aluno;
import br.com.indracompany.gestaoalunos.repository.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        List<Aluno> alunos = alunosRepository.findAll();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Aluno>> getById(@PathVariable Long id) {
        Optional<Aluno> aluno;
        try {
            aluno = alunosRepository.findById(id);
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Aluno>> deleteById(@PathVariable Long id) {
        try {
            alunosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return alunosRepository.findById(id)
            .map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setNota(alunoAtualizado.getNota());
            Aluno alunoAtual = alunosRepository.save(aluno);
            return ResponseEntity.ok().body(alunoAtual);
        }).orElse(ResponseEntity.notFound().build());
    }

}
