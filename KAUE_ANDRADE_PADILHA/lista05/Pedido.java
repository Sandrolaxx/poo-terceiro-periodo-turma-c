package lista05;

import java.util.Date;

public class Pedido {
  Integer id;
  Date dataCriacao;
  Date dataPagamento;
  Date dataVencimento;
  Cliente cliente;
  Vendedor vendedor;
  Loja loja;
  Item[] itens = new Item[3];

  public float calcularValorTotal() {
    Float valorTotal = 0.0f;

    for (int i = 0; i < itens.length; i++) {
      valorTotal += itens[i].valor;
    }

    System.out.println("Valor total: " + valorTotal);
    return valorTotal;
  }

  public void gerarDescricaoVenda() {
    String msg = "Data de criação: ".concat(dataCriacao.toString())
    .concat(", Valor total: ").concat(calcularValorTotal() + "");
    System.out.println(msg);
  }
}
