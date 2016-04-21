package teste;

import principal.Controlador;

public class MainTeste {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Controlador cont = new Controlador();
		AgendaService as = new AgendaService();
		
		while(true){
			
			/*
			"1 - Inserir Contato"
			"2 - Excluir Contato"
			"3 - Editar Contato"
			"4 - Buscar Contato"
			"5 - Listar Contato"
			*/
			
			cont.Menu();
			int op = cont.getOpcao();
			if(op == 1){
					String contato = new String(cont.receberDadosContato());
					String result = as.adicionarContato(contato);
					System.out.println(result);
			}
			else if(op == 2){
				String contato = new String(cont.receberDadosContato());
				String result = as.removerContato(contato);
				System.out.println(result);
			}
			else if(op == 3){
				String cpf = new String(cont.receberCpf());
				String contato = new String(cont.receberDadosContato());
				String result = as.editarContato(cpf, contato);
				System.out.println(result);
			}
			else if(op == 4){
				String cpf = new String(cont.receberCpf());
				String result = as.buscarContato(cpf);
				System.out.println(result);
			}
			else if(op == 5){
				String result = as.listarContatos();
				//System.out.println(result);
			}
			
		}
	}
}


