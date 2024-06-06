package lista01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    System.out.println("\nAtividade 1");
    atv1();
    
    System.out.println("\nAtividade 2");
    atv2();

    System.out.println("\nAtividade 3");
    atv3();

    System.out.println("\nAtividade 4");
    atv4();

    System.out.println("\nAtividade 5");
    atv5();
  }

  public static void atv1() {
    List<String> colegas = new ArrayList<>();

    colegas.add("João");
    colegas.add("Maria");
    colegas.add("José");
    colegas.add("Pedro");
    colegas.add("Ana");

    String msg = "K - ";
    for (int i = 0; i < colegas.size(); i++) {
      msg += colegas.get(i) + ", ";
    }
    System.out.println(msg);
  }

  public static void atv2() {
    HashSet<Integer> numeros = new HashSet<>();

    numeros.add(11);
    numeros.add(3);
    numeros.add(7);
    numeros.add(11);
    numeros.add(9);

    int numero = 7;
    System.out.print("O conjunto contém o número " + numero + "?\nResposta: ");
    if (numeros.contains(numero)) {
      System.out.println("Sim");
    } else {
      System.out.println("Não");
    }
  }

  public static void atv3() {
    List<String> jogos = new ArrayList<>();

    jogos.add("Minecraft");
    jogos.add("Minecraft");
    jogos.add("Elden Ring");
    jogos.add("Elden Ring");
    jogos.add("GTA V");
    jogos.add("Red Dead Redemption 2");
    jogos.add("Days Gone");

    List<String> jogosUnicos = filtrarJogos(jogos);
    System.out.println("Todos os jogos: " + jogos);
    System.out.println("Jogos Unicos: " + jogosUnicos);
  }

  public static void atv4() {
    Queue<String> animes = new PriorityQueue<>(); // Orderna em ordem alfabética

    animes.add("Jujutsu Kaisen");
    animes.add("Kimetsu no Yaiba");
    animes.add("Hunter x Hunter");
    animes.add("Boku no Hero Academia");
    animes.add("Sword Art Online");

    System.out.println("Animes: " + animes);
  }

  public static void atv5() {
    Map<String, String> pc = new HashMap<>();

    // .put() adiciona um par de chave e valor
    pc.put("Processador: Ryzen 5 5600x", "R$ 900");
    pc.put("Placa de Vídeo: RTX 2060 Super", "R$ 2500");
    pc.put("Memória RAM: 16GB DDR4", "R$ 400");
    pc.put("Armazenamento: SSD NVME 512GB", "R$ 200");
    pc.put("Fonte: 550W 80 Plus Bronze", "R$ 350");

    // .entrySet() retorna um conjunto de pares chave-valor
    for (Map.Entry<String, String> componenteDoPC : pc.entrySet()) {
      System.out.println(componenteDoPC.getKey() + " - " + componenteDoPC.getValue());
    }

    System.out.println("");
  }
  
  public static List<String> filtrarJogos(List<String> jogos) {
    List<String> jogosUnicos = new ArrayList<>();

    for (String jogo : jogos) {
      if (!jogosUnicos.contains(jogo)) {
        jogosUnicos.add(jogo);
      }
    }

    return jogosUnicos;
  }
}