public class Cliente extends Endereco{
  String nomeCliente;
  Integer idadeCliente;

  public void apresentacao() {
    System.out.println("Meu nome é " + nomeCliente + ", tenho " + idadeCliente + " anos, moro na cidade de " + cidade + ".");
  }
}
