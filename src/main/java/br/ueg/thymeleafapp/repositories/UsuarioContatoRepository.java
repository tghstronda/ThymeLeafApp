package br.ueg.thymeleafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ueg.thymeleafapp.model.UsuarioContato;

public interface UsuarioContatoRepository extends JpaRepository<UsuarioContato, Long> {

	@Query("select usuario from UsuarioContato usuario " + "where usuario.email like ?1 and usuario.password like ?2")
	UsuarioContato findByLogin(String username, String password);
}
