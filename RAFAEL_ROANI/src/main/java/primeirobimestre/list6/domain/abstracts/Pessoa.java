package primeirobimestre.list6.domain.abstracts;

public abstract class Pessoa {
    protected String nome;
    protected Integer idade;
    protected Endereco endereco;

    public Pessoa(String nome, Integer idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public abstract void apresentarse();

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}