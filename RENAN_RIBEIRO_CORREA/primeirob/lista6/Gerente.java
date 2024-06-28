public class Gerente extends Endereco {
  String nome;
  int idade;
  Loja loja;
  float salarioBase;
  float[] salarioRecebido = new float[3];

  public void apresentar () {
    System.out.println("Nome: " + nome);
    System.out.println(", Idade: " + idade);
    System.out.println(", Loja: " + loja);
  }

  public void calculoBonusSalario() {
    double bonusVendedor = salarioBase * 0.2;
    System.out.println("Bonus do Salário do Gerente R$ " + bonusVendedor);
  }

  public void calcularMediaSalario() {
    float totalDoSalario = 0;
    for (int contador = 0; contador < salarioRecebido.length; contador++) { 
      totalDoSalario = totalDoSalario + salarioRecebido[contador]; 
    }
    Float mediaDoSalario = totalDoSalario / 3;
    System.out.println("Média do Salario do Gerente R$ " + mediaDoSalario);
  }
}
