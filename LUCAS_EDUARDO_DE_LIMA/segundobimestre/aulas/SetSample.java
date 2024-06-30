package segundobimestre.aulas;

import java.util.HashSet;
import java.util.Set;

public class SetSample {
    
    public static void main(String[] args) {
        
        Set<String> nomeNaoRepetidos = new HashSet<>();

        nomeNaoRepetidos.add("Gabriel");
        nomeNaoRepetidos.add("Rafael");
        nomeNaoRepetidos.add("Maria");
        nomeNaoRepetidos.add("João");
    
        for (String nome : nomeNaoRepetidos){
            System.out.println(nome);
        }
        
        nomeNaoRepetidos.add("João");
        System.out.println("\nSegundo for-----");

        nomeNaoRepetidos.forEach(nome -> System.out.println(nome));

    }


}
