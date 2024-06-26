public class Item {
  int id;
  String nome;
  String tipo;
  float preco;

  public void gerarDescricao  () {
    System.out.println("ID: " + id);
    System.out.println(", Nome: " + nome);
    System.out.println(", Tipo: " + tipo);
    System.out.println(", Preço: " + preco);
  }
}
