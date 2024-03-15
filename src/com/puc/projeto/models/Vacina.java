package com.puc.projeto.models;

import java.util.ArrayList;

public class Vacina {
	
	private String nome;
	private ArrayList<Dose> doses;

	public Vacina() {}
	
	public Vacina(String nome, ArrayList<Dose> doses) {
		this.nome = nome;
		this.doses = doses;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDose(Dose dose) {
		this.doses.add(dose);
	}
	
	public void setDoses(ArrayList<Dose> doses) {
		this.doses = doses;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public ArrayList<Dose> getDoses() {
		return this.doses;
	}
}
