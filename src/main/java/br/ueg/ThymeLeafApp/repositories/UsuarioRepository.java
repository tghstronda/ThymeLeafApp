/**
 * 
 */
package br.ueg.ThymeLeafApp.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ueg.ThymeLeafApp.model.Usuario;

/**
 * @author tghstronda
 *
 */
public interface UsuarioRepository 
	extends PagingAndSortingRepository<Usuario, Long> {

}
