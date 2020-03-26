package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Topico;

/**
 * TopicoRepository
 */
public interface TopicoRepository extends JpaRepository<Topico, Long> {

  // Caso a entidade Topico tivesse uma propriedade chamada cursoNome
  // e também um método chamando findByCursoNome, mas considerando que
  // com esse método queria fazer a query pelo relacionamento com a entidade
  // Curso, basta colocar um _ entre no nome da entidade de relacionamento e
  // a sua propriedade, como abaixo. Caso queria pela propriedade da entidade
  // Topico, basta deixar sem _
  // E ainda é possível navegar entre relacionamento Topico->Curso->Categoria.nome
  // Existe uma anotação que você coloca, o @query. E aí você importa desse
  // pacote, Spring framework data. Nos parênteses, entre aspas, você vai ter
  // que montar a query na mão, usando o jpql. Você teria que fazer um
  // SELECT t FROM topico t WHERE t.curso.nome = :nomeCurso.
  // @Query("SELECT t FROM topico t WHERE t.curso.nome = :nomeCurso")
  // List<Topico> carregarPorCursoDoNome(@Param("nomeCurso") String nomeCurso);
  
	List<Topico> findByCurso_Nome(String nomeCurso);

    
}