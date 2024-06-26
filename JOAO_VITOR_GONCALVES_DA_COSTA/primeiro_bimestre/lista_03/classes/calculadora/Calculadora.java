package lista_03.classes.calculadora;

public class Calculadora {

  public double preco_da_venda = 0.0;
  public double troco_do_cliente = 0.0;
  public double desconto_em_reais = 0.0;
  private double porcentagem_do_desconto = 5.0 / 100.0; // se não colocar .0 depois ele fica como 0, ou seja quebra o
                                                        // decimal

  private double calcularPrecoTotal(int qntd, double preco) {
    return qntd * preco;
  }

  public double setPrecoDaVenda(int quantidadeVendida, double preco_da_planta) {
    this.preco_da_venda = this.calcularPrecoTotal(quantidadeVendida, preco_da_planta);
    if (quantidadeVendida > 10) {

      this.desconto_em_reais = this.preco_da_venda * this.getDiscount();
      this.preco_da_venda -= this.desconto_em_reais;

      System.out.println("Preço total: R$" + String.format(" %.2f", this.preco_da_venda) + ", desconto de R$"
          + String.format(" %.2f", this.desconto_em_reais)); // saída com desconto

      return this.preco_da_venda; // return para não duplicar a mensagem
    } else {
      this.desconto_em_reais = 0.0;
      System.out.println("Preço total: R$" + String.format(" %.2f", this.preco_da_venda)); // formatar a saída do número
      return (this.preco_da_venda);
    }
  }

  public double getDiscount() {
    return this.porcentagem_do_desconto; // get para pegar o atributo privado
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
  }
}

// 1. Desconto Especial:
// Quando um cliente compra mais de 10 plantas, Dona Gabrielinha oferece um
// desconto especial de 5% no valor total da compra.

// Entrada: Receber dois valores, primeiro a quantidade da referida planta,
// segundo a valor o preço da mesma.
// Saída: Retornar caso a quantidade informada for maior que 10 realizar o
// desconto.

// 2. Registro de Vendas:
// Dona Gabrielinha deseja manter um registro das vendas, incluindo a quantidade
// de plantas vendidas, o valor venda e os descontos aplicados.

// Entrada: Venda realizada sistema
// Saída: Armazenamento desses dados no sistema.

// 3. Adicionar ao menu existente função 2 e aprimorar cálculo do valor a pagar
// com a função 1.