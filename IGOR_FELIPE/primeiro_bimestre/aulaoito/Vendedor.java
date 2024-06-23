package primeiro_bimestre.aulaoito;

public class Vendedor {
    private String nome;

    private Integer idade;

    public Vendedor(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }


    
}
