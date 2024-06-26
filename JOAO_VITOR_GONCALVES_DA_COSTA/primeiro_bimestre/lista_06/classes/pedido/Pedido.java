package lista_06.classes.pedido;

import java.util.Date;

import lista_06.classes.cliente.Cliente;
import lista_06.classes.item.Item;
import lista_06.classes.loja.Loja;
import lista_06.classes.vendedor.Vendedor;

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

  public Cliente getCliente() {
    return cliente;
  }

  public String gerarDescricaoVenda() {
    System.out.println("Cliente: ");
    this.cliente.apresentarse();
    return "Data de criação: ".concat(this.dataCriacao.toString())
        + String.format(" - Valor %.2f", this.calcularValorTotal());
  }
}
