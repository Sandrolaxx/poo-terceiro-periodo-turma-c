package primeirobimetre.lista_1.lista_6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens = new ArrayList<>();

    public Pedido(int id, Date dataCriacao, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens.addAll(itens);
    }

    public double calcularValorTotal() {
        double soma = 0;
        for (Item item : itens) {
            soma += item.getValor();
        }
        return soma;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data Criação: " + dataCriacao);
        System.out.println("Valor Total: R$ " + calcularValorTotal());
    }

    public void cadastrarItem(Item item) {
        itens.add(item);
    }

    public void cadastrarListItem(List<Item> item) {
        itens.addAll(item);
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
