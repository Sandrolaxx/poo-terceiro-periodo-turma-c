package MARIA_CLARA_LIOTTO.prova;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private double precoIngresso;
    @SuppressWarnings("rawtypes")
    private List ingressosDisponiveis;
    
    

  
    
    @SuppressWarnings("unchecked")
    public Evento(String nome, String data, double precoIngresso, int ingressosDisponiveis) {
        this.nome = nome;
        this.data = data;
        this.precoIngresso = precoIngresso;
        this.ingressosDisponiveis = new ArrayList<>();
        for (double i = 0; i < i; i++) {
            this.ingressosDisponiveis.add(new Ingresso(this));
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getData() {
        return data;
    }
    
    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }


    
    @SuppressWarnings("rawtypes")
    public List getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }
    
    public int getQuantidadeIngressosDisponiveis() {
        return ingressosDisponiveis.size();
    }
    
    public boolean temIngressosDisponiveis() {
        return !ingressosDisponiveis.isEmpty();
    }
    @SuppressWarnings("null")
    public int comprarIngresso() {
        if (temIngressosDisponiveis()) {
            return (int) ingressosDisponiveis.remove(0);
        } else {
            return (Integer) null;
        }
    }
    
    
}