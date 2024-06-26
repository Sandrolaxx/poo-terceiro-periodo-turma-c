package Listasete;

public class Cliente {
    private String nome = "Ana";
    private int idade = 18;
    private String cidade = "Cascavel";
    private String endereco = "Rua Jacarandá";

    public Cliente(String nome, int idade, String cidade, String endereco){
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.endereco = endereco;
    }
    public void apresentarse(){
        System.out.println("Nome do cliente: " + nome);
        System.out.println("Idade do cliente: " + idade);
        System.out.println("Endereco: " + endereco);
        
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}
