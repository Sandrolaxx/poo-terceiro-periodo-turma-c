package SegundoBI.listas.lista1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Atv 01
        atv01();

        // Atv 02
        atv02();

        // Atv 03
        atv03();

        // Atv 04
        atv04();

        // Atv 05
        Scanner optionScanner = new Scanner(System.in);
        int option = 0;
        Scanner subOptionScanner = new Scanner(System.in);
        int subOption = 0;
        atv05(optionScanner, option, subOptionScanner, subOption);
    }

    public static void atv01() {
        List<String> alunos = new ArrayList<>();

        alunos.add("Gonçalves");
        alunos.add("Luiz");
        alunos.add("Gabriel Paludo");
        alunos.add("Evandro");
        alunos.add("Artur Lion");

        alunos.forEach(item -> System.out.println(item.charAt(0) + " - " + item));
    }

    public static void atv02() {
        HashSet<Integer> numerosInteiros = new HashSet<>();
        Integer numeroEscolhido;
        numeroEscolhido = 2;

        numerosInteiros.add(1);
        numerosInteiros.add(2);
        numerosInteiros.add(2);
        numerosInteiros.add(7);
        numerosInteiros.add(89);
        numerosInteiros.add(35);
        numerosInteiros.add(2);

        numerosInteiros.forEach(item -> System.out.println(item.equals(numeroEscolhido)));
    }

    public static void atv03() {
        List<String> jogosZerados = new ArrayList<>();

        jogosZerados.add("Bioshock Infinite");
        jogosZerados.add("Mario World");
        jogosZerados.add("Resident Evil 4");
        jogosZerados.add("Mario World");
        jogosZerados.add("Hollow Knight");
        jogosZerados.add("Hollow Knight");
        jogosZerados.add("Cuphead");
        jogosZerados.add("Marvel's SpiderMan");
        jogosZerados.add("Elden Ring");
        jogosZerados.add("Sonic Generations");
        jogosZerados.add("A Hat in Time");

        jogosZerados.stream().distinct().forEach(game -> System.out.println(game));
        /*boolean jogoPassou = false;
        for (int i = 0; i < jogosZerados.size(); i++) {
            jogoPassou = false;
            String currentGame = jogosZerados.get(i);
            for (int j = 0; j < i; j++) {
                if (currentGame.equals(jogosZerados.get(j))) {
                    jogoPassou = true;
                    break;
                }
            }
            if (!jogoPassou) {
                System.out.println(currentGame);
            }
        }*/
    }

    public static void atv04() {
        Queue<String> seriesAssistidas = new PriorityQueue<>();

        seriesAssistidas.add("Evangellion");
        seriesAssistidas.add("Show de Truman");
        seriesAssistidas.add("Castelo Animado");
        seriesAssistidas.add("Entergalactic");
        seriesAssistidas.add("The Boondocks");

        seriesAssistidas.forEach(item -> System.out.println(item));
    }

    public static void atv05(Scanner operationOptionScan, int operationOption, Scanner subOperationOptionScan,
            int subOperationOption) {
        Map<Integer, String> computador = new HashMap<>();
        Map<String, String> pecasComputador = new HashMap<>();
        Scanner pecaAdicionadaScan = new Scanner(System.in);
        String pecaAdicionada;
        String buscaNomePecaMap;

        computador.put(1, "Processador");
        computador.put(2, "Placa de Vídeo");
        computador.put(3, "Placa Mãe");
        computador.put(4, "Memória RAM");
        computador.put(5, "Fonte");

        do {
            System.out.print("[1] - Adicionar peça\n[2] - Listar peça\n[3] - Sair");
            operationOption = operationOptionScan.nextInt();
            switch (operationOption) {
                case 1:
                    System.out.print(
                            "Qual peça deseja adicionar?\n   [1] - Processador\n   [2] - Placa de Vídeo\n   [3] - Placa Mãe\n   [4] - Memória RAM\n   [5] - Fonte\nResposta: ");
                    subOperationOption = subOperationOptionScan.nextInt();
                    buscaNomePecaMap = computador.get(subOperationOption); // Basicamente o HashMap das peças e outro
                                                                           // das peças adicionadas
                    System.out.print("Nome da peça: ");
                    pecaAdicionada = pecaAdicionadaScan.next();
                    pecasComputador.put(buscaNomePecaMap, pecaAdicionada);
                    break;

                case 2:
                    System.out.print(
                            "Qual peça deseja visualizar?\n   [1] - Processador\n   [2] - Placa de Vídeo\n   [3] - Placa Mãe\n   [4] - Memória RAM\n   [5] - Fonte\nResposta: ");
                    subOperationOption = subOperationOptionScan.nextInt();
                    subOperationOption = subOperationOptionScan.nextInt();
                    buscaNomePecaMap = computador.get(subOperationOption); // Basicamente o HashMap das peças e outro
                                                                           // das peças adicionadas
                    System.out.println(pecasComputador.get(buscaNomePecaMap));
                    break;

                default:
                    break;
            }
        } while (operationOption != 3);
    }
}