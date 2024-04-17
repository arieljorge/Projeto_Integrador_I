package com.projeto.modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Vacina {

	private String nome;
	private ArrayList<Dose> doses;

	public Vacina() {}
	
	public Vacina(String nome) {
		this.nome = nome;
	}
	
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
	
	public void imprimir(int indice) {
		System.out.println(String.format(indice + ". %s\n", this.nome));
		
		for(int i = 0; i < doses.size(); i++) {
			Dose dose = doses.get(i);
			
			String mensagem = indice + ":" + (i+1) + 
					". \tDATA: %s\n" +
					"  \tLOTE: %s\n" +
					"  \tCÓDIGO: %s\n" +
					"  \tASS: %s\n" +
					"  \t     %s\n";
			
			System.out.println(String.format(mensagem, new SimpleDateFormat("dd/MM/yyyy").format(dose.getData()), dose.getLote(), dose.getCodigo(), dose.getNome(), dose.getRegistro()));
		}
	}
}
