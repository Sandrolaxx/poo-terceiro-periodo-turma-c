package Atv4eAtv5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Celular", 3500));
        produtos.add(new Produto("Capinha", 50));
        produtos.add(new Produto("Notebook", 5000));
        produtos.add(new Produto("Mouse", 99.99));


        //resolução atv4
        List<Produto> produtosFiltrados = produtos.stream()
                .filter(produto -> produto.getPreco() > 100.0)
                .collect(Collectors.toList());

        produtosFiltrados.forEach(System.out::println);

        //resolução atv5
        double somaTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        System.out.println(somaTotal);
    }
}
