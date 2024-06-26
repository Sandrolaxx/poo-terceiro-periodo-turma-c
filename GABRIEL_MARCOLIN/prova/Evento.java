package GABRIEL_MARCOLIN.prova;

import java.util.Date;

public class Evento {

    private String nome;

    private Date dataInicio;

    private Date dataTermino;

    private double preco;

    public Evento(){
    }

    public Evento(String nomeEvento, long dataTermino,double preco){
        Long umDia = 86400000l;
        Long criacaoEvento = new Date().getTime();
        Long terminoEvento = criacaoEvento + (umDia * dataTermino);

        this.dataInicio = new Date();
        this.nome = nomeEvento;
        this.dataTermino = new Date(terminoEvento);
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio){
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino){
        this.dataTermino = dataTermino;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }
}