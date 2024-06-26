package segundob.aulas.auladois;

import java.util.HashSet;
import java.util.Set;

public class SetSample {
    
    public static void main(String[] args) {
        
        //Criando set
        Set<String> nomeNaoRepitidos = new HashSet<>();

        //Adicionando itens
        nomeNaoRepitidos.add("Gabriel");
        nomeNaoRepitidos.add("Rafael");
        nomeNaoRepitidos.add("Maria");
        nomeNaoRepitidos.add("João");
        
        //Iterando sobre set
        for (String nome : nomeNaoRepitidos) {
            System.out.println(nome);
        }
        
        //Tentando adicionar um item duplicado
        nomeNaoRepitidos.add("João");
        
        System.out.println("\nSegundo for------");
        
        //Iterando sobre set -> para cada item printLn
        nomeNaoRepitidos.forEach(nome -> System.out.println(nome));
    }

}
