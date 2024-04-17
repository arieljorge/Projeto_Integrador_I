package com.projeto.controle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.projeto.modelos.Dose;
import com.projeto.modelos.Sexo;
import com.projeto.modelos.Usuario;
import com.projeto.modelos.Vacina;

public class Controle {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private int indiceUsuario = -1;
	
	public Controle() {
		Scanner scan = new Scanner(System.in);
		listagem(scan);
		scan.close();
	}
	
	public void limparTela() {
		System.out.println("\n\n\n\n\n");
		System.out.println("\033[H\033[2J");
	}
	
	public void listagem(Scanner scan) {		
		System.out.print("1 - Selecionar usuário;\n2 - Adicionar usuário;\n: ");
		int escolha = scan.nextInt();
		
		limparTela();
		
		String CPF;
		
		switch (escolha) {
		case 1:
			
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getNome() + " - " + usuario.getCPF());
			}
			
			System.out.print("Informe o CPF do usuário: ");
			CPF = scan.next();
			
			indiceUsuario = -1;
			
			for (int i = 0; i < usuarios.size(); i++) {
				if ( usuarios.get(i).getCPF().equals(CPF) )
					indiceUsuario = i;
			}
			
			limparTela();
			if (indiceUsuario >= 0) {
				dadosUsuario(scan);
			} else {
				limparTela();
				System.out.println("USUÁRIO NÃO ENCONTRADO");
				listagem(scan);
			}
			
			break;
		case 2:
			
			Usuario usuario = new Usuario();
			
			String nome;
			String sexo;
			boolean gestante = false;
			int dia, mes, ano;
			String unidade;
			
			System.out.println("Preencha os campos abaixo...");
			System.out.print("Nome: ");
			nome = scan.next();
			System.out.print("CPF: ");
			CPF = scan.next();
			System.out.print("Sexo (M/F): ");
			sexo = scan.next();
			
			if ( sexo.toUpperCase().equals("F") ) {				
				System.out.print("Gestante ? (S/N)  ");
				gestante = scan.next().toUpperCase().equals("S") ? true : false;
			}
			
			System.out.println("Data de nascimento...");
			System.out.print("Dia: ");
			dia = scan.nextInt();
			System.out.print("Mês: ");
			mes = scan.nextInt();
			System.out.print("Ano: ");
			ano = scan.nextInt();
			System.out.print("Unidade de saúde: ");
			unidade = scan.next();
			
			usuario.setNome(nome);
			usuario.setCPF(CPF);
			usuario.setSexo(sexo.toUpperCase().equals("M") ? Sexo.MASCULINO : sexo.toUpperCase().equals("M") ? Sexo.FEMININO : null);
			usuario.setGestante(gestante);
			usuario.setUnidade(unidade);
			usuario.setData(new GregorianCalendar(ano, mes - 1, dia).getTime());
			usuario.setVacinas(new ArrayList<Vacina>());
			
			boolean permitido = true;
			
			for (Usuario u : usuarios) {
				if ( u.getCPF().equals(usuario.getCPF()) )
					permitido = false;
			}
			
