package SegundoBim.lista2SegBim;

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
        // Atv1 - Escreva um programa que receba uma lista de números inteiros e retorne
        // uma lista contendo apenas os números pares usando a Stream API. A lista deve
        // ter ao menos 8 números.

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
        // Atv2 - Dada a seguinte lista de nomes("roberto", "josé", "caio", "vinicius"),
        // escreva um programa que converta todos os nomes para letras maiúsculas usando
        // a Stream API.

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
        // Atv3 - Crie um programa que conte quantas vezes cada palavra única aparece em
        // uma lista de strings. Utilize a Stream API para processar os dados. Lista de
        // palavras("se", "talvez", "hoje" "sábado", "se", "quarta", "sábado")

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
        // Atv4 - Crie uma Classe Produto, ela possui os atributos nome e preço. Crie
        // uma lista com 4 objetos do tipo Produto, pode definir os valores diretamente
        // no código("hard coded"). Escreva um programa que filtre os produtos cujo
        // preço seja maior que R$ 100,00 utilizando a Stream API.

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Saia", 150.0));
        produtos.add(new Produto("Vestido", 100.0));
        produtos.add(new Produto("camisa", 50.0));
        produtos.add(new Produto("Calça", 139.0));

        List<Produto> precoMaior = produtos.stream()
                .filter(produto -> produto.getPreco() > 100.0)
                .toList();

        for (Produto p : precoMaior) {
            System.out.println(p.getNome());
        }
        return produtos;

    }

    public static void atividade5() {
        // Atv5 - Realize a soma do valor total dos Produtos que estão na lista de
        // produtos criados na atv4, realize essa soma utilizando Stream API.
        List<Produto> produtos = atividade4();

        int total = produtos.stream()
                .map(produto -> produto.getPreco())
                .reduce(0.0, (numeroAnterior, numeroAtual) -> numeroAnterior + numeroAtual)
                .intValue();

        System.out.println("Total: R$ " + total);
    }

    public static void atividade6() {
        // Atv6- Dada a lista("Java", "Python", "C", "JavaScript", "Ruby"), ordene a
        // mesma conforme o tamanho da palavra, da menor para a maior, utilizando a
        // Stream API.
        List<String> linguagemProgramacao = new ArrayList<>();
        linguagemProgramacao.add("Java");
        linguagemProgramacao.add("Python");
        linguagemProgramacao.add("C");
        linguagemProgramacao.add("JavScript");
        linguagemProgramacao.add("Ruby");

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
