package segundob.listas.lista2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<Product> produtos;

    public static void main(String[] args) {
        System.out.println("ATV1_________\n");
        atvUm();
        System.out.println("\nATV2_________\n");
        atvDois();
        System.out.println("\nATV3_________\n");
        atvTres();
        System.out.println("\nATV4_________\n");
        atvQuatro();
        System.out.println("\nATV5_________\n");
        atvCinco();
        System.out.println("\nATV6_________\n");
        atvSeis();
    }

    private static void atvUm() {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        List<Integer> numerosPares = numeros.stream().filter(n -> n % 2 == 0)
                .toList();
        numerosPares.forEach(num -> System.out.println(num));
    }

    private static void atvDois() {
        List<String> nomes = new ArrayList<>(List.of("roberto", "josé", "caio", "vinicius"));
        List<String> nomesMaiusculo = nomes.stream().map(String::toUpperCase).toList();
        nomesMaiusculo.forEach(nome -> System.out.println(nome));
    }

    private static void atvTres() {
        List<String> palavras = new ArrayList<>(List.of("se", "talvez", "hoje", "sábado", "se",
                "quarta", "sábado"));
        Map<String, Long> palavrasContadas = palavras.stream()
                .collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));

        palavrasContadas.forEach((palavra, contador) -> System.out.println(palavra + " : " + contador));
    }

    private static void atvQuatro() {
        produtos = new ArrayList<>();
        produtos.add(new Product("Teclado", 80.00));
        produtos.add(new Product("Micro-ondas", 600.00));
        produtos.add(new Product("Mouse", 99.00));
        produtos.add(new Product("Monitor 144Hz", 599.90));
        List<Product> produtosCaros = produtos.stream()
                .filter(produto -> produto.getPrice() > 100)
                .toList();
        produtosCaros.forEach(produto -> System.out.println("Produto: " + produto.getName() +
                "\nPreço: " + produto.getPrice() + "\n"));
    }

    private static void atvCinco() {
        double valorTotal = produtos.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total: R$" + valorTotal);
    }

    private static void atvSeis() {
        List<String> linguagens = new ArrayList<>(List.of("Java", "Python", "C", "JavaScript", "Ruby"));
        List<String> linguagensPorTamanho = linguagens.stream().sorted(Comparator.comparing(String::length)).toList();
        linguagensPorTamanho.forEach(System.out::println);
    }
}
