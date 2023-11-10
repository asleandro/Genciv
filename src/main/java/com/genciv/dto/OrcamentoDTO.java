package com.genciv.dto;

import java.util.List;

import com.genciv.model.Cliente;
import com.genciv.model.Endereco;
import com.genciv.model.ServicoOrcado;

public class OrcamentoDTO {

	private Long id;
	private Cliente cliente;
	private String obraOrcada;
	private Endereco enderecoObra;
	private List<ServicoOrcadoDTO> servicosOrcados;
	private double valorMaterialTotal;
	private double valorServicoTotal;
	private String prazoPagamentoMaterial;
	private String prazoPagamentoServico;
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObraOrcada() {
		return obraOrcada;
	}

	public void setObraOrcada(String obraOrcada) {
		this.obraOrcada = obraOrcada;
	}

	public Endereco getEnderecoObra() {
		return enderecoObra;
	}

	public void setEnderecoObra(Endereco enderecoObra) {
		this.enderecoObra = enderecoObra;
	}

	public List<ServicoOrcadoDTO> getServicosOrcados() {
		return servicosOrcados;
	}

	public void setServicosOrcados(List<ServicoOrcadoDTO> servicosOrcados) {
		this.servicosOrcados = servicosOrcados;
	}

	public double getValorMaterialTotal() {
		return valorMaterialTotal;
	}

	public void setValorMaterialTotal(double valorMaterialTotal) {
		this.valorMaterialTotal = valorMaterialTotal;
	}

	public double getValorServicoTotal() {
		return valorServicoTotal;
	}

	public void setValorServicoTotal(double valorServicoTotal) {
		this.valorServicoTotal = valorServicoTotal;
	}

	public String getPrazoPagamentoMaterial() {
		return prazoPagamentoMaterial;
	}

	public void setPrazoPagamentoMaterial(String prazoPagamentoMaterial) {
		this.prazoPagamentoMaterial = prazoPagamentoMaterial;
	}

	public String getPrazoPagamentoServico() {
		return prazoPagamentoServico;
	}

	public void setPrazoPagamentoServico(String prazoPagamentoServico) {
		this.prazoPagamentoServico = prazoPagamentoServico;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
