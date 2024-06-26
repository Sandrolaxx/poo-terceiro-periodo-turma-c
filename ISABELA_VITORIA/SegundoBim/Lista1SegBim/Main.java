package SegundoBim.Lista1SegBim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        System.out.println("Atividade 1");
        atividade1();

        System.out.println("Atividade 2");
        atividade2();

        System.out.println("Atividade 3");
        atividade3();

        System.out.println("Atividade 4");
        atividade4();

        System.out.println("Atividade 5");
        atividade5();
    }

    public static void atividade1() {
        List<String> nomeColegas = new ArrayList<>();

        nomeColegas.add("Maria");
        nomeColegas.add("Joao");
        nomeColegas.add("Cleber");
        nomeColegas.add("Sophia");
        nomeColegas.add("Josoares");

        String inicial = "I - ";

        for (int i = 0; i < nomeColegas.size(); i++) {
            inicial += nomeColegas.get(i);
        }
        System.out.println(inicial);
    }

    public static void atividade2() {
        HashSet<Integer> numeros = new HashSet<>();

        numeros.add(6);
        numeros.add(8);
        numeros.add(4);
        numeros.add(11);
        numeros.add(21);

        int n = 21;
        System.out.println("Esse conjunto de numeros contem o numero " + n + " ? \n ");

        if (numeros.contains(n)) {
            System.out.println("SIM");
        } else {
            System.out.println("NÃO");
        }
    }

    public static void atividade3() {
        List<String> jogos = new ArrayList<>();

        jogos.add("\nGenshin Impact");
        jogos.add("\nGenshin Impact");
        jogos.add("\nUntil Dawn");
        jogos.add("\nThe last of us");
        jogos.add("\nOri");

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

    public static void atividade4() {
        PriorityQueue<String> anime = new PriorityQueue<>(); // ordem alfabetica

        anime.add("Card captor sakura");
        anime.add("\nMobile Suit Gundam: Iron-Blooded Orphans");
        anime.add("\nLovely Complex");
        anime.add("\nHaikyuu");
        anime.add("\nSousou no Frieren");

        System.out.println("TOP 5 animes: " + anime);
    }

    public static void atividade5() {
        Map<String, String> setup = new HashMap<>();
        setup.put("Processador", "i5 7500U");
        setup.put("Memória RAM", "16GB DDR4");
        setup.put("Disco Rígido", "1TB SSD");
        setup.put("Placa de Vídeo", "NVIDIA GTX 1050 Ti");
        setup.put("Placa Mãe", "ASUS Prime B250M-A");
        setup.put("Fonte de Alimentação", "500W 80 Plus Bronze");

        for (Map.Entry<String, String> pecas : setup.entrySet()) {
            System.out.println(pecas.getKey() + "  " + pecas.getValue());
        }
    }
}
