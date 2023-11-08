package com.genciv.orcamento;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.genciv.cliente.Cliente;
import com.genciv.endereco.Endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamentos")
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private String obra_orcada;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco enderecoObra;

	@OneToMany(mappedBy = "servico_orcado", fetch = FetchType.EAGER)
	@Cascade(CascadeType.PERSIST)
	private List<ServicoOrcado> servicosOrcados;
	
	
	private double valor_material_total;
	private double valor_servico_total;
	private String prazo_pagamento_material;
	private String prazo_pagamento_servico;
	private Boolean ativo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObraOrcada() {
		return obra_orcada;
	}

	public void setObraOrcada(String obraOrcada) {
		this.obra_orcada = obraOrcada;
	}

	public Endereco getEnderecoObra() {
		return enderecoObra;
	}

	public void setEnderecoObra(Endereco enderecoObra) {
		this.enderecoObra = enderecoObra;
	}

	public List<ServicoOrcado> getServicosOrcados() {
		return servicosOrcados;
	}

	public void setServicosOrcados(List<ServicoOrcado> servicosOrcados) {
		this.servicosOrcados = servicosOrcados;
	}

	public double getValorMaterialTotal() {
		return valor_material_total;
	}

	public void setValorMaterialTotal(double valorMaterialTotal) {
		this.valor_material_total = valorMaterialTotal;
	}

	public double getValorServicoTotal() {
		return valor_servico_total;
	}

	public void setValorServicoTotal(double valorServicoTotal) {
		this.valor_servico_total = valorServicoTotal;
	}

	public String getPrazoPagamentoMaterial() {
		return prazo_pagamento_material;
	}

	public void setPrazoPagamentoMaterial(String prazoPagamentoMaterial) {
		this.prazo_pagamento_material = prazoPagamentoMaterial;
	}

	public String getPrazoPagamentoServico() {
		return prazo_pagamento_servico;
	}

	public void setPrazoPagamentoServico(String prazoPagamentoServico) {
		this.prazo_pagamento_servico = prazoPagamentoServico;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
