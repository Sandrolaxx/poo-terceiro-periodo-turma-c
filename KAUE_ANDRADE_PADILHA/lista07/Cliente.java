package lista07;

public class Cliente extends Pessoa {

  public Cliente(String nome, Integer idade, Endereco endereco) {
    super(nome, idade, endereco);
  }

  @Override
  public void apresentarse() {
    String msg = "Olá, meu nome é " + getNome() + ", Tenho " + getIdade() + " Anos.";
    System.out.println(msg);
  }
}
