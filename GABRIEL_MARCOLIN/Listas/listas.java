import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class listas {
    public static void main(String[] args) {
        /*
         * Atividade 1
         * Criar um ArrayList de strings e adicione os nomes de cinco dos seus colegas
         * favoritos da turma.
         * Em seguida, itere sobre a lista e imprima a inicial do seu nome + " - " +
         * cada nome da lista.
         */

        List<String> colegas = new ArrayList<String>();

        colegas.add("Maju");
        colegas.add("Igor");
        colegas.add("Arthur");
        colegas.add("Gabriel");
        colegas.add("Marcelo");

        System.out.println("Array antes da formatação");
        for (String nomes : colegas) {
            System.out.println(nomes);
        }

        System.out.println("Array depois da formatação");

        for (String nomes : colegas) {
            char primeiraLetra = nomes.charAt(0);
            System.out.println(primeiraLetra + " - " + nomes);
        }

        /*
         * Atividade 2
         * Crie um HashSet de números inteiros e adicione alguns números repetidos.
         * Verifique se o conjunto contém um número específico e imprima o resultado.
         */

        Set<Integer> numeros = new HashSet<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(4);
        numeros.add(3);
        numeros.add(2);
        numeros.add(1);

        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha um número de 1 a 5 para ver se ele existem no HashSet");
        int numero = sc.nextInt();
        sc.nextLine();

        if (numeros.contains(numero)) {
            System.out.println("O Hash set possui o número " + numero);
        } else {
            System.out.println("O HashSet não possui o número " + numero);
        }

        /*
         * Atividado 3
         * Escreva um método que receba uma lista de strings contendo os jogos que você
         * já zerou.
         * Caso tenha zerado mais de uma vez, adicione o nome do jogo para cada vez.
         * Após criar a lista de jogos zerados, retorne uma nova lista contendo apenas
         * as strings únicas (sem duplicatas).
         */

        List<String> jogos = new ArrayList<>();

        jogos.add("Hades");
        jogos.add("Hades 2");
        jogos.add("Terraria");
        jogos.add("Terraria");
        jogos.add("Terraria");
        jogos.add("Terraria");
        jogos.add("Terraria");
        jogos.add("Terraria");
        /* e por aí vai kkk */

        listarJogos(jogos);

        /*
         * Atividade 4
         * Crie um método que utilize PriorityQueue para ordenar uma lista com o nome
         * dos cinco melhores animes/filmes que você já viu em ordem alfabética.
         * Em seguida, imprima a lista ordenada.
         */

         Queue<String> animes = new PriorityQueue<>();

         animes.add("Fullmetal Alchemist Broterhood");
         animes.add("Hunter X Hunter");
         animes.add("Naruto");
         animes.add("Jujutsu Kaisen");
         animes.add("Deathnote");
 
         for (String nome : animes) {
             System.out.println(nome);
         }
 
         /*
          * Atividade 5
          * Crie um método que crie uma estrutura que permita salvar as configurações de
          * hardware da sua máquina, exemplo: "Processador" : "i5 7500U".
          * Faça isso para no mínimo 5 peças e imprima a peça e seu respectivo valor.
          */
 
         Map<String, String> pecas = new HashMap<>();
 
         pecas.put("Processador", "Intel Core i");
         pecas.put("PlacaMae", "AsRock DDR4");
         pecas.put("PlacaDeVideo", "GTX 1050 Ti");
         pecas.put("Memoria", "HyperX Fury 16GB");
         pecas.put("Fonte", "EVGA 500W");
 
         System.out.println("Meu PC da Nasa (sqn)");
         for (Map.Entry<String, String> valor : pecas.entrySet()) {
             System.out.println(valor.getKey() + " : " + valor.getValue());
         }
    }

    public static void listarJogos(List<String> jogos) {
        List<String> listaJogos = new ArrayList<>();

        for (String jogo : jogos) {
            if (!listaJogos.contains(jogo)) {
                listaJogos.add(jogo);
            }
        }

        System.out.println("Lista de jogos sem duplicatas");
        for (String jogo : listaJogos) {
            System.out.println(jogo);
        }
    }
}