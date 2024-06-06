package atividade_7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Atividade 1
        System.out.println("-------ATV1------");
        ArrayList<String> nomes = lerNomes(scanner);

        // Atividade 2
        System.out.println("\n// --------ATV2-------");
        HashSet<Integer> numeros = lerNumeros(scanner);

        // Atividade 3
        System.out.println("\n//--------ATV3-------");
        ArrayList<String> jogosZerados = lerJogosZerados(scanner);

        // Atividade 4
        System.out.println("\n//-------ATV4-------");
        PriorityQueue<String> animesFilmes = lerAnimesFilmes(scanner);

        // Atividade 5
        System.out.println("------ATV5------");
        HashMap<String, String> hardwareConfig = lerConfiguracoesHardware(scanner);

        scanner.close();

    
        imprimirNomesComIniciais(nomes);
        verificarNumero(numeros, 5);
        imprimirJogosUnicos(jogosZerados);
        imprimirAnimesFilmesOrdenados(animesFilmes);
        imprimirConfiguracoesHardware(hardwareConfig);
    }

    public static ArrayList<String> lerNomes(Scanner scanner) {
        ArrayList<String> nomes = new ArrayList<>();
        System.out.println("Insira os nomes de cinco pessoas da sala:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes.add(scanner.nextLine());
        }
        return nomes;
    }

    public static void imprimirNomesComIniciais(ArrayList<String> nomes) {
        System.out.println("Lista de nomes com iniciais:");
        for (String nome : nomes) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }
    }

    public static HashSet<Integer> lerNumeros(Scanner scanner) {
        HashSet<Integer> numeros = new HashSet<>();
        System.out.println("Insira alguns números (separados por espaço por favor):");
        String[] numerosInput = scanner.nextLine().split(" ");
        for (String num : numerosInput) {
            numeros.add(Integer.parseInt(num));
        }
        return numeros;
    }

    public static void verificarNumero(HashSet<Integer> numeros, int numero) {
        System.out.print("Verifique se o conjunto contém o número " + numero + ": ");
        System.out.println(numeros.contains(numero) ? "Sim" : "Não");
    }

    public static ArrayList<String> lerJogosZerados(Scanner scanner) {
        ArrayList<String> jogosZerados = new ArrayList<>();
        System.out.println("Insira os jogos que você já zerou (digite 'fim' para terminar):");
        while (true) {
            String jogo = scanner.nextLine();
            if (jogo.equalsIgnoreCase("fim")) break;
            jogosZerados.add(jogo);
        }
        return jogosZerados;
    }

    public static void imprimirJogosUnicos(ArrayList<String> jogosZerados) {
        Set<String> jogosUnicos = new HashSet<>(jogosZerados);
        System.out.println("Jogos zerados:");
        for (String jogo : jogosUnicos) {
            System.out.println(jogo);
        }
    }

    public static PriorityQueue<String> lerAnimesFilmes(Scanner scanner) {
        PriorityQueue<String> animesFilmes = new PriorityQueue<>();
        System.out.println("Insira o nome de cinco animes/filmes que você já viu:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Anime/Filme " + (i + 1) + ": ");
            animesFilmes.add(scanner.nextLine());
        }
        return animesFilmes;
    }

    public static void imprimirAnimesFilmesOrdenados(PriorityQueue<String> animesFilmes) {
        System.out.println("Animes/Filmes em ordem alfabética:");
        while (!animesFilmes.isEmpty()) {
            System.out.println(animesFilmes.poll());
        }
    }

    public static HashMap<String, String> lerConfiguracoesHardware(Scanner scanner) {
        HashMap<String, String> hardwareConfig = new HashMap<>();
        System.out.println("Insira pelo menos 5 peças de hardware e suas configurações:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Peça " + (i + 1) + ": ");
            String peca = scanner.nextLine();
            System.out.print("Configuração " + (i + 1) + ": ");
            String configuracao = scanner.nextLine();
            hardwareConfig.put(peca, configuracao);
        }
        return hardwareConfig;
    }

    public static void imprimirConfiguracoesHardware(HashMap<String, String> hardwareConfig) {
        System.out.println("Configurações de hardware:");
        for (Map.Entry<String, String> entry : hardwareConfig.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
