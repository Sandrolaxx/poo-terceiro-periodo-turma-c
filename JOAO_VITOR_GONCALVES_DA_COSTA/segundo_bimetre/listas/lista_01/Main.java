package listas.lista_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    atv1();
    System.out.println("\n");
    atv2();
    System.out.println("\n");
    atv3();
    System.out.println("\n");
    atv4();
    System.out.println("\n");
    atv5();
  }

  // ATV 1
  public static void atv1() {
    List<String> nomes_dos_gurizes = new ArrayList<String>();

    nomes_dos_gurizes.add("Marcelo Orlandini");
    nomes_dos_gurizes.add("Kauê Pozzobon");
    nomes_dos_gurizes.add("Evandro Paludo");
    nomes_dos_gurizes.add("Luiz Gonçalves");
    nomes_dos_gurizes.add("Gabriel Colman");

    nomes_dos_gurizes.forEach(nome -> {
      System.out.println("J " + " - " + nome);
    });
  }

  // ATV 2

  public static void atv2() {
    HashSet<Integer> numeros_inteiros = new HashSet<Integer>();

    Random randomNumber = new Random();

    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));
    numeros_inteiros.add(randomNumber.nextInt(20));

    Integer numero_para_comparar = randomNumber.nextInt(20);

    if (numeros_inteiros.contains(numero_para_comparar)) {
      System.out.println("números_inteiros contem o número: " + numero_para_comparar);
    } else {
      System.out.println("números_inteiros não contem o número: " + numero_para_comparar);
    }

    for (Integer num : numeros_inteiros) {
      System.out.println(num);
    }
  }

  // ATV 3

  public static void atv3() {
    List<String> joguinhos_dos_guri = new ArrayList<String>();
    List<String> joguinhos_dos_guri_sem_repeticao = new ArrayList<String>();

    joguinhos_dos_guri.add("pokemon fire red");
    joguinhos_dos_guri.add("pokemon fire red");
    joguinhos_dos_guri.add("pokemon fire red");
    joguinhos_dos_guri.add("pokemon black and white");
    joguinhos_dos_guri.add("pokemon SoulSilver");
    joguinhos_dos_guri.add("Minecraft");
    joguinhos_dos_guri.add("Lego batman 2");
    joguinhos_dos_guri.add("Cod Black ops 2");
    joguinhos_dos_guri.add("Cod Black ops 2");
    joguinhos_dos_guri.add("Cod ghost");
    joguinhos_dos_guri.add("Cod ghost");

    for (String jogo : joguinhos_dos_guri) {
      if (!joguinhos_dos_guri_sem_repeticao.contains(jogo)) {
        joguinhos_dos_guri_sem_repeticao.add(jogo);
      }
    }

    for (String jogo : joguinhos_dos_guri_sem_repeticao) {
      System.out.println("Jogo: " + jogo);
    }
  }
  // ATV 4

  public static void atv4() {
    List<String> animesFilmesDosGuri = new ArrayList<String>();
    PriorityQueue<String> queueParaOrdenar = new PriorityQueue<String>(
        (a, b) -> a.toLowerCase().compareTo(b.toLowerCase()));
    animesFilmesDosGuri.add("One Piece");
    animesFilmesDosGuri.add("Naruto");
    animesFilmesDosGuri.add("Sonho possível");
    animesFilmesDosGuri.add("Soul");
    animesFilmesDosGuri.add("Como treinar seu dragão");
    animesFilmesDosGuri.add("Gente Grande");
    animesFilmesDosGuri.add("Carros");
    animesFilmesDosGuri.add("Duelo de Titans");
    animesFilmesDosGuri.add("Jurassic Park");
    animesFilmesDosGuri.add("Era do gelo 1");
    animesFilmesDosGuri.add("Era do gelo 2");

    queueParaOrdenar.addAll(animesFilmesDosGuri);
    animesFilmesDosGuri.clear();
    // Ordenando a PriorityQueue
    while (!queueParaOrdenar.isEmpty()) {
      animesFilmesDosGuri.add(queueParaOrdenar.poll());
    }

    for (String animes_filme : animesFilmesDosGuri) {
      System.out.println(animes_filme);
    }
  }
  // ATV 5

  public static void atv5() {
    Map<String, String> componentes_hadware = new HashMap<>();

    componentes_hadware.put("processador", "intel core i3");
    componentes_hadware.put("Placa mãe", "Aorus elite");
    componentes_hadware.put("Fonte", "Mag a650");
    componentes_hadware.put("Memória ram", "ASGAR ddr4");
    componentes_hadware.put("Gabinete", "Rise mode");

    for (Map.Entry<String, String> entrada : componentes_hadware.entrySet()) {
      System.out.println("Compoente: " + entrada.getKey() + ", modelo: " + entrada.getValue());
    }
  }
}

// Em uma classe Main:
// Atv1 - Criar um ArrayList de strings e adicione os nomes de cinco dos seus
// colegas favoritos da turma. Em seguida, itere sobre a lista e imprima a
// inicial do seu nome + " - " + cada nome da lista.
// Atv2 -Crie um HashSet de números inteiros e adicione alguns números
// repetidos. Verifique se o conjunto contém um número específico e imprima o
// resultado.
// Atv3 -Escreva um método que receba uma lista de strings contendo os jogos que
// você já zerou. Caso tenha zerado mais de uma vez, adicione o nome do jogo
// para cada vez. Após criar a lista de jogos zerados, retorne uma nova lista
// contendo apenas as strings únicas (sem duplicatas).
// Atv4 -Crie um método que utilize PriorityQueue para ordenar uma lista com o
// nome dos cinco melhores animes/filmes que você já viu em ordem alfabética. Em
// seguida, imprima a lista ordenada.
// Atv5 -Crie um método que crie uma estrutura que permita salvar as
// configurações de hardware da sua máquina, exemplo: "Processador" : "i5
// 7500U". Faça isso para no mínimo 5 peças e imprima a peça e seu respectivo
// valor.