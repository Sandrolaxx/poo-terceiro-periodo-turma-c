
public class Vendedor extends Endereco {
  String nomeVendedor;
  Integer idadeVendedor;
  Loja loja = new Loja();
  Float salarioBaseVendedor;
  Float[] salarioRecebidoVendedor = new Float[3];

  public void calculoBonusSalario() {
    double bonusVendedor = salarioBaseVendedor * 0.2;
    System.out.println("Bonus do Salário R$ " + bonusVendedor);
  }
  public void calcularMediaSalario() {
    float totalDoSalario = 0;
    for (int contador = 0; contador < salarioRecebidoVendedor.length; contador++) { 
      totalDoSalario = totalDoSalario + salarioRecebidoVendedor[contador]; 
    }
    Float mediaDoSalario = totalDoSalario / 3;
    System.out.println("Média do Salario do Vendedor R$ " + mediaDoSalario);
  }
  public void apresentacao() {
    System.out.println("Meu nome é " + nomeVendedor + ", tenho " + idadeVendedor + " anos, estou trabalhando na loja " + loja.nomeDaLoja);
  }
}
