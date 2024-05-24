
    import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // ATV1
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
        List<Integer> pares = numeros.stream()
                                     .filter(num -> num % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        // ATV2
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> maiusculas = nomes.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + maiusculas);

        // ATV3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        palavras.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .forEach((palavra, contagem) -> System.out.println(palavra + ": " + contagem));

        // ATV4
        List<Produto> produtos = Arrays.asList(
                new Produto("Ingresso", 50.0),
                new Produto("Pipocas", 120.0),
                new Produto("Poltrona", 80.0),
                new Produto("Filme", 150.0)
        );
        List<Produto> produtosCaros = produtos.stream()
                                              .filter(produto -> produto.getPreco() > 100.0)
                                              .collect(Collectors.toList());
        System.out.println("Produtos com preço maior que R$ 100,00: " + produtosCaros);

        // ATV5
        double total = produtos.stream()
                               .mapToDouble(Produto::getPreco)
                               .sum();
        System.out.println("Valor total dos produtos: R$" + total);

        // ATV6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                                          .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                                          .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + ordenadas);
    }
}
