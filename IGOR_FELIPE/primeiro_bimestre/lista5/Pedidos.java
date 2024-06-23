package primeiro_bimestre.lista5;
import java.util.Date;
import java.util.ArrayList;

public class Pedidos {
    Integer id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    public Pedidos(Integer id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor,Loja loja,ArrayList<Item> item){
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        for(int i = 0;i<itens.size();i++){
            this.itens.add(itens.get(i));
        }
    }

    public float calcularValorTotal(){
        float valorTotal = 0;
        for(int i = 0;i < itens.size();i++){
            valorTotal += itens.get(i).valor;
        }
        System.out.println("O valor total da compra é de:"+valorTotal);
        return valorTotal;
    }

    public void descricaoVenda(){
        System.out.println("Data de criação:"+dataCriacao);
        System.out.println("Valor total:"+calcularValorTotal());
    }
}
