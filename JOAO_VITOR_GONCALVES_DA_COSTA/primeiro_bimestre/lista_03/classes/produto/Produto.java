package lista_03.classes.produto;

public class Produto {
  public String nome;
  public int quantidade_vendida;
  public double preco_da_venda;
  public double valor_do_desconto;
  public double valor_do_troco;
  public double valor_em_falta;

  public void setValorDoTroco(double valor_do_troco) {
    this.valor_do_troco = valor_do_troco;
  }

  public void setValorEmFalta(double valor_em_falta) {
    this.valor_em_falta = valor_em_falta;
  }

  public void setNome(String name) {
    this.nome = name;
  }

  public void setQuantidadeVendida(int quantidade_vendida) {
    this.quantidade_vendida = quantidade_vendida;
  }

  public void setPrecoDaVenda(double preco_da_venda) {
    this.preco_da_venda = preco_da_venda;
  }

  public void setValorDoDesconto(double valor_do_desconto) {
    this.valor_do_desconto = valor_do_desconto;
  }

  @Override
  public String toString() {
    return "Produto: " + this.nome + ", Quantidade: " + this.quantidade_vendida +
        ", Preço Unitário: R$ " + String.format(" %.2f", this.preco_da_venda) + ", Desconto: R$ "
        + String.format(" %.2f", this.valor_do_desconto) + ", valor do"
        + (valor_em_falta > 0 ? " faltou pagar" : " troco pago") + ": R$ "
        + String.format(" %.2f", this.valor_do_troco);
  }
}
