package segundobimestre.aulas;

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

        String[] nomesVetor = new String[20];

        for (int i =  0; i < nomes.size(); i++){
            System.out.println(nomes.get(i));
        }

        System.out.println("\n----Segundo print----");

        nomes.remove(2);
        nomes.remove(alunoAleatorio);

        nomes.forEach(nome -> System.out.println(nome));

        nomes.removeIf(nome -> nome.contains("l"));

        System.out.println("\n ----Terceiro print----");

        nomes.forEach(nome->System.out.println(nome));
    }


}

