package com.projeto.modelos;

import java.util.Date;

public class Dose {

	private Date data;
	private String lote;
	private String codigo;
	
	//dados de quem aplicou a vacina
	private String nome;
	private String registro;
	
	public Dose() {} 
	
	public Dose(Date data, String lote, String codigo, String nome, String registro) {
		this.data = data;
		this.lote = lote;
		this.codigo = codigo;
		this.nome = nome;
		this.registro = registro;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setLote(String lote) {
		this.lote = lote;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public String getLote() {
		return this.lote;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getRegistro() {
		return this.registro;
	}
}
