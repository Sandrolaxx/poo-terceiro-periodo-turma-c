package primeirob.listas.listaseis;

import java.util.Date;

public class Pedido {
    
    private Integer id;

    private Date dataCriacao;
    
    private Date dataPagamento;

    private Date dataVencimentoReserva;

    private Cliente cliente;

    private Item[] items;

    public Pedido(Integer id, Cliente cliente, Item[] items) {
        Long diaMs = 86400000l;
        Long msAgora = new Date().getTime();
        Long msDaquiTresDias = msAgora + (3 * diaMs);

        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.dataCriacao = new Date();
        this.dataVencimentoReserva = new Date(msDaquiTresDias);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Double calcularValorTotal() {
        Double total = 0d;
        
        for (int i = 0; i < items.length; i++) {
            total += items[i].getValor();
        }

        return total;
    }

}
