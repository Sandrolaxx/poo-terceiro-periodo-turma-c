package Lista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class lista1 {
    public static void main(String[] args) {
        // Atv1
        System.out.println("// Atv1");
        ArrayList<String> colegas = new ArrayList<>(Arrays.asList("Ana", "Bruno", "Carla", "Diego", "Eduardo"));
        for (String nome : colegas) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }

        // Atv2
        System.out.println("\n// Atv2");
        HashSet<Integer> numeros = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 3, 7, 8, 9, 10));
        System.out.println("Conjunto: " + numeros);
        int numeroEspecifico = 5;
        if (numeros.contains(numeroEspecifico)) {
            System.out.println("O conjunto contém o número " + numeroEspecifico);
        } else {
            System.out.println("O conjunto não contém o número " + numeroEspecifico);
        }

        // Atv3
        System.out.println("\n// Atv3");
        List<String> jogosZerados = Arrays.asList("Minecraft", "Valorant", "The Witcher 3", "Minecraft", "Valorant");
        List<String> jogosUnicos = removeDuplicatas(jogosZerados);
        System.out.println("Jogos zerados (sem duplicatas): " + jogosUnicos);

        // Atv4
        System.out.println("\n// Atv4");
        PriorityQueue<String> animesFilmes = new PriorityQueue<>(Arrays.asList("Your Name", "Attack on Titan", "Spirited Away", "Naruto", "My Hero Academia"));
        List<String> listaOrdenada = new ArrayList<>();
        while (!animesFilmes.isEmpty()) {
            listaOrdenada.add(animesFilmes.poll());
        }
        System.out.println("Animes/Filmes em ordem alfabética: " + listaOrdenada);

        // Atv5
        System.out.println("\n// Atv5");
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> configuracoes = new HashMap<>();

        System.out.println("Insira as configurações de hardware da sua máquina:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome da configuração (exemplo: Processador): ");
            String chave = scanner.nextLine();
            System.out.print("Digite o valor da configuração (exemplo: i5 7500U): ");
            String valor = scanner.nextLine();
            configuracoes.put(chave, valor);
        }

        System.out.println("\nConfigurações inseridas:");
        for (HashMap.Entry<String, String> entry : configuracoes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    // Método para remover duplicatas (Atv3)
    public static List<String> removeDuplicatas(List<String> lista) {
        HashSet<String> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }
}