package lista04;

public class Vendedor extends Pessoa {
  Loja loja = new Loja();
  Float salarioBase;
  Float[] salarioRecebido = new Float[3];

  public void apresentarse() {
    String msg = "Olá, meu nome é ".concat(nome)
    .concat(", Tenho ").concat(idade.toString()).concat(" Anos ")
    .concat("e trabalho na loja ").concat(loja.nome);
    System.out.println(msg);
  }

  public void calcularMedia() {
    Float salarioTotal = 0.2f;
    for (int i = 0; i < salarioRecebido.length; i++) { salarioTotal += salarioRecebido[i]; }

    Float media = salarioTotal / salarioRecebido.length;
    System.out.println("A média dos salários recebidos é: R$ " + media);
  }

  public void calcularBonus() {
    Float bonus = salarioBase * 0.2f;
    System.out.println("O bônus do salário base é: R$ " + bonus);
  }
}
