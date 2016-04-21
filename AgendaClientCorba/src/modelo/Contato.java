package modelo;

public class Contato {
    private String nome;
    private String CPF;
    private String email;
    private String telefone;

    public Contato() {
    	nome = new String();
    	CPF = new String();
    	email = new String();
    	telefone = new String();

    }

    public Contato(String nome, String CPF, String email, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
