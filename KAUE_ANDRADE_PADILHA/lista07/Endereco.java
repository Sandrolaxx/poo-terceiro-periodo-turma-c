package lista07;

public class Endereco {
  private String estado;
  private String cidade;
  private String bairro;
  private String rua;
  private Integer numero;
  private String complemento;

  public Endereco(String estado, String cidade, String bairro, String rua, Integer numero, String complemento) {
    this.estado = estado;
    this.cidade = cidade;
    this.bairro = bairro;
    this.rua = rua;
    this.numero = numero;
    this.complemento = complemento;
  }

  public void apresentarLogradouro() {
    String msg = "Endereço: " + rua + ", Número: " + numero + ", Complemento: " + complemento + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado;
    System.out.println(msg);
  }

  public String getEstado() {
    return estado;
  }

  public String getCidade() {
    return cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public String getRua() {
    return rua;
  }

  public Integer getNumero() {
    return numero;
  }

  public String getComplemento() {
    return complemento;
  }
}
