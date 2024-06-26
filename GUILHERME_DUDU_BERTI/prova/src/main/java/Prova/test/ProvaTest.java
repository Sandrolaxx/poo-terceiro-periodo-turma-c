package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.test;

import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain.Cliente;
import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain.Evento;

public class ProvaTest {
    public static void main(String[] args) {


        Cliente cliente1 = Cliente.ClienteBuilder.builder()
                .nome("Guilherme")
                .idade(18)
                .build();
        Cliente cliente2 = Cliente.ClienteBuilder.builder()
                .nome("Bernardo")
                .idade(18)
                .build();

        Evento evento1 = Evento.EventoBuilder.builder()
                .idEvento(1L)
                .nomeEvento("ExpoCap")
                .valorIngresso(44.90)
                .build();
        Evento evento2 = Evento.EventoBuilder.builder()
                .idEvento(2L)
                .nomeEvento("ExpoSalu")
                .valorIngresso(29.90)
                .build();


        System.out.println("========= CLIENTES =========");
        System.out.println(cliente1.apresentarse());
        System.out.println(cliente2.apresentarse());

        System.out.println("\n\n========= EVENTOS =========");
        System.out.println(evento1.gerarDescricaoEvento());
        System.out.println(evento2.gerarDescricaoEvento());


    }
}
