package primeirobimetre.lista_1.lista_3;

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double valorTotal;
    private double desconto;


    public Venda(int quantidade, double precoUnitario) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = quantidade * precoUnitario;
        this.desconto = calcularDesconto();
    }


    private double calcularDesconto() {
        if (quantidade > 10) {
            return 0.05 * valorTotal;
        } else {
            return 0;
        }
    }


    public double obterValorTotalComDesconto() {
        return valorTotal - desconto;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }
}