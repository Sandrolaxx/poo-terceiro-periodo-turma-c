package GABRIEL_PALUDO_FRANCESCHINI.prova.src;

public class Eventos {

    private int idEvento;
    private String rua;
    private String cidade;
    private int numero;
    private String nomeEvento;
    private int diaEvento;
    private int mesEvento;

    public Eventos(int idEvento, String rua, int numero, String cidade, String nomeEvento, int diaEvento, int mesEvento) {
        this.idEvento = idEvento;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.nomeEvento = nomeEvento;
        this.diaEvento = diaEvento;
        this.mesEvento = mesEvento;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getDiaEvento() {
        return diaEvento;
    }

    public void setDiaEvento(int diaEvento) {
        this.diaEvento = diaEvento;
    }

    public int getMesEvento() {
        return mesEvento;
    }

    public void setMesEvento(int mesEvento) {
        this.mesEvento = mesEvento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    
    
    
}