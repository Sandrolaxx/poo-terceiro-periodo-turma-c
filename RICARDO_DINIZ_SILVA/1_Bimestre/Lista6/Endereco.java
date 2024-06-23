package RICARDO_DINIZ_SILVA.Lista6;

public class Endereco {
  public String estado;
  public String cidade;
  public String bairro;
  public String rua;
  public int numero;
  public String complemento;

  public void apresentarLogradouro() {
    System.out.println("Localizado na Rua: ".concat(rua).concat(", N° ").concat(String.valueOf(numero)).concat(", Complemento: ").concat(complemento).concat(", no bairro ").concat(bairro).concat(" da cidade de ").concat(cidade).concat(" no estado do ").concat(estado));
  }
}
