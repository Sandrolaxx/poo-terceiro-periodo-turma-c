import java.util.HashSet;
import java.util.Set;

public class SetSample {

    public static void main(String[] args) {

        Set<String> nomeNaoRepetidos = new HashSet<>();

        nomeNaoRepetidos.add("Joao");
        nomeNaoRepetidos.add("Pedro");
        nomeNaoRepetidos.add("Maria");
        nomeNaoRepetidos.add("Giullia");

        for (String nome: nomeNaoRepetidos){
            System.out.println(nome);
        }

        nomeNaoRepetidos.add("Joao");

        System.out.println("\nSegundo for---------");

        nomeNaoRepetidos.forEach(item -> System.out.println(item));
    }
}
