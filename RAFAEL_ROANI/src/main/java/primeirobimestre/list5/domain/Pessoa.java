package primeirobimestre.list5.domain;

public abstract class Pessoa extends Endereco {
    protected String nome;
    protected Integer idade;

    protected Pessoa(String nome, Integer idade, String cidade, String bairro, String rua) {
        super(cidade, bairro, rua);
        this.nome = nome;
        this.idade = idade;
    }

    public abstract void apresentarse();

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
}