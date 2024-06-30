package segundob.aulas.auladois;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueSample {

    public static void main(String[] args) {


        Pessoa pessoa1 = new Pessoa("Guilherme");
        Pessoa pessoa2 = new Pessoa("Jorge");

        Queue<Pessoa> pessoas = new LinkedBlockingQueue<>();


        pessoas.add(pessoa2);

        pessoas.forEach(System.out::println);

        Queue<String> nomes = new LinkedList<>();

        nomes.add("Igor");
        nomes.add("Rafael");
        nomes.add("Anderson");
        nomes.add("Guilherme");
        nomes.add("Lucas");

        System.out.println("\n ----------------------");

        Queue<String> nomesOrdenados = new PriorityQueue<>(nomes);
        nomesOrdenados.forEach(System.out::println);

    }

}
