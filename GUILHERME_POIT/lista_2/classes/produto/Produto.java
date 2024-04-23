package lista_2.classes.produto;

public class Produto {
    public String name;
    public int quantidadeVendida;
    public double precoVenda;
    public double valorDesconto;

    public void setValues(String name, int quantidadeVendida, double precoVenda, double valorDesconto) {
        this.name = name;
        this.quantidadeVendida = quantidadeVendida;
        this.precoVenda = precoVenda;
        this.valorDesconto = valorDesconto;
    }

    @Override
    public String toString() {
        return "Produto: " + this.name + ", Quantidade: " + this.quantidadeVendida +
                ", Preço Unitário: R$ " + String.format(" %.2f", this.precoVenda) + ", Desconto: R$ "
                + String.format(" %.2f", this.valorDesconto);
    }
}
