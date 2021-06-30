package br.com.orange.cdc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.cdc.domain.Livro;
import br.com.orange.cdc.projecao.DetalheLivroProjecao;
import br.com.orange.cdc.projecao.LivroProjecao;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{
	
	@Query(value = "SELECT l.titulo, l.id FROM livro l", nativeQuery = true)
	List<LivroProjecao> listTituloIdLivro();
	
	@Query(value = "SELECT l.titulo, l.resumo, l.preco, l.numero_paginas as numeroPaginas, l.isbn, l.sumario, a.nome, a.descricao, c.nome as nomeCategoria "
			+ " FROM livro l"
			+ " JOIN autor a ON a.id = l.autor_id"
			+ " JOIN categoria c ON c.id = l.categoria_id"
			+ " WHERE l.id = :id", nativeQuery = true)
	Optional<DetalheLivroProjecao> detalhesLivroById(Long id);
}
