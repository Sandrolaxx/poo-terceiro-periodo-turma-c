package Lista2.poo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Atividade 1");
        atividade1();

        System.out.println("Atividade 2");
        atividade2();

        System.out.println("Atividade 3");
        atividade3();

        System.out.println("Atividade 4");
        atividade4();

        System.out.println("Atividade 5");
        atividade5();

        System.out.println("Atividade 6");
        atividade6();
    }

    public static void atividade1() {
        // Atv 1 

        List<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(7);
        numeros.add(6);
        numeros.add(4);
        numeros.add(2);
        numeros.add(10);

        List<Integer> par = numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .toList();

        for (Integer numeroPar : par) {
            System.out.println(numeroPar);
        }

    }

    public static void atividade2() {
        // Atv 2 

        List<String> nomes = new ArrayList<>();
        nomes.add("Roberto");
        nomes.add("José");
        nomes.add("Caio");
        nomes.add("Vinicius");

        List<String> nomeMaiusculo = nomes.stream()
                .map(nome -> nome.toUpperCase())
                .toList();

        System.out.println("Nomes em maiusculo:" + nomeMaiusculo);

    }

    public static void atividade3() {
        // Atv 3

        List<String> palavra = new ArrayList<>();
        palavra.add("se");
        palavra.add("talvez");
        palavra.add("hoje");
        palavra.add("sábado");
        palavra.add("se");
        palavra.add("quarta");
        palavra.add("sábado");

        List<String> palavraUnica = palavra.stream()
                .distinct()
                .toList();

        System.out.println("Palavra unicas:" + palavraUnica);

    }

    public static List<Produto> atividade4() {
        // Atv 4 

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Adidas Campus", 800.0));
        produtos.add(new Produto("Converse One Star", 180.0));
        produtos.add(new Produto("Havaianas", 45.0));
        produtos.add(new Produto("Pantufas", 15.0));

        List<Produto> precoMaior = produtos.stream()
                .filter(produto -> produto.getPreco() > 100.0)
                .toList();

        for (Produto p : precoMaior) {
            System.out.println(p.getNome());
        }
        return produtos;

    }

    public static void atividade5() {
        // Atv 5 
        List<Produto> produtos = atividade4();

        int total = produtos.stream()
                .map(produto -> produto.getPreco())
                .reduce(0.0, (numeroAnterior, numeroAtual) -> numeroAnterior + numeroAtual)
                .intValue();

        System.out.println("Total: R$ " + total);
    }

    public static void atividade6() {
        // Atv 6
        List<String> linguagemProgramacao = new ArrayList<>();
        linguagemProgramacao.add("Java");
        linguagemProgramacao.add("JavScript");
        linguagemProgramacao.add("C");
        linguagemProgramacao.add("Python");
        linguagemProgramacao.add("Css");

        List<String> linguagemProgramacaoOrdenada = linguagemProgramacao.stream()
                .sorted((linguagemA, linguagemB) -> linguagemA.length() - linguagemB.length())
                .toList();

        System.out.println("Linguagens ordenadas: " + linguagemProgramacaoOrdenada);

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
}
