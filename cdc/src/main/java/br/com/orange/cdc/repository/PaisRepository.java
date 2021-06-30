package br.com.orange.cdc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long>{

}
