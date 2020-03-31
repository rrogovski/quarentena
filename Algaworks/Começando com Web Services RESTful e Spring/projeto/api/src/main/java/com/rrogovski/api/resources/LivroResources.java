package com.rrogovski.api.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * LivroResources
 */
@RestController
@RequestMapping("/livros")
public class LivroResources {

	@Autowired
	private LivrosRepository livrosRepository;

  @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {

		// List<Livro> livros = new ArrayList<>();

		// livros.add(new Livro("Rest Aplicado"));
		// livros.add(new Livro("Git passo-a-passo"));

		return ResponseEntity.ok(livrosRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Livro> salvar(@RequestBody Livro livro) {		
		livrosRepository.save(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);

		return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Livro> deletar(@PathVariable("id") Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);

		if (livro.isPresent()) {
			livrosRepository.deleteById(id);
			return ResponseEntity.ok(livro.get());
		}

		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Livro> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {

		Optional<Livro> livroAtualizar = livrosRepository.findById(id);

		if (livroAtualizar.isPresent()) {
			livro.setId(id);
			livrosRepository.save(livro);
			return ResponseEntity.ok(livro);
		}

		return ResponseEntity.notFound().build();
	}
  
}