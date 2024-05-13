package LUCAS_EDUARDO_DE_LIMA.listas.listasete;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
    long id;
    LocalDate dataCriacao;
    LocalDate dataPagamento;
    LocalDate dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    List<Item> itens;

    public Pedido(long id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data criação: " + dataCriacao + ", Valor total: " + calcularValorTotal());
    }
}
