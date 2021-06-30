package br.com.orange.cdc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Livro;
import br.com.orange.cdc.projecao.LivroProjecao;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{
	
	@Query(value = "SELECT l.titulo, l.id FROM livro l", nativeQuery = true)
	List<LivroProjecao> listTituloIdLivro();
}
