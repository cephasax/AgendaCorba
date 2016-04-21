package principal;

import java.util.Scanner;

import modelo.Agenda;
import modelo.Contato;

public class Controlador {
	
	public Scanner in = new Scanner(System.in);
	private int opcao = 0;
	
	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public void Menu(){
		opcao = 0; 
		System.out.println("Escolha sua opcao:\n"
		 		+ "1 - Inserir Contato\n"
		 		+ "2 - Excluir Contato\n"
		 		+ "3 - Editar Contato\n"
		 		+ "4 - Buscar Contato\n"
		 		+ "5 - Listar Contato\n\n");
		String op = in.nextLine(); 
		opcao = Integer.valueOf(op);
	 }
	
	public int escolherOpcao(){
		return opcao;
	}
	
	public String receberDadosContato(){
		
		Contato c = new Contato();
		System.out.println("Digite o nome do contato: ");
		c.setNome(in.nextLine());
		System.out.println("Digite o cpf do contato: ");
		c.setCPF(in.nextLine());
		System.out.println("Digite o email do contato: ");
		c.setEmail(in.nextLine());
		System.out.println("Digite o telefone do contato: ");
		c.setTelefone(in.nextLine());
		Agenda a = new Agenda();
		
		return a.contatoToString(c);
	}
	
	public String receberCpf(){
		System.out.println("Digite o cpf do contato procurado: ");
		String cpf = new String(in.nextLine());
		return cpf;		
	}
	
}
