//Em uma classe Main:
//Atv1 - Escreva um programa que receba uma lista de números inteiros e retorne uma
// lista contendo apenas os números pares usando a Stream API. A lista deve ter ao menos 8 números.

package segundoBimestre.lista_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        //ATV1
        System.out.println("ATIVIDADE 01");

        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);

        List<Integer> numpar = nums.stream()
                .filter(nump -> (nump % 2 == 0))
                .toList();
        numpar.forEach(nump -> System.out.println(nump));


//ATIV2
        System.out.println("ATIVIDADE 02");

        List<String> name = new ArrayList<>();

        name.add("roberto");
        name.add("jose");
        name.add("caio");
        name.add("vinicius");

        List<String> nameMaiusculo = name.stream()
                .map(String::toUpperCase)
                .toList();
        nameMaiusculo.forEach(nameM -> System.out.println(nameM));

//ATV3
        System.out.println("ATIVIDADE 03");


        List<String> palavra = new ArrayList<>();

        palavra.add("se");
        palavra.add("talvez");
        palavra.add("hoje");
        palavra.add("sabado");
        palavra.add("se");
        palavra.add("quarta");
        palavra.add("sabado");

        Map<String, Long> contagemPalavras = palavra.stream()
                .collect(Collectors.groupingBy(palavrasrep -> palavrasrep, Collectors.counting()));

        // Imprimir o resultado
        contagemPalavras.forEach((palavrasrep, contagem) -> System.out.println(palavrasrep + ": " + contagem));


//ATIV4
        System.out.println("ATIVIDADE 04");

        List<Produto> produtosBala = new ArrayList<>();

        produtosBala.add(new Produto("arroz", 150.00));
        produtosBala.add(new Produto("feijao", 20.00));
        produtosBala.add(new Produto("carne", 120.00));
        produtosBala.add(new Produto("batata", 50.00));

        List<Produto> acimaPc =  produtosBala.stream()
                .filter(acima -> acima.getPreco() > 100.00)
                .toList();
        acimaPc.forEach(System.out::println);


//ATIV5
        System.out.println("ATIVIDADE 05");

        double somaTotal = produtosBala.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        System.out.println("\nValor total dos produtos: R$ " + somaTotal);



//ATIV6
        System.out.println("ATIVIDADE 06");

        List<String> linguagens = new ArrayList<>();

        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("C");
        linguagens.add("JavaScript");
        linguagens.add("Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
                .sorted((str1, str2) -> Integer.compare(str1.length(), str2.length()))
                .toList();

        System.out.println("Lista ordenada pelo tamanho das palavras:");
       linguagensOrdenadas.forEach(System.out::println);



    }
}

