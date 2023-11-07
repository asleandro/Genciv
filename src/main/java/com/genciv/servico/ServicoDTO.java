package com.genciv.servico;

import java.util.List;

import com.genciv.materialconsumido.MaterialConsumido;

public class ServicoDTO {
    private long id;
    private String nome;
    private String descricao;
    private double valorInstalacaoPorUnd;
    private double valorMaterialPorUnd;
    private List<MaterialConsumido> materiaisConsumidos;
    
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorInstalacaoPorUnd() {
		return valorInstalacaoPorUnd;
	}
	public void setValorInstalacaoPorUnd(double valorInstalacaoPorUnd) {
		this.valorInstalacaoPorUnd = valorInstalacaoPorUnd;
	}
	public double getValorMaterialPorUnd() {
		return valorMaterialPorUnd;
	}
	public void setValorMaterialPorUnd(double valorMaterialPorUnd) {
		this.valorMaterialPorUnd = valorMaterialPorUnd;
	}
	public List<MaterialConsumido> getMateriaisConsumidos() {
		return materiaisConsumidos;
	}
	public void setMateriaisConsumidos(List<MaterialConsumido> materiaisConsumidos) {
		this.materiaisConsumidos = materiaisConsumidos;
	}

    
}
