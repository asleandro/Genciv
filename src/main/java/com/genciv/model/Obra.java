package com.genciv.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "obras")
public class Obra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamento;

	@OneToMany(mappedBy = "obra", cascade = CascadeType.ALL)
	private List<ServicoExecutado> servicosExecutados = new ArrayList<>();

	@OneToMany(mappedBy = "obra", cascade = CascadeType.ALL)
	private List<MaterialUtilizado> materiaisUtilizados = new ArrayList<>();

	public void adicionarServicoExecutado(ServicoOrcado servicoOrcado, double quantidade) {
		ServicoExecutado servicoExecutado = new ServicoExecutado(servicoOrcado, quantidade, this);
		this.servicosExecutados.add(servicoExecutado);
	}

	public void adicionarMaterialUtilizado(ServicoOrcado servicoOrcado, double quantidade) {
		MaterialUtilizado materialUtilizado = new MaterialUtilizado(servicoOrcado, quantidade, this);
		this.materiaisUtilizados.add(materialUtilizado);
	}

}
