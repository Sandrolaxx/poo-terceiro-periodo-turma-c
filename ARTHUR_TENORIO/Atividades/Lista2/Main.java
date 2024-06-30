package Atividades.Lista2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
//exe1
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);

        List<Integer> pares =  numeros.stream()
                                     .filter(numero -> numero % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println(("exe1"));
        System.out.println("Numeros pares da lista: "+  pares);
        System.out.println("----------------------------------------------------------");




    exe2();
    exe3();
    exe4();
    exe6();


        
    }

//exe2


public static void exe2() {
    System.out.println("exe2");
    List<String> nomes = new ArrayList<>();
    nomes.add("calleri");
    nomes.add("lucas");
    nomes.add("ferreirinha");
    nomes.add("rafael");

    List<String> maiusculas = nomes.stream()    
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());
    System.out.println("nomes com letra maiuscula" + maiusculas);
    System.out.println("----------------------------------------------------------");




    
}
//exe3
public static void exe3() {
    System.out.println("exe3");
    List<String> frases = new ArrayList<>();
    frases.add("se");
    frases.add("talvez");
    frases.add("hoje");
    frases.add("sabado");
    frases.add("se");
    frases.add("Quarta");
    frases.add("sabado");

    Map<String, Long> contagemPalavras = frases.stream()
    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

    System.out.println("Contagem de palavras:");
    contagemPalavras.forEach((palavra, contagem) -> System.out.println(palavra + ": " + contagem));
    System.out.println("----------------------------------------------------------");



    
}
//exe4 e 5
public static void exe4() {
    System.out.println("exe4");
    List<Produto> produtos = Arrays.asList(
        new Produto("berinjela", 150.0),
        new Produto("bola", 120.0),
        new Produto("Agua", 80.0),
        new Produto("camiseta", 150.0)
    );

    List<Produto> produtosCaros = produtos.stream()
                                          .filter(produto -> produto.getPreco() > 100.0)
                                          .collect(Collectors.toList());

    System.out.println("Produtos com preço maior que R$ 100,00:");
    produtosCaros.forEach(produto -> System.out.println(produto.getNome()));
    System.out.println("----------------------------------------------------------");
    System.out.println("exe5");
    double valorTotal = produtos.stream()
    .mapToDouble(Produto::getPreco)
    .sum();

    System.out.println("Valor total dos produtos: R$" + valorTotal);
    System.out.println("----------------------------------------------------------");

    

}

public static void exe6() {
    System.out.println("exe6");
    
    List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
                                                     .sorted(Comparator.comparingInt(String::length))
                                                     .toList();

        System.out.println("Lista de linguagens ordenadas pelo tamanho da palavra:");
        linguagensOrdenadas.forEach(System.out::println);
}

    
}
    

