package MATEUS_DOS_SANTOS_CONRRADO.prova;

 public class Ccliente {
    private String nome;
    private String email;
    private String telefone;

     public Ccliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

     public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
