import java.util.*;

public class lita1 {

    public static void main(String[] args) {
        // ATV1
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Renan");
        nomes.add("Mateus");
        nomes.add("Ricardo");
        nomes.add("Guilherme");
        nomes.add("Anthony");

        for (String nome : nomes) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }

        // ATV2
        HashSet<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(2);
        numeros.add(4);

        int numeroParaVerificar = 3;
        if (numeros.contains(numeroParaVerificar)) {
            System.out.println("O conjunto contém o número " + numeroParaVerificar);
        } else {
            System.out.println("O conjunto não contém o número " + numeroParaVerificar);
        }

        // ATV3
        List<String> jogosZerados = Arrays.asList("Hollow Knight", "Ori", "Elden Ring", "Dark Souls 3", "Stardew Valley", "Hollow Knight", "Ori");
        List<String> jogosZeradosSemDuplicatas = removeDuplicatas(jogosZerados);

        System.out.println("Jogos zerados sem duplicatas:");
        for (String jogo : jogosZeradosSemDuplicatas) {
            System.out.println(jogo);
        }

        // ATV4
        List<String> animesFilmes = Arrays.asList("Como Treinar Seu Dragão", "Kung Fu Panda", "Carros", "Black Clover", "Kimetsu no Yaiba");
        PriorityQueue<String> animesFilmesOrdenados = new PriorityQueue<>(animesFilmes);

        System.out.println("Animes/filmes em ordem alfabética:");
        while (!animesFilmesOrdenados.isEmpty()) {
            System.out.println(animesFilmesOrdenados.poll());
        }

        // ATV5
        Map<String, String> configuracoesHardware = new HashMap<>();
        configuracoesHardware.put("Placa de Vídeo", "RTX 3070 Master (Aorus)");
        configuracoesHardware.put("Processador", "Ryzen 7 5800X3D");
        configuracoesHardware.put("Memória RAM", "16GB");
        configuracoesHardware.put("Refrigeração", "Water Cooler (Corsair)");
        configuracoesHardware.put("Placa Mãe", "B550M");

        System.out.println("Configurações de hardware:");
        for (Map.Entry<String, String> configuracao : configuracoesHardware.entrySet()) {
            System.out.println(configuracao.getKey() + ": " + configuracao.getValue());
        }
    }

    private static List<String> removeDuplicatas(List<String> lista) {
        Set<String> semDuplicatas = new HashSet<>(lista);
        return new ArrayList<>(semDuplicatas);
    }
}
