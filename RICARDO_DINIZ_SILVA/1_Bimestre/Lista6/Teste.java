package RICARDO_DINIZ_SILVA.Lista6;

import java.util.Calendar;
import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        Cliente cliente01 = new Cliente("Joana", 45, "Florandia", "Agua Rosa", "Av. Europa");
        Cliente cliente02 = new Cliente("Claudia", 39, "Florandia", "Agua Rosa", "Av. Atlantida");

        Vendedor vendedor01 = new Vendedor("Maria", 54, "Florandia", "Agua Rosa", "João pedro II", 1600, new double[]{1600, 1699, 1857});
        Vendedor vendedor02 = new Vendedor("Elizabete", 37, "Florandia", "Agua Rosa", "XV de novenbro", 1550, new double[]{1550, 1632, 1748});

        Loja loja = new Loja("Flor da Terra", "Flor da Terra LTDA", 88736957000141L, "Florandia", "Centro", "Rua da Conceição",
                new Vendedor[]{vendedor01, vendedor02},
                new Cliente[]{cliente01, cliente02});

        vendedor01.setLoja(loja);
        vendedor02.setLoja(loja);

        System.out.println("###### Apresentarse #######");
        System.out.println("Loja:");
        loja.apresentarse();

        System.out.println("\nVendedores:");
        vendedor01.apresentarse();
        vendedor02.apresentarse();

        System.out.println("\nClientes:");
        cliente01.apresentarse();
        cliente02.apresentarse();

        System.out.println("\n###### Contar Clientes e Vendedores #######");
        System.out.println("Clientes: ".concat(String.valueOf(loja.contarClientes())));
        System.out.println("Vendedores: ".concat(String.valueOf(loja.contarVendedores())));

        System.out.println("\n###### Calcular media e Calcular bonus #######");
        System.out.println("Calcular media:");
        System.out.println("Vendedor 1: ".concat(String.valueOf(vendedor01.calcularMedia())));
        System.out.println("Vendedor 2: ".concat(String.valueOf(vendedor02.calcularMedia())));

        System.out.println("\nCalcular bonus:");
        System.out.println("Vendedor 1: ".concat(String.valueOf(vendedor01.calcularBonus())));
        System.out.println("Vendedor 2: ".concat(String.valueOf(vendedor02.calcularBonus())));

        System.out.println("\n###### Gerentes #######");
        Gerente gerente01 = new Gerente("João", 45, "Florandia", "Agua Rosa", "Av. Europa", loja, 2500, new double[]{2500, 2600, 2700});
        Gerente gerente02 = new Gerente("Pedro", 39, "Florandia", "Agua Rosa", "Av. Atlantida", loja, 2400, new double[]{2400, 2500, 2600});

        System.out.println("\n####### Aprentação Gerentes #######");
        gerente01.apresentarse();
        gerente02.apresentarse();

        System.out.println("\n###### Calcular media e Calcular bonus #######");
        System.out.println("Calcular media:");
        gerente01.calcularMedia();
        gerente02.calcularMedia();

        System.out.println("\nCalcular bonus:");
        gerente01.calcularBonus();
        gerente02.calcularBonus();

        System.out.println("\n###### Item #######");
        Item item01 = new Item(232, "Cadeira", "Móveis", 150);
        Item item02 = new Item(233, "Mesa", "Móveis", 250);
        Item item03 = new Item(234, "Sofá", "Móveis", 350);
        item01.gerarDescricao();
        item02.gerarDescricao();

        Date dataAtual = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(Calendar.DAY_OF_MONTH, 3);

        Date dataVencimento = c.getTime();

        System.out.println("\n###### Pedido #######");
        System.out.println("Pedido 01 - Pagamento na data certa");
        Pedido pedido01 = new Pedido(1, dataAtual, dataAtual, dataVencimento, cliente01, vendedor01, loja, new Item[]{item01, item02, item03});
        pedido01.calcularValorTotal();
        pedido01.gerarDescricaoVenda();

        ProcessaPedido processaPedido = new ProcessaPedido();
        processaPedido.processar(pedido01);
        processaPedido.getConfirmacaoPagamento(pedido01);

        System.out.println("\nPedido 02 - Pagamento atrasado");
        c.add(Calendar.DAY_OF_MONTH, 4);
        Date dataPagamentoAtrasado = c.getTime();
        Pedido pedido02 = new Pedido(2, dataAtual, dataPagamentoAtrasado, dataVencimento, cliente02, vendedor02, loja, new Item[]{item01, item02, item03});
        processaPedido.processar(pedido02);
        processaPedido.getConfirmacaoPagamento(pedido02);
    }
}
