package primeirobi.prova;

import java.util.Date;

public class Evento {
    
    private String tipo;
    private Date dataEvento = null;

    public Evento(String tipo, Date data) {
        this.tipo = tipo;
        this.dataEvento = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
}
