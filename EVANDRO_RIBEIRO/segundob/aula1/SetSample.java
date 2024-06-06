package segundob.aula1;

import java.util.HashSet;
import java.util.Set;

public class SetSample {

    public static void main(String[] args) {

        Set<String> nomeNaoRepitidos = new HashSet <> ();

        nomeNaoRepitidos.add("Gabriel");
        nomeNaoRepitidos.add("Rafael");
        nomeNaoRepitidos.add("Maria");
        nomeNaoRepitidos.add("João");

        for (String nome: nomeNaoRepitidos) {
            System.out.println(nome);

        }

        nomeNaoRepitidos.add("João");
        nomeNaoRepitidos.forEach(item -> System.out.println(item));

        
    }
}

