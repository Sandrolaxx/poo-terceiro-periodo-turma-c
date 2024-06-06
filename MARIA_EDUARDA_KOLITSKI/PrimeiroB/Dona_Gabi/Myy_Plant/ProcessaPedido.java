package PrimeiroB.Dona_Gabi.Myy_Plant;

import java.util.Date;

public class ProcessaPedido {

    private Integer sequence = 0;

    public Pedido processaPedido(Cliente cliente, Item[] itens, String empresaParceira) {
        Pedido pedido = new Pedido(sequence++, cliente, itens, empresaParceira);
        return pedido;
    }

    public void confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();

        if (dataAtual.getTime() > pedido.getDataVencimentoReserva().getTime()) {
            System.out.println("Não foi possível realizar o pagamento. Pedido expirado.");
            return;
        }

        pedido.setDataPagamento(new Date());
        System.out.println("Pagamento confirmado com sucesso!");
    }
}