package primeirob.Lista07.domain;

public abstract class Pessoa {
    protected String nomePessoa;
    protected Integer idade;
    protected Endereco endereco;

    protected Pessoa(String nomePessoa, Integer idade, Endereco endereco) {
        this.nomePessoa = nomePessoa;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public abstract String apresentarse();
}
