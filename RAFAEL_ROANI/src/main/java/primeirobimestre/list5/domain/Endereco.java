package primeirobimestre.list5.domain;

public abstract class Endereco {
    protected String cidade;
    protected String bairro;
    protected String rua;

    protected Endereco(String cidade, String bairro, String rua) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }
}