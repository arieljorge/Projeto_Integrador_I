package com.projeto.modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {

	private String nome;
	private String CPF;
	private String cidade;
	private String estado;
	private String unidadeDeSaude;
	private Date dataNascimento;
	private Sexo sexo;
	private boolean gestante;
	
	private ArrayList<Vacina> vacinas;
	
	public Usuario() {}
	
	public Usuario(String nome, String CPF, String cidade, String estado, String unidade, Date dataNascimento, Sexo sexo, boolean gestante) {
		this.nome = nome;
		this.CPF = CPF;
		this.cidade = cidade;
		this.estado = estado;
		this.unidadeDeSaude = unidade;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.gestante = gestante;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
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
	
	public void setVacinas(ArrayList<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public void setGestante(boolean gestante) {
		this.gestante = gestante;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCPF() {
		return this.CPF;
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
	
	public Sexo getSexo() {
		return this.sexo;
	}
	
	public boolean getGestante() {
		return this.gestante;
	}
	
	public void imprimir() {
		if (this.gestante) {
			System.out.println(String.format("NOME: %s\nDATA NASCIMENTO: %s\nSEXO: %s\nCIDADE: %s\nESTADO: %s\nUNIDADE DE SAÚDE: %s", 
					this.nome, 
					new SimpleDateFormat("dd/MM/yyyy").format(this.dataNascimento), 
					this.sexo + "(GESTANTE)", 
					this.cidade, 
					this.estado, 
					this.unidadeDeSaude));
		} else {			
			System.out.println(String.format("NOME: %s\nDATA NASCIMENTO: %s\nSEXO: %s\nCIDADE: %s\nESTADO: %s\nUNIDADE DE SAÚDE: %s", 
					this.nome, 
					new SimpleDateFormat("dd/MM/yyyy").format(this.dataNascimento), 
					this.sexo, 
					this.cidade, 
					this.estado, 
					this.unidadeDeSaude));
		}
	}
}
