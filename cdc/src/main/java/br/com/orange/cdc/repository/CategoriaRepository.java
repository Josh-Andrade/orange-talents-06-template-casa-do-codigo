package br.com.orange.cdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	Optional<Categoria> findByNome(String nome);
}
