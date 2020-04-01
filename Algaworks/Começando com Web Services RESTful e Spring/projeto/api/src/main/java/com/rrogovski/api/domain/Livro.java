package com.rrogovski.api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
  @NotNull
	@Column(name = "nome", nullable = false)
  private String nome;

  @Setter
  @NotNull
	@Column(name = "autor", nullable = false)
  private String autor;

  @Setter
  @NotNull
	@Column(name = "publicacao", nullable = false)
  private Date publicacao;

  @Setter
  @NotNull
	@Column(name = "editora", nullable = false)
  private String editora;

  @Setter
  @NotNull
	@Column(name = "resumo", nullable = false)
  private String resumo;

  @Setter
  @NotNull
  // @JoinColumn(name = "comentarios", nullable = false)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro")
  private List<Comentario> comentarios;
}