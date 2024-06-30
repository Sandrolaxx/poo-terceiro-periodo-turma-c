package SegundoBI.aulas.aula01;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class ListClasse {
      public static void main(String[] args) {
            List<String> nomes = new ArrayList<>();
            String alunoAleatorio= "Carlos";

            nomes.add("Gabriel");
            nomes.add("Rafael");
            nomes.add("Maria");
            nomes.add("João");

            for (String nome : nomes) {
                  System.out.println(nome);
            }

            nomes.add("João");

            // .length() pega o tamanho total do vetor e .size() quantos itens estão ocupando ele

            for (int i = 0; i < nomes.size(); i++) {
                  System.out.println(nomes.get(i));
            }

            nomes.remove(2);
            nomes.remove(alunoAleatorio);

            nomes.forEach(nome -> System.out.println(nome)); //Arrow function é com - ao invés de =

            //Exemplo de função lambda assim como forEach
            nomes.removeIf(nome -> nome.contains("l")); //Arrow function é com - ao invés de =

            //----------------
            //Lista Encadeada

            List<String> nomesEncadeados = new LinkedList<>();

            nomesEncadeados.add("Gabriel");
            nomesEncadeados.add("Rafael");
            nomesEncadeados.add("João");
            nomesEncadeados.add("Cleber");

            //nomesEncadeados.getFirst();
      }
}