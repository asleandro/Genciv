package com.genciv.dto;

public class ServicoOrcadoDTO {
	private Long servicoId;
	private Long orcamentoId;
	private double quantidade;
	

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servico_id) {
		this.servicoId = servico_id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Long getOrcamentoId() {
		return orcamentoId;
	}

	public void setOrcamentoId(Long orcamento_id) {
		this.orcamentoId = orcamento_id;
	}
	
	

}
