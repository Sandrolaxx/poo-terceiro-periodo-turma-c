package primeiro_bimestre.lista1;

public class Vendas{
    private int qtd;
    private float valor;
    private float desconto;

    public Vendas(int qtd, float valor, float desconto){
        this.qtd = qtd;
        this.valor = valor;
        this.desconto = desconto;
    }

    public int getQtd(){
        return qtd;
    }
    public float getValor(){
        return valor;
    }
    public float getDesconto(){
        return desconto;
    }
}


