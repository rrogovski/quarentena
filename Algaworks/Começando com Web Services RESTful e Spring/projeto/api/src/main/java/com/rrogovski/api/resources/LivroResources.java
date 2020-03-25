package com.rrogovski.api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * LivroResources
 */
@RestController
public class LivroResources {

  @RequestMapping(value = "/livros", method = RequestMethod.GET)
	public String listar() {
		return "Rest aplicado, Git passo-a-passo";
	}
  
}