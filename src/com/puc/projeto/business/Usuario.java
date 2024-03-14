package com.puc.projeto.business;

import java.util.Date;

public class Usuario {

	protected String nome;
	protected String cidade;
	protected String estado;
	protected String unidadeDeSaude;
	protected Date dataNascimento;
	
	public Usuario() {}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setUnidade(String unidade) {
		this.unidadeDeSaude = unidade;
	}
	
	public void setData(Date data) {
		this.dataNascimento = data;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getUnidade() {
		return this.unidadeDeSaude;
	}
	
	public Date getData() {
		return this.dataNascimento;
	}
}
