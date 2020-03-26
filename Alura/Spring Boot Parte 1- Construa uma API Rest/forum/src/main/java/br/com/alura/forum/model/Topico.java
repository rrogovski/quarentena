package br.com.alura.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "topico")
public class Topico {

	@Id
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
  @NotNull
	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Setter
  @NotNull
	@Column(name = "mensagem", nullable = false)
	private String mensagem;

	@Setter
  @NotNull
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Setter
  @NotNull
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

	@Setter
	@ManyToOne
	private Usuario autor;

	@Setter
	@ManyToOne
	private Curso curso;

	@Setter
	@OneToMany(mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
