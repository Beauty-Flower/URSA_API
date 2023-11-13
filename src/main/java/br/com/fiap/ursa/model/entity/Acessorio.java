package br.com.fiap.ursa.model.entity;

import jakarta.validation.constraints.NotNull;

public class Acessorio {
		
	private int id;
	@NotNull private int idBicicleta;
	@NotNull private int idCliente;
	@NotNull private String descricao;
	@NotNull private float valor;
	
	public Acessorio() {}

	public Acessorio(int id, @NotNull int idBicicleta, @NotNull int idCliente, @NotNull String descricao,
			@NotNull float valor) {
		this.id = id;
		this.idBicicleta = idBicicleta;
		this.idCliente = idCliente;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBicicleta() {
		return idBicicleta;
	}

	public void setIdBicicleta(int idBicicleta) {
		this.idBicicleta = idBicicleta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
