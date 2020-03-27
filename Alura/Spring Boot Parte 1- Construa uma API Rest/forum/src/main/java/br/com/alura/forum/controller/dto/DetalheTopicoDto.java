package br.com.alura.forum.controller.dto;

import java.util.List;

import br.com.alura.forum.model.Topico;
import lombok.Getter;

/**
 * DetalheTopicoDto
 */
@Getter
public class DetalheTopicoDto {

  private TopicoDto topico;
  private UsuarioDto autor;
  private List<RespostaDto> respostas;

  public DetalheTopicoDto(Topico topico) {
    this.topico = new TopicoDto(topico);
    this.autor = UsuarioDto.AsDto(topico.getAutor());
    this.respostas = RespostaDto.ListAsDto(topico.getRespostas());
  }
}