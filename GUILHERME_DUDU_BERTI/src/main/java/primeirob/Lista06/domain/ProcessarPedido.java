package primeirob.Lista06.domain;

import java.time.LocalDate;
import java.util.List;

public class ProcessarPedido {
    private Long proximoIdPedido = 1L;
    private Pedido pedido;

    public Pedido processar(Cliente cliente, Vendedor vendedor, Loja loja, LocalDate dataCriacao, List<Item> itens) {

        Pedido pedido = Pedido.PedidoBuilder.builder()
                .id(proximoIdPedido++)
                .cliente(cliente)
                .vendedor(vendedor)
                .loja(loja)
                .dataCriacao(dataCriacao)
                .itens(itens)
                .build();

        processar(pedido);
        return pedido;
    }

    public void processar(Pedido pedido) {
        this.pedido = pedido;
        if (pedido == null) {
            System.out.println("Pedido inválido. Não é possível processar.");
            return;
        }

        LocalDate dataAtual = LocalDate.now();

        if (verificarPagamento()) {
            System.out.println("Pedido processado com sucesso!");
            System.out.println(pedido.gerarDescricaoVenda());
        } else {
            System.out.println("\nNão foi possível processar o pedido. A reserva está vencida.\n");
        }
    }

    private boolean verificarPagamento() {
        return !pedido.getDataCriacao().isAfter(pedido.getDataPagamento()) &&
                !pedido.getDataPagamento().isAfter(pedido.getDataVencimentoReserva());
    }
}
