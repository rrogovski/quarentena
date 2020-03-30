package com.rrogovski.api.repository;

import com.rrogovski.api.domain.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LivrosRepository
 */
public interface LivrosRepository extends JpaRepository<Livro, Long>{

  
}