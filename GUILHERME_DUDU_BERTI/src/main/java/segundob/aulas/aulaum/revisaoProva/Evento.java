package segundob.aulas.aulaum.revisaoProva;

import java.util.Date;

public class Evento {

    private Integer id;

    private String descricao;

    private String endereco;

    private Integer clienteMax;

    private Integer clientes;

    private Double valorDiarioIngresso;

    private Date dataInicio;

    private Date dataFim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getClienteMax() {
        return clienteMax;
    }

    public void setClienteMax(Integer clienteMax) {
        this.clienteMax = clienteMax;
    }

    public Integer getClientes() {
        return clientes;
    }

    public void setClientes(Integer clientes) {
        this.clientes = clientes;
    }

    public Double getValorDiarioIngresso() {
        return valorDiarioIngresso;
    }

    public void setValorDiarioIngresso(Double valorDiarioIngresso) {
        this.valorDiarioIngresso = valorDiarioIngresso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date date) {
        this.dataInicio = date;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

}
