package listas.lista_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import listas.lista_02.classes.Produto;
import listas.lista_02.classes.Words;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    atv01();
    atv02();
    atv03();
    atv05(atv04());
    atv06();
  }

  // Atv1 - Escreva um programa que receba uma lista de números inteiros e retorne
  // uma lista contendo apenas os números pares usando a Stream API. A lista deve
  // ter ao menos 8 números.

  public static void atv01() {
    List<Integer> lista_dos_numeros = new ArrayList<>();

    Random randomNumber = new Random();

    for (int i = 0; i < 10; i++) {
      lista_dos_numeros.add(randomNumber.nextInt(100));
    }

    System.out.println("Todos os números");
    lista_dos_numeros.stream().forEach(num -> System.out.println(num));

    System.out.println("------------------");
    System.out.println("Só números pares");

    lista_dos_numeros = lista_dos_numeros.stream().filter(num -> num % 2 == 0).toList();

    lista_dos_numeros.stream().forEach(num -> System.out.println(num));
  }

  // Atv2 - Dada a seguinte lista de nomes("roberto", "josé", "caio", "vinicius"),
  // escreva um programa que converta todos os nomes para letras maiúsculas usando
  // a Stream API.

  public static void atv02() {
    List<String> nomes = new ArrayList<>();

    nomes.add("roberto");
    nomes.add("josé");
    nomes.add("caio");
    nomes.add("vinicius");

    nomes = nomes.stream().map(nome -> nome.toUpperCase()).toList();

    nomes.stream().forEach(nome -> System.out.println(nome));
  }

  // Atv3 - Crie um programa que conte quantas vezes cada palavra única aparece em
  // uma lista de strings. Utilize a Stream API para processar os dados. Lista de
  // palavras("se", "talvez", "hoje" "sábado", "se", "quarta", "sábado")

  public static void atv03() {
    List<String> palavras_para_comparar = new ArrayList<>(
        Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado"));

    Words contador = new Words();

    palavras_para_comparar.stream().forEach(palavra -> {
      switch (palavra) {
        case "se":
          contador.setSeApareceu();
          break;
        case "talvez":
          contador.setTalvezApareceu();
          break;
        case "hoje":
          contador.setHojeApareceu();
          break;
        case "sábado":
          contador.setSabadoApareceu();
          break;
        case "quarta":
          contador.setQuartaApareceu();
          break;
        default:
          break;
      }
    });

    System.out.println("Contagem de aparição das palavras \n");
    System.out.println("se");
    System.out.println(contador.getSeApareceu());
    System.out.println("\ntalvez");
    System.out.println(contador.getTalvezApareceu());
    System.out.println("\nhoje");
    System.out.println(contador.getHojeApareceu());
    System.out.println("\nsábado");
    System.out.println(contador.getSabadoApareceu());
    System.out.println("\nquarta");
    System.out.println(contador.getQuartaApareceu());
  }

  // Atv4 - Crie uma Classe Produto, ela possui os atributos nome e preço. Crie
  // uma lista com 4 objetos do tipo Produto, pode definir os valores diretamente
  // no código("hard coded"). Escreva um programa que filtre os produtos cujo
  // preço seja maior que R$ 100,00 utilizando a Stream API.

  public static List<Produto> atv04() {
    List<Produto> produtos = new ArrayList<>();

    produtos.add(new Produto("Banana", 30.0));
    produtos.add(new Produto("Feijão", 101.0));
    produtos.add(new Produto("Frango", 100.01));
    produtos.add(new Produto("Cachaça", 12.0));

    produtos.stream().filter(produto -> produto.getPreco() > 100).toList().forEach(produto -> {
      System.out.println("Produto:");
      System.out.println("Nome: ".concat(produto.getNome()));
      System.out.println("Preço: " + (produto.getPreco()));
      System.out.println("\n");
    });

    return produtos;
  }

  // Atv5 - Realize a soma do valor total dos Produtos que estão na lista de
  // produtos criados na atv4, realize essa soma utilizando Stream API.

  public static void atv05(List<Produto> produtos) {
    Double sum = produtos.stream()
        .reduce(0.0,
            (valorFinal, produto) -> valorFinal + produto.getPreco(),
            Double::sum);
    System.out.println("Soma dos valores: " + sum);
  }

  // Atv6- Dada a lista("Java", "Python", "C", "JavaScript", "Ruby"), ordene a
  // mesma conforme o tamanho da palavra, da menor para a maior, utilizando a
  // Stream API.

  public static void atv06() {
    List<String> linguagens = new ArrayList<>(Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby", "C++"));

    linguagens.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
        .toList().forEach(item -> System.out.println(item));
  }
}
