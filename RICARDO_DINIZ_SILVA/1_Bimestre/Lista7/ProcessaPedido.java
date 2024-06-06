package RICARDO_DINIZ_SILVA.Lista7;

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
        String mensagem = "Processando o Pedido com ID: ".concat(pedido.getId().toString())
        .concat("\nData de criação do pedido: ").concat(pedido.getDataCriacao().toString())
        .concat("\nData de pagamento do pedido: ").concat(pedido.getDataPagamento().toString())
        .concat("\nData de vencimento do pedido: ").concat(pedido.getDataVencimento().toString())
        .concat("\nCliente: ").concat(pedido.getCliente().getNome())
        .concat("\nVendedor: ").concat(pedido.getVendedor().getNome())
        .concat("\nLoja: ").concat(pedido.getLoja().nome)
        .concat("\nEmpresa com parceria: ").concat(pedido.getEmpresaParceira());
        System.out.println(mensagem);
    }

    private void confirmarPagamento(Pedido pedido) {
        int data = pedido.getDataPagamento().compareTo(pedido.getDataVencimento());

        if (data <= 0) {
            System.out.println("Pagamento realizado com sucesso");
        } else {
            System.out.println("O pagamento não foi processado, pois a data de pagamento é maior que a data de vencimento");
        }
    }

    public void confirmaOPagamento(Pedido pedido) {
        confirmarPagamento(pedido);
    }

    public void finalizarPedido(Pedido pedido) {
        System.out.print("Qual a empresa parceira do pedido? ");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        pedido.setEmpresaParceira(scanner.nextLine());
        pedido.gerarDescricaoVenda();
    }
}
