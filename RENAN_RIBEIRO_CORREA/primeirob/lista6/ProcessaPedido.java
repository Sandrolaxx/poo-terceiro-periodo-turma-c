public class ProcessaPedido {
  public void processar(Pedido pedido) {
    System.out.println("Processando o pedido: " + pedido.id);
    pedido.calcularValor();
    pedido.descricaoVenda();
  }

  private void confirmarPagamento(Pedido pedido) {
    boolean resultado = pedido.dataPagamento.before(pedido.dataVencimentoReserva);
    if (resultado) {
      System.out.println("Pagamento confirmado com sucesso!");
    } else {
      System.out.println("Pagamento não foi confirmado!");
    }
  }

  public void teste(Pedido pedido) {
    confirmarPagamento(pedido);
  }
}
