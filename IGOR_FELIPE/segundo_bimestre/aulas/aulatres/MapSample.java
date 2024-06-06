package segundo_bimestre.aulas.aulatres;

import java.util.ArrayList;
import java.util.List;

public class MapSample {
    public static void main(String[] args) {
        
        List<String> frutas = new ArrayList<>();

        frutas.add("Melancia");
        frutas.add("Limão");
        frutas.add("Uva");
        frutas.add("Maça");
        frutas.add("Uva");

        List<String> abacates = frutas.stream()
            .map(fruta -> "Abacate")
            .toList();

        abacates.forEach(fruta -> System.out.println(fruta));

        List<Integer> numbs = new ArrayList<>();

        numbs.add(2);
        numbs.add(3);
        numbs.add(5);
        numbs.add(12);

        List<Integer> numbsMult = numbs.stream()

            .map(valor -> {
                Integer valorSomado = valor + 3;
                System.out.println(valor);
                System.out.println(valorSomado);

                return valorSomado;
            })
            .toList();

        numbsMult.forEach(numero -> System.out.println(numero));

    }
}
