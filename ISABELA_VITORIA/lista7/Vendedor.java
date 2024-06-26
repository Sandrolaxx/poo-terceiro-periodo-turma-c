package lista7;

public class Vendedor extends Pessoa {
  private Loja localDeTrabalho;
  private Float salarioBase;
  private Float[] salarioRecebido;

  public Vendedor(String nomeCompleto, Integer idadePessoa, Endereco enderecoResidencial, Float[] salarioRecebido) {
    super(nomeCompleto, idadePessoa, enderecoResidencial);
    this.salarioRecebido = salarioRecebido;
  }
  public void apresentarse() {
    System.out.println("Meu nome é " + this.getNomeCompleto() + ", tenho " + this.getIdadePessoa() + " anos e trabalho na loja " + localDeTrabalho.nome);
  }

  public void calcularMedia() {
    Float salarioTotal = 0f;
    for (Float salario : salarioRecebido) {
      salarioTotal += salario;
    }
    Float media = salarioTotal / salarioRecebido.length;
    System.out.println("A média é: R$ " + media);
  }
  public void calcularBonus() {
    if (salarioBase != null) {
      Float bonus = salarioBase * 0.2f;
      System.out.println("O bônus é: R$ " + bonus);
    }
  }

  public void setLoja(Loja localDeTrabalho) {
    this.localDeTrabalho = localDeTrabalho;
  }
  public void setSalarioBase(Float salarioBase) {
    this.salarioBase = salarioBase;
  }

  public String getNome() {
    return super.getNomeCompleto();
  }
}
