package com.rrogovski.api.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Comentario
 */
@Entity
@NoArgsConstructor
@Getter
@Table(name = "comentario")
public class Comentario {

  @Id
  @Setter
  @Column(name = "id", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @NotNull
  @Column(name = "texto", nullable = false)
  private String texto;
  
  @Setter
  @NotNull
  @Column(name = "usuario", nullable = false)
  private String usuario;
  
  @Setter
  @NotNull
  @Column(name = "data", nullable = false)
  private Date data;

  @Setter
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "livro_id")
  @JsonIgnore
  private Livro livro;
}
