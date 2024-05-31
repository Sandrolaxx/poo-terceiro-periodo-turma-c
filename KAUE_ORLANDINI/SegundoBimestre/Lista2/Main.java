package KAUE_ORLANDINI.SegundoBimestre.Lista2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        //ATV1
        System.out.println("Atividade 1");
        
        List<Integer> numeros = new ArrayList<>();
            numeros.add(10);
            numeros.add(21);
            numeros.add(6);
            numeros.add(8);
            numeros.add(5);
            numeros.add(9);
            numeros.add(46);
            numeros.add(53);

        List<Integer> pares = numeros.stream()
                .filter(numero -> numero % 2 == 0) 
                .collect(Collectors.toList()); 

            System.out.println("Números pares: " + pares);


        //ATV2
        System.out.println(" ");
        System.out.println("atividade 2");
       

        List<String> nomes = new ArrayList<>();
            nomes.add("roberto");
            nomes.add("jose");
            nomes.add("caio");
            nomes.add("vinicius");

        List<String> nomesM = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

            System.out.println("nomes com as letras maiusculas:" + nomesM);

        
        //ATV3
        System.out.println(" ");
        System.out.println("atividade 3");
        
        List<String> palavras = new ArrayList<>();
            palavras.add("se");
            palavras.add("talvez");
            palavras.add("hoje");
            palavras.add("sabado");
            palavras.add("se");
            palavras.add("quarta");
            palavras.add("sabado");

        List<String> palavrasR = palavras.stream()
                .distinct()
                .collect(Collectors.toList());

            System.out.println("palavras: " + palavrasR);

        //ATV4
        System.out.println(" ");
        System.out.println("Atividade 4 ");
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", 50.0));
        produtos.add(new Produto("Produto 2", 150.0));
        produtos.add(new Produto("Produto 3", 80.0));
        produtos.add(new Produto("Produto 4", 200.0));

        List<Produto> produtosCaros = produtos.stream()
                                            .filter(p -> p.getPreco() > 100.0)
                                            .collect(Collectors.toList());

        
        System.out.println("Produtos com preço maior que R$ 100,00:");
        for (Produto produto : produtosCaros) {
            System.out.println(produto.getNome() + ": R$" + produto.getPreco());
            }
       

        //ATV5
        System.out.println("");
        System.out.println("Atividade 5");
        double total = produtos.stream()
                               .mapToDouble(Produto::getPreco)
                               .sum();

        System.out.println("Valor total dos produtos: R$" + total);
       
       //ATV6
       System.out.println("");
       System.out.println("Atividade 6");

       List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println("Lista ordenada pelo tamanho das palavras:");
        linguagensOrdenadas.forEach(System.out::println);
       
       
        }        
    }