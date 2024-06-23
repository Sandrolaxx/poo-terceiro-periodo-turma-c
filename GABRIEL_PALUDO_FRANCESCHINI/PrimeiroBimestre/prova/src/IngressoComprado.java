package GABRIEL_PALUDO_FRANCESCHINI.prova.src;

import java.util.ArrayList;

public class IngressoComprado {
    private  ArrayList<IngressoComprado> ingressoComprados = new ArrayList<>();
    private int idClienteComIngresso;
    private int idEventoSelecionado;
    private boolean ingressoUtilizado;    

    public IngressoComprado(int idClienteComIngresso, int idEventoSelecionado) {
        this.idClienteComIngresso = idClienteComIngresso;
        this.idEventoSelecionado = idEventoSelecionado;
    }

    public int getIdClienteComIngresso() {
        return idClienteComIngresso;
    }

    public void setIdClienteComIngresso(int idClienteComIngresso) {
        this.idClienteComIngresso = idClienteComIngresso;
    }

    public int getIdEventoSelecionado() {
        return idEventoSelecionado;
    }

    public void setIdEventoSelecionado(int idEventoSelecionado) {
        this.idEventoSelecionado = idEventoSelecionado;
    }

    public ArrayList<IngressoComprado> getIngressoComprados() {
        return ingressoComprados;
    }

    public void setIngressoComprados(ArrayList<IngressoComprado> ingressoComprados) {
        this.ingressoComprados = ingressoComprados;
    }

    public boolean isIngressoUtilizado() {
        return ingressoUtilizado;
    }

    public void setIngressoUtilizado(boolean ingressoUtilizado) {
        this.ingressoUtilizado = ingressoUtilizado;
    }

}