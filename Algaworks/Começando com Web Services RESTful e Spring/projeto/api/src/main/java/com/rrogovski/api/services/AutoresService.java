package com.rrogovski.api.services;

import java.util.List;

import com.rrogovski.api.domain.Autor;
import com.rrogovski.api.repository.AutoresRepository;

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
}