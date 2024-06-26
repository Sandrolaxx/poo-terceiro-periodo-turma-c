package lista05;

public class ProcessaPedido {
  public void processar(Pedido pedido) {
    String msg = "Processando Pedido: ".concat(pedido.id.toString())
    .concat("\nData de criação: ").concat(pedido.dataCriacao.toString())
    .concat("\nData de pagamento: ").concat(pedido.dataPagamento.toString())
    .concat("\nData de vencimento: ").concat(pedido.dataVencimento.toString())
    .concat("\nCliente: ").concat(pedido.cliente.nome)
    .concat("\nVendedor: ").concat(pedido.vendedor.nome)
    .concat("\nLoja: ").concat(pedido.loja.nome);
    System.out.println(msg);
  }

  private void confirmarPagamento(Pedido pedido) {
    int resultado = pedido.dataPagamento.compareTo(pedido.dataVencimento);

    if (resultado <= 0) {
      System.out.println("Pagamento confirmado :D");
    } else {
      System.out.println("Pagamento não confirmado :c");
    }
  }

  public void testarMetodo(Pedido pedido) {
    confirmarPagamento(pedido);
  }
}
