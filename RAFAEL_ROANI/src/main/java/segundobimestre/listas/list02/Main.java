package segundobimestre.listas.list02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("###### Atividade 01 ######\n");
        atv01();
        System.out.println("\n###### Atividade 02 ######\n");
        atv02();
        System.out.println("\n###### Atividade 03 ######\n");
        atv03();
        System.out.println("\n###### Atividade 04 ######\n");
        atv04();
        System.out.println("\n###### Atividade 05 ######\n");
        atv05();
        System.out.println("\n###### Atividade 06 ######\n");
        atv06();
    }

    private static void atv01() {
        List<Integer> listNums = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Numeros antes: \n");
        listNums.forEach(System.out::println);

        listNums = listNums.stream().filter(n -> (n % 2) == 0).toList();
        System.out.println("\nNumeros depois: \n");
        listNums.forEach(System.out::println);
    }

    private static void atv02() {
        List<String> listNames = new ArrayList<>(List.of("roberto", "josé", "caio", "vinicius"));
        System.out.println("Nomes antes: \n");
        listNames.forEach(System.out::println);

        System.out.println("\nNomes depois: \n");
        listNames = listNames.stream().map(String::toUpperCase).toList();
        listNames.forEach(System.out::println);
    }

    private static void atv03() {
        List<String> listaPalavras = new ArrayList<>(List.of("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado"));
        Map<String, Long> palavrasRepetidas = listaPalavras.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                a -> 1L,
                                Long::sum)
                );

        System.out.println(palavrasRepetidas);
    }

    private static void atv04() {
        produtos.add(new Produto("Tenis", 449.99));
        produtos.add(new Produto("Meia", 59.99));
        produtos.add(new Produto("Camisa", 167.29));
        produtos.add(new Produto("Calça", 89.67));
        System.out.println("Produtos: \n");
        produtos.forEach(System.out::println);

        List<Produto> produtosFiltrados = produtos.stream().filter(Produto::isPriceMaior100).toList();

        System.out.println("\nProdutos com preço maior que R$ 100,00: \n");
        produtosFiltrados.forEach(System.out::println);
    }

    private static void atv05() {
        Double soma = produtos.stream().mapToDouble(Produto::getPreco).sum();

        System.out.println("Soma dos produtos: R$ " + soma);
    }

    private static void atv06() {
        List<String> linguagensProgamacao = new ArrayList<>(List.of("Java", "Python", "C", "JavaScript", "Ruby"));
        System.out.println("Antes da ordenação: ");
        System.out.println(linguagensProgamacao);

        linguagensProgamacao = linguagensProgamacao.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println("\nDepois da ordenação por tamanho da palavra: ");
        System.out.println(linguagensProgamacao);
    }
}
