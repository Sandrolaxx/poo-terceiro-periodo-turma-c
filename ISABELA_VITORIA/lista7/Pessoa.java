package lista7;

public class Pessoa {
  private String nomeCompleto;
  private Integer idadePessoa;
  private Endereco enderecoResidencial;

  public Pessoa() {}

  public Pessoa(String nomeCompleto, Integer idadePessoa, Endereco enderecoResidencial) {
    this.nomeCompleto = nomeCompleto;
    this.idadePessoa = idadePessoa;
    this.enderecoResidencial = enderecoResidencial;
  }
  public void apresentarPessoa() {
    System.out.println("Me chamo " + nomeCompleto + ", tenho " + idadePessoa + " anos.");
  }

  public String getNomeCompleto() {return nomeCompleto;}

  public Integer getIdadePessoa() {return idadePessoa;}

  public Endereco getEnderecoResidencial() {
    return enderecoResidencial;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public void setIdadePessoa(Integer idadePessoa) {
    this.idadePessoa = idadePessoa;
  }

  public void setEnderecoResidencial(Endereco enderecoResidencial) {
    this.enderecoResidencial = enderecoResidencial;
  }
}
