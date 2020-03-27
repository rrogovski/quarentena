package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Usuario;
import lombok.Getter;

/**
 * UsuarioDto
 */
@Getter
public class UsuarioDto {

  private Long id;
  private String nome;
  private String email;

  public UsuarioDto(Usuario usuario) {
    this.id = usuario.getId();
    this.nome = usuario.getNome();
    this.email = usuario.getEmail();
  }

  public static UsuarioDto AsDto(Usuario usuario) {
    return new UsuarioDto(usuario);
  }

  public static List<UsuarioDto> ListAsDto(List<Usuario> usuarios) {
      return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
  }
}