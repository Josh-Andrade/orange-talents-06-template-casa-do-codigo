package br.com.orange.cdc.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.orange.cdc.dto.DetalheLivroDto;
import br.com.orange.cdc.dto.LivroDto;
import br.com.orange.cdc.projecao.DetalheLivroProjecao;
import br.com.orange.cdc.projecao.LivroProjecao;
import br.com.orange.cdc.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro")
public class ExibirLivrosController {

	private LivroRepository livroRepository;

	public ExibirLivrosController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping("/listar")
	public ResponseEntity<List<LivroDto>> listarLivros() {
		List<LivroProjecao> listaProjecao = livroRepository.listTituloIdLivro();
		return ResponseEntity.ok(listaProjecao.stream().map(LivroDto::new).collect(Collectors.toList()));
	}
	
	@GetMapping("detalhe/{id}")
	public ResponseEntity<DetalheLivroDto> detalheLivro(@PathVariable Long id){
		Optional<DetalheLivroProjecao> livroProjecao = livroRepository.detalhesLivroById(id);
		if(!livroProjecao.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(new DetalheLivroDto(livroProjecao.get()));
	}
}
