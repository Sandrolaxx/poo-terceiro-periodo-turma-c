package PrimeiroB.Dona_Gabi.Myy_Plant;

import java.util.Date;

public class Pedido {
    private Integer id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Item[] itens;
    private String empresaParceira; // Adicionando atributo para armazenar o nome da empresa parceira

    public Pedido(Integer id, Cliente cliente, Item[] itens, String empresaParceira) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.dataCriacao = new Date();
        this.empresaParceira = empresaParceira;

        // Definindo a data de vencimento da reserva baseada na data de criação do pedido
        Long diaMs = 86400000L; // Milissegundos em um dia
        Long msAgora = this.dataCriacao.getTime();
        Long msDaquiTresDias = msAgora + (3 * diaMs);
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

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public String getEmpresaParceira() {
        return empresaParceira;
    }

    public void setEmpresaParceira(String empresaParceira) {
        this.empresaParceira = empresaParceira;
    }

    public Double calcularValorTotal() {
        Double total = 0d;

        for (Item item : itens) {
            total += item.getValor();
        }

        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Valor Total: " + calcularValorTotal());
    }
}
