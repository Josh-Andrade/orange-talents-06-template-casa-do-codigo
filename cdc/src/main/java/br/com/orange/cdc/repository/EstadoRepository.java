package br.com.orange.cdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long>{
	
	@Query(value = "SELECT e FROM Estado e WHERE e.pais.id =:id AND e.nome like :nome")
	Optional<Estado> verificaEstadoDisponivelPais(Long id, String nome);
	
	@Query(value = "SELECT e FROM Estado e WHERE e.id =:idEstado AND e.pais.id =:idPais")
	Optional<Estado> verificaEstadoPertencePais(Long idEstado, Long idPais);
	
}
