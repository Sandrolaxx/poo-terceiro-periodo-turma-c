package SegundoBI.listas.lista2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // atividade 01
        atv01();

        // atividade 02
        atv02();

        // atividade 03
        atv03();

        // atividade 04 e 05
        atv04();

        // atividade 06
        atv06();
    }

    public static void atv01() {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 54, 23, 5, 4, 98, 67, 0, 15));
        numeros.stream().filter(item -> (item % 2) == 0).forEach(System.out::println);
    }

    public static void atv02() {
        List<String> nomes = new ArrayList<>(Arrays.asList("roberto", "josé", "caio", "vinicius"));
        System.out.println(nomes.stream().map(letra -> letra.toUpperCase()).toList());
    }

    public static void atv03() {
        List<String> palavrasRepetidas = new ArrayList<>(Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado"));
        palavrasRepetidas.stream().distinct().forEach(palavra -> System.out.println(palavra));
    }

    public static void atv04() {
        List<Produto> produtos = Arrays.asList(new Produto("Teclado", 100.0), new Produto("Mouse", 350.0), new Produto("Monitor", 1500.0), new Produto("Headphone", 316.0));
        List<Produto> produtosFiltrados = produtos.stream().filter(item -> item.getPreco() > 100.0).collect(Collectors.tolist());
        System.out.println(produtosFiltrados);
        double somaProdutos = produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public static void atv06() {
        List<String> lingaugens = new ArrayList<>(Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby"));
        lingaugens.stream().map(item -> item.length()).forEach(item -> System.out.println(item));
    }
}
