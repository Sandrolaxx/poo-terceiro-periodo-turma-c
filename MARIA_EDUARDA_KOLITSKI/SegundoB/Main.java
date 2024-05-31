package SegundoB;

import java.util.*;
import java.util.stream.*;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // ATV1
        List<Integer> numeros = Arrays.asList(10, 23, 45, 67, 88, 92, 101, 120);
        List<Integer> pares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        // ATV2
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> maiusculas = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + maiusculas);

        // ATV3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagemPalavras = palavras.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("Contagem de palavras: " + contagemPalavras);

        // ATV4
        List<Produto> produtos = Arrays.asList(
                new Produto("Produto1", 150.0),
                new Produto("Produto2", 80.0),
                new Produto("Produto3", 200.0),
                new Produto("Produto4", 120.0)
        );
        List<Produto> produtosCaros = produtos.stream()
                .filter(p -> p.getPreco() > 100.0)
                .collect(Collectors.toList());
        System.out.println("Produtos com preço maior que R$ 100,00: " + produtosCaros);

        // ATV5
        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Valor total dos produtos: R$ " + total);

        // ATV6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadasPorTamanho = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + ordenadasPorTamanho);
    }
}
