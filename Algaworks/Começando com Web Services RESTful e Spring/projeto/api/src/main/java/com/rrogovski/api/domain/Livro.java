package com.rrogovski.api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Livro
 */
@Entity
@NoArgsConstructor
@Getter
@Table(name = "livro")
public class Livro {

  public Livro(String nome) {
    this.nome = nome;
  }

  @Id
  @Setter
  @Column(name = "id", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Setter
  @NotNull(message = "Informação obrigatória")
  @NotEmpty(message = "Informação obrigatória")
	@Column(name = "nome", nullable = false)
  private String nome;

  @Setter
  @NotNull(message = "Informação obrigatória")
  // @NotEmpty(message = "Informação obrigatória")
  @Column(name = "publicacao", nullable = false)
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date publicacao;

  @Setter
  @NotNull(message = "Informação obrigatória")
  @NotEmpty(message = "Informação obrigatória")
	@Column(name = "editora", nullable = false)
  private String editora;

  @Setter
  // @NotNull(message = "Informação obrigatória")
  @NotEmpty(message = "Informação obrigatória")
  @Size(min = 10, max = 1000, message = "Quantidade de caracteres dever de 10 a 1000!")
	@Column(name = "resumo", nullable = false)
  private String resumo;

  @Setter
  @NotNull(message = "Informação obrigatória")
  @ManyToOne
	@JoinColumn(name = "autor_id")
  private Autor autor;

  @Setter
  // @NotNull
  // @JoinColumn(name = "comentarios", nullable = false)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro")
  private List<Comentario> comentarios;
}