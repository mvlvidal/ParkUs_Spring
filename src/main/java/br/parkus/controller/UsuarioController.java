package br.parkus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.parkus.service.UsuarioService;

@RestController("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
}
