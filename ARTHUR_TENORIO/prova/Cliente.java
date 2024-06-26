package ARTHUR_TENORIO.prova;

public class Cliente{

    private String nome;
    private String endereco;
    private String contato;
    private String cpf;

    public cliente(String nome, String endereco, String contato, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.cpf = cpf;
    }

 

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contato='" + contato + '\'' +
                ",CPF=" + cpf + '\'' + '}';
    }
}
