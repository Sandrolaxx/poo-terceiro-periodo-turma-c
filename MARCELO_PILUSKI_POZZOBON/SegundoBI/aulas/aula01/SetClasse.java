package SegundoBI.aulas.aula01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetClasse {
      public static void main(String[] args) {
            Set<String> nomeNaoRepetidos = new HashSet<>();

            nomeNaoRepetidos.add("Gabriel");
            nomeNaoRepetidos.add("Rafael");
            nomeNaoRepetidos.add("Maria");
            nomeNaoRepetidos.add("João");

            for (String nome : nomeNaoRepetidos) {
                  System.out.println(nome);
            }

            nomeNaoRepetidos.add("João");

            nomeNaoRepetidos.forEach(item -> System.out.println(item)); // Arrow function é com - ao invés de =
      }
}