package MARIA_JULIA.prova;

public class IngressoProva {
    private EventoProva evento;
    private int id;
    private double valor;
    
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = evento.getValorIngresso();
    }
    public IngressoProva(EventoProva evento, int id) {
        this.evento = evento;
        this.id = id;
    }
    public EventoProva getEvento() {
        return evento;
    }
    public void setEvento(EventoProva evento) {
        this.evento = evento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
