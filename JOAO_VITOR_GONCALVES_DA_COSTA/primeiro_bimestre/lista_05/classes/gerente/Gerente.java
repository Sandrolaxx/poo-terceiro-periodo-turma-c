package lista_05.classes.gerente;

import lista_05.classes.vendedor.Vendedor;

public class Gerente extends Vendedor {

  private double valorParaMultiplicarParaCalcularBonus = 0.35;

  public Gerente(String nome, int idade, String bairro, String cidade, String rua, String estado, String complemento,
      String numero, int quantidadeDeSalariosRecebidos,
      double salarioBase) {
    super(nome, idade, bairro, cidade, rua, estado, complemento, numero, quantidadeDeSalariosRecebidos, salarioBase);
  }

  public void calcularBonus() {
    double bonus = this.getSalarioBase() * this.getValorParaMultiplicarParaCalcularBonus();
    System.out.println("O valor adicional que ele deve receber é R$ " + String.format("%.2f", bonus));
  }

  @Override
  public double getValorParaMultiplicarParaCalcularBonus() {
    return this.valorParaMultiplicarParaCalcularBonus;
  }
}
