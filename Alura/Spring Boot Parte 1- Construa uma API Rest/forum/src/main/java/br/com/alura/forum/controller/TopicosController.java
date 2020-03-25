package br.com.alura.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;

/**
 * TopicosController
 */
@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    // @RequestMapping(value = "/topicos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/topicos")
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

        List<Topico> topicos = topicoRepository.findAll();

        return TopicoDto.ListAsDto(topicos);
    }
}