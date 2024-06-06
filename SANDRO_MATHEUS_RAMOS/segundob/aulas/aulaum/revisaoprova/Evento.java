package segundob.aulas.aulaum.revisaoprova;

import java.util.Date;

public class Evento {
    
    private Integer id;

    private String descricao;

    private String endereco;

    private Integer maxClientes;

    private Double vlrDiarioIngresso;

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

    public Integer getMaxClientes() {
        return maxClientes;
    }

    public void setMaxClientes(Integer maxClientes) {
        this.maxClientes = maxClientes;
    }

    public Double getVlrDiarioIngresso() {
        return vlrDiarioIngresso;
    }

    public void setVlrDiarioIngresso(Double vlrDiarioIngresso) {
        this.vlrDiarioIngresso = vlrDiarioIngresso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

}
