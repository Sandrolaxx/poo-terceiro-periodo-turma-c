package SegundoBI.listas.lista2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // atividade 01
        atv01();

        // atividade 02
        atv02();
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
}
