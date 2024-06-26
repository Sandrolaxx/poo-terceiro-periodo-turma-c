package lista_05.classes.processa_pedido;

import java.util.Date;

import lista_05.classes.pedido.Pedido;

public class ProcessaPedido {
  private Pedido pedido;
  private Long umDiaEmMs = 86400000l;

  public ProcessaPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public void processar() {
    this.confirmarPagamento();
  }

  private void confirmarPagamento() {
    Long dataDeVencimento = this.pedido.getDataVencimentoReserva();
    Long dataDoPagamento = this.pedido.getDataPagamento();
    boolean pagamentoOk = this.verficarDataDeVencimento(dataDeVencimento, dataDoPagamento);
    System.out.println("Data do pagamento: " + new Date(dataDoPagamento).toString());
    System.out.println("Data do vencimento: " + new Date(dataDeVencimento).toString());
    System.out.println("Situação do pagamente: " + (pagamentoOk ? "Pagamento confirmado" : "Pagamento não confirmado"));
  }

  public Pedido getPedido() {
    return pedido;
  }

  public Long getUmDiaEmMs() {
    return umDiaEmMs;
  }

  public boolean verficarDataDeVencimento(Long dataDeVencimento, Long dataDoPagamento) {
    if (dataDoPagamento > dataDeVencimento) {
      return false;
    }
    return true;
  }

}
