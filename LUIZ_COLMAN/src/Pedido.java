import java.util.Date;
import java.util.ArrayList;

class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    // Método para calcular o valor total do pedido
    double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.valor;
        }
        return total;
    }

    // Método para gerar descrição da venda
    String gerarDescricaoVenda() {
        return "Pedido criado em " + dataCriacao.toString() + " no valor de R$" + calcularValorTotal();
    }
}
