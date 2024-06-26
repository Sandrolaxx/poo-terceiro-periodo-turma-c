package aula_02;

import java.util.ArrayList;
import java.util.List;

public class FilterSample {

  String aaaaaaaaa = "";

  public String getAaaaaaaaa() {
    return aaaaaaaaa;
  }

  public void setAaaaaaaaa(String aaaaaaaaa) {
    this.aaaaaaaaa = aaaaaaaaa;
  }

  public static void main(String[] args) {
    // List<String> frutas = new ArrayList<>();
    // List<String> apenasUva = new ArrayList<>();

    // frutas.add("melancia");
    // frutas.add("pera");
    // frutas.add("uva");
    // frutas.add("maça");
    // frutas.add("uva");

    // frutas.forEach(fruta -> System.out.println(fruta));

    // apenasUva.addAll(frutas.stream().filter(fruta -> fruta == "uva").toList());

    // System.out.println("\n-----------------Só uvinha abaixo-----------------\n");

    // apenasUva = apenasUva.stream().map(fruta -> {
    // System.out.println(fruta);
    // return "a";
    // }).toList();

    // apenasUva.forEach(fruta -> System.out.println(fruta));

    List<Integer> nums = new ArrayList<>();

    nums.add(1);
    nums.add(1);
    nums.add(1);
    nums.add(1);
    nums.add(1);
    nums.add(1);

    nums = nums.stream().map(number -> {
      System.out.println(number);

      return number * 3;
    }).toList();

    nums.forEach(num -> System.out.println(num));

    System.err.println(nums.stream().reduce(0, (valorAnterior, valorAtual) -> valorAnterior + valorAtual));
  }
}
