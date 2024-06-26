package MARIA_JULIA.prova;

public class PessoaProva {
    private String nome;
    private int idade;
    private String endereco;
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    public String getEndereco() {
        return endereco;
    }


    



    public void apresentarse() {
        System.out.println("Pessoa [nome=" + getNome() + ", idade=" + getIdade() + ", endereco=" + getEndereco() + "]");
    }

    public PessoaProva(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;


    }
}
