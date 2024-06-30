import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Atividade 1");
    atv1();

    System.out.println("\nAtividade 2");
    atv2();

    System.out.println("\nAtividade 3");
    atv3();

    System.out.println("\nAtividade 4");
    atv4();

    System.out.println("\nAtividade 5");
    atv5();

    System.out.println("\nAtividade 6");
    atv6();
  }

  public static void atv1() {
    List<Integer> numeros = new ArrayList<>(List.of(23, 4, 1, 324, 45, 21, 67, 8));

    List<Integer> pares = numeros.stream()
      .filter(numero -> numero % 2 == 0)
      .toList();

    System.out.println("Números Pares: " + pares);
  }

  public static void atv2() {
    List<String> nomes = new ArrayList<>(List.of("Roberto", "José", "Caio", "Vinicius"));

    List<String> nomesEmMaiusculo = nomes.stream()
      .map(nome -> nome.toUpperCase())
      .toList();
    
    System.out.println("Nomes em Maiúsculo: " + nomesEmMaiusculo);
  }

  public static void atv3() {
    List<String> palavras = new ArrayList<>(List.of("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado"));

    List<String> palavrasUnicas = palavras.stream()
      .distinct() // Remove duplicados
      .toList();

    System.out.println("Palavras Únicas: " + palavrasUnicas);
  }

  public static List<Produto> atv4() {
    List<Produto> produtos = new ArrayList<>(List.of(
      new Produto("Camiseta da Hering", 50.0),
      new Produto("Calça da Renner", 150.0),
      new Produto("Tênis da Shopee", 200.0),
      new Produto("Jaqueta da Shein", 100.0)
    ));

    List<Produto> produtosCaros = produtos.stream()
      .filter(produto -> produto.getPreco() > 100.0)
      .toList();
    
    System.out.print("Produtos Caros: ");
    produtosCaros.forEach(produto -> System.out.print(produto.getNome() + ", "));
    System.out.println("");

    return produtos;
  }

  public static void atv5() {
    List<Produto> produtos = atv4();

    Integer total = produtos.stream()
      .map(produto -> produto.getPreco())
      .reduce(0.0, (prev, current) -> prev + current)
      .intValue();
    
    System.out.println("Valor Total: R$" + total);
  }

  public static void atv6() {
    List<String> stack = new ArrayList<>(List.of("Java", "Python", "C", "JavaScript", "Ruby"));

    List<String> stackOrdenada = stack.stream()
      .sorted((a, b) -> a.length() - b.length()) // Ordena pelo tamanho da palavra
      .toList();
    
    System.out.println("Stack Ordenada: " + stackOrdenada);
  }
}
