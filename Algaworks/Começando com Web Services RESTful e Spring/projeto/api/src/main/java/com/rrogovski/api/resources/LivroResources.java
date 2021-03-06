package com.rrogovski.api.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import com.rrogovski.api.domain.Comentario;
import com.rrogovski.api.domain.Livro;
import com.rrogovski.api.services.LivrosService;
import com.rrogovski.api.services.exceptions.LivroNaoEncontratoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Livro>> listar() {
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		// return ResponseEntity.ok(livrosService.listar());
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livrosService.listar());
	}

	@PostMapping
	public ResponseEntity<Livro> salvar(@Valid @RequestBody Livro livro) {		
		livro = livrosService.salvar(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		// return ResponseEntity.ok(livrosService.buscar(id));
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livrosService.buscar(id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Livro> deletar(@PathVariable("id") Long id) {		
		return ResponseEntity.ok(livrosService.deletar(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
		try {
			return ResponseEntity.ok(livrosService.atualizar(livro));
		} catch (LivroNaoEncontratoException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/{id}/comentarios")
	public ResponseEntity<Void> adcionarComentario(@Valid @PathVariable("id") Long livroId, @RequestBody Comentario comentario) {
		livrosService.salvarComentario(livroId, comentario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}/comentarios")
	public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable("id") Long livroId) {
		return ResponseEntity.ok(livrosService.listarComentarios(livroId));
	}
}