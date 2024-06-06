package Lista01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Lista01 {

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
    List<String> nomes_dos_xirus = new ArrayList<String>();

    nomes_dos_xirus.add("Guilherme");
    nomes_dos_xirus.add("Bernardo");
    nomes_dos_xirus.add("Rafael");
    nomes_dos_xirus.add("Kaue");
    nomes_dos_xirus.add("Sandro");

    nomes_dos_xirus.forEach(nome -> {
      System.out.println("A " + " - " + nome);
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
      System.out.println("números_inteiros que tem o número: " + numero_para_comparar);
    } else {
      System.out.println("números_inteiros que não tem o número: " + numero_para_comparar);
    }

    for (Integer num : numeros_inteiros) {
      System.out.println(num);
    }
  }

  // ATV 3

  public static void atv3() {
    List<String> joguinhos_dos_xiru = new ArrayList<String>();
    List<String> joguinhos_dos_xirus_sem_repeticao = new ArrayList<String>();

    joguinhos_dos_xiru  .add("Tanki online");
    joguinhos_dos_xiru .add("Tanki online");
    joguinhos_dos_xiru .add("Tanki online");
    joguinhos_dos_xiru .add("Tanki online");
    joguinhos_dos_xiru .add("Tanki online");
    joguinhos_dos_xiru .add("Minecraft");
    joguinhos_dos_xiru .add("Clash Royale");
    joguinhos_dos_xiru .add("Cod Black ops 2");
    joguinhos_dos_xiru .add("Blods strike");
    joguinhos_dos_xiru .add("Free fire");
    joguinhos_dos_xiru .add("Free fire");

    for (String jogo : joguinhos_dos_xiru ) {
      if (!joguinhos_dos_xirus_sem_repeticao.contains(jogo)) {
        joguinhos_dos_xirus_sem_repeticao.add(jogo);
      }
    }

    for (String jogo : joguinhos_dos_xirus_sem_repeticao) {
      System.out.println("Jogo: " + jogo);
    }
  }
  // ATV 4

  public static void atv4() {
    List<String> animesFilmesDosXirus = new ArrayList<String>();
    PriorityQueue<String> queueParaOrdenar = new PriorityQueue<>(
        (a, b) -> a.toLowerCase().compareTo(b.toLowerCase()));
        animesFilmesDosXirus.add("One Piece");
        animesFilmesDosXirus.add("Naruto");
        animesFilmesDosXirus.add("Sonho possível");
        animesFilmesDosXirus.add("Soul");
        animesFilmesDosXirus.add("Como treinar seu dragão");
        animesFilmesDosXirus.add("Gente Grande");
        animesFilmesDosXirus.add("Carros");
        animesFilmesDosXirus.add("Duelo de Titans");
        animesFilmesDosXirus.add("Jurassic Park");
        animesFilmesDosXirus.add("Era do gelo 1");
        animesFilmesDosXirus.add("Era do gelo 2");

    queueParaOrdenar.addAll(animesFilmesDosXirus);
    animesFilmesDosXirus.clear();
    // Ordenando a PriorityQueue
    while (!queueParaOrdenar.isEmpty()) {
        animesFilmesDosXirus.add(queueParaOrdenar.poll());
    }

    for (String animes_filme : animesFilmesDosXirus) {
      System.out.println(animes_filme);
    }
  }
  // ATV 5

  public static void atv5() {
    Map<String, String> componentes_hadware = new HashMap<>();

    componentes_hadware.put("intel core i3", "R$1500");
    componentes_hadware.put("Placa mãe", "Aorus elite");
    componentes_hadware.put("Fonte", "Mag a650");
    componentes_hadware.put("Memória ram", "ASGAR ddr4");
    componentes_hadware.put("Gabinete", "Rise mode");

    for (Map.Entry<String, String> entrada : componentes_hadware.entrySet()) {
      System.out.println("Compoente: " + entrada.getKey() + ", modelo: " + entrada.getValue());
    }
  }
}