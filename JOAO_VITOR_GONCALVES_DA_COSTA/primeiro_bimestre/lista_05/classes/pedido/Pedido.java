package lista_05.classes.pedido;

import java.util.Date;

import lista_05.classes.cliente.Cliente;
import lista_05.classes.item.Item;
import lista_05.classes.loja.Loja;
import lista_05.classes.vendedor.Vendedor;

public class Pedido {
  public int id;
  public Date dataCriacao;
  public Date dataPagamento;
  public Date dataVencimentoReserva;
  public Cliente cliente;
  public Vendedor vendedor;
  public Loja loja;
  public Item[] itens;
  public Date date = new Date();
  public Long umDiaEmMs = 86400000l;

  public Pedido(int id, Long dataCriacao, Long dataPagamento, Cliente cliente,
      Vendedor vendedor, Loja loja, Item... itens) {
    this.id = id;
    this.dataCriacao = new Date(dataCriacao);

    this.dataPagamento = new Date(dataPagamento);
    this.dataVencimentoReserva = new Date(dataCriacao + (this.umDiaEmMs * 3));
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.loja = loja;
    this.itens = itens;
  }

  public Long getDataVencimentoReserva() {
    return dataVencimentoReserva.getTime();
  }

  public Long getDataPagamento() {
    return dataPagamento.getTime();
  }

  public double calcularValorTotal() {
    double valorTotal = 0;
    for (int i = 0; i < itens.length; i++) {
      valorTotal += itens[i].getValor();
    }
    return valorTotal;
  }

  public void gerarDescricaoVenda() {
    System.out
        .println(
            "Data de criação: ".concat(this.dataCriacao.toString())
                + String.format(" - Valor %.2f", this.calcularValorTotal()));
  }
}
