package ISABELA_VITORIA.prova;

public class Ingresso {
    private Cliente cliente;
    private Evento evento;

    public Ingresso(Cliente cliente, Evento evento) {
        this.cliente = cliente;
        this.evento = evento;
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
