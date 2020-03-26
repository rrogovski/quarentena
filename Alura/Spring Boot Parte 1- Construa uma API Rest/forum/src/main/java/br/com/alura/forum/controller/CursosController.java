package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.model.Curso;
import br.com.alura.forum.repository.CursoRepository;

/**
 * CursosController
 */
@RestController
@RequestMapping("/cursos")
public class CursosController {

  @Autowired
    private CursoRepository cursoRepository;

  @GetMapping
  public List<Curso> cursos(String categoria) {

    List<Curso> cursos = null;

    cursos = categoria == null ? cursoRepository.findAll() : cursoRepository.findByCategoria(categoria);

    return cursos; 
  }
}