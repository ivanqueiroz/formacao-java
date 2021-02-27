package br.com.indracompany.gestaoalunos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    /*Codigo não testado.
    @ManyToOne
    @JoinColumn(name = "id")
    private Aluno aluno;
     */

}
