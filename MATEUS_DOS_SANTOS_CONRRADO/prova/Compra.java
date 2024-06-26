package MATEUS_DOS_SANTOS_CONRRADO.prova;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Cevento> eventos;

    public Compra() {
        this.eventos = new ArrayList<>();
    }

    public void cadastrarEvento(Cevento evento) {
        eventos.add(evento);
    }

    public void comprarIngresso(int indiceEvento, int quantidadeIngressos) {
        if (indiceEvento >= 0 && indiceEvento < eventos.size()) {
            Cevento evento = eventos.get(indiceEvento);
            evento.Compra(quantidadeIngressos);
        } else {
            System.out.println("Evento não encontrado.");
        }
    }
}