			if (permitido) {
				usuarios.add(usuario);
				limparTela();
				listagem(scan);
			} else {
				limparTela();
				System.out.println("Não foi possível adicionar o usuário, CPF já registrado!!!!");
				listagem(scan);
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + escolha);
		}
	}
	
	public void dadosUsuario(Scanner scan) {
		Usuario usuario = usuarios.get(indiceUsuario);
		
		System.out.println(usuario.getNome() + " - " + usuario.getCPF());
		if ( usuario.getGestante() )
			System.out.println("GESTANTE");
		System.out.println("Data de nascimento : " + new SimpleDateFormat("dd/MM/yyyy").format(usuario.getData()) );
		System.out.println("Unidade de saúde: " + usuario.getUnidade());
		System.out.println("\n\nVACINAS:\n\n");
		
		if (usuario.getVacinas() != null) {			
			for (int i = 0; i < usuario.getVacinas().size(); i++) {
				usuario.getVacinas().get(i).imprimir(i + 1);
			}
		}
		
		System.out.print("\n\n1 - Adicionar vacina;\n2 - Editar Vacina/Dose;\n3 - Editar usuário;\n4 - Excluir usuário;\n5 - Voltar\n: ");
		int escolha = scan.nextInt();
		
		switch (escolha) {
		case 1:
			limparTela();
			adicionarVacina(scan);
			break;
		case 2:
			System.out.print("\nInforme o nome da vacina : ");
			String nome = scan.next();
			int indice = -1;
			
			for (int i = 0; i < usuario.getVacinas().size(); i++) {
				if (usuario.getVacinas().get(i).getNome().toUpperCase().equals(nome.toUpperCase()))
					indice = i;
			}
			
			limparTela();
			editarVacina(scan, indice, null);
			break;
		case 3:
			limparTela();
			editarUsuario(scan);
			break;
		case 4:
			usuarios.remove(indiceUsuario);
			limparTela();
			listagem(scan);
			break;
		case 5:
			limparTela();
			listagem(scan);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + escolha);
		}
	}

	private void adicionarVacina(Scanner scan) {
		System.out.print("Informe o nome da vacina: ");
		String nome = scan.next();
		
		Vacina vacina = new Vacina(nome);
		vacina.setDoses(new ArrayList<Dose>());
		
		usuarios.get(indiceUsuario).setVacina(vacina);
		limparTela();
		dadosUsuario(scan);
	}

	private void editarVacina(Scanner scan, int indice, String mensagem) {
		Usuario usuario = usuarios.get(indiceUsuario);
		Vacina vacina = usuario.getVacinas().get(indice);
		limparTela();
		vacina.imprimir(indice + 1);
		if(mensagem != null)
			System.out.println(mensagem);
		System.out.print("1 - Editar nome da vacina;\n2 - Remover vacina;\n3 - Adicionar dose;\n4 - Remover dose;\n5 - Editar dose;\n6 - Voltar;\n: ");
		int escolha = scan.nextInt();
		
		boolean permitido = true;
		
		switch (escolha) {
		case 1:
			System.out.print("\n\nNome vacina: ");
			String nome = scan.next();
			permitido = true;
			for(Vacina v : usuario.getVacinas()) {
				if ( v.getNome().toUpperCase().equals(nome.toUpperCase()) )
					permitido = false;
			}
			
			if(permitido) {
				usuarios.get(indiceUsuario).getVacinas().get(indice).setNome(nome);
				limparTela();
				editarVacina(scan, indice, null);
			}else {
				limparTela();
				editarVacina(scan, indice, "Nome da vacina já registrada!!!");
			}
			break;
		case 2:
			usuarios.get(indiceUsuario).getVacinas().remove(indice);
			limparTela();
			dadosUsuario(scan);
		case 3:
			int dia, mes, ano;
			String lote, codigo, nomeAplicante, registro;
			limparTela();
			System.out.println("Preencher os campos abaixo...");
			System.out.println("Data da aplicação...");
			System.out.print("Dia: ");
			dia = scan.nextInt();
			System.out.print("Mês: ");
			mes = scan.nextInt();
			System.out.print("Ano: ");
			ano = scan.nextInt();
			System.out.print("\nLote: ");
			lote = scan.next();
			System.out.print("Codigo: ");
			codigo = scan.next();
			System.out.println("\nDADOS DO APLICANTE");
			System.out.print("Nome: ");
			nomeAplicante = scan.next();
			System.out.print("Registro: ");
			registro = scan.next();
			
			Dose dose = new Dose(new GregorianCalendar(ano, mes - 1, dia).getTime(), lote, codigo, nomeAplicante, registro);
			
			permitido = true;
			
			for(Dose d : vacina.getDoses()) {
				if (d.getLote().toUpperCase().equals(dose.getLote().toUpperCase()))
					permitido = false;
			}
			
			if(permitido) {				
				usuarios.get(indiceUsuario).getVacinas().get(indice).setDose(dose);
				limparTela();
				editarVacina(scan, indice, null);
			}else {
				limparTela();
				editarVacina(scan, indice, "Lote da dose ja registrado!!!");
			}
			
			break;
		case 4:
			System.out.print("Informe o lote da dose: \n");
			String loteA = scan.next();
			
			for(int i = 0; i < vacina.getDoses().size(); i++) {
				if(vacina.getDoses().get(i).getLote().toUpperCase().equals(loteA.toUpperCase()))
					usuarios.get(indiceUsuario).getVacinas().get(indice).getDoses().remove(i);
			}
			
			limparTela();
			editarVacina(scan, indice, null);
			
			break;
		case 5:
			System.out.print("Informe o lote da dose: \n");
			String loteB = scan.next();
			int indiceDose = -1;
			
			for(int i = 0; i < vacina.getDoses().size(); i++) {
				if(vacina.getDoses().get(i).getLote().toUpperCase().equals(loteB.toUpperCase()))
					indiceDose = i;
			}
			
			if(indiceDose >= 0) {
				limparTela();
				editarDose(scan, indice, indiceDose);
			}else {
				limparTela();
				editarVacina(scan, indice, "Não foi encontrado o lote informado!!!");
			}
			break;
		case 6:
			limparTela();
			dadosUsuario(scan);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + escolha);
		}
	}

	private void editarDose(Scanner scan, int indiceVacina, int indiceDose) {
		int dia, mes, ano;
		String lote, codigo, nomeAplicante, registro;
		
		Vacina vacina = usuarios.get(indiceUsuario).getVacinas().get(indiceVacina);
		Dose dose = vacina.getDoses().get(indiceDose);
		
		System.out.println("Preencher os campos abaixo...");
		System.out.println(String.format("Data da aplicação: %s => ", new SimpleDateFormat("dd/MM/yyyy").format(dose.getData())));
		System.out.print("Dia: ");
		dia = scan.nextInt();
		System.out.print("Mês: ");
		mes = scan.nextInt();
		System.out.print("Ano: ");
		ano = scan.nextInt();
		System.out.print(String.format("\nLote: %s => ", dose.getLote()));
		lote = scan.next();
		System.out.print(String.format("Codigo: %s => ", dose.getCodigo()));
		codigo = scan.next();
		System.out.println("\nDADOS DO APLICANTE");
		System.out.print(String.format("Nome: %s => ", dose.getNome()));
		nomeAplicante = scan.next();
		System.out.print(String.format("Registro: %s => ", dose.getRegistro()));
		registro = scan.next();
		
		dose = new Dose(new GregorianCalendar(ano, mes - 1, dia).getTime(), lote, codigo, nomeAplicante, registro);
		
		boolean permitido = true;
		
		for(Dose d : vacina.getDoses()) {
			if (d.getLote().toUpperCase().equals(dose.getLote().toUpperCase()))
				permitido = false;
		}
		
		if(permitido) {
			usuarios.get(indiceUsuario).getVacinas().get(indiceVacina).getDoses().get(indiceDose).setCodigo(dose.getCodigo());
			usuarios.get(indiceUsuario).getVacinas().get(indiceVacina).getDoses().get(indiceDose).setData(dose.getData());
			usuarios.get(indiceUsuario).getVacinas().get(indiceVacina).getDoses().get(indiceDose).setLote(dose.getLote());
			usuarios.get(indiceUsuario).getVacinas().get(indiceVacina).getDoses().get(indiceDose).setNome(dose.getNome());
			usuarios.get(indiceUsuario).getVacinas().get(indiceVacina).getDoses().get(indiceDose).setRegistro(dose.getRegistro());
			limparTela();
			editarVacina(scan, indiceVacina, null);
		}else {
			limparTela();
			editarVacina(scan, indiceVacina, "Lote da dose ja registrado!!!");
		}
	}

	private void editarUsuario(Scanner scan) {
		Usuario usuario = usuarios.get(indiceUsuario);
		
		String nome;
		boolean gestante = false;
		int dia, mes, ano;
		String unidade;
		
		System.out.println("Preencha os campos abaixo...");
		System.out.print(String.format("Nome: %s => ", usuario.getNome()));
		nome = scan.next();
				
		if (usuario.getSexo().equals(Sexo.FEMININO)) {				
			System.out.print(String.format("Gestante (S/N): %s => ", usuario.getGestante() ? "Sim" : "Não"));
			gestante = scan.next().toUpperCase().equals("S") ? true : false;
		}
		
		System.out.println(String.format("Data de nascimento: %s", new SimpleDateFormat("dd/MM/yyyy").format(usuario.getData())));
		System.out.print("Dia: ");
		dia = scan.nextInt();
		System.out.print("Mês: ");
		mes = scan.nextInt();
		System.out.print("Ano: ");
		ano = scan.nextInt();
		
		System.out.print(String.format("Unidade de saúde: %s => ", usuario.getUnidade()));
		unidade = scan.next();
		
		usuarios.get(indiceUsuario).setNome(nome);
		usuarios.get(indiceUsuario).setGestante(gestante);
		usuarios.get(indiceUsuario).setData(new GregorianCalendar(ano, mes - 1, dia).getTime());
		usuarios.get(indiceUsuario).setUnidade(unidade);
		
		limparTela();
		dadosUsuario(scan);
	}
}
