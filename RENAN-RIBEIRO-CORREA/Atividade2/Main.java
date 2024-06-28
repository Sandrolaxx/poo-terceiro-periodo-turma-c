import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Produto{
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
}

public class Main {
  public static void main(String[] args) {

    // ATV1
    List<Integer> numeros = new ArrayList<>();
    numeros.add(2);
    numeros.add(6);
    numeros.add(9);
    numeros.add(12);
    numeros.add(5);
    numeros.add(21);

    List<Integer> numerosPar = numeros.stream()
      .filter(numero -> numero % 2 == 0)
      .collect(Collectors.toList());
    numerosPar.forEach(numero -> System.out.println(numero));

    // ATV2
    List<String> nomes = new ArrayList<>();

    nomes.add("roberto");
    nomes.add("josé");
    nomes.add("caio");
    nomes.add("vinicius");

    List<String> nomesM = nomes.stream()
      .map(nome -> nome.toUpperCase())
      .collect(Collectors.toList());
    nomesM.forEach(nome -> System.out.println(nome));

    // ATV3
    List<String> palavras = new ArrayList<>();

    palavras.add("se");
    palavras.add("talvez");
    palavras.add("hoje");
    palavras.add("sábado");
    palavras.add("se");
    palavras.add("quarta");
    palavras.add("sábado");

    List<String> semRepetir = palavras.stream()
      .distinct()
      .collect(Collectors.toList());
    semRepetir.forEach(palavra -> System.out.println(palavra));

    // ATV4
    List<Produto> produtos = new ArrayList<>();

    produtos.add(new Produto("produto 1", 20.0));
    produtos.add(new Produto("produto 2", 30.0));
    produtos.add(new Produto("produto 3", 40.0));
    produtos.add(new Produto("produto 4", 110.0));
    produtos.add(new Produto("produto 5", 120.0));

    List<Produto> produtosCaro = produtos.stream()
      .filter(produto -> produto.getPreco() > 100.0)
      .collect(Collectors.toList());
      produtosCaro.forEach(produto -> System.out.println(produto.getNome()));

    // ATV5
    int valorTotal = produtos.stream()
      .map(produto -> produto.getPreco())
      .reduce(0.0, (produtoAnterior, produtoAtual) -> produtoAnterior + produtoAtual)
      .intValue();
    System.out.println(valorTotal);

    // ATV6
    List<String> linguagens = new ArrayList<>();

    linguagens.add("java");
    linguagens.add("python");
    linguagens.add("c");
    linguagens.add("javascript");
    linguagens.add("ruby");

    List<String> linguagensOrdenado = linguagens.stream()
      .sorted((x, y) -> x.length() - y.length())
      .collect(Collectors.toList());
    linguagensOrdenado.forEach(linguagem -> System.out.println(linguagem));
  }
}