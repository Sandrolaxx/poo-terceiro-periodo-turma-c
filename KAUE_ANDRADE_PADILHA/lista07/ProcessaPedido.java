package lista07;

import java.util.Scanner;

public class ProcessaPedido {
    public void venda(Pedido pedido) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        Integer id = 0;
        System.out.print("Digite o nome do item: ");
        String nome = sc.nextLine();
        System.out.print("Digite o tipo do item: ");
        String tipo = sc.nextLine();
        System.out.print("Digite o valor do item: ");
        Float valor = sc.nextFloat();

        pedido.adicionarItem(new Item(id, nome, tipo, valor));
    }

    public void processar(Pedido pedido) {
        String msg = "Processando Pedido: ".concat(pedido.getId().toString())
                .concat("\nData de criação: ").concat(pedido.getDataCriacao().toString())
                .concat("\nData de pagamento: ").concat(pedido.getDataPagamento().toString())
                .concat("\nData de vencimento: ").concat(pedido.getDataVencimento().toString())
                .concat("\nCliente: ").concat(pedido.getCliente().getNome())
                .concat("\nVendedor: ").concat(pedido.getVendedor().getNome())
                .concat("\nLoja: ").concat(pedido.getLoja().nome)
                .concat("\nEmpresa parceira: ").concat(pedido.getEmpresaParceira());
        System.out.println(msg);
    }

    private void confirmarPagamento(Pedido pedido) {
        int resultado = pedido.getDataPagamento().compareTo(pedido.getDataVencimento());

        if (resultado <= 0) {
            System.out.println("Pagamento confirmado :D");
        } else {
            System.out.println("Pagamento não confirmado :c");
        }
    }

    public void testarMetodo(Pedido pedido) {
        confirmarPagamento(pedido);
    }

    public void finalizarPedido(Pedido pedido) {
        System.out.print("Digite a empresa parceira: ");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        pedido.setEmpresaParceira(sc.nextLine());
        pedido.gerarDescricaoVenda();
    }
}
