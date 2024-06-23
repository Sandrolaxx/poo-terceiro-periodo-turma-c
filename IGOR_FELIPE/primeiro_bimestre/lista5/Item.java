package primeiro_bimestre.lista5;

public class Item {
    public Integer id;
    public String nome;
    public String tipo;
    public float valor;

    public Item(Integer id,String nome, String tipo, float valor){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao(){
        System.out.println("Id: "+id+"\nNome: "+nome+"\nTipo: "+tipo+"\nValor: "+valor);
    }
}
