import java.util.ArrayList;
import java.util.List;

public class ListSample {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        String alunoAleatorio = "Carlos";

        nomes.add("Joao");
        nomes.add("Pedro");
        nomes.add("Maria");
        nomes.add("Giullia");
        nomes.add("Pedro");
        nomes.add(alunoAleatorio);

        String[] nomesVetor = new String[20];

        for (int i = 0; i < args.length; i++) { //qtd max do vetor

        }

        for (int i  = 0; i < nomes.size(); i++){ //qtd elementos vetor
            System.out.println(nomes.get(i));
        }

        nomes.remove(1);
        nomes.remove(alunoAleatorio);

        System.out.println("\n\n");
        nomes.forEach(nome -> System.out.println(nome));

        nomes.removeIf(nome -> nome.contains("l"));

        System.out.println("\n\n");
        nomes.forEach(nome -> System.out.println(nome));
    }
}
