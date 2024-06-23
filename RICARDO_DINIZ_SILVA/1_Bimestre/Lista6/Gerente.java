package RICARDO_DINIZ_SILVA.Lista6;

public class Gerente extends Pessoa{
  Loja loja;
  double salarioBase;
  double[] salariosRecebidos;

  public Gerente(String nome, int idade, String cidade, String bairro, String rua, Loja loja, double salarioBase, double[] salariosRecebidos) {
    super(nome, idade, cidade, bairro, rua);
    this.loja = loja;
    this.salarioBase = salarioBase;
    this.salariosRecebidos = salariosRecebidos;
  }

  @Override
  public void apresentarse() {
    System.out.println("Nome: ".concat(nome).concat(", minha idade: ").concat(String.valueOf(idade)).concat(", loja: ".concat(loja.nomeFantasia)));
  }

  public void calcularMedia() {
    double soma = 0;
    for(double salario : salariosRecebidos) {
      soma += salario;
    }
    System.out.println("Média salarial: ".concat(String.valueOf(soma / salariosRecebidos.length)));
  }

  public void calcularBonus() {
    System.out.println("Bônus salarial: ".concat(String.valueOf(salarioBase * 0.35)));
  }
}
