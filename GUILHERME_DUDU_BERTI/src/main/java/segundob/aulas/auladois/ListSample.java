package segundob.aulas.auladois;

import java.util.ArrayList;
import java.util.List;

public class ListSample {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        String alunoAleatorio = "Carlos";

        nomes.add("Gabriel");
        nomes.add("Rafael");
        nomes.add("Maria");
        nomes.add("João");
        nomes.add("Joãol");
        nomes.add(alunoAleatorio);

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("\n---Segundo Print---\n");

        nomes.remove(2);
        nomes.remove(alunoAleatorio);

        nomes.forEach(nome -> System.out.println(nome));

        System.out.println("\n---Terceiro Print---\n");

        nomes.removeIf(nome -> nome.contains("l"));
        nomes.forEach(nome -> System.out.println(nome));

    }

}
