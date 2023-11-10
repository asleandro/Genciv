package com.genciv.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String nome;
	private String descricao;
	private double valorInstalacaoPorUnd;
	private double valorMaterialPorUnd;

	@OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
	@Cascade(CascadeType.PERSIST)
	private List<MaterialConsumido> materiaisConsumidos = new ArrayList<>();

	public List<MaterialConsumido> getMateriaisConsumidos() {
		return materiaisConsumidos;
	}

	public void setMateriaisConsumidos(List<MaterialConsumido> materiaisConsumidos) {
		this.materiaisConsumidos = materiaisConsumidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
