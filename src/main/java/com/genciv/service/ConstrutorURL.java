package com.genciv.service;

public class ConstrutorURL {

	private static final String BASE_URI = "http://localhost:8080/aprovar-orcamento";

	public static String construirURLAprovacaoOrcamento(Long orcamentoId, String codigoAprovacao) {
		return String.format("%s/%d?codigo=%s", BASE_URI, orcamentoId, codigoAprovacao);
	}

}
