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
@SequenceGenerator(name = "livro_seq", sequenceName = "livro_seq", allocationSize = 1, initialValue = 1)
public class Livro {

  @Id
  @Column(name = "id", updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "livro_seq")
  private Long id;
  
  @Setter
  @NotNull
	@Column(name = "nome", nullable = false)
  private String nome;

  @Setter
  @NotNull
	@Column(name = "publicacao", nullable = false)
  private Date publicacao;

  @Setter
  @NotNull
	@Column(name = "publicacao", nullable = false)
  private String editora;

  @Setter
  @NotNull
	@Column(name = "publicacao", nullable = false)
  private String resumo;

  @Setter
  @NotNull
  @JoinColumn(name = "comentarios", nullable = false)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro_id")
  private List<Comentario> comentarios;
  private String autor;
}