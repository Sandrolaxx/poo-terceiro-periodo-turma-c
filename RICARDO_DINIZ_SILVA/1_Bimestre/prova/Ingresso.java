package RICARDO_DINIZ_SILVA.prova;

public class Ingresso {

    private String nome;
    private String tipo;
    private Float valor;

    public Ingresso(Integer id, String nome, String tipo, Float valor) {

        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Ingresso(String nome, String tipo, Float valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("Nome: " + nome + ", Data: " + tipo + ", Valor: " + valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
