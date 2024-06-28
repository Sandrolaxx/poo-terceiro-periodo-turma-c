import java.util.Date;

public class Pedido {
  int id;
  Date dataCriacao;
  Date dataPagamento;
  Date dataVencimentoReserva;
  Cliente cliente;
  Vendedor vendedor;
  Loja loja;
  Item[] itens = new Item[4];

  private float total;
  public void calcularValor () {
    total = 0;
    for (int contador = 0; contador < itens.length; contador++) {
      total = total + itens[contador].preco;
    }
    System.out.println("Valor total do Pedido R$ " + total);
  }

  public void descricaoVenda () {
    System.out.println("ID: " + id);
    System.out.println(", Data de Criação: " + dataCriacao);
    System.out.println(", Data de Pagamento: " + dataPagamento);
    System.out.println(", Valor Pago: " + total);
  }
}
