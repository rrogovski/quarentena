package com.rrogovski.api.domain;

import java.util.Date;
import java.util.Locale;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

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
  @NotNull(message = "Informação obrigatória")
  @NotEmpty(message = "Informação obrigatória")
  @Column(name = "texto", nullable = false)
  @Size(min = 10, max = 1000, message = "Quantidade de caracteres dever de 10 a 1000!")
  @JsonProperty("comentario")
  private String texto;
  
  @Setter
  @NotNull(message = "Informação obrigatória")
  @NotEmpty(message = "Informação obrigatória")
  @Column(name = "usuario", nullable = false)
  private String usuario;
  
  @Setter
  @NotNull(message = "Informação obrigatória")
  // @NotEmpty(message = "Informação obrigatória")
  @Column(name = "data", nullable = false)
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-4")
  // @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private Date data;

  @Setter
  @NotNull(message = "Informação obrigatória")
  // @NotEmpty(message = "Informação obrigatória")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "livro_id")
  @JsonIgnore
  private Livro livro;
}
