import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    // Atividade 1
    System.out.println("# Atividade 01 #");
    List<String> amigos = new ArrayList<>();
    amigos.add("Bill Gates");
    amigos.add("Steve Jobs");
    amigos.add("Super Xandão");
    amigos.add("Elon Musk");
    amigos.add("Cris Bumbstead");

    String texto = "";
    for (int i = 0; i < amigos.size(); i++) {
      char primeiraLetra = amigos.get(i).charAt(0);
      texto += primeiraLetra + " " + amigos.get(i) + " - ";
    }
    System.out.println(texto);
    
    // Atividade 2
    System.out.println("# Atividade 2 #");
    HashSet<Integer> numeros = new HashSet<>();
    numeros.add(12);
    numeros.add(13);
    numeros.add(15);
    numeros.add(14);
    numeros.add(14);

    int numeroEscolhido = 7;
    if (numeros.contains(numeroEscolhido)) {
      System.out.println("Sim, contém o número " + numeroEscolhido);
    } else {
      System.out.println("Não, não contém o número " + numeroEscolhido);
    }

    // Atividade 3
    System.out.println("# Atividade 3# ");
    List<String> meusJogos = new ArrayList<>();
    meusJogos.add("GTAV");
    meusJogos.add("GTAV");
    meusJogos.add("GTA SAN ANDREAS");
    meusJogos.add("GTA SAN ANDREAS");
    meusJogos.add("GTA SAN ANDREAS");

    List<String> jogosSemRepetir = naoRepetirJogos(meusJogos);
    System.out.println(jogosSemRepetir);

    // Atividade 4
    System.out.println("# Atividade 4 #");
    Queue<String> meusFilmes = new PriorityQueue<>();
    meusFilmes.add("Até o Último Homem");
    meusFilmes.add("O Poderoso Chefão");
    meusFilmes.add("Vingadores: Ultimato");
    meusFilmes.add("Velozes e Furiosos 7");
    meusFilmes.add("A Hora do Rush");
    meusFilmes.add("Homem-Aranha: Longe de Casa");

    System.out.println(meusFilmes);

    // Atividade 5
    System.out.println("# Atividade 5 #");
    Map<String, String> myComputer = new HashMap<>();

    myComputer.put("Processador: Ryzen 5 5500", "R$ 597");
    myComputer.put("Placa de Vídeo: RTX 3060 12GB", "R$ 1599");
    myComputer.put("Memória RAM: 16GB 2666mhz DDR4", "R$ 389");
    myComputer.put("Armazenamento: SSD M.2 NVME 512GB", "R$ 199");
    myComputer.put("Fonte: 500W 80 Plus Bronze", "R$ 199");

    myComputer.forEach((componente, valor) -> {
      System.out.println(componente + " - " + valor);
    });
  }

  public static List<String> naoRepetirJogos(List<String> jogos) {
    List<String> jogosUnicos = new ArrayList<>();
    for (String jogo : jogos) {
      if (!jogosUnicos.contains(jogo)) {
        jogosUnicos.add(jogo);
      }
    }
    return jogosUnicos;
  }
}