package lista_2.classes.calculadora;

public class Calculadora {

    public double precoVenda = 0.0;
    public double trocoCliente = 0.0;
    public double desconto = 0.0;
    public double porcentagemDesconto = 5.0 / 100.0;

    public double calcularValorTotal(int quant, double preco) {
        return quant * preco;
    }

    public double setPrecoDaVenda(int quantVendida, double precoPlanta) {
        this.precoVenda = this.calcularValorTotal(quantVendida, precoPlanta);
        if (quantVendida > 10) {

            this.desconto = this.precoVenda * this.getDiscount();
            this.precoVenda -= this.desconto;

            System.out.println("Preço total: R$" + String.format(" %.2f", this.precoVenda) + ", desconto de R$"
                    + String.format(" %.2f", this.desconto));

            return this.precoVenda;
        } else {
            this.desconto = 0.0;
            System.out.println("Preço total: R$" + String.format(" %.2f", this.precoVenda)); // formatar a saída do
                                                                                             // número
            return (this.precoVenda);

        }

    }

    public double getDiscount() {
        return this.porcentagemDesconto;
    }

    public double verPrecoDaVenda() {

        return this.precoVenda;
    }

    public double calcularTroco(double valorPago) {
        return valorPago - this.precoVenda;
    }

    public void setTrocoDoCliente(double valorPago) {

        this.trocoCliente = calcularTroco(valorPago);

        if (this.trocoCliente < 0) {
            System.out.println("Falta R$" + String.format(" %.2f", this.trocoCliente * -1));

        } else if (this.trocoCliente > 0) {
            System.out.println("Troco R$" + String.format(" %.2f", this.trocoCliente));

        } else {
            System.out.println("Não é necessario troco");
        }
    }
}
