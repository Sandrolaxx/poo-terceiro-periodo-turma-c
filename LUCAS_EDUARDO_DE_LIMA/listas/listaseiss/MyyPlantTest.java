package listas.listaseiss;

import java.util.List;

public class MyyPlantTest {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Parana", "Cascavel", "Nova Cidade", 123, "Casa");


        Cliente cliente01 = new Cliente("Maria", 82, endereco);
        Cliente cliente02 = new Cliente("Joana", 76, endereco);

        Loja loja = new Loja ("Flores do Amanhecer", "FLORES D. A. LTDA", 123400011, endereco, List.of(cliente01, cliente02), null);

        Vendedor vendedor = new Vendedor("Claudia", 55, endereco, loja, 1500, new double[]{1550, 1600, 1650});

        Gerente gerente1 = new Gerente("Cleusa", 45, endereco, loja, 1600, List.of(1700D, 1800D, 1900D));
        Gerente gerente2 = new Gerente("Juliana", 45, endereco, loja, 1600, List.of(1700D, 1800D, 1900D));

        Item item01 = new Item(1, "Lirio", "Flor", 12);
        Item item02 = new Item(2, "Gira Sol", "Flor", 12);

        ProcessaPedido processaPedido = new ProcessaPedido(loja);

        Pedido pedido = processaPedido.processar(null, cliente01, List.of(item01, item02));

        System.out.println("\n");
        gerente1.apresentarse();
        gerente1.calcularBonus();
        gerente1.calcularMedia();
        gerente1.setLoja(loja);
        gerente1.endereco.apresentarLogradouro();
        System.out.println("\n");
        gerente2.apresentarse();
        gerente2.calcularBonus();
        gerente2.calcularMedia();
        gerente2.setLoja(loja);
        gerente2.endereco.apresentarLogradouro();
        System.out.println("\n");
        item01.gerarDescricao();
        item02.gerarDescricao();
        System.out.println("\n");
        pedido.gerarDescricaoVenda();
        processaPedido.confirmarPagamento(pedido);
        System.out.println("\n");
    }
}

