package primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {

    private Integer sequence = 0;
    
    public Pedido processaPedido(Cliente cliente, Item[] items) {
        Pedido pedido = new Pedido(sequence++, cliente, items);

        return pedido;
    }
    
    public void confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();

        if (dataAtual.getTime() > pedido.getDataVencimentoReserva().getTime()) {
            System.out.println("Não foi possível!");
        
            return;
        }

        pedido.setDataPagamento(new Date());
    }

}
