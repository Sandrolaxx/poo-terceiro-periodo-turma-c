package EDUARDA_GABRIELI_KACPRZAK.prova;

import java.util.ArrayList;
import java.util.List;
import EDUARDA_GABRIELI_KACPRZAK.prova.CadastroEvento.Evento;

public class ListarEvento {
    private static List<Evento> eventos = new ArrayList<>(); 

    static void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("\nNão há eventos cadastrados.");
            return;
        }
        System.out.println("\nEventos Cadastrados");
        System.out.println("---------------------");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }
}
