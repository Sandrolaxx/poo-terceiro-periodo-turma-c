public class Item {
    private int id;

    private String nome;

    private double valor;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID do item:" + getId());
        System.out.println("Nome do item: " + getNome());
        System.out.println("Valor do item: " + getValor());
    }
}
