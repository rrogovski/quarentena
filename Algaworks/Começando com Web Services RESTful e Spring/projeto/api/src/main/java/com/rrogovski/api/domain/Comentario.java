package com.rrogovski.api.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@SequenceGenerator(name = "comentario_seq", sequenceName = "comentario_seq", allocationSize = 1, initialValue = 1)
public class Comentario {

  @Id
  @Column(name = "id", updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "comentario_seq")
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
}
