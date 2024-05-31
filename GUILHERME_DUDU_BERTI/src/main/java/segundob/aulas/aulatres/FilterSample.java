package segundob.aulas.aulatres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilterSample {

    public static void main(String[] args) {

        List<String> frutas = new ArrayList<>();

        frutas.add("Banana");
        frutas.add("Uva");
        frutas.add("Laranja");
        frutas.add("Limao");
        frutas.add("Uva");

        List<String> apenasAbacates = frutas.stream().map(fruta -> "abacate").toList();
        apenasAbacates.forEach(System.out::println);

        System.out.println("---------------------");

        List<String> apenasUvas = frutas.stream().filter(fruta -> fruta.equals("Uva")).toList();

        apenasUvas.forEach(System.out::println);

        System.out.println("---------------------");

        List<Integer> numbs = new ArrayList<>();

        numbs.add(3);
        numbs.add(4);
        numbs.add(5);
        numbs.add(12);

        List<Integer> numsMaisTres = numbs.stream().map(num -> {
            Integer valorSomado = num + 3;

            System.out.print(num);
            System.out.print(valorSomado);

            return valorSomado;
        })
                // .toList(); // java 16 para cima
                .collect(Collectors.toList()); // pra baixo do java 16

        numsMaisTres.forEach(item -> System.out.println(item));

    }

}
