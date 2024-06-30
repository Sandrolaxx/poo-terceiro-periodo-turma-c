package aula_01;

import java.util.HashSet;
import java.util.Set;

class Main {
  public static void main(String[] args) {
    Set<String> nomeNaoReptido = new HashSet<>();

    nomeNaoReptido.add("Marcelo");
    nomeNaoReptido.add("Pedro");
    nomeNaoReptido.add("Joao");
    nomeNaoReptido.add("Vitor");

    for (String nome : nomeNaoReptido) {
      System.out.println(nome);
    }

    System.out.println("\n -------------------- \n");

    nomeNaoReptido.forEach(item -> System.out.println(item));
  }
}