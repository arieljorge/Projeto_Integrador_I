package com.puc.projeto.business;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

	private String nome;
	private String cidade;
	private String estado;
	private String unidadeDeSaude;
	private Date dataNascimento;
	
	private ArrayList<Vacina> vacinas;
	
	public Usuario() {}
	
	public Usuario(String nome, String cidade, String estado, String unidade, Date dataNascimento) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.unidadeDeSaude = unidade;
		this.dataNascimento = dataNascimento;
	}
	
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
	
	public void setVacina(Vacina vacina) {
		this.vacinas.add(vacina);
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
	
	public ArrayList<Vacina> getVacinas() {
		return this.vacinas;
	}
}
