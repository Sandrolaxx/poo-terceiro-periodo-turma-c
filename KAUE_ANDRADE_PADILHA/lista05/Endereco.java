package lista05;

// Estou usando uma classe Pessoa que já contem cidade, bairro e rua
// então nesse caso estou criando a classe Endereço apenas porque o execicio pede

public class Endereco {
  String estado;
  String cidade;
  String bairro;
  String rua;
  Integer numero;
  String complemento;

  public void apresentarLogradouro() {
    String msg = "Endereço: ".concat(rua)
    .concat(", Número: ").concat(numero.toString())
    .concat(", Complemento: ").concat(complemento)
    .concat(", Bairro: ").concat(bairro)
    .concat(", Cidade: ").concat(cidade)
    .concat(", Estado: ").concat(estado);
    System.out.println(msg);
  }
}