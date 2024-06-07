import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    // ATIVIDADE 1
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    List<Integer> numerosPares = numeros.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
    System.out.println("Números Pares: " + numerosPares);

    // ATIVIDADE 2
    List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
    List<String> nomesMaiusculos = nomes.stream()
        .map(nome -> nome.toUpperCase())
        .collect(Collectors.toList());
    System.out.println("Nomes Maiúsculos: " + nomesMaiusculos);

    // ATIVIDADE 3
    List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
    Map<String, Long> frequenciaPalavras = palavras.stream()
        .collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));
    System.out.println("Frequência das Palavras: " + frequenciaPalavras);

    // ATIVIDADE 4
    class Produto {
      String nome;
      double preco;

      Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
      }
    }

    List<Produto> produtos = Arrays.asList(
        new Produto("Arroz", 50),
        new Produto("Feijão", 120),
        new Produto("Macarrão", 80),
        new Produto("Óleo", 150));

    List<Produto> produtosCaros = produtos.stream()
        .filter(produto -> produto.preco > 100)
        .collect(Collectors.toList());
    System.out.println("Produtos Caros: " + produtosCaros);

    // ATIVIDADE 5
    double somaTotal = produtos.stream()
        .mapToDouble(produto -> produto.preco)
        .sum();
    System.out.println("Soma Total dos Preços: " + somaTotal);

    // ATIVIDADE 6
    List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
    List<String> linguagensOrdenadas = linguagens.stream()
        .sorted((l1, l2) -> Integer.compare(l1.length(), l2.length()))
        .collect(Collectors.toList());
    System.out.println("Linguagens Ordenadas pelo Tamanho: " + linguagensOrdenadas);
  }
}
