package LUIZ_COLMAN.prova;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private List<Cliente> participantes;

    public Evento(String nome, String data, String local) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public void adicionarParticipante(Cliente cliente) {
        this.participantes.add(cliente);
    }

    public List<Cliente> getParticipantes() {
        return participantes;
    }
}

