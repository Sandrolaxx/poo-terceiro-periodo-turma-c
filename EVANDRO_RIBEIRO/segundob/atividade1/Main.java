package segundob.atividade1;

/*ATV1


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Diana");
        nomes.add("Eduardo");

        for (String nome : nomes) {
            System.out.println(nome.charAt(0) + " - " + nome);
        }
    }
}

ATV1*/


/*ATV2

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        HashSet<Integer> numeros = new HashSet<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(20); 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número a ser verificado: ");
        int numeroEspecifico = scanner.nextInt();

        if (numeros.contains(numeroEspecifico)) {
            System.out.println("O conjunto contém o número " + numeroEspecifico);
        } else {
            System.out.println("O conjunto não contém o número " + numeroEspecifico);
        }
    }
}

ATV2 */


/*ATV3 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> jogosZerados = inserirJogosZerados();

        List<String> jogosUnicos = removerDuplicatas(jogosZerados);

        System.out.println("Jogos zerados:");
        for (String jogo : jogosUnicos) {
            System.out.println(jogo);
        }
    }

    public static List<String> inserirJogosZerados() {
        Scanner scanner = new Scanner(System.in);
        List<String> jogosZerados = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.print("Digite o nome do jogo zerado (ou 'sair' para finalizar): ");
            String jogo = scanner.nextLine();

            if (jogo.equalsIgnoreCase("sair")) {
                continuar = false;
            } else {
                jogosZerados.add(jogo);
            }
        }

        return jogosZerados;
    }

    public static List<String> removerDuplicatas(List<String> jogosZerados) {
        Set<String> set = new HashSet<>(jogosZerados);
        return new ArrayList<>(set);
    }
}


ATV3*/



/*ATV4

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] animesFilmes = inserirAnimesFilmes();

        PriorityQueue<String> pq = ordenarEmOrdemAlfabetica(animesFilmes);

        System.out.println("Animes/Filmes em ordem alfabética:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static String[] inserirAnimesFilmes() {
        Scanner scanner = new Scanner(System.in);
        String[] animesFilmes = new String[5];

        System.out.println("Digite os nomes dos cinco melhores animes/filmes que você já viu:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Anime/Filme " + (i + 1) + ": ");
            animesFilmes[i] = scanner.nextLine();
        }

        return animesFilmes;
    }

    public static PriorityQueue<String> ordenarEmOrdemAlfabetica(String[] animesFilmes) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String animeFilme : animesFilmes) {
            pq.offer(animeFilme);
        }
        return pq;
    }
}


ATV4*/


/*ATV5

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> configuracoes = inserirConfiguracoesHardware();

        System.out.println("Configurações de Hardware:");
        for (Map.Entry<String, String> entry : configuracoes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, String> inserirConfiguracoesHardware() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> configuracoes = new HashMap<>();

        System.out.println("Digite as configurações de hardware da sua máquina:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Peça " + (i + 1) + ": ");
            String peca = scanner.nextLine();
            System.out.print("Valor: ");
            String valor = scanner.nextLine();
            configuracoes.put(peca, valor);
        }

        return configuracoes;
    }
}


ATV5*/
