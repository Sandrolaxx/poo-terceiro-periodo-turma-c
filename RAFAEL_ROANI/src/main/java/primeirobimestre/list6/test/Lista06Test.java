package primeirobimestre.list6.test;

import primeirobimestre.list6.domain.domains.*;
import primeirobimestre.list6.generated_class.GeneretedClass;

import java.util.List;

public class Lista06Test {
    public static void main(String[] args) {
        Cliente cliente01 = GeneretedClass.cliente();
        Cliente cliente02 = GeneretedClass.cliente();

        Vendedor vendedor01 = GeneretedClass.vendedor();
        Vendedor vendedor02 = GeneretedClass.vendedor();

        Gerente gerente01 = GeneretedClass.gerente();
        Gerente gerente02 = GeneretedClass.gerente();

        Loja loja = GeneretedClass.loja(
                List.of(cliente01, cliente02),
                List.of(vendedor01, vendedor02),
                List.of(gerente01, gerente02)
        );

        vendedor01.setLoja(loja);
        vendedor02.setLoja(loja);
        gerente01.setLoja(loja);
        gerente02.setLoja(loja);

        System.out.println("####### Apresentarse #######");
        cliente01.apresentarse();
        cliente02.apresentarse();
        vendedor01.apresentarse();
        vendedor02.apresentarse();
        loja.apresentarse();

        ItemCompra itemCompra01 = GeneretedClass.itemCompra();
        ItemCompra itemCompra02 = GeneretedClass.itemCompra();
        ItemCompra itemCompra03 = GeneretedClass.itemCompra();
        ItemCompra itemCompra04 = GeneretedClass.itemCompra();

        ProcessaPedido processaPedido = new ProcessaPedido(loja);

        Pedido pedido01 = processaPedido.processar(cliente01, vendedor01, List.of(itemCompra01, itemCompra02));
        Pedido pedido02 = processaPedido.processar(cliente02, vendedor02, List.of(itemCompra03, itemCompra04));

        System.out.println("\n####### Calcular Media #######");
        System.out.println("Gerentes:");
        System.out.println(gerente01.calcularMedia());
        System.out.println(gerente02.calcularMedia());
        System.out.println("Vendedores:");
        System.out.println(vendedor01.calcularMedia());
        System.out.println(vendedor02.calcularMedia());

        System.out.println("\n####### Calcular Bonus #######");
        System.out.println("Gerentes:");
        System.out.println(gerente01.calcularBonus());
        System.out.println(gerente02.calcularBonus());
        System.out.println("Vendedores:");
        System.out.println(vendedor01.calcularBonus());
        System.out.println(vendedor02.calcularBonus());

        System.out.println("\n####### Endereço #######");
        System.out.println("Clientes: ");
        System.out.println(cliente01.getEndereco().apresentarLogradouro());
        System.out.println(cliente02.getEndereco().apresentarLogradouro());
        System.out.println("Vendedores:");
        System.out.println(vendedor01.getEndereco().apresentarLogradouro());
        System.out.println(vendedor02.getEndereco().apresentarLogradouro());
        System.out.println("Gerentes:");
        System.out.println(gerente01.getEndereco().apresentarLogradouro());
        System.out.println(gerente01.getEndereco().apresentarLogradouro());
        System.out.println("Loja: ");
        System.out.println(loja.getEndereco().apresentarLogradouro());

        System.out.println("\n####### Item - Gerar Descrição #######");
        System.out.println(itemCompra01.gerarDescricao());
        System.out.println(itemCompra02.gerarDescricao());
        System.out.println(itemCompra03.gerarDescricao());
        System.out.println(itemCompra04.gerarDescricao());

        System.out.println("\n####### Pedido - Calcular Valor Total #######");
        System.out.println(pedido01.calcularValorTotal());
        System.out.println(pedido02.calcularValorTotal());

        System.out.println("\n####### Pedido - Gerar Descrição de Venda #######");
        System.out.println(pedido01.gerarDescricaoVenda());
        System.out.println(pedido02.gerarDescricaoVenda());

        System.out.println("\n####### ProcessaPedido - Confirma Pagamento - Não pago #######");
        processaPedido.confirmarPagamento(pedido01);
        processaPedido.confirmarPagamento(pedido02);

        processaPedido.pagarPedido(pedido01);
        processaPedido.pagarPedido(pedido02);

        System.out.println("\n####### ProcessaPedido - Confirma Pagamento - Pago #######");
        processaPedido.confirmarPagamento(pedido01);
        processaPedido.confirmarPagamento(pedido02);
    }
}