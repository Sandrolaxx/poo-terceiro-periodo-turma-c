package ATV6.src;

import java.util.Date;

public class ProcessaPedido {
    public void processar(Pedido pedido) {
        if (!confirmarPagamento(pedido)) {
            System.out.println("Reserva vencida. Pedido não processado.");
            return;
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        return dataAtual.before(pedido.getDataVencimentoReserva());
    }
}
