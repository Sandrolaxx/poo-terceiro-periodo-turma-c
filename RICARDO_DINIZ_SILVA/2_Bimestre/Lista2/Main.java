import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Atividade 1
    System.out.println("ATV 1");
    List<Integer> todosOsNumeros = new ArrayList<>();
    for (int i = 4; i < 20; i++) {
      todosOsNumeros.add(i);
    }

    List<Integer> apenasPares = todosOsNumeros.stream()
      .filter(numero -> numero % 2 == 0)
      .toList();

    System.out.println("Só numero par:");
    apenasPares.forEach(numero -> System.out.println(numero));
    // Atividade 2
    System.out.println("\n\nATV 2");
    List<String> nomes = new ArrayList<>();
    nomes.add("roberto");
    nomes.add("josé");
    nomes.add("caio");
    nomes.add("vinicius");

    List<String> nomesEmMaiusculo = nomes.stream()
      .map(nome -> nome.toUpperCase())
      .toList();
    
    System.out.println("Nomes em maiúsculo:");
    nomesEmMaiusculo.forEach(nome -> System.out.println(nome));
    // Atividade 3
    System.out.println("\n\nATV 3");
    List<String> palavras = new ArrayList<>();
    palavras.add("se");
    palavras.add("talvez");
    palavras.add("hoje");
    palavras.add("sábado");
    palavras.add("se");
    palavras.add("quarta");
    palavras.add("sábado");

    List<String> palavrasSemRepetir = palavras.stream()
      .distinct()
      .toList();

    System.out.println("Palavra sem repetir:");
    palavrasSemRepetir.forEach(palavra -> System.out.println(palavra));
    // Atividade 4
    System.out.println("\n\nATV 4");
    List<Produto> produtos = new ArrayList<>();
    produtos.add(new Produto("controle xbox", 350.0));
    produtos.add(new Produto("camiseta", 50.0));
    produtos.add(new Produto("tênis roubado", 35.0));
    produtos.add(new Produto("monza", 5000.0));
    produtos.add(new Produto("meia", 10.0));

    List<Produto> produtosMaiorQueCem = produtos.stream()
      .filter(produto -> produto.getPreco() > 100.0)
      .toList();
    
    System.out.println("Produtos maior que R$ 100:");
    produtosMaiorQueCem.forEach(produto -> System.out.println(produto.getNome()));
    // Atividade 5
    System.out.println("\n\nATV 5");
    int valorTotal = produtos.stream()
      .map(produto -> produto.getPreco())
      .reduce(0.0, (anterior, atual) -> anterior + atual)
      .intValue();
    
    System.out.println("total: " + valorTotal);
    // Atividade 6
    System.out.println("\n\nATV 6");
    List<String> linguagens = new ArrayList<>();
    linguagens.add("Java");
    linguagens.add("Python");
    linguagens.add("C");
    linguagens.add("JavaScript");
    linguagens.add("Ruby");

    List<String> linguagensEmOrdem = linguagens.stream()
      .sorted((linguagem1, linguagem2) -> linguagem1.length() - linguagem2.length())
      .toList();
    
    System.out.println("lista ordenada:");
    linguagensEmOrdem.forEach(linguagem -> System.out.println(linguagem));
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

  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setPreco(double preco) {
    this.preco = preco;
  }
}