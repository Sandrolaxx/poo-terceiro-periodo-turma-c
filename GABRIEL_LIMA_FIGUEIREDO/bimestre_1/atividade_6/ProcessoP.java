package bimestre_1.atividade_6;

import java.util.Date;

public class ProcessoP {

    public void processar(int idPedido, Date dataCriacao, String cliente, String vendedor, String loja, Item[] itens) {
        Pedido pedido = new Pedido(idPedido, dataCriacao, cliente, vendedor, loja, itens);
        confirmarPagamento(pedido);
    }

    private void confirmarPagamento(Pedido pedido) {
        if (pedido.getpayDate() > pedido.getDataReserv()) {
            System.out.println("Pagamento confirmado para o pedido " + pedido.getId());
        } else {
            System.out.println("A reserva para o pedido " + pedido.getId() + " está vencida.");
        }
    }

  
    public static void main(String[] args) {
    
        Item item1 = new Item(1, "Produto 1", "Eletrônico", 1000);
        Item item2 = new Item(2, "Produto 2", "Moda", 50);

        
        Item[] itens = {item1, item2};

      
        ProcessoP processador = new ProcessoP();

        
        Date dataCriacao = new Date(System.currentTimeMillis() - 3 * 24 * 60 * 60 * 1000);
        processador.processar(1, dataCriacao, "Cliente", "Vendedor", "Loja", itens);

       
        Date dataAtual = new Date();
        processador.processar(2, dataAtual, "Cliente", "Vendedor", "Loja", itens);
    }
}
