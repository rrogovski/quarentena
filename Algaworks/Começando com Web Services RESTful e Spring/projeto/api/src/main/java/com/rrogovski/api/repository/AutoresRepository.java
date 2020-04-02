package com.rrogovski.api.repository;

import com.rrogovski.api.domain.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AutoresRepository
 */
public interface AutoresRepository extends JpaRepository<Autor, Long>{

  
}