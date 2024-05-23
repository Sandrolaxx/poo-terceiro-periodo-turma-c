import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lista2 {
    public static void main(String[] args) {
        // Atividade 1 Escreva um programa que receba uma lista de números inteiros e
        // retorne uma lista contendo apenas os números pares usando a Stream API.
        // A lista deve ter ao menos 8 números.

        /* List<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);

        List<Integer> numerosPares = numeros.stream().filter(nums -> nums % 2 == 0)
                .toList();

        numerosPares.forEach(nums -> System.out.println(nums)); */

        // Atividade 2
        // Dada a seguinte lista de nomes("roberto", "josé", "caio", "vinicius"),
        // escreva um programa que converta todos os nomes para letras maiúsculas usando
        // a Stream API.

      /*   List<String> nomes = new ArrayList<>();

        nomes.add("roberto");
        nomes.add("josé");
        nomes.add("caio");
        nomes.add("vinicius");

        List<String> nomesFormatados = nomes.stream().map(nome -> nome.toUpperCase()).toList();

        nomesFormatados.forEach(nome -> System.out.println(nome));*/


        //Atividade 3
        //Crie um programa que conte quantas vezes cada palavra única aparece em uma lista de strings. 
        //Utilize a Stream API para processar os dados. 
        //Lista de palavras("se", "talvez", "hoje" "sábado", "se", "quarta", "sábado")

        List<String> palavras = new ArrayList<>();
        
        palavras.add("se");
        palavras.add("talvez");
        palavras.add("hoje");
        palavras.add("sábado");
        palavras.add("se");
        palavras.add("quarta");
        palavras.add("sábado");

       // List<String> palavrasUnicas = palavras.stream().distinct().toList();
       Map<String, Long> contagemPalavras = palavras.stream()
       .collect(Collectors.groupingBy(word -> word, Collectors.counting()));


       contagemPalavras.forEach((palavra, contagem) -> {
        if (contagem == 1) {
            System.out.println(palavra + ": " + contagem);
        }
    });

    }
}