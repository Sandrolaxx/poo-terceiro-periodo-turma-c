package segundob.aulas.auladois;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListSample {
    
    public static void main(String[] args) {
        
        //Criando lista
        List<String> nomes = new ArrayList<>();
        String alunoAleatorio = "Carlos";
        
        //Adicionando elementos
        nomes.add("Gabriel");
        nomes.add("Rafael");
        nomes.add("Maria");
        nomes.add("João");
        nomes.add("Joãol");
        nomes.add(alunoAleatorio);
        
        //Iterando na lista com indice
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }
        
        System.out.println("\n---Segundo print----");
        
        //Removendo por indice
        nomes.remove(2);
        //Removendo por referência
        nomes.remove(alunoAleatorio);
        
        //Iterando na lista
        nomes.forEach(e -> System.out.println(e));
        
        //Iterando na lista e removendo por condição
        nomes.removeIf(nome -> nome.contains("l"));
        
        System.out.println("\n---Terceiro print----");
        
        //Iterando na lista
        nomes.forEach(nome -> System.out.println(nome));
        
        //--------------
        
        //Criando lista encadeada
        List<String> nomesEncadeados = new LinkedList<>();

        nomesEncadeados.add("Cleber");
        nomesEncadeados.add("Roberto");
        nomesEncadeados.add("José");

        for (String nome : nomesEncadeados) {
            System.out.println(nome);
        }
    }

}
