package PrimeiroB.Ana_Castela;

public class Cliente {
    private String nome;
    private Integer idade;
    private String cpf;

    public Cliente(String nome, Integer idade, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void clienteDescricao () {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
