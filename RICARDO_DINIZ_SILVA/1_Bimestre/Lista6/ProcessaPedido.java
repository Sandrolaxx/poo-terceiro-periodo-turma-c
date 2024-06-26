package RICARDO_DINIZ_SILVA.Lista6;

public class ProcessaPedido {
  public void processar(Pedido pedido) {
    System.out.println("Processamento do pedido: " + String.valueOf(pedido.id));
    System.out.println("Cliente: " + pedido.cliente.nome);
    System.out.println("Vendedor: " + pedido.vendedor.nome);
    System.out.println("Loja: " + pedido.loja.nomeFantasia);
    System.out.println("Data de criação: " + pedido.dataCriacao.toString());
    System.out.println("Data de pagamento: " + pedido.dataPagamento.toString());
    System.out.println("Data de vencimento da reserva: " + pedido.dataVencimentoReserva.toString());
    pedido.calcularValorTotal();
  }

  private void confirmarPagamento(Pedido pedido) {
    if (pedido.dataPagamento.before(pedido.dataVencimentoReserva)) {
      System.out.println("Pagamento confirmado");
    } else {
      System.out.println("Pagamento não confirmado");
    }
  }

  public void getConfirmacaoPagamento(Pedido pedido) {
    confirmarPagamento(pedido);
  }
}
