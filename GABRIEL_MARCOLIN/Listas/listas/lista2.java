package listas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lista2 {
    public static void main(String[] args) {
        // Atividade 1 
        //Escreva um programa que receba uma lista de números inteiros e retorne uma lista contendo apenas os números pares usando a Stream API. A lista deve ter ao menos 8 números.

        List<Integer> numeros = new ArrayList<>();

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

        numerosPares.forEach(nums -> System.out.println(nums));

        // Atividade 2
        // Dada a seguinte lista de nomes("roberto", "josé", "caio", "vinicius"),  escreva um programa que converta todos os nomes para letras maiúsculas usando a Stream API.

        List<String> nomes = new ArrayList<>();

        nomes.add("roberto");
        nomes.add("josé");
        nomes.add("caio");
        nomes.add("vinicius");

        List<String> nomesFormatados = nomes.stream().map(nome -> nome.toUpperCase()).toList();

        nomesFormatados.forEach(nome -> System.out.println(nome));

        // Atividade 3
        // Crie um programa que conte quantas vezes cada palavra única aparece em uma lista de strings.
        // Utilize a Stream API para processar os dados. Lista de palavras("se", "talvez", "hoje" "sábado", "se", "quarta", "sábado").

        List<String> palavras = new ArrayList<>();

        palavras.add("se");
        palavras.add("talvez");
        palavras.add("hoje");
        palavras.add("sábado");
        palavras.add("se");
        palavras.add("quarta");
        palavras.add("sábado");

        Map<String, Long> palavrasUnicas = palavras.stream()
                .collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));

        palavrasUnicas.forEach((palavra, quantidade) -> {
            if (quantidade == 1) {
                System.out.println(palavra + ": " + quantidade);
            }
        });

        // Atividade 4
        // Crie uma Classe Produto, ela possui os atributos nome e preço.  Crie uma lista com 4 objetos do tipo Produto, pode definir os valores
        // diretamente no código("hard coded"). Escreva um programa que filtre os produtos cujo preço seja maior que R$  100,00 utilizando a Stream API.

        ProdutoLista2 produto1 = new ProdutoLista2();
        produto1.setNome("Lápis");
        produto1.setPreco(5);

        ProdutoLista2 produto2 = new ProdutoLista2();
        produto2.setNome("Carro");
        produto2.setPreco(100000);

        ProdutoLista2 produto3 = new ProdutoLista2();
        produto3.setNome("Celular");
        produto3.setPreco(3000);

        ProdutoLista2 produto4 = new ProdutoLista2();
        produto4.setNome("Melancia");
        produto4.setPreco(25);

        List<ProdutoLista2> precosProdutos = new ArrayList<>();

        precosProdutos.add(produto1);
        precosProdutos.add(produto2);
        precosProdutos.add(produto3);
        precosProdutos.add(produto4);

        List<ProdutoLista2> produtosCaros = precosProdutos.stream().filter(precos -> precos.getPreco() > 100).toList();

        produtosCaros
                .forEach(precos -> System.out.println("Produto: " + precos.getNome() + " Valor: " + precos.getPreco()));

        // Atividade 5
        // Realize a soma do valor total dos Produtos que estão na lista de produtos  criados na atv4, realize essa soma utilizando Stream API.

        // Levei em consideração todos os produtos, e não somente os que tinham o preço  maior que 100
        Double somaProdutos = precosProdutos.stream().map(precos -> precos.getPreco()).reduce(0d,
                (valorAnterior, valorAtual) -> valorAnterior + valorAtual);

        System.out.println("Soma total dos produtos da lista 4: " + somaProdutos);

        // Atividade 6
        // Dada a lista("Java", "Python", "C", "JavaScript", "Ruby"), ordene a mesma conforme o tamanho da palavra, da menor para a maior, utilizando a Stream API.

        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();

        linguagensOrdenadas.forEach(ordem -> System.out.println(ordem));
    }
}