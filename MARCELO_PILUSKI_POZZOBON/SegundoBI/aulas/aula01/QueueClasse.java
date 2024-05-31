package SegundoBI.aulas.aula01;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueClasse {
      public static void main(String[] args) {
            Queue<String> nomes = new LinkedList<>();

            nomes.add("teste1");
            nomes.add("teste2");
            
            nomes.peek();
            nomes.poll();

            Queue<String> nomes2 = new LinkedList<>();

            nomes2.add("teste1");
            nomes2.add("teste2");
            //Lembrar que Queue (fila) usa o conceito de FIFO - First In First Out


            Queue<String> nomes3 = new PriorityQueue<>(nomes);
            //O PriorityQueue vai ordenar a lista por prioridade, a padrão no caso é ordem alfabética
      }
}
