package lista05;

public class Item {
  Integer id;
  String nome;
  String tipo;
  Float valor;

  public void gerarDescricao() {
    String msg = "ID: ".concat(id.toString())
    .concat(", Nome: ").concat(nome)
    .concat(", Tipo: ").concat(tipo)
    .concat(", Valor: ").concat(valor.toString());
    System.out.println(msg);
  }
}
