package Lista01.Lista02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static List<Product> itens;

    public static void main(String[] args) {
        System.out.println("Atividade 01");
        atv01();
        System.out.println("\nAtividade 02");
        atv02();
        System.out.println("\nAtividade 03");
        atv03();
        System.out.println("\nAtividade 04");
        atv04();
        System.out.println("\nAtividade 05");
        atv05();
        System.out.println("\nAtividade 06");
        atv06();
    }

    private static void atv01() {
        List<Integer> listaDeNumerosPrimos = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        System.out.println("\nLista de Números: \n");
        listaDeNumerosPrimos.forEach(numeros -> System.out.println(numeros));
        listaDeNumerosPrimos = listaDeNumerosPrimos.stream().filter(n -> (n % 2) == 0).toList();
        System.out.println("\nLista de Números Primos\n");
        listaDeNumerosPrimos.forEach(numeros -> System.out.println(numeros));
    }

    private static void atv02() {
        List<String> listaDeNomes = new ArrayList<>(List.of("roberto", "josé", "caio", "vinicius"));
        System.out.println("\nLista de Nomes: \n");
        listaDeNomes.forEach(nomes -> System.out.println(nomes));
        listaDeNomes = listaDeNomes.stream().map(String::toUpperCase).toList();
        System.out.println("\nLista de Nomes Maiusculos: \n");
        listaDeNomes.forEach(nomes -> System.out.println(nomes));
    }

    private static void atv03() {
        List<String> listaDePalavras = new ArrayList<>(
                List.of("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado"));
        System.out.println("\nLista de Palavras: \n");
        listaDePalavras.forEach(palavras -> System.out.println(palavras));

    }

    private static void atv04() {
        
            itens = new ArrayList<>();
            itens.add(new Product("Piano", 80.00));
            itens.add(new Product("Forno Eletrico", 600.00));
            itens.add(new Product("Teclado", 99.00));
            itens.add(new Product("Carregador", 599.90));
            List<Product> productExpensive = itens.stream()
                    .filter(product -> ((Product) product).getPrice() > 100)
                    .toList();
            productExpensive.forEach(produto -> System.out.println("Produto: " + produto.getName() +
                    "\nPreço: " + produto.getPrice() + "\n"));
        
    }

    private static void atv05() {
        double valorTotal = itens.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total: R$" + valorTotal);
    }

    private static void atv06() {
 List<String> linguagens = new ArrayList<>(List.of("Java", "Python", "C", "JavaScript", "Ruby"));
        List<String> linguagemTotal = linguagens.stream().sorted(Comparator.comparing(String::length)).toList();
        linguagemTotal.forEach(System.out::println);
    }

}
