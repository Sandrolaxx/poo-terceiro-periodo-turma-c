package segundob.aulas.aulatres;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilterSample {

    public static void main(String[] args) {

        List<String> frutas = new ArrayList<>();

        frutas.add("🍉");
        frutas.add("🍋");
        frutas.add("🍇");
        frutas.add("🍎");
        frutas.add("🍇");

        List<String> apenasUvas = frutas.stream()
                .filter(fruta -> fruta.equals("🍇"))
                // .toList(); //--> Java 16 ou superior
                .collect(Collectors.toList()); // Abaixo do 16

        apenasUvas.forEach(fruta -> System.out.println(fruta));
    }

}
