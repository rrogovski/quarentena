package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Curso;
import lombok.Getter;

/**
 * CursoDto
 */
@Getter
public class CursoDto {

  private Long id;
  private String categoria;
  private String nome;

  public CursoDto(Curso curso) {
    this.id = curso.getId();
    this.categoria = curso.getCategoria();
    this.nome = curso.getNome();
  }

  public static CursoDto AsDto(Curso curso) {
    return new CursoDto(curso);
  }

  public static List<CursoDto> ListAsDto(List<Curso> cursos) {
      return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
  }
}