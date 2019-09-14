package br.ueg.ThymeLeafApp.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.ueg.ThymeLeafApp.model.UserContato;

public interface ContatoRepository
	extends PagingAndSortingRepository <UserContato , Long>
{

}
