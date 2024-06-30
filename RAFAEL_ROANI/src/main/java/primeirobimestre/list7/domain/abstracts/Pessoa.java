package primeirobimestre.list7.domain.abstracts;

import primeirobimestre.list7.domain.domains.Endereco;

public abstract class Pessoa {
    protected String nome;
    protected Integer idade;
    protected Endereco endereco;

    public Pessoa(String nome, Integer idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
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