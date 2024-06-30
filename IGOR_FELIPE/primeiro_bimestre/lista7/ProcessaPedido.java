package primeiro_bimestre.lista7;
import java.util.Date;
import java.util.ArrayList;


public class ProcessaPedido {
    public Pedidos processaPedido(ArrayList<Pedidos>allPedidos, Cliente cliente, ArrayList<Item> itens){
        Pedidos pedido = new Pedidos(allPedidos.size()+1,cliente,itens);

        return pedido;
    }

    public void confirmarPagamento(Pedidos pedido){
        Date dataAtual = new Date();

        if(dataAtual.getTime()>pedido.getDataVencimentoReserva().getTime()){
            System.out.println("Não foi possível confirmar o pagamento");
            
            return;
        }
        System.out.println("Pedido confirmado com sucesso");
        pedido.setDataPagamento(new Date());
    }
}
