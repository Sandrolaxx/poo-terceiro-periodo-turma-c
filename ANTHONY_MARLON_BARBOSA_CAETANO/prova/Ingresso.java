package ANTHONY_MARLON_BARBOSA_CAETANO.prova;

public class Ingresso {
    private Evento evento;
    private Cliente cliente;
    private boolean utilizado;
    
    public Ingresso(Evento evento, Cliente cliente) {
        this.evento = evento;
        this.cliente = cliente;
        this.utilizado = false;
    }
    
    public void utilizarIngresso() {
        this.utilizado = true;
    }
    
    public Evento getEvento() {
        return evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean isUtilizado() {
        return utilizado;
    }
}
