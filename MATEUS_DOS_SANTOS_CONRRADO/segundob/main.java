import java.util.*;
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

public class Main { // Certifique-se de que o nome do arquivo é Main.java
    public static void main(String[] args) {
        
        // ATV1:
        System.out.println("// ATV1");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numerosPares = numeros.stream()
                                             .filter(n -> n % 2 == 0)
                                             .collect(Collectors.toList());
        System.out.println(numerosPares);

        // ATV2:
        System.out.println("// ATV2");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println(nomesMaiusculos);

        // ATV3:
        System.out.println("// ATV3");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagemPalavras = palavras.stream()
                                                     .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(contagemPalavras);

        // ATV4:
        System.out.println("// ATV4");
        List<Produto> produtos = Arrays.asList(
            new Produto("Produto1", 50.0),
            new Produto("Produto2", 150.0),
            new Produto("Produto3", 200.0),
            new Produto("Produto4", 80.0)
        );
        List<Produto> produtosCaros = produtos.stream()
                                              .filter(p -> p.getPreco() > 100.0)
                                              .collect(Collectors.toList());
        System.out.println(produtosCaros);

        // ATV5:
        System.out.println("// ATV5");
        double somaPrecoProdutos = produtos.stream()
                                           .mapToDouble(Produto::getPreco)
                                           .sum();
        System.out.println("Soma total dos preços dos produtos: R$ " + somaPrecoProdutos);

        // ATV6:
        System.out.println("// ATV6");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> linguagensOrdenadas = linguagens.stream()
                                                     .sorted(Comparator.comparingInt(String::length))
                                                     .collect(Collectors.toList());
        System.out.println(linguagensOrdenadas);
    }
}
