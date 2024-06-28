package segundob.listas.lista2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    // Crie todas as atividades em um arquivo Main.java, atividades separadas por comentários, exemplo //ATV1, abaixo o código.
    public static void main(String[] args) {
        // Atv1 - Escreva um programa que receba uma lista de números inteiros e retorne uma lista contendo apenas os números pares usando a Stream API. A lista deve ter ao menos 8 números.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(number -> number % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Números pares: " + evenNumbers);
        System.out.println("-----------------------------------------");
        

        /// Atv2 - Dada a seguinte lista de nomes("roberto", "josé", "caio", "vinicius"), escreva um programa que converta todos os nomes para letras maiúsculas usando a Stream API.
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculo = nomes.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        System.out.println("Nomes: " + nomesMaiusculo);
        System.out.println("-----------------------------------------");


        // Atv3 - Crie um programa que conte quantas vezes cada palavra única aparece em uma lista de strings. Utilize a Stream API para processar os dados. Lista de palavras("se", "talvez", "hoje" "sábado", "se", "quarta", "sábado")
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> palavrasContadas = palavras.stream()
                                            .collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));

        palavrasContadas.forEach((word, count) -> System.out.println(word + ": " + count));
        System.out.println("-----------------------------------------");


        // Atv4 - Crie uma Classe Produto, ela possui os atributos nome e preço. Crie uma lista com 4 objetos do tipo Produto, pode definir os valores diretamente no código("hard coded"). Escreva um programa que filtre os produtos cujo preço seja maior que R$ 100,00 utilizando a Stream API.
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();
        Produto produto4 = new Produto();

        produto1.setNome("Maria");
        produto1.setPreco(10.00);

        produto2.setNome("Júlia");
        produto2.setPreco(100.00);

        produto3.setNome("Gonçalves");
        produto3.setPreco(1000.00);

        produto4.setNome("Raposo");
        produto4.setPreco(10000.00);

        List<Produto> produtos = Arrays.asList(produto1,produto2,produto3,produto4);

        List<Produto> produtosFiltrados = produtos.stream()
                                           .filter(produto -> produto.getPreco() > 100.00)
                                           .collect(Collectors.toList());

        System.out.println("Produtos acima de 100 reais: ");
        produtosFiltrados.forEach(produto -> System.out.println(produto.getNome() + ": " + produto.getPreco()));
        System.out.println("-----------------------------------------");


        // Atv5 - Realize a soma do valor total dos Produtos que estão na lista de produtos criados na atv4, realize essa soma utilizando Stream API.
        Double soma = produtos.stream()
        .map(produto -> produto.getPreco())
        .reduce(0d,(valorAnterior,valorAtual)-> valorAnterior+valorAtual);

        System.out.println("soma dos produtos: " + soma);
        System.out.println("-----------------------------------------");

            
        // Atv6- Dada a lista("Java", "Python", "C", "JavaScript", "Ruby"), ordene a mesma conforme o tamanho da palavra, da menor para a maior, utilizando a Stream API
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> linguagensOrdenado = linguagens.stream()
                                .sorted((lingua1, lingua2) -> Integer.compare(lingua1.length(), lingua2.length()))
                                .collect(Collectors.toList());

        System.out.println("Linguagens de programação ordenadas: " + linguagensOrdenado);

        System.out.println("-----------------------------------------");


    
        
    }

}