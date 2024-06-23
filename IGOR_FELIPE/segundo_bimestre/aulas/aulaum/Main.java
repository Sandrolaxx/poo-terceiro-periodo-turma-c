package segundo_bimestre.aulas.aulaum;

import java.util.Set;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) {
        
        Set<String> nomesNaoRepetidos = new HashSet<>();

        nomesNaoRepetidos.add("Igor");
        nomesNaoRepetidos.add("Gabriel");
        nomesNaoRepetidos.add("Arthur");
        nomesNaoRepetidos.add("Maju");


        for(String nome : nomesNaoRepetidos){
            System.out.println(nome);
        }

        System.out.println("");
        nomesNaoRepetidos.add("Igor");

        nomesNaoRepetidos.forEach(item -> System.out.println(item));
    }
}