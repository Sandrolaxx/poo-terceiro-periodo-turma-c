package primeiro_bimestre.lista7;

public class Item {
    private Integer id;
    private String nome;
    private String tipo;
    private Float valor;

    public Item(Integer id, String nome, String tipo, Float valor){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
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
    
    public void gerarDescricao(){
        System.out.println("Id: "+getId()+"\nNome: "+getNome()+"\nTipo: "+getTipo()+"\nValor: "+getValor());
    }
}
