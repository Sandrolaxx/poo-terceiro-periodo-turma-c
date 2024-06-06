package segundob.aulas.auladois;

public class Pessoa {

    private String nome;

    

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
