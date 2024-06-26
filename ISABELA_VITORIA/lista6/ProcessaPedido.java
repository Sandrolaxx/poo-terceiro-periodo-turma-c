package lista6;

public class ProcessaPedido {
  public void processar(Pedido pedido) {
    String msg = "Processando Pedido: ".concat(pedido.id.toString())
    .concat("\nData de criação: ").concat(pedido.dataCriacao.toString())
    .concat("\nData de pagamento: ").concat(pedido.dataPagamento.toString())
    .concat("\nData de vencimento: ").concat(pedido.dataVencimento.toString())
    .concat("\nCliente: ").concat(pedido.cliente.nome)
    .concat("\nVendedor: ").concat(pedido.vendedor.nome)
    .concat("\nLoja: ").concat(pedido.loja.nomeFantasia);
    System.out.println(msg);
  }

  private void confirmarPagamento(Pedido pedido) {
    int resultado = pedido.dataPagamento.compareTo(pedido.dataVencimento);
    if (resultado <= 0) {
      System.out.println("Pagamento confirmado com sucesso");
    } else {
      System.out.println("Pagamento não confirmado, passou da data de vencimento");
    }
  }

  public void testeConfirmarPagamento(Pedido pedido) {
    confirmarPagamento(pedido);
  }
}
