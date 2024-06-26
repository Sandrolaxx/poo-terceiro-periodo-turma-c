package lista7;

public class Gerente extends Pessoa {
  private Loja loja;
  private Float salarioBase;
  public Float[] salarioRecebido = new Float[3];

  public Gerente(String nomeCompleto, Integer idadePessoa, Loja loja, Endereco enderecoResidencial, Float[] salarioRecebido) {
    super(nomeCompleto, idadePessoa, enderecoResidencial);
    this.loja = loja;
    this.salarioRecebido = salarioRecebido;
  }
  public void apresentarse() { 
    System.out.println("Olá, meu nome é " + this.getNomeCompleto() + ", Tenho " + this.getIdadePessoa().toString() + " Anos e trabalho na loja " + loja.nome);
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

  public Float getSalarioBase() {return salarioBase;}

  public void setSalarioBase(Float salarioBase) {
    this.salarioBase = salarioBase;
  }
  public Loja getLoja() {return loja;}
  public void setLoja(Loja loja) {this.loja = loja;}
}
