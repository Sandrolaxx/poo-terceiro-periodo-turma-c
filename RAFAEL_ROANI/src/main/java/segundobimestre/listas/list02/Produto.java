package segundobimestre.listas.list02;

import java.text.Format;
import java.text.NumberFormat;

public class Produto {
    private String nome;
    private Double preco;


    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - " + "R$ " + preco;
    }

    public boolean isPriceMaior100() {
        return preco > 100;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
