package segunda_versao.model;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;

    public Pessoa() {

    }

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void apresentarSe() {
        System.out.println("Nome da pessoa: " + nome);
        System.out.println("Idade da pessoa: " + idade);
    }
}
