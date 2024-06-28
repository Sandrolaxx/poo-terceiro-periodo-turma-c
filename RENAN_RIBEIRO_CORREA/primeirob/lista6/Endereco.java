public class Endereco {
  String rua;
  String bairro;
  String cidade;
  String estado;
  String numeroCasa;
  String complemento;

  public void apresentarLocalizacao () {
    System.out.println("Eu moro na rua " + rua + ", no bairro " + bairro + ", na cidade de " + cidade + ", no estado de " + estado + ", no número " + numeroCasa + ".");
  }
}
