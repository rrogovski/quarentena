package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Curso;

/**
 * CursoRepository
 */
public interface CursoRepository extends JpaRepository<Curso, Long>{

  Curso findByNome(String nome);
  List<Curso> findByCategoria(String categoria);
  
}