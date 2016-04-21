

import org.omg.CORBA.ORB;

import HelloApp.HelloPOA;
import modelo.Agenda;
import modelo.Contato;

public class HelloImpl extends HelloPOA{

	private ORB orb;
	private Agenda agenda;
	
	public void setOrb(ORB orb_val){
		orb = orb_val;
		agenda = new Agenda();
	}
	
	public void shutdown(){
		orb.shutdown(false);
	}
	
	public String sayHello(){
		return "Agenda Iniciada";
	}

	@Override
	public String adicionarContato(String contato) {
		Contato c = agenda.stringToContato(contato);
		if(agenda.buscarContatoPorCPF(c.getCPF()) == null){
			agenda.getContatos().add(c);
			return "Contato adicionado com sucesso\n";
		}
		else{
			return "Contato ja existe na agenda\n";
		}
		
	}

	@Override
	public String removerContato(String contato) {
		Contato c = agenda.stringToContato(contato);
		if(agenda.buscarContatoPorCPF(c.getCPF()) != null){
			agenda.getContatos().remove(c);
			return "Contato removido com sucesso\n";
		}
		else{
			return "Contato nao encontrado\n";
		}
		
	}
	
	@Override
	public String buscarContato(String cpf) {
		Contato c = agenda.buscarContatoPorCPF(cpf);
		if(c != null){
			return agenda.contatoToString(c);
		}
		else{
			return "Contato nao encontrado\n";
		}
	}

	@Override
	public String editarContato(String cpf, String contato) {
		Contato c = agenda.buscarContatoPorCPF(cpf);
		if(c != null){
			agenda.removerContato(c);
			agenda.getContatos().add(agenda.stringToContato(contato));
			return "Contato editado com sucesso\n";

		}
		else{
			return "Contato nao encontrado\n";
		}
		
	}

	@Override
	public String listarContatos() {
		String agend = new String("Nome \t | CPF \t | Email \t | Telefone \n");
		
		for(Contato c: agenda.getContatos()){
			agend = agend + c.getNome();
			agend = agend + "\t | ";
			agend = agend + c.getCPF();
			agend = agend + "\t | ";
			agend = agend + c.getEmail();
			agend = agend + "\t | ";
			agend = agend + c.getTelefone();
			agend = agend + "\n";
		}
		return agend;
	}
	
	
	
}
