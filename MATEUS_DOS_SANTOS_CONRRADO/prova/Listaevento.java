package MATEUS_DOS_SANTOS_CONRRADO.prova;

import java.util.ArrayList;
import java.util.List;

public class Listaevento {
    private List<Listaevento> eventos;

    public Listaevento() {
        this.eventos = new ArrayList<>();
    }

    public void listarEventos() {
        System.out.println("Lista de Eventos:");
        for (Listaevento evento : eventos) {
            System.out.println(evento);
        }
    }
}
