import java.util.Date;

public class ProcessaPedido {
    public void processar(Pedido pedido) {
        if (confirmarPagamento(pedido)) {
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Falha ao processar pedido: reserva vencida.");
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        return !dataAtual.after(pedido.getDataVencimentoReserva());
    }
}
