package com.rrogovski.api.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rrogovski.api.domain.Livro;
import com.rrogovski.api.repository.LivrosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * LivroResources
 */
@RestController
@RequestMapping("/livros")
public class LivroResources {

	@Autowired
	private LivrosRepository livrosRepository;

  @RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {

		// List<Livro> livros = new ArrayList<>();

		// livros.add(new Livro("Rest Aplicado"));
		// livros.add(new Livro("Git passo-a-passo"));

		return livrosRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Livro salvar(@RequestBody Livro livro) {		
		livrosRepository.save(livro);
		return livro;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);

		return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Livro> deletar(@PathVariable("id") Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);

		//return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
		if (livro.isPresent()) {
			livrosRepository.deleteById(id);
			return ResponseEntity.ok(livro.get());
		}

		return ResponseEntity.notFound().build();
	}
  
}