package listas.lista02;

public class Product {
    private String nome;
    private double preco;

    public Product (String nome, double preco) {
        this.nome = nome;
        this.preco = preco;

    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

}