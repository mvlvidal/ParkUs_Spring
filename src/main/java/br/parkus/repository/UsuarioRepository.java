package br.parkus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.parkus.model.Usuario;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByLogin(String login);
}
