package com.rrogovski.api.services;

import java.util.List;

import com.rrogovski.api.domain.Livro;
import com.rrogovski.api.repository.LivrosRepository;
import com.rrogovski.api.resources.LivroResources;
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

  public List<Livro> listar() {
    return livrosRepository.findAll();
  }

  public Livro buscar(Long id) {
    Livro livro = livrosRepository.getOne(id);

    if (livro == null) {
      throw new LivroNaoEncontratoException("Livro não encontrado!");
    }

    return livro;
  }

  public Livro salvar(Livro livro) {
    livro.setId(null);
    return livrosRepository.save(livro);
  }

  public Livro deletar(Long id) {
    Livro livro = livrosRepository.getOne(id);
    try {
      livrosRepository.deleteById(id);
      return livro;
    } catch (LivroNaoEncontratoException e) {
      throw new LivroNaoEncontratoException("Livro não encontrado!");
    }
  }

  public Livro atualizar(Livro livro) {
    verificarExistencia(livro);
    livrosRepository.save(livro);
    return livro;
  }

  private void verificarExistencia(Livro livro) {
    buscar(livro.getId());
  }
}