package CLARA_LIOTTO.Lista5;

import java.util.ArrayList;

public class ProcessarPedido {
    private static int proximoIdPedido = 1; 

    public static Pedido criarNovoPedido(Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        Pedido novoPedido = new Pedido(proximoIdPedido, cliente, vendedor, loja, itens);
        proximoIdPedido++; 
        return novoPedido;
    }

    public void processar(Pedido pedido) {
        if (confirmarPagamento(pedido)) {
            System.out.println("Pagamento confirmado e pedido processado.");
            
        } else {
            System.out.println("Não foi possível processar o pedido.");
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        
        return true; 
    }
}