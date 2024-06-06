package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Atividade1 {

    public static void main(String[] args) {

        System.out.println("Exercicio 1");
        exercicio1();

        System.out.println("Exercicio 2");
        exercicio2();

        System.out.println("Exercicio 3");
        exercicio3();

        System.out.println("Exercicio 4");
        exercicio4();

        System.out.println("Exercicio 5");
        exercicio5();
    }

    public static void exercicio1() {
        List<String> nomeColegas = new ArrayList<>();

        nomeColegas.add("Isabela");
        nomeColegas.add("Giullia");
        nomeColegas.add("Eduarda");
        nomeColegas.add("Gina");
        nomeColegas.add("Erica");

        String inicial = "I - ";

        for (int i = 0; i < nomeColegas.size(); i++) {
            inicial += nomeColegas.get(i);
        }
        System.out.println(inicial);
    }

    public static void exercicio2() {
        HashSet<Integer> numeros = new HashSet<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(10);
        numeros.add(30);
        numeros.add(40);

        int n = 21;
        System.out.println("Esse conjunto de numeros contem o numero " + n + " ? \n ");

        if (numeros.contains(n)) {
            System.out.println("SIM");
        } else {
            System.out.println("NÃO");
        }
    }

    public static void exercicio3() {
        List<String> jogos = new ArrayList<>();

        jogos.add("\nCuphead");
        jogos.add("\nOutlast");
        jogos.add("\nOutlast");
        jogos.add("\nLittle Miss Fortune");
        jogos.add("\nResident Evil 7");

        List<String> unicosJogos = filtrarJogos(jogos);
        System.out.println("todos os jogos: " + jogos);
        System.out.println("Jogos Unicos: " + unicosJogos);
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

    public static void exercicio4() {
        PriorityQueue<String> anime = new PriorityQueue<>(); // ordem alfabetica

        anime.add("Jujutsu Kaisen");
        anime.add("\nChainsaw Man");
        anime.add("\nKamisama Hajimemashita");
        anime.add("\nErased");
        anime.add("\nPonyo");

        System.out.println("TOP 5 animes: " + anime);
    }

    public static void exercicio5() {
        Map<String, String> setup = new HashMap<>();
        setup.put("Processador", "i9 13900HX");
        setup.put("Memória RAM", "16GB DDR4");
        setup.put("Disco Rígido", "1TB SSD NVMe");
        setup.put("Placa de Vídeo", "NVIDIA RTX 4050");

        for (Map.Entry<String, String> pecas : setup.entrySet()) {
            System.out.println(pecas.getKey() + "  " + pecas.getValue());
        }
    }
}
