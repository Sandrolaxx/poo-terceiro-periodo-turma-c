package SegundoBI.aulas.aula02;

import java.util.ArrayList;
import java.util.List;

public class FilterSample {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        

        frutas.add("Melancia");
        frutas.add("Laranja");
        frutas.add("Uva");
        frutas.add("Maça");
        frutas.add("Uva");

        List<String> apenasUvas = new ArrayList<>();

        for(String fruta : frutas) {
            if (fruta.equals("Uva")) {
                apenasUvas.add(fruta);
            }
        }

        // FAZENDO COM STREAM API

        List<String> apenasUvas2 = frutas.stream().filter(fruta -> fruta == "Uva").toList();
        // IMPORTANTE LEMBRAR DO MÉTODO .toList() PARA ADICIONAR NA LISTA
        // PREFERÍVEL USAR .equals() AO INVÉS DE ==

        // .map() muda os valores da lista (array) que nem no JS

        // .findFirst() resolve o problema do NullPointerException
        // .orElse()

    }
}