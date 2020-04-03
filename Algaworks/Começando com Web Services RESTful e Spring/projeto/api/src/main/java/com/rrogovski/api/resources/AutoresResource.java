package com.rrogovski.api.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.rrogovski.api.domain.Autor;
import com.rrogovski.api.services.AutoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @PostMapping
  public ResponseEntity<Autor> salvar(@Valid @RequestBody Autor autor) {
    autor = autoresService.salvar(autor);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(autor);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Autor> buscar(@PathVariable("id") Long id) {
    return ResponseEntity.ok(autoresService.buscar(id));
  }
}