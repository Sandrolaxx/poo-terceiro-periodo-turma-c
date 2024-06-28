package RENAN_RIBEIRO_CORREA.prova;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private int capacidade;
    private List<Ingresso> ingressos;

    public Evento(int id, String nome, String descricao, Date data, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.capacidade = capacidade;
        this.ingressos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void addIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }
}
