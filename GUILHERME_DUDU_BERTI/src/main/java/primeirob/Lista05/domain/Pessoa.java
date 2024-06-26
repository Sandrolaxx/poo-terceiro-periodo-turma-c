package primeirob.Lista05.domain;

public abstract class Pessoa {
    String nomePessoa;
    String cidade;
    String bairro;
    String rua;
    Integer idade;

    public Pessoa(String nomePessoa, String cidade, String bairro, String rua, Integer idade) {
        this.nomePessoa = nomePessoa;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.idade = idade;
    }

    // met add
    public abstract String apresentarse();
}
