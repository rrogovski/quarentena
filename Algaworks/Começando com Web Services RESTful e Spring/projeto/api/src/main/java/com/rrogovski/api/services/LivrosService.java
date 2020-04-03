package com.rrogovski.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.rrogovski.api.domain.Comentario;
import com.rrogovski.api.domain.Livro;
import com.rrogovski.api.repository.AutoresRepository;
import com.rrogovski.api.repository.ComentariosRepository;
import com.rrogovski.api.repository.LivrosRepository;
import com.rrogovski.api.services.exceptions.LivroNaoEncontratoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LivrosService
 */
@Service
public class LivrosService {

  @Autowired
  private LivrosRepository livrosRepository;

  @Autowired
  private AutoresRepository autoresRepository;

  @Autowired
  private ComentariosRepository comentariosRepository;

  public List<Livro> listar() {
    return livrosRepository.findAll();
  }

  public Livro buscar(Long id) {
    Optional<Livro> livro = livrosRepository.findById(id);

    if (!livro.isPresent()) {
      throw new LivroNaoEncontratoException("Livro não encontrado!");
    }

    return livro.get();
  }

  public Livro salvar(Livro livro) {
    livro.setId(null);
    livro.setAutor(autoresRepository.getOne(livro.getAutor().getId()));

    return livrosRepository.save(livro);
  }

  public Livro deletar(Long id) {
    Optional<Livro> livro = livrosRepository.findById(id);

    if (livro.isPresent()) {
      livrosRepository.deleteById(id);
      return livro.get();
    } else {
      throw new LivroNaoEncontratoException("Livro não encontrado!");
    }
  }

  public Livro atualizar(Livro livro) {
    verificarExistencia(livro);
    livrosRepository.save(livro);
    return livro;
  }

  public Comentario salvarComentario(Long livroId, Comentario comentario) {
    Livro livro = buscar(livroId);

    comentario.setLivro(livro);
    comentario.setData(new Date());

    return comentariosRepository.save(comentario);
  }

  public List<Comentario> listarComentarios(Long livroId) {
    Livro livro = buscar(livroId); 

    return livro.getComentarios();
  }

  private void verificarExistencia(Livro livro) {
    buscar(livro.getId());
  }
}