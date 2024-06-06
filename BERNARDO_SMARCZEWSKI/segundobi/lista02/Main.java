package segundobi.lista02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        

        // ATV 01
        
        List<Integer> num = new ArrayList<>();

        num.add(1);
        num.add(12);
        num.add(4);
        num.add(6);
        num.add(7);
        num.add(9);
        num.add(10);
        num.add(2);
        num.add(3);

        List<Integer> numPares = num.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());

        numPares.forEach(System.out::println);


        // ATV 02

        List<String> nomes = new ArrayList<>();

        nomes.add("roberto");
        nomes.add("josé");
        nomes.add("caio");
        nomes.add("vinicius");

        List<String> nomesMaiusculo = nomes.stream()
                                           .map(nome -> nome.toUpperCase())
                                           .collect(Collectors.toList());

        nomesMaiusculo.forEach(System.out::println);


        // ATV 03

        List<String> palavras = new ArrayList<>();

        palavras.add("se");
        palavras.add("talvez");
        palavras.add("hoje");
        palavras.add("sábado");
        palavras.add("se");
        palavras.add("quarta");
        palavras.add("sábado");

        Map<String, Long> palavrasCont = palavras.stream()
                    .collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));
                    
        palavrasCont.forEach((palavra, contagem) -> 
            System.out.println(palavra + ": " + contagem));

        
        // ATV 04

        List<Produto> produtos = new ArrayList<>();

        Produto p1 = new Produto("Carregador", 50.00);
        produtos.add(p1);
        Produto p2 = new Produto("Celular", 1000.00);
        produtos.add(p2);
        Produto p3 = new Produto("Monitor", 800.00);
        produtos.add(p3);
        Produto p4 = new Produto("Fone", 60.00);
        produtos.add(p4);

        List<Produto> produtosFiltrados = produtos.stream() 
            .filter(produto -> produto.getPreco() > 100.00)
            .collect(Collectors.toList());

        produtosFiltrados.forEach(produto -> 
            System.out.println(produto.getNome() + " : " + produto.getPreco()));
        

        // ATV 05

        double precoTotal = produtos.stream()
            .mapToDouble(Produto::getPreco)
            .sum();

        System.out.println("Preço total dos itens: " + precoTotal);


        // ATV 06

        List<String> linguagens = new ArrayList<>();

        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("C");
        linguagens.add("JavaScript");
        linguagens.add("Ruby");

        List<String> listaOrdenada = linguagens.stream()
                                          .sorted(Comparator.comparingInt(String::length))
                                          .collect(Collectors.toList());

        listaOrdenada.forEach(System.out::println);

    }

    
}