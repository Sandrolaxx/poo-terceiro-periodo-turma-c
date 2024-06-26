package ATV7.src;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private ArrayList<Item> itens = new ArrayList<>();

    public Pedido(int id, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
        this.dataCriacao = new Date();
        calcularDataVencimentoReserva();
    }

    private void calcularDataVencimentoReserva() {
        long tresDias = 3 * 24 * 60 * 60 * 1000;
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + tresDias);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação do Pedido: " + dataCriacao);
        System.out.println("Valor Total do Pedido: R$" + calcularValorTotal());
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
