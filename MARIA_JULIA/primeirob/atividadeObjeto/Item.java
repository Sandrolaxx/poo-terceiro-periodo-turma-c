package primeirob.atividadeObjeto;

// 4. Criar uma classe Item com:
// - Atribuitos id, nome, tipo, valor.
// - Método gerarDescricao, printa o id do item, nome, tipo e valor.
public class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public int getId() {
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

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

}
