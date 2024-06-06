package RICARDO_DINIZ_SILVA.Lista7;

public class Gerente extends Pessoa {
  private Loja loja;
  private Float salarioBase;
  public Float[] salarioRecebido = new Float[3];

  // Construtor
  public Gerente(String nome, Integer idade, Loja loja, Endereco endereco, Float[] salarioRecebido) {
    this.setNome(nome);
    this.setIdade(idade);
    this.loja = loja;
    this.setEndereco(endereco);
    this.salarioRecebido = salarioRecebido;
  }

  // Override para sobrescrever
  @Override
  public void apresentarse() { 
    System.out.println("Olá, meu nome é " + this.getNome() + ", Tenho " + this.getIdade().toString() + " Anos e trabalho na loja " + loja.nome);
  }

  public void calcularMedia() {
    Float salarioTotal = 0.2f;
    for (int i = 0; i < salarioRecebido.length; i++) {
      salarioTotal += salarioRecebido[i];
    }
    Float media = salarioTotal / salarioRecebido.length;
    System.out.println("A média é: R$ " + media);
  }

  public void calcularBonus() {
    Float bonus = salarioBase * 0.35f;
    System.out.println("O bônus é: R$ " + bonus);
  }

  public Float getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(Float salarioBase) {
    this.salarioBase = salarioBase;
  }

  public Loja getLoja() {
    return loja;
  }

  public void setLoja(Loja loja) {
    this.loja = loja;
  }
}
