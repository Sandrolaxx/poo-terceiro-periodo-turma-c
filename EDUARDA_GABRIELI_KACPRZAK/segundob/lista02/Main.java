package listas.lista02;

import java.util.ArrayList;
import java.util.List;         
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ----------------- ATIVIDADE 01 ----------------- 

        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        num.add(8);
        num.add(9);

        List<Integer> numPares = num.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        numPares.forEach(System.out::println);

        System.out.print("\n");

        // ----------------- ATIVIDADE 02 ----------------- 

        List<String> name = new ArrayList<>();
        name.add("Giullia");
        name.add("Eduarda");
        name.add("Maria Eduarda");
        name.add("Rafael");

        List<String> nameUpper = name.stream()
                .map(nome -> nome.toUpperCase())
                .collect(Collectors.toList());

        nameUpper.forEach(System.out::println);
        System.out.print("\n");

        // ----------------- ATIVIDADE 03 ----------------- 

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
                System.out.print("\n");

        // ----------------- ATIVIDADE 04 ----------------- 

        List<Product> products = new ArrayList<>();

        Product p1 = new Product("Monitor", 800.00);
        products.add(p1);
        Product p2 = new Product("Teclado Mecânico", 300.00);
        products.add(p2);
        Product p3 = new Product("Mouse Logitech", 600.00);
        products.add(p3);
        Product p4 = new Product("Fone de Ouvido JBL", 200.00);
        products.add(p4);

        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getPreco() > 100.00)
                .collect(Collectors.toList());

                filteredProducts.forEach(product ->
                System.out.println(product.getNome() + " : " + product.getPreco()));
                System.out.print("\n");

        // ----------------- ATIVIDADE 05 ----------------- 

        double precoTotal = products.stream().mapToDouble(Product::getPreco).sum();
        System.out.println("Preço total dos itens: " + precoTotal);
        System.out.print("\n");

        // ----------------- ATIVIDADE 06 ----------------- 

        List<String> langs = new ArrayList<>();

        langs.add("Java");
        langs.add("Python");
        langs.add("C");
        langs.add("JavaScript");
        langs.add("Ruby");

        List<String> listedLangs = langs.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

                listedLangs.forEach(System.out::println);
                System.out.print("\n");        
    }
}