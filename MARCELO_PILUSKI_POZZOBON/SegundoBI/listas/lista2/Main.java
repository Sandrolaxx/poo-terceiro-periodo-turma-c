package SegundoBI.listas.lista2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // atividade 01
        //atv01();

        // atividade 02
        //atv02();

        // atividade 03
        //atv03();

        // atividade 04
        atv04();
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
        
        
        Produto teclado = new Produto();
        Produto mouse = new Produto();
        Produto monitor = new Produto();
        Produto headphone = new Produto();

        teclado.nome = "teclado";
        teclado.preco = 100;
        mouse.nome = "mouse";
        mouse.preco = 350;
        monitor.nome = "monitor";
        monitor.preco = 1500;
        headphone.nome = "headphone";
        headphone.preco = 316;

        

        System.out.println(teclado.nome);
    }

    public static void atv05() {

    }

    public static void atv06() {
        List<String> lingaugens = new ArrayList<>(Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby"));
        lingaugens.stream().map(item -> item.length()).forEach(item -> System.out.println(item));
    }
}
