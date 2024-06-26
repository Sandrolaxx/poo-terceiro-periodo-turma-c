import java.util.Date;

public class Pedido {

    private int id;

    private Date dataCriacao;

    private Date dataPagamento;

    private Date dataVencimentoReserva;

    private Cliente cliente;

    private Vendedor vendedor;

    private Loja loja;

    private Item[] itens;

    public Pedido() {
        Long umDia = 86400000l;
        Long criacaoPedido = new Date().getTime();
        Long vencimentoReserva = criacaoPedido + (umDia * 3);

        this.dataCriacao = new Date();
        this.dataVencimentoReserva = new Date(vencimentoReserva);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Loja getLoja() {
        return loja;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void calcularValorTotal() {
        double valorTotal = 0;

        for (int i = 0; i < itens.length; i++) {
            valorTotal += itens[i].getValor();
        }
        System.out.println("O valor total da venda é: " + valorTotal);
    }

    public void gerarDescricaoVenda() {
        calcularValorTotal();
        System.out.println("A data de criação do seu pedido é: " + getDataCriacao());
    }
}
