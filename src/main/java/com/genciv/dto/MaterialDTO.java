package com.genciv.dto;

import java.util.ArrayList;
import java.util.List;

import com.genciv.model.Fornecedor;

public class MaterialDTO {

	private long id;
	private String nome;
	private String tipo;
	private double valorCusto;
	private double valorVenda;
	private String unidade;
	private String qtdEmbalagem;
	private List<Fornecedor> fornecedores = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getQtdEmbalagem() {
		return qtdEmbalagem;
	}

	public void setQtdEmbalagem(String qtdEmbalagem) {
		this.qtdEmbalagem = qtdEmbalagem;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	

}
