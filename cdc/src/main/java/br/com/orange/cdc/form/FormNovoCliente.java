package br.com.orange.cdc.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.orange.cdc.config.validation.Exist;
import br.com.orange.cdc.config.validation.ValidCpfCnpj;
import br.com.orange.cdc.config.validation.ValorUnico;
import br.com.orange.cdc.domain.Cliente;
import br.com.orange.cdc.domain.Estado;
import br.com.orange.cdc.domain.Pais;
import br.com.orange.cdc.repository.ClienteRepository;
import br.com.orange.cdc.repository.EstadoRepository;
import br.com.orange.cdc.repository.PaisRepository;

public class FormNovoCliente {

	@ValidCpfCnpj(message = "Cpf ou Cnpj invalido")
	@NotBlank
	@ValorUnico(message = "Cpf ou Cpnj já cadastrado", campo = "documento", entity = "Cliente")
	private String documento;

	@NotBlank
	@Email
	@ValorUnico(message = "Email já cadastrado", campo = "email", entity = "Cliente")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@Exist(entity = Pais.class, message = "País não encontrado")
	private Long idPais;

	private Long idEstado;
	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public FormNovoCliente(@NotBlank String documento, @NotBlank @Email String email, @NotBlank String nome,
			@NotBlank String sobrenome, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente converterFormToEntityCliente(ClienteRepository clienteRepository, PaisRepository paisRepository,
			EstadoRepository estadoRepository) {
		Cliente cliente = new Cliente(documento, email, nome, sobrenome, endereco, complemento, cidade, retornaPais(paisRepository), telefone, cep);
		cliente.setEstado(retornaEstadoSePresente(estadoRepository));
		return cliente;
	}
	
	public Pais retornaPais(PaisRepository paisRepository) {
		return paisRepository.findById(idPais).get();
	}
	
	public Estado retornaEstadoSePresente(EstadoRepository estadoRepository) {
		return idEstado == null ? null : estadoRepository.findById(idEstado).get();
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
