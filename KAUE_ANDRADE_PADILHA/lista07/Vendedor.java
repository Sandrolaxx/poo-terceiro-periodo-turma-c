package lista07;

public class Vendedor extends Pessoa {
  private Loja loja;
  private Float salarioBase;
  private Float[] salarioRecebido;

  public Vendedor(String nome, Integer idade, Endereco endereco, Float[] salarioRecebido) {
    super(nome, idade, endereco);
    this.salarioRecebido = salarioRecebido;
  }

  @Override
  public void apresentarse() {
    System.out.println(
        "Olá, meu nome é " + this.getNome() + ", Tenho " + this.getIdade() + " anos e trabalho na loja " + loja.nome);
  }

  public void calcularMedia() {
    Float salarioTotal = 0f;
    for (Float salario : salarioRecebido) {
      salarioTotal += salario;
    }
    Float media = salarioTotal / salarioRecebido.length;
    System.out.println("A média dos salários recebidos é: R$ " + media);
  }

  public void calcularBonus() {
    if (salarioBase != null) {
      Float bonus = salarioBase * 0.2f;
      System.out.println("O bônus do salário base é: R$ " + bonus);
    } else {
      System.out.println("Salário base não definido.");
    }
  }

  public void setLoja(Loja loja) {
    this.loja = loja;
  }

  public void setSalarioBase(Float salarioBase) {
    this.salarioBase = salarioBase;
  }
}
