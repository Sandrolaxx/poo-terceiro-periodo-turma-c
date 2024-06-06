package segundob.atividade2;


/* ATV1

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();
        
        System.out.println("Digite pelo menos 8 números inteiros:");

        for (int i = 0; i < 8; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int numero = scanner.nextInt();
            numeros.add(numero);
        }

        while (true) {
            System.out.print("Deseja adicionar mais um número? (s/n): ");
            char resposta = scanner.next().charAt(0);
            if (resposta == 'n' || resposta == 'N') {
                break;
            } else if (resposta == 's' || resposta == 'S') {
                System.out.print("Número " + (numeros.size() + 1) + ": ");
                int numero = scanner.nextInt();
                numeros.add(numero);
            }
        }
        
        scanner.close();

        List<Integer> numerosPares = numeros.stream()
                                             .filter(n -> n % 2 == 0)
                                             .collect(Collectors.toList());

        System.out.println("Números pares: " + numerosPares);
    }
}

ATV 1 */

/* ATV2 

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");

        List<String> nomesMaiusculas = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());

        System.out.println("Nomes em letras maiúsculas: " + nomesMaiusculas);
    }
}

ATV2 */

/* ATV3

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> contagemPalavras = palavras.stream()
                                                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        contagemPalavras.forEach((palavra, contagem) -> System.out.println(palavra + ": " + contagem));
    }
}

ATV3 */

/*ATV4

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Produto> produtos = Arrays.asList(
                new Produto("Produto A", 50.00),
                new Produto("Produto B", 150.00),
                new Produto("Produto C", 200.00),
                new Produto("Produto D", 99.99)
        );

        List<Produto> produtosFiltrados = produtos.stream()
                                                  .filter(produto -> produto.getPreco() > 100.00)
                                                  .collect(Collectors.toList());

        System.out.println("Produtos com preço maior que R$ 100,00:");
        produtosFiltrados.forEach(System.out::println);
    }
}

ATV4 */

/* ATV5

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Produto> produtos = Arrays.asList(
                new Produto("Produto A", 50.00),
                new Produto("Produto B", 150.00),
                new Produto("Produto C", 200.00),
                new Produto("Produto D", 99.99)
        );

        double valorTotal = produtos.stream()
                                    .mapToDouble(Produto::getPreco)
                                    .sum();

        System.out.println("Valor total dos produtos: R$ " + valorTotal);
    }
}

ATV5 */

/*ATV6


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
                                                     .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                                                     .collect(Collectors.toList());

        System.out.println("Linguagens ordenadas por tamanho: " + linguagensOrdenadas);
    }
}


*/
