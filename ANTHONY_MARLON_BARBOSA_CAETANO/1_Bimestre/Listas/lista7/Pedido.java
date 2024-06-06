import java.util.Date;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataVencimentoReserva;
    private Item[] itens;

    public Pedido(int id, Date dataCriacao, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.itens = itens;

        long tresDias = 3 * 24 * 60 * 60 * 1000L;
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + tresDias);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
}
