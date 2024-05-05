package lista_6;

import java.util.List;

public class Lista06Test {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Parana", "Cascavel", "Centro", 246, "Predio");
        Loja loja = new Loja("Beija Flor", "Beija Flor LTDA", 1234567892323L, endereco);

        Cliente cliente01 = new Cliente("Claudineia", 57, endereco);
        Cliente cliente02 = new Cliente("Angela", 45, endereco);

        Vendedor vendedor01 = new Vendedor("Maria", 34, endereco, loja, 1530);
        Vendedor vendedor02 = new Vendedor("Joana", 34, endereco, loja, 1680);

        Gerente gerente = new Gerente("Lucimar", 40, endereco, loja, 2200);

        loja.cadastrarCliente(cliente01);
        loja.cadastrarCliente(cliente02);
        loja.cadastrarVendedor(vendedor01);
        loja.cadastrarVendedor(vendedor02);
        loja.cadastrarGerente(gerente);

        vendedor01.adicionarSalarioRecebido(1590);
        vendedor01.adicionarSalarioRecebido(1635);
        vendedor01.adicionarSalarioRecebido(1650);

        vendedor02.adicionarSalarioRecebido(1640);
        vendedor02.adicionarSalarioRecebido(1675);
        vendedor02.adicionarSalarioRecebido(1700);

        ProcessaPedido processaPedido = new ProcessaPedido(loja);

        System.out.println("----- Clientes ------");
        cliente01.apresentarse();
        cliente02.apresentarse();

        System.out.println("----- Vendedores ------");
        vendedor01.apresentarse();
        vendedor02.apresentarse();
        System.out.println("Calcular media: ");
        System.out.println("Media: " + vendedor01.calcularMedia());
        System.out.println("Media: " + vendedor01.calcularMedia());
        System.out.println("Calcular bonus: ");
        System.out.println("Bonus: " + vendedor01.calcularBonus());
        System.out.println("Bonus: " + vendedor02.calcularBonus());

        System.out.println("----- Gerente ------");
        gerente.apresentarse();
        System.out.println("Calcular media: ");
        System.out.println("Media: " + gerente.calcularMedia());
        System.out.println("Calcular bonus: ");
        System.out.println("Bonus: " + gerente.calcularBonus());

        System.out.println("----- Loja ------");
        loja.apresentarse();
        System.out.println("Clientes: " + loja.contarClientes());
        System.out.println("Vendedores: " + loja.contarVendedores());

        System.out.println("----- Pedido e Item ------");
        Item item01 = new Item("Gira Sol", "Flor", 35.99);
        item01.gerarDescricao();
        Item item02 = new Item("Orquidea", "Flor", 75.49);
        item02.gerarDescricao();
        Pedido pedido = processaPedido.processar(cliente01, vendedor01, List.of(item01, item02));
        pedido.gerarDescricaoVenda();
        processaPedido.comfirmaPagamento(pedido);
    }
}
