package prova;

import java.util.ArrayList;
import java.util.List;

public class ListarEventos {
    private List<CadastroEvento> eventos;

    public ListarEventos() {
        this.eventos = new ArrayList<>();
    }

    public void adicionarEvento(CadastroEvento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            System.out.println("Lista de Eventos:");
            for (CadastroEvento evento : eventos) {
                System.out.println("- " + evento.getNomeEvento());
            }
        }
    }

    public CadastroEvento selecionarEvento(String nomeEvento) {
        for (CadastroEvento evento : eventos) {
            if (evento.getNomeEvento().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }
}
