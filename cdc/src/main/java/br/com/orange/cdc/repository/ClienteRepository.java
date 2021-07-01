package br.com.orange.cdc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
