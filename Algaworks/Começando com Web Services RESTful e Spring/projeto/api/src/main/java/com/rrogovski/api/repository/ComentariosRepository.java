package com.rrogovski.api.repository;

import com.rrogovski.api.domain.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ComentariosRepository
 */
public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

  
}