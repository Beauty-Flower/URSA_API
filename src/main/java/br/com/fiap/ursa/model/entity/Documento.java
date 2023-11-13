package br.com.fiap.ursa.model.entity;

import jakarta.validation.constraints.NotNull;

public class Documento {

	private int id;
	@NotNull private int idBicicleta;
	@NotNull private int idCliente;
	private String boleto;
	private String notaFiscal;
	@NotNull private String foto;
	
	public Documento() {}

	public Documento(int id, @NotNull int idBicicleta, @NotNull int idCliente, String boleto, String notaFiscal,
			@NotNull String foto) {
		this.id = id;
		this.idBicicleta = idBicicleta;
		this.idCliente = idCliente;
		this.boleto = boleto;
		this.notaFiscal = notaFiscal;
		this.foto = foto;
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

	public String getBoleto() {
		return boleto;
	}

	public void setBoleto(String boleto) {
		this.boleto = boleto;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
