package GIULLIA_VILANOVA.prova;

public class Ingresso {

    private Evento evento;
    private double preco;
    private Cliente cliente;
    private int id;

    public Ingresso(Evento evento, double preco, Cliente cliente, int id) {
        this.evento = evento;
        this.preco = preco;
        this.cliente = cliente;
        this.id = id;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}