package bimestre_1.atividade_6;

import java.util.Date;

public class Pedido {
    private int ident;
    private Date dataCriacao;
    private Date payDate;
    private Date dataReserv;
    private String client;
    private String vendedor;
    private String store;
    private Item[] itens;

    public Pedido(int ident, Date dataCriacao, String client, String vendedor, String store, Item[] itens) {
        this.ident = ident;
        this.dataCriacao = dataCriacao;
        this.client = client;
        this.vendedor = vendedor;
        this.store = store;
        this.itens = itens;
        dataReserv = calcularDataVencimentoReserva();
    }
    private Date calcularDataVencimentoReserva() {
      long tresDias = 3 * 24 * 60 * 60 * 1000; 
      return new Date(dataCriacao.getTime() + tresDias);
  }
    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValue();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de criação do pedido: " + dataCriacao);
        System.out.println("Valor total do pedido: " + calcularValorTotal());
    }

    private void calculardataReserv() {
        long tresDias = 3 * 24 * 60 * 60 * 1000; 
        dataReserv = new Date(dataCriacao.getTime() + tresDias);
    }
    public int getId() {
        return ident;
    }

    public void setId(int ident) {
        this.ident = ident;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        calculardataReserv();
    }

    public Long getpayDate() {
        return payDate.getTime();
    }

    public void setpayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getclient() {
        return client;
    }

    public void setclient(String client) {
        this.client = client;
    }

    public String getvendedor() {
        return vendedor;
    }

    public void setvendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getstore() {
        return store;
    }

    public void setstore(String store) {
        this.store = store;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public Long getDataReserv(){
   
      return dataReserv.getTime();


    }
}
