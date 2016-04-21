package modelo;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<Contato>();
    }
    
    public void inserirContato(Contato c){
        contatos.add(c);
    }
    public boolean removerContato(Contato c){
        return contatos.remove(c);
    }
    public Contato removerContatoPorIndice(int id){
        return contatos.remove(id);
    }
    public Contato buscarContatoPorCPF(String CPF){
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getCPF().equalsIgnoreCase(CPF))
                return contatos.get(i);
        }
        return null;
    }
    
    public Contato buscarContatoPorEmail(String email){
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getEmail().equalsIgnoreCase(email))
                return contatos.get(i);
        }
        return null;
    }
    public List<Contato> buscarContatoPorNome(String nome){
        List<Contato> lista = new ArrayList<Contato>();
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getNome().contains(nome))
                lista.add(contatos.get(i));
        }
        return lista;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
    
    public String contatoToString(Contato c){
    	String contato = new String();
    	contato = 	c.getNome() + "-" 
    			+ 	c.getEmail() + "-" 
    			+ 	c.getCPF() + "-"
    			+ 	c.getTelefone();
    	return contato;
    }
    
    public Contato stringToContato(String c){
    	Contato contato = new Contato();
    	String partes[] = new String[4];
    	partes = c.split("-");
    	contato.setNome(partes[0]);
    	contato.setEmail(partes[1]);
    	contato.setCPF(partes[2]);
    	contato.setTelefone(partes[3]);
    	return contato;
    }
}
