package RENAN_RIBEIRO_CORREA.prova;

public class Ingresso {
    private int id;
    private Evento evento;
    private Cliente cliente;
    private boolean utilizado;

    public Ingresso(int id, Evento evento, Cliente cliente) {
        this.id = id;
        this.evento = evento;
        this.cliente = cliente;
        this.utilizado = false;
    }

    public int getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
    }
}
