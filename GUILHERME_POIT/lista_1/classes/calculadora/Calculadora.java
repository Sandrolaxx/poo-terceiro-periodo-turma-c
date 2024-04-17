package lista_1.classes.calculadora;

public class Calculadora {

  public double preco_venda = 0.0;
  public double troco_cliente = 0.0;

  private double calcularValorTotal(int quant, double preco) {
    return quant * preco;
  }

  public void setPrecoDaVenda(int quantVendida, double preco_planta) {
    this.preco_venda = this.calcularValorTotal(quantVendida, preco_planta);
    System.out.println("Valor total: R$" + String.format(" %.2f", this.preco_venda)); 
  }

  public double verPrecoDaVenda() { 
    return this.preco_venda;
  }


  private double calcularTroco(double valor_pago) {
    return valor_pago - this.preco_venda;
  }

  public void setTrocoDoCliente(double valor_pago) { 
    this.troco_cliente = calcularTroco(valor_pago);

    if (this.troco_cliente < 0) {
      System.out.println("Falta R$" + String.format(" %.2f", this.troco_cliente * -1));
    } else if (this.troco_cliente > 0) {
      System.out.println("Troco R$" + String.format(" %.2f", this.troco_cliente));
    } else {
      System.out.println("Não é necessario troco");
    }
  }
}
