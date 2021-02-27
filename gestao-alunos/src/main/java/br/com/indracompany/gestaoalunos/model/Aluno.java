package br.com.indracompany.gestaoalunos.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name ="increment", strategy = "incremet")
	private Long id;
	private String email;

	@NotBlank(message = "Nome é obrigatório!")
	private String nome;

	@PositiveOrZero(message = "Nota é obrigatória")
	private Integer nota;

	/* Código não testado
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
	private List<Materia> materia;
	 */

}
