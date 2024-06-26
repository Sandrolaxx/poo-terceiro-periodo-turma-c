package ANTHONY_MARLON_BARBOSA_CAETANO.prova;

public class Evento {
    private String nome;
    private String data;
    private double preco;
    
    public Evento(String nome, String data, double preco) {
        this.nome = nome;
        this.data = data;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
