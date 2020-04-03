package com.rrogovski.api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Autor
 */
@Entity
@NoArgsConstructor
@Getter
@Table(name = "autor")
public class Autor {

  @Id
  @Setter
  @Column(name = "id", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @NotNull
  @Column(name = "nome")
  private String nome;

  @Setter
  @NotNull
  @Column(name = "nascimento")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date nascimento;

  @Setter
  @NotNull
  @Column(name = "nacionalidade")
  private String nacionalidade;

  @Setter
  @OneToMany(mappedBy = "autor")
  @JsonIgnore
  private List<Livro> livros;
}