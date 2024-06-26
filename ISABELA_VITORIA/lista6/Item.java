package lista6;

public class Item {
    int id;
    String nome;
    String tipo;
    float valor;

    public void gerarDescricao(){
        String mensagem = "ID: " + id + "Nome: " + nome + " ,Tipo: " + tipo + " ,Valor: " + valor;
        System.out.println(mensagem);
    }
}
