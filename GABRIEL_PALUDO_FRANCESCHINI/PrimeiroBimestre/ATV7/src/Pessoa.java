package ATV7.src;

public class Pessoa {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Pessoa(String nome, int idade, String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = new Endereco(estado, cidade, bairro, rua, numero, complemento);
    }

    public void apresentarPessoa() {
        System.out.println(this.getNome()
            .concat(", " + this.getIdade() + " anos de idade"));
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}