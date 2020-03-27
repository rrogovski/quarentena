package br.com.alura.forum.config.validacao;

import lombok.Getter;

@Getter
public class ErroFormDto {

  private String campo;
  private String erro;

  public ErroFormDto(String campo, String erro) {
    this.campo = campo;
    this.erro = erro;
  }
}
