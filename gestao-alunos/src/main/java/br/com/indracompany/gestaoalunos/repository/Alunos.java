package br.com.indracompany.gestaoalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.indracompany.gestaoalunos.model.Aluno;

public interface Alunos extends JpaRepository<Aluno, Long> {}
