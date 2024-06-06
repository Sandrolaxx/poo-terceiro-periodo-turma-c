package segundob.aulas.aulaum.revisaoprova;

import java.util.Date;

public class Ingresso {
    
    private Integer id;

    private Cliente cliente;

    private Evento evento;

    private String descricao;

    private Integer diasUtilizacao;

    private Date dataUtilizacao;

    private Double valorTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDiasUtilizacao() {
        return diasUtilizacao;
    }

    public void setDiasUtilizacao(Integer diasUtilizacao) {
        this.diasUtilizacao = diasUtilizacao;
    }

    public Date getDataUtilizacao() {
        return dataUtilizacao;
    }

    public void setDataUtilizacao(Date dataUtilizacao) {
        this.dataUtilizacao = dataUtilizacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
