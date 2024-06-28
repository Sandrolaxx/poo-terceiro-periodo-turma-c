import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    // ATIVIDADE 1
    System.out.println("\n1.\n");
    List<String> turma = new ArrayList<>();

    turma.add("Ricardo");
    turma.add("Anthony");
    turma.add("Pedro");
    turma.add("Guilherme");
    turma.add("Marcos");
    String texto = "";
    for (int i = 0; i < turma.size(); i++) {
      texto += turma.get(i) + " - ";
    }
    System.out.println("R -" + texto);
    
    // ATIVIDADE 2
    System.out.println("\n2.\n");
    HashSet<Integer> numeros = new HashSet<>();

    numeros.add(232);
    numeros.add(243);
    numeros.add(72);
    numeros.add(111);
    numeros.add(95);
    int numeroQualquer = 111;

    if (numeros.contains(numeroQualquer)) {
      System.out.println("possui o número " + numeroQualquer);
    } else {
      System.out.println("não possui o número " + numeroQualquer);
    }

    // ATIVIDADE 3
    System.out.println("\n3.\n");
    List<String> jogosZerados = new ArrayList<>();

    jogosZerados.add("GTA San Andreas");
    jogosZerados.add("GTA V");
    jogosZerados.add("Minecraft");
    jogosZerados.add("GTA V");
    jogosZerados.add("God of War");
    jogosZerados.add("GTA San Andreas");

    List<String> jogosSemRepetir = filtroDeJogos(jogosZerados);
    System.out.println("Jogos sem repetir: " + jogosSemRepetir);
    System.out.println("Jogos zerados: " + jogosZerados);

    // ATIVIDADE 4
    System.out.println("\n4.\n");
    Queue<String> animesEFilmes = new PriorityQueue<>();

    animesEFilmes.add("dragon ball");
    animesEFilmes.add("naruto");
    animesEFilmes.add("velozes e furiosos");
    animesEFilmes.add("kung Fu Panda");
    animesEFilmes.add("todo mundo em pânico");
    animesEFilmes.add("velozes e furiosos desafio em tóquio");

    System.out.println("Meus animes e filmes\n" + animesEFilmes);

    // ATIVIDADE 5
    System.out.println("\n5.\n");
    Map<String, String> pc = new HashMap<>();

    pc.put("Intel Core i7 ", "800 reais");
    pc.put("Nvidia RTX 3060 ", "3000 reais");
    pc.put("16GB ", "500 reais");
    pc.put("2TB SSD ", "600 reais");
    pc.put("750W ", "700 reais");

    pc.keySet().forEach(chave -> System.out.println(chave + " - " + pc.get(chave)));
  }

  public static List<String> filtroDeJogos(List<String> jogos) {
    List<String> jogosSemRepetir = new ArrayList<>();
    for (String jogo : jogos) {
      if (!jogosSemRepetir.contains(jogo)) {
        jogosSemRepetir.add(jogo);
      }
    }
    return jogosSemRepetir;
  }
}