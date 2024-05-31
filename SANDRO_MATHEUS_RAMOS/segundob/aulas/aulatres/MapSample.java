package segundob.aulas.aulatres;

import java.util.ArrayList;
import java.util.List;

public class MapSample {

    public static void main(String[] args) {

        List<String> frutas = new ArrayList<>();

        frutas.add("🍉");
        frutas.add("🍋");
        frutas.add("🍇");
        frutas.add("🍎");
        frutas.add("🍇");

        List<String> abacates = frutas.stream()
                .map(fruta -> "🥑")
                .toList();

        abacates.forEach(item -> System.out.println(item));

        List<Integer> numbs = new ArrayList<>();

        numbs.add(3);
        numbs.add(4);
        numbs.add(5);
        numbs.add(12);

        List<Integer> numsMaisTrees = numbs.stream()
                .map(num -> {
                    Integer valorSomado = num + 3;

                    System.out.print(num);
                    System.out.print(valorSomado);

                    return valorSomado;
                })
                .toList();

        numsMaisTrees.forEach(item -> System.out.println(item));
    }

}
