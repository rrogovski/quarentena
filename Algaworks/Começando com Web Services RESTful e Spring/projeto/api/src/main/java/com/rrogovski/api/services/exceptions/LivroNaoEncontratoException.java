package com.rrogovski.api.services.exceptions;

/**
 * LivroNaoEncontratoException
 */
public class LivroNaoEncontratoException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public LivroNaoEncontratoException(String mensagem) {
    super(mensagem);
  }

  public LivroNaoEncontratoException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}