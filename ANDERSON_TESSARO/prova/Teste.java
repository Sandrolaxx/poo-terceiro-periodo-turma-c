package ANDERSON_TESSARO.prova;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Evento evento1 = new Evento("Evento 1", "Local 1", "Data 1", 100);
        Evento evento2 = new Evento("Evento 2", "Local 2", "Data 2", 200);

        evento1.cadastrarParticipante("Participante 1", "12345678901");
        evento1.cadastrarParticipante("Participante 2", "23456789012");

        evento2.cadastrarParticipante("Participante 3", "34567890123");
        evento2.cadastrarParticipante("Participante 4", "45678901234");

        List<Evento> eventos = new ArrayList<>();
        eventos.add(evento1);
        eventos.add(evento2);

        System.out.println("Lista de eventos:");
        for (Evento evento : eventos) {
            System.out.println(evento.getNome());
        }

        System.out.println("\nComprando ingresso para Participante 1 no Evento 1:");
        evento1.comprarIngresso("12345678901");

        System.out.println("\nUtilizando ingresso para Participante 1 no Evento 1:");
        evento1.comprarIngresso("12345678901");

        System.out.println("\nLista de eventos:");
        for (Evento evento : eventos) {
            System.out.println(evento.getNome());
        }
    }
}