package lista05;

public class Cliente extends Pessoa {
  public void apresentarse() {
    String msg = "Olá, meu nome é ".concat(nome)
    .concat(", Tenho ").concat(idade.toString()).concat(" Anos ");
    System.out.println(msg);
  }
}