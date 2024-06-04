package br.parkus.repository;

import org.springframework.stereotype.Repository;

import br.parkus.model.Usuario;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{

	Usuario findByLogin(String login);
}
