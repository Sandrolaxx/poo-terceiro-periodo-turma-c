package segundob.aulas.auladois;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        String alunoAleatorio = Carlos;

        nomes.add("Gabriel");
        nomes.add("Rafael");
        nomes.add("Maria");
        nomes.add("João");
        nomes.add("Joãol");
        nomes.add(alunoAleatorio);


        for (int i = 0; i < nomesVetor.size; i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("Segundo print --------------");
        nomes.remove(2);
        nomes.remove(alunoAleatorio);

        nomes.forEach(nome -> System.out.println(nome));

        nomes.removeIf(nome -> nome.contains("l"));

        System.out.println("Terceiro print --------------");
        nomes.forEach(nome -> System.out.println(nome));
    }
}
