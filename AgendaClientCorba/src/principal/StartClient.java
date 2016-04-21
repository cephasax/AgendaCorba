package principal;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class StartClient {

	public static void main(String[] args) {
		try{
	        // create and initialize the ORB
	        ORB orb = ORB.init(args, null);

	        // get the root naming context
	        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	 
	        // resolve the Object Reference in Naming
	        Hello hello = HelloHelper.narrow(ncRef.resolve_str("ABC"));

	        System.out.println(hello.sayHello());
	        Controlador cont = new Controlador();
	        
	        while(true){
				
				cont.Menu();
				int op = cont.getOpcao();
				//Inserir Contato
				if(op == 1){
					String contato = new String(cont.receberDadosContato());
					String result = hello.adicionarContato(contato);
					System.out.println(result);
				}
				
				//Excluir Contato
				else if(op == 2){
					String contato = new String(cont.receberDadosContato());
					String result = hello.removerContato(contato);
					System.out.println(result);
				}
				
				//Editar Contato
				else if(op == 3){
					String cpf = new String(cont.receberCpf());
					String contato = new String(cont.receberDadosContato());
					String result = hello.editarContato(cpf, contato);
					System.out.println(result);
				}
				
				//Buscar Contato
				else if(op == 4){
					String cpf = new String(cont.receberCpf());
					String result = hello.buscarContato(cpf);
					System.out.println(result);
				}
				
				//Listar Contatos
				else if(op == 5){
					String result = hello.listarContatos();
					System.out.println(result);
				}
	        }
	        } catch (Exception e) {
	          System.out.println("ERROR : " + e) ;
	          e.printStackTrace(System.out);
	          }
	    }

}
