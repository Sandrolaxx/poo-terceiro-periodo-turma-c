package ERIKA_SARTORELLI.prova.Evento;

public class Evento {
    private String nome;
    private double preco;

    public Evento(String nome, double preco) {
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
