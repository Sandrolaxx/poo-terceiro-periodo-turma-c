package PrimeiroB.Ana_Castela;

public class Evento {
    private String nome;
    private String cantor;
    private String tipo;
    private Double valor;

    public Evento(String nome, String cantor, String tipo, Double valor) {
        this.nome = nome;
        this.cantor = cantor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
