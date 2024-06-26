package RAFAEL_ROANI.prova.domain;

public class Ingresso {
    private Evento evento;
    private Cliente cliente;

    public Ingresso(Evento evento, Cliente cliente) {
        this.evento = evento;
        this.cliente = cliente;
    }

    public void usar() {
        System.out.println("Ingresso utilizado por " + cliente.getNome() + " no evento: " + evento.getTitulo());
    }

    public Evento getEvento() {
        return evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
