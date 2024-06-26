package ERIKA_SARTORELLI.prova.Menu;

import java.util.ArrayList;

import ERIKA_SARTORELLI.prova.Evento.Evento;

public class ListaEventos {
    private ArrayList<Evento> eventos = new ArrayList<>();

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento.getNome() + " - Preço: R$" + evento.getPreco());
        }
    }
}

