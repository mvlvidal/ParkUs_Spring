package br.parkus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.parkus.model.Usuario;
import br.parkus.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long>{
	
	@Autowired
	private UsuarioRepository repository;

	
	public Usuario create(Usuario usuario) {
		return null;
		
	}
}
