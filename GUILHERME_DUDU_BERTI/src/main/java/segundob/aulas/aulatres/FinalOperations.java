package segundob.aulas.aulatres;

import java.util.ArrayList;
import java.util.List;

public class FinalOperations {

    public static void main(String[] args) {

        List<String> frutas = new ArrayList<>();

        frutas.add("Banana");
        frutas.add("Uva");
        frutas.add("Laranja");
        frutas.add("Limao");
        frutas.add("Uva");

        frutas.forEach(fruta -> System.out.println(fruta));

        frutas.stream().forEach(fruta -> System.out.println(fruta));

    }

}
