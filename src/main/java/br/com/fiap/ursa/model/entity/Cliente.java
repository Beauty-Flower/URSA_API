package br.com.fiap.ursa.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Cliente {
	
	private int id;
	@NotBlank private String nome;
	@NotNull private Long cpf;
	@NotNull private String senha;
	
	public Cliente() {}
	
	public Cliente(int id, @NotBlank String nome, @NotNull Long cpf, @NotNull String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
