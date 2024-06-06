package segundob.aulas.auladois;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueSample {
    
    public static void main(String[] args) {
        
        //Criando pessoas
        Pessoa pessoa1 = new Pessoa("Sandro");
        Pessoa pessoa2 = new Pessoa("Guilherme");
        
        //Criando file de pessoas
        Queue<Pessoa> pessoas = new LinkedList<>();
        
        //Adicionando pessoa
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        
        //Iterando na fila
        pessoas.forEach(pessoa -> System.out.println(pessoa.getNome()));
        
        //Vê o primeiro item da fila
        System.out.println(pessoas.peek());
        
        //Vê e remove primeiro item da fila
        System.out.println(pessoas.poll());
        
        //Iterando na fila
        pessoas.forEach(pessoa -> System.out.println(pessoa.getNome()));
        
        Queue<String> nomes = new LinkedList<>();

        nomes.add("Igor");
        nomes.add("João");
        nomes.add("Alberto");
        nomes.add("Ab");
        nomes.add("Ac");
        nomes.add("Zico");

        System.out.println("\n--------------------------------");

        //Transformando nossa fila em uma fila com ordenação natural
        Queue<String> nomesOrdenados = new PriorityQueue<>(nomes);

        //Iterando na fila
        nomesOrdenados.forEach(nome -> System.out.println(nome));
    }

}
