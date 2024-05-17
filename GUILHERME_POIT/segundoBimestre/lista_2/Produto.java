package segundoBimestre.lista_2;

public class Produto {

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    private String nome;

    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return ("nome: " + nome +  " = " +  " preco: " + preco);
    }
}
