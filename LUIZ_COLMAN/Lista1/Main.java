import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // ATV1
        ArrayList<String> colegas = new ArrayList<>();
        colegas.add("João");
        colegas.add("Maria");
        colegas.add("Pedro");
        colegas.add("Ana");
        colegas.add("Carlos");

        String minhaInicial = "M";
        for (String nome : colegas) {
            System.out.println(minhaInicial + " - " + nome);
        }

        // ATV2
        Set<Integer> numeros = new HashSet<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        boolean contemNumero = numeros.contains(30);
        System.out.println("Contém o número 30? " + contemNumero);

        // ATV3
        List<String> jogosZerados = new ArrayList<>();
        jogosZerados.add("The Legend of Zelda: Breath of the Wild");
        jogosZerados.add("Super Mario Odyssey");
        jogosZerados.add("The Legend of Zelda: Breath of the Wild"); // Duplicado

        List<String> jogosUnicos = getJogosUnicos(jogosZerados);
        System.out.println("Jogos Únicos: " + jogosUnicos);

        // ATV4
        Queue<String> animesFilmes = new PriorityQueue<>();
        animesFilmes.add("Attack on Titan");
        animesFilmes.add("Naruto");
        animesFilmes.add("One Piece");
        animesFilmes.add("Death Note");
        animesFilmes.add("Fullmetal Alchemist");

        System.out.println("Animes/Filmes Ordenados: ");
        while (!animesFilmes.isEmpty()) {
            System.out.println(animesFilmes.poll());
        }

        // ATV5
        ConfiguracaoHardware configuracao = new ConfiguracaoHardware();
        configuracao.adicionarComponente("Processador", "i5 7500U");
        configuracao.adicionarComponente("Memória RAM", "8GB DDR4");
        configuracao.adicionarComponente("Placa de Vídeo", "GTX 1050 Ti");
        configuracao.adicionarComponente("Armazenamento", "SSD 256GB");
        configuracao.adicionarComponente("Fonte de Alimentação", "500W");

        configuracao.imprimirConfiguracoes();
    }

    private static List<String> getJogosUnicos(List<String> jogosZerados) {
        return new ArrayList<>(new HashSet<>(jogosZerados));
    }
}

class ConfiguracaoHardware {
    private HashMap<String, String> componentes = new HashMap<>();

    public void adicionarComponente(String componente, String especificacao) {
        componentes.put(componente, especificacao);
    }

    public void imprimirConfiguracoes() {
        for (Map.Entry<String, String> entry : componentes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
