package com.rrogovski.api.handler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPBinding;

import com.rrogovski.api.domain.DetalhesErro;
import com.rrogovski.api.services.exceptions.AutorExistenteException;
import com.rrogovski.api.services.exceptions.AutorNaoEncontradoException;
import com.rrogovski.api.services.exceptions.LivroNaoEncontratoException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * ResourceExceptionHandler
 */
@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(LivroNaoEncontratoException.class)
  public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException (LivroNaoEncontratoException e, HttpServletRequest request) {

    DetalhesErro erro = new DetalhesErro();
    erro.setStatus(404l);
    erro.setTitulo("Livro não encontrado!");
    erro.setMensagemDesenvolvedor(String.format("%s/404", baseURI()));
    erro.setTimestamp(System.currentTimeMillis());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
  }

  @ExceptionHandler(AutorExistenteException.class)
  public ResponseEntity<DetalhesErro> handleAutorExistenteException (AutorExistenteException e, HttpServletRequest request) {

    DetalhesErro erro = new DetalhesErro();
    erro.setStatus(409l);
    erro.setTitulo("O autor já existe!");
    erro.setMensagemDesenvolvedor(String.format("%s/409", baseURI()));
    erro.setTimestamp(System.currentTimeMillis());

    return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
  }

  @ExceptionHandler(AutorNaoEncontradoException.class)
  public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoException (AutorNaoEncontradoException e, HttpServletRequest request) {

    DetalhesErro erro = new DetalhesErro();
    erro.setStatus(409l);
    erro.setTitulo("Autor não encontrado!");
    erro.setMensagemDesenvolvedor(String.format("%s/409", baseURI()));
    erro.setTimestamp(System.currentTimeMillis());

    return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request) {

    DetalhesErro erro = new DetalhesErro();
    erro.setStatus(400l);
    erro.setTitulo("Requisição inválida!");
    erro.setMensagemDesenvolvedor(String.format("%s/400", baseURI()));
    erro.setTimestamp(System.currentTimeMillis());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
  }

  private String baseURI(){
    String baseEnvLinkURL = null;
    HttpServletRequest currentRequest = ((ServletRequestAttributes)RequestContextHolder.
      currentRequestAttributes()).getRequest();

    baseEnvLinkURL = "http://" + currentRequest.getLocalName();
    
    if(currentRequest.getLocalPort() != 80) {
      baseEnvLinkURL += ":" + currentRequest.getLocalPort();
    }
    
    if(!StringUtils.isEmpty(currentRequest.getContextPath())) {
        baseEnvLinkURL += currentRequest.getContextPath();
    }

    return baseEnvLinkURL;
  }
}