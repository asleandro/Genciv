package com.genciv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;

	public Endereco() {

	}

	public void atualizarInformacoes(Endereco novoEndereco) {
		if (novoEndereco.getLogradouro() != null) {
			this.logradouro = novoEndereco.getLogradouro();
		}
		if (novoEndereco.getBairro() != null) {
			this.bairro = novoEndereco.getBairro();
		}
		if (novoEndereco.getCep() != null) {
			this.cep = novoEndereco.getCep();
		}
		if (novoEndereco.getUf() != null) {
			this.uf = novoEndereco.getUf();
		}
		if (novoEndereco.getCidade() != null) {
			this.cidade = novoEndereco.getCidade();
		}
		if (novoEndereco.getNumero() != null) {
			this.numero = novoEndereco.getNumero();
		}
		if (novoEndereco.getComplemento() != null) {
			this.complemento = novoEndereco.getComplemento();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
