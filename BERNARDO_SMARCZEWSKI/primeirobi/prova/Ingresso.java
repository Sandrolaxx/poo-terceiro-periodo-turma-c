package primeirobi.prova;

public class Ingresso {
    
    private Evento evento;
    private boolean uso = false;

    public Ingresso (Evento evento) {
        this.evento = evento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean isUse() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }

}
