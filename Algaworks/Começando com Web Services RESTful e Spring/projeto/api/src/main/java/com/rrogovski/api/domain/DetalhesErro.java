package com.rrogovski.api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DetalhesErro
 */
@Getter
@Setter
@NoArgsConstructor
public class DetalhesErro {

  private String titulo;
  private Long status;
  private Long timestamp;
  private String mensagemDesenvolvedor;
}