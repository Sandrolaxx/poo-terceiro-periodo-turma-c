package LUCAS_EDUARDO_DE_LIMA.listas.listasete;

import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {
    static int id = 1;
    Loja loja;
    ProcessaPedido(Loja loja) {
        this.loja = loja;
    }

    public Pedido processar(Vendedor vendedor, Cliente cliente, List<Item> items) {
        LocalDate dataAtual = LocalDate.now();
        return new Pedido(id++, dataAtual, null, dataAtual.plusDays(3), cliente, vendedor, loja, items);
    }

    public void confirmarPagamento(Pedido pedido) {
        if (LocalDate.now().isBefore(pedido.dataVencimentoReserva)) {
            pedido.dataPagamento = LocalDate.now();
            System.out.println("Pedido pago com sucesso");
        } else {
            System.out.println("Pedido ja venceu o pagamento.");
        }
    }
}

