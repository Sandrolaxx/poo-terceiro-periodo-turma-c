package lista_02.classes.produto;

public class Produto {
  public String name;
  public int quantidade_vendida;
  public double preco_da_venda;
  public double valor_do_desconto;

  public void setValues(String name, int quantidade_vendida, double preco_da_venda, double valor_do_desconto) {
    this.name = name;
    this.quantidade_vendida = quantidade_vendida;
    this.preco_da_venda = preco_da_venda;
    this.valor_do_desconto = valor_do_desconto;
  }

  @Override
  public String toString() {
    return "Produto: " + this.name + ", Quantidade: " + this.quantidade_vendida +
        ", Preço Unitário: R$ " + String.format(" %.2f", this.preco_da_venda) + ", Desconto: R$ "
        + String.format(" %.2f", this.valor_do_desconto);
  }
}
