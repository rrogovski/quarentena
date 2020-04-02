package com.rrogovski.api.services;

import java.util.List;

import com.rrogovski.api.domain.Autor;
import com.rrogovski.api.repository.AutoresRepository;
import com.rrogovski.api.services.exceptions.AutorExistenteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AutoresService
 */
@Service
public class AutoresService {

  @Autowired
  private AutoresRepository autoresRepository;

  public List<Autor> listar() {
    return autoresRepository.findAll();
  }

  public Autor salvar(Autor autor) {
    if(autor.getId() != null) {
      Autor autorExistente = autoresRepository.getOne(autor.getId());

      if(autorExistente != null) {
        throw new AutorExistenteException("O autor já existe!");
      }
    }

    return autoresRepository.save(autor);
  }
}