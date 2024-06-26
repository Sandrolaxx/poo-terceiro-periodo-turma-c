package lista_06.classes.vendedor;

import lista_06.classes.loja.Loja;
import lista_06.classes.pessoa.Pessoa;

public class Vendedor extends Pessoa {

  private double salarioBase;
  private double valorParaMultiplicarParaCalcularBonus = 0.2;
  private double salarioRecebido[];
  private Loja lojaEmqueTrabalha;
  public int salariosRecebidosLength;

  public Vendedor(String nome, int idade, String bairro, String cidade, String rua, String estado, String complemento,
      String numero, int quantidadeDeSalariosRecebidos,
      double salarioBase) {
    super(nome, idade, bairro, cidade, rua, estado, complemento, numero);

    this.salariosRecebidosLength = quantidadeDeSalariosRecebidos;
    this.salarioBase = salarioBase;

    if (this.salariosRecebidosLength < 3) {
      System.out.println(
          "Quantidade mínima de salários é 3, portanto vamos colocar a quantidade de salarios recebidos como 3");
      salarioRecebido = new double[3];
      this.salariosRecebidosLength = 3;
    }
    salarioRecebido = new double[this.salariosRecebidosLength];
  }

  @Override
  public void apresentarse() {
    super.apresentarse();
    System.out.println("E atualmente trabalho na loja:");
    this.getLojaEmqueTrabalha();
  }

  public void adicionarSalarios(double... salarios) {
    if (salarios.length == this.salariosRecebidosLength) {
      for (int i = 0; i < this.salariosRecebidosLength; i++) {
        this.salarioRecebido[i] = salarios[i];
      }
    } else {
      System.out.println("Quantidade de salários passada não corresponde à quantidade definida anteriormente.");
    }
  }

  public void calcularMedia() {
    double mediaDosSalarios = 0;
    for (int i = 0; i < this.salariosRecebidosLength; i++) {
      mediaDosSalarios += salarioRecebido[i];
    }
    System.out.println("A média dos últimos " + this.salariosRecebidosLength
        + " salários recebidos é R$ " + String.format("%.2f", mediaDosSalarios / this.salariosRecebidosLength));
  }

  public void calcularBonus() {
    double bonus = this.salarioBase * this.getValorParaMultiplicarParaCalcularBonus();
    System.out.println("O valor adicional que ele deve receber é R$ " + String.format("%.2f", bonus));
  }

  // GETTERS
  public void getLojaEmqueTrabalha() {
    lojaEmqueTrabalha.apresentarse();
  }

  public double getValorParaMultiplicarParaCalcularBonus() {
    return valorParaMultiplicarParaCalcularBonus;
  }

  public double getSalarioBase() {
    return salarioBase;
  }

  // SETTERS
  public void setLojaEmqueTrabalha(Loja lojaEmqueTrabalha) {
    this.lojaEmqueTrabalha = lojaEmqueTrabalha;
  }
}
