import java.util.*;
import java.util.stream.Collectors;

class AtvDois {
    public static void main(String[] args) {
        // Atv1
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        System.out.println("\n----------\n");

        // Atv2
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);

        System.out.println("\n----------\n");

        // Atv3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagemPalavras = palavras.stream()
                                                     .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println("Contagem de palavras: " + contagemPalavras);

        System.out.println("\n----------\n");
        // Atv4
        List<Produto> produtos = Arrays.asList(
            new Produto("Produto1", 50.0),
            new Produto("Produto2", 150.0),
            new Produto("Produto3", 200.0),
            new Produto("Produto4", 99.0)
        );
        List<Produto> produtosCaros = produtos.stream()
                                              .filter(p -> p.getPreco() > 100.0)
                                              .collect(Collectors.toList());
        System.out.println("Produtos com preço maior que R$ 100,00: " + produtosCaros);

        System.out.println("\n----------\n");

        // Atv5
        double somaPrecos = produtos.stream()
                                    .mapToDouble(Produto::getPreco)
                                    .sum();
        System.out.println("Soma dos preços dos produtos: R$ " + somaPrecos);

        System.out.println("\n----------\n");

        // Atv6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> linguagensOrdenadas = linguagens.stream()
                                                     .sorted(Comparator.comparingInt(String::length))
                                                     .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas pelo tamanho da palavra: " + linguagensOrdenadas);

        System.out.println("\n----------\n");
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{nome='" + nome + "', preco=" + preco + '}';
    }
}
