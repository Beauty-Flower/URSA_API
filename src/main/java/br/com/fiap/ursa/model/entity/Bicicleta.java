package br.com.fiap.ursa.model.entity;

import jakarta.validation.constraints.NotNull;

public class Bicicleta {
	
	private int id;
	@NotNull private int idCliente;
	@NotNull private String numeroSerie;
	@NotNull private String modelo;
	@NotNull private String marca;
	@NotNull private Float valor;
	
	public Bicicleta() {}

	public Bicicleta(int id, @NotNull int idCliente, @NotNull String numeroSerie, @NotNull String modelo,
			@NotNull String marca, @NotNull Float valor) {
		this.id = id;
		this.idCliente = idCliente;
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}
