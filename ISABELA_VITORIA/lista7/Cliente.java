package lista7;

public class Cliente extends Pessoa {

  public Cliente(String nomeCompleto, Integer idadePessoa, Endereco enderecoResidencial) {
    super(nomeCompleto, idadePessoa, enderecoResidencial);
  }


  public void apresentarse() {
    String msg = "Olá, meu nome é " + getNomeCompleto() + ", Tenho " + getIdadePessoa() + " Anos.";
    System.out.println(msg);
  }

  public String getNome() {
    return super.getNomeCompleto();
  }
}
