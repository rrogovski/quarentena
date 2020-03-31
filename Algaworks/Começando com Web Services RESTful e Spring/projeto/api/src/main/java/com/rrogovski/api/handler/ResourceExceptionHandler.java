package com.rrogovski.api.handler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPBinding;

import com.rrogovski.api.domain.DetalhesErro;
import com.rrogovski.api.services.exceptions.LivroNaoEncontratoException;

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

    DetalhesErro erro = new DetalhesErro();
    erro.setStatus(404l);
    erro.setTitulo("Livro não encontrado!");
    erro.setMensagemDesenvolvedor(String.format("%s/404", baseEnvLinkURL));
    erro.setTimestamp(System.currentTimeMillis());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
  }
}