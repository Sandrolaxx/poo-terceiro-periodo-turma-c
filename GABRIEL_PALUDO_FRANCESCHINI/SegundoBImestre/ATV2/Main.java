package SegundoBimestre.ATV2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    System.out.println("Atividade 1:");
    atv1();
    System.out.println("\nAtividade 2:");
    atv2();
    System.out.println("\nAtividade 3:");
    atv3();
    System.out.println("\nAtividade 4:");
    atv4();
    System.out.println("\nAtividade 5:");
    atv5();
    System.out.println("\nAtividade 6:");
    atv6();
  }



  //ATV1     
  public static void atv1() {
    List<Integer> numeros = new ArrayList<>();
    numeros.add(1);
    numeros.add(2);
    numeros.add(3);
    numeros.add(4);
    numeros.add(5);
    numeros.add(6);
    numeros.add(7);
    numeros.add(8);

    numeros.stream().filter(item -> (item % 2) == 0).forEach(System.out::println);
  }



  //ATV2
  public static void atv2() {
    List<String> nomes = new ArrayList<>();
    nomes.add("roberto");
    nomes.add("josé");
    nomes.add("caio");
    nomes.add("vinicius");

    System.out.println(nomes.stream().map(letra -> letra.toUpperCase()).toList());
  }



  //ATV3
  public static void atv3() {
    List<String> palavras = new ArrayList<>();
    palavras.add("se");
    palavras.add("talvez");
    palavras.add("hoje");
    palavras.add("sábado");
    palavras.add("se");
    palavras.add("quarta");
    palavras.add("sábado");

    Map<String, Long> contarPalavras = palavras.stream().collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));
    System.out.println("contagem das palavras:" + contarPalavras);
  }



  //ATV4
  public static void atv4() {
    List<Produtos> produtos = Arrays.asList(
    new Produtos("mouse", 200),
    new Produtos("mousepad", 50),
    new Produtos("teclado", 150),
    new Produtos("fone", 80));

    System.out.println("produtos mais caros que 100 reais:");
    produtos.stream().filter(produto -> produto.getPreco() > 100.0).forEach(produto -> System.out.println(produto.nome));
  }



  //ATV5
  public static void atv5() {
    List<Produtos> produtos = Arrays.asList(
    new Produtos("mouse", 200),
    new Produtos("mousepad", 50),
    new Produtos("teclado", 150),
    new Produtos("fone", 80));

  double precoTotal = produtos.stream().mapToDouble(Produtos::getPreco).sum();
  System.out.println("soma do valor dos produtos = " + precoTotal);
  }



  //ATV6
  public static void atv6() {
    List<String> linguagens = new ArrayList<>();
    linguagens.add("Java");
    linguagens.add("Python");
    linguagens.add("C");
    linguagens.add("JavaScript");
    linguagens.add("Ruby");
    
    System.out.println("palavras ordenadas por ordem de tamanho");
    linguagens.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).toList().forEach(item -> System.out.println(item));
  }
} 