package ANDERSON_TESSARO.prova;

import java.util.ArrayList;
import java.util.List;

public class Evento { 
    private String nome;
    private String local;
    private String data;
    private int capacidade;
    private List<Participante> participantes;

    public Evento(String nome, String local, String data, int capacidade) {
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.capacidade = capacidade;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public String getData() {
        return data;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void cadastrarParticipante(String nome, String cpf) {
        Participante participante = new Participante(nome, cpf);
        this.participantes.add(participante);
    }

    public void comprarIngresso(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'comprarIngresso'");
    }

    public boolean verificarDisponibilidadeIngresso(int quantidadeIngressos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarDisponibilidadeIngresso'");
    }

    public void venderIngresso(int quantidadeIngressos, Evento cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'venderIngresso'");
    }

    public Ingresso[] getIngressosVendidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIngressosVendidos'");
    }

}
   