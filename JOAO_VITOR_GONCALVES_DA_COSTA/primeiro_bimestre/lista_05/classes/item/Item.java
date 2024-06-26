package lista_05.classes.item;

public class Item {
  private int id;
  private String nome;
  private String tipo;
  private double valor;

  public Item(int id, String nome, String tipo, double valor) {
    this.tipo = tipo;
    this.id = id;
    this.nome = nome;
    this.valor = valor;
  }

  public void gerarDescricao() {
    System.out.println(" Descrição do produto: \n"
        .concat("Nome: " + this.getNome())
        .concat(" - Id: " + this.getId())
        .concat(" - Tipo: " + this.getTipo())
        .concat(" - Valor: " + this.getValor()));
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getTipo() {
    return tipo;
  }

  public double getValor() {
    return valor;
  }

}
