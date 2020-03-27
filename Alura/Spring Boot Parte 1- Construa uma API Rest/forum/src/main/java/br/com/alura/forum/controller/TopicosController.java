package br.com.alura.forum.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

/**
 * TopicosController
 */
@RestController
@RequestMapping("/topicos")
public class TopicosController {

    // Injeção de dependência @Autowired
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // @RequestMapping(value = "/topicos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@RequestMapping(value = "/topicos", method = RequestMethod.GET)
    @GetMapping
    public List<TopicoDto> topicos(String nomeCurso) {

        // List<Topico> topicos = new ArrayList<Topico>();
        // Integer cursoId = 1, topicoId = 1;

        // for (int i = 0; i < 3; i++) {
        //     Curso curso = new Curso(String.format("Curso %d", i), String.format("Categoria %d", i));
        //     curso.setId(cursoId.longValue());
        //     cursoId++;

        //     for (int j = 0; j < 3; j++) {
        //         Topico topico = new Topico(String.format("Tópico %d - Curso %d", j, i), String.format("Mensagem %d-%d", j, i), curso);
        //         topico.setId(topicoId.longValue());
        //         topicoId++;

        //         topicos.add(topico);
        //     }
        // }

        List<Topico> topicos = null;

        topicos = nomeCurso == null ? topicoRepository.findAll() : topicoRepository.findByCurso_Nome(nomeCurso);

        return TopicoDto.ListAsDto(topicos);
    }

    //@RequestMapping(value = "/topicos", method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);

        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}