package segunda_versao.model;

import java.time.LocalDate;

public class Pedido {
    private long id;
    private LocalDate dataCriacao;
    private LocalDate dataPagamento;
    private LocalDate dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private Item itens;

    public Pedido(long id, Cliente cliente, Item itemEncontrado) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itemEncontrado;
        this.dataCriacao = LocalDate.now();
        this.dataVencimentoReserva = LocalDate.now().plusDays(3);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimentoReserva() {
        return this.dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(LocalDate dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Item[] getItens() {
        return this.itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public double calcularValorTotal() {
        double total = 0;

        if (itens != null) {
            for (Item item : itens) {
                total += item.getValor();
            }
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Descrição da venda:\n"
                .concat("Data de criação do pedido: ")
                .concat(String.valueOf(dataCriacao))
                .concat("\nValor total: R$ ")
                .concat(String.valueOf(calcularValorTotal())));
    }
}
