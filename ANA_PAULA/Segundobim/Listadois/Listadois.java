package Segundobim.Listadois;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Listadois {
    public static void main(String[] args) {
        //ATV 1
        List<Integer>numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numpares = numbers.stream()
        .filter( numeros -> numeros % 2 == 0 )
        .collect(Collectors.toList());
        System.out.println("ATV 1");
        System.out.println("Apenas os números pares: " + numpares);
       
        //ATV 2
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
        System.out.println("\nATV 2");
        System.out.println("Nomes convertidos para letras maiúsculas: " +nomesMaiusculos);
        
        //ATV 3
        List<String> palavra = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> repetidas = palavra.stream()
        .collect(Collectors.groupingBy(palavras -> palavras, Collectors.counting()));
        System.out.println("\nATV 3");
        System.out.println("Palavras repetidas:" + repetidas);

        //ATV 4 
        List<Produto> produtos = Arrays.asList(
            new Produto("Iphone 15", 3000.0),
            new Produto("Creme para cabelo", 90.0),
            new Produto("Echo Dot ", 350.0),
            new Produto("Aspirador de pó", 95.0)
        );
        List<Produto> produtosFiltrados = produtos.stream()
        .filter(produto -> produto.getPreco() > 100.0)
        .collect(Collectors.toList());
        System.out.println("\nATV 4");
        System.out.println("Produtos de valor maior que R$ 100,00: " + produtosFiltrados);
        
        //ATV 5
        double soma = produtos.stream()
        .mapToDouble(Produto::getPreco)
        .sum();
        System.out.println("\nATV 5");
        System.out.println("A soma dos produtos é: " + soma);

        //ATV 6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordem = linguagens.stream()
        .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
        .collect(Collectors.toList());
        System.out.println(("\nATV 6"));
        System.out.println("As palavras em ordem de tamanho(maior para menor): " + ordem);




        



    }
}