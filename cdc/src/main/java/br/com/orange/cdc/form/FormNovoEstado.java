package br.com.orange.cdc.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.orange.cdc.config.validation.Exist;
import br.com.orange.cdc.domain.Estado;
import br.com.orange.cdc.domain.Pais;
import br.com.orange.cdc.repository.PaisRepository;

public class FormNovoEstado {

	@NotBlank
	private String nome;

	@Exist(entity = Pais.class)
	@NotNull
	private Long idPais;

	public FormNovoEstado(@NotBlank String nome, @NotBlank Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Long getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

	public Estado converterToEntityEstado(PaisRepository paisRepository) {
		return new Estado(nome, retornaPais(paisRepository));
	}

	public Pais retornaPais(PaisRepository paisRepository) {
		return paisRepository.findById(idPais).get();
	}
}
