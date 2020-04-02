package com.rrogovski.api.resources;

import java.util.List;

import com.rrogovski.api.domain.Autor;
import com.rrogovski.api.services.AutoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AutoresResource
 */
@RestController
@RequestMapping("/autores")
public class AutoresResource {

  @Autowired
  private AutoresService autoresService;

  @GetMapping
  public ResponseEntity<List<Autor>> listar() {
    return ResponseEntity.ok(autoresService.listar());
  }
}