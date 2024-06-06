package prova.classes.endereco;

public class Endereco {
  public String rua;
  public String estado;
  public String cidade;
  public String bairro;
  public String numero;

  public Endereco(String rua, String estado, String cidade, String bairro, String numero) {
    this.rua = rua;
    this.estado = estado;
    this.cidade = cidade;
    this.bairro = bairro;
    this.numero = numero;
  }

  public void apresentarLogradouro() {
    System.out.println(
        this.getRua()
            .concat(" " + this.getNumero())
            .concat(" - " + getBairro())
            .concat(" - ")
            + getCidade()
                .concat(", " + getEstado()));
  }

  public String getRua() {
    return rua;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public String getEstado() {
    return estado;
  }

  public String getNumero() {
    return numero;
  }

}
