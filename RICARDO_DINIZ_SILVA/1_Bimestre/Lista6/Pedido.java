package RICARDO_DINIZ_SILVA.Lista6;

import java.util.Date;

public class Pedido {
  int id;
  Date dataCriacao;
  Date dataPagamento;
  Date dataVencimentoReserva;
  Cliente cliente;
  Vendedor vendedor;
  Loja loja;
  Item[] itens = new Item[3];

  public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
    this.id = id;
    this.dataCriacao = dataCriacao;
    this.dataPagamento = dataPagamento;
    this.dataVencimentoReserva = dataVencimentoReserva;
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.loja = loja;
    this.itens = itens;
  }

  public void calcularValorTotal() {
    double valorTotal = 0;
    for(Item item : itens) {
      valorTotal += item.valor;
    }
    System.out.println("Valor total do pedido: ".concat(String.valueOf(valorTotal)));
  }

  public void gerarDescricaoVenda() {
    System.out.println("Descrição da venda: ");
    double valorTotal = 0;
    for(Item item : itens) {
      valorTotal += item.valor;
    }
    System.out.println("Data de criação: ".concat(dataCriacao.toString()).concat(", Valor total: ").concat(String.valueOf(valorTotal)));
  }
}
