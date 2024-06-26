package segunda_versao.model;

import java.time.LocalDate;

public class ProcessaPedido {

    public static int id = 0;

    public Pedido processar(Cliente cliente, Item[] itens) {
        Pedido pedido = new Pedido(id++, cliente, itens);

        return pedido;
    }

    public static boolean confirmarPagamento(Pedido pedido) {
        if (pedido.getDataVencimentoReserva() != null && pedido.getDataVencimentoReserva().isBefore(LocalDate.now())) {
            return false;
        }

        pedido.setDataPagamento(LocalDate.now());
        return true;
    }
}
