package com.rrogovski.api.resources;

import java.net.URI;
import java.util.List;

import com.rrogovski.api.domain.Livro;
import com.rrogovski.api.services.LivrosService;
import com.rrogovski.api.services.exceptions.LivroNaoEncontratoException;

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
	private LivrosService livrosService;

  @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(livrosService.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Livro> salvar(@RequestBody Livro livro) {		
		livro = livrosService.salvar(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.ok(livrosService.buscar(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Livro> deletar(@PathVariable("id") Long id) {		
		return ResponseEntity.ok(livrosService.deletar(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Livro> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
		try {
			return ResponseEntity.ok(livrosService.atualizar(livro));
		} catch (LivroNaoEncontratoException e) {
			return ResponseEntity.notFound().build();
		}
	}
  
}