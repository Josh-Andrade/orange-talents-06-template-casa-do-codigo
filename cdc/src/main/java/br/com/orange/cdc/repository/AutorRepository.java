package br.com.orange.cdc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

}
