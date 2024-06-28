package SegundoBimestre.ATV2;

public class Produtos {
    public String nome;
    public Integer preco;

    public Produtos(String nome, Integer preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getPreco() {
        return preco;
    }
    public void setPreco(Integer preco) {
        this.preco = preco;
    }
}