package lista_01.classes.calculadora;

public class Calculadora {

  public double preco_da_venda = 0.0;
  public double troco_do_cliente = 0.0;

  private double calcularPrecoTotal(int qntd, double preco) {
    return qntd * preco;
  }

  public void setPrecoDaVenda(int quantidadeVendida, double preco_da_planta) {
    this.preco_da_venda = this.calcularPrecoTotal(quantidadeVendida, preco_da_planta);
    System.out.println("Preço total: R$" + String.format(" %.2f", this.preco_da_venda)); // formatar a saída do número
  }

  public double verPrecoDaVenda() { // para ver o preço só
    return this.preco_da_venda;
  }

  private double calcularTroco(double valor_pago) { // Fiz dessa forma para trabalhar o uso de atributos privados
    return valor_pago - this.preco_da_venda;
  }

  public void setTrocoDoCliente(double valor_pago) { // passando só o valor pago como parámetro, pois eu já tenho o
                                                     // atributo preço da venda que contem o valor total do produto
    this.troco_do_cliente = calcularTroco(valor_pago);

    if (this.troco_do_cliente < 0) {
      System.out.println("Está faltando R$" + String.format(" %.2f", this.troco_do_cliente * -1));
    } else if (this.troco_do_cliente > 0) {
      System.out.println("Devolva R$" + String.format(" %.2f", this.troco_do_cliente));
    } else {
      System.out.println("Não precisa de troco");
    }
  }
}

// A calculadora deve ser capaz de realizar as seguintes operações:

// 1. Cálculo de Preço Total:
// Dona Gabrielinha deseja calcular o preço total da venda de um item,
// considerando a quantidade de uma planta vendida vezes seu preço unitário.

// Entrada: Receber dois valores, primeiro a quantidade da referida planta,
// segundo a valor o preço da mesma.
// Saída: Retornar o resultado do cálculo.

// 2. Cálculo de Troco:
// A calculadora deve calcular o troco a ser dado ao cliente, considerando o
// valor pago.

// Entrada: Receber dois valores, primeiro o valor recebido pelo cliente,
// segundo o valor total da compra.
// Saída: Retornar o resultado do cálculo.

// 3. Criar Menu Console:
// [1] - Calcular Preço Total
// [2] - Calcular Troco
// [3] - Sair