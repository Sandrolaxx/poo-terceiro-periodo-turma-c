package LUCAS_EDUARDO_DE_LIMA.listas.listasete;


public class Item {
    long id;
    String nome;
    String tipo;
    double valor;

    public Item(long id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void gerarDescricao(){
        System.out.println("Id: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor);
    }
}

