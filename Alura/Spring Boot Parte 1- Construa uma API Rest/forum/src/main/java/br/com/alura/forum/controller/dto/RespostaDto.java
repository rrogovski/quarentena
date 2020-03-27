package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Resposta;
import lombok.Getter;

/**
 * RespostaDto
 */
@Getter
public class RespostaDto {

  private Long id;
  private String mensagem;
  private Boolean solucao;
  private LocalDateTime dataCriacao;
  private UsuarioDto autor;

  public RespostaDto(Resposta resposta) {
    this.id = resposta.getId();
    this.mensagem = resposta.getMensagem();
    this.solucao = resposta.getSolucao();
    this.dataCriacao = resposta.getDataCriacao();
    this.autor = UsuarioDto.AsDto(resposta.getAutor());
  }

  public static RespostaDto AsDto(Resposta resposta) {
    return new RespostaDto(resposta);
  }

  public static List<RespostaDto> ListAsDto(List<Resposta> respostas) {
      return respostas.stream().map(RespostaDto::new).collect(Collectors.toList());
  }
}