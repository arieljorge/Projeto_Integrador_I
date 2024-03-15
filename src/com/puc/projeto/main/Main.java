package com.puc.projeto.main;

import javax.swing.JOptionPane;

import com.puc.projeto.models.Usuario;

public class Main {

	public static void main(String[] args) {
		Usuario user = new Usuario();
		
		try {
			user.setNome( JOptionPane.showInputDialog("Informe seu Nome:") );
			user.setCidade( JOptionPane.showInputDialog("Informe sua Cidade:") );
			user.setEstado( JOptionPane.showInputDialog("Informe seu Estado: ") );
			user.setUnidade( JOptionPane.showInputDialog("informe a Unidade de Saúde") );
		} catch (Exception e) {
			System.out.println("Erro no processo de cadastro,\n tenha cuidado ao passar uma informção");
		}
		
		JOptionPane.showMessageDialog(null, String.format("Nome: %s\nCidade: %s\nEstado: %s\nUnidade de saúde: %s", user.getNome(), user.getCidade(), user.getEstado(), user.getUnidade()));
	}
}
