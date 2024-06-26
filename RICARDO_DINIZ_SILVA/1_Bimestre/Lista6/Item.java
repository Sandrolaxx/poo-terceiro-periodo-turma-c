package RICARDO_DINIZ_SILVA.Lista6;

public class Item {
  int id;
  String nome;
  String tipo;
  double valor;

  public Item(int id, String nome, String tipo, double valor) {
    this.id = id;
    this.nome = nome;
    this.tipo = tipo;
    this.valor = valor;
  }

  public void gerarDescricao() {
    System.out.println("ID: ".concat(String.valueOf(id)).concat(", Nome: ").concat(nome).concat(", Tipo: ").concat(tipo).concat(", Valor: ").concat(String.valueOf(valor)));
  }
}
