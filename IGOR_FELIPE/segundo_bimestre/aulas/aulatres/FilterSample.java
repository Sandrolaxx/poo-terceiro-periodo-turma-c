package segundo_bimestre.aulas.aulatres;

import java.util.List;
import java.util.ArrayList;

public class FilterSample {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();


        frutas.add("Melancia");
        frutas.add("Limão");
        frutas.add("Uva");
        frutas.add("Maça");
        frutas.add("Uva");

        
        List<String> apenasUvas = frutas.stream()
            .filter(fruta -> fruta.equals("Uva"))
            .toList();

        apenasUvas.forEach(uva -> System.out.println(uva));
    }
}
