package listaSeis.src;

public class Item {
    public int id;
    public String nome;
    public String tipo;
    public int valor;

    public void gerarDescricao() {
        System.out.println("Id: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\nValor: " + valor);
    }
}
