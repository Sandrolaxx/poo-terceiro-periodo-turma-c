package segunda_versao.model;

public class Item {
    private long id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(String nome, String tipo, double valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("Descrção do Item:\n"
                .concat("Id: ")
                .concat(String.valueOf(id))
                .concat("\nNome: ")
                .concat(tipo)
                .concat("\nTipo: ")
                .concat(tipo)
                .concat("\nValor: ")
                .concat(String.valueOf(valor)));
    }
}
