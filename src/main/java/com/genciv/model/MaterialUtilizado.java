package com.genciv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "materiais_utilizados")
public class MaterialUtilizado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "servico_orcado_id")
	private ServicoOrcado servicoOrcado;

	@ManyToOne
	@JoinColumn(name = "obra_id")
	private Obra obra;

	private double quantidade;

	public MaterialUtilizado(ServicoOrcado servicoOrcado, double quantidade, Obra obra) {
		this.servicoOrcado = servicoOrcado;
		this.quantidade = quantidade;
		this.obra = obra;
	}
}
