package primeiro_bimestre.lista5;
import java.util.Date;
import java.util.ArrayList;

public class ProcessaPedido {
    Integer id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    Long dia = 86400000l;

    public ProcessaPedido(Integer id, String dataCriacao, String dataPagamento, Cliente cliente, Vendedor vendedor, Loja loja, Item item){
        this.id = id;
        this.dataCriacao = new Date(dataCriacao);
        this.dataPagamento = new Date(dataPagamento);
        this.dataVencimentoReserva = new Date(this.dataCriacao.getTime()+(dia*3));
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        for(int i = 0;i<itens.size();i++){
            this.itens.add(itens.get(i));
        }
    }

    public Pedidos processarPedido(ArrayList<Item> teste){
        if(confirmarPagamento()==true){
            System.out.println("Pedido criado com sucesso");
            Pedidos pedido = new Pedidos(this.id,this.dataCriacao,this.dataPagamento,this.dataVencimentoReserva,this.cliente,this.vendedor,this.loja,teste);
            return pedido;
        }else{
            System.out.println("Pedido não criado, pagamento não efetuado");
            return null;
        }
    }

    private Boolean confirmarPagamento(){
        if(dataVencimentoReserva.getTime()>dataPagamento.getTime()){
            return true;
        }else{
            return false;
        }
    }   
    
}

