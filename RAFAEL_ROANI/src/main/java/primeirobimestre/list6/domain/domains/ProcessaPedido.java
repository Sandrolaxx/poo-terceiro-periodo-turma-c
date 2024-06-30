package primeirobimestre.list6.domain.domains;

import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {
    private Long id = 1L;
    private Loja loja;

    public ProcessaPedido(Loja loja) {
        this.loja = loja;
    }

    public Pedido processar(Cliente cliente, Vendedor vendedor, List<ItemCompra> itemCompras) {
        LocalDate dataVenda = LocalDate.now();

        return Pedido.PedidoBuilderLista06.builder()
                .id(id++)
                .cliente(cliente)
                .vendedor(vendedor)
                .loja(loja)
                .dataCriacao(dataVenda)
                .dataPagamento(null)
                .dataVencimentoReserva(dataVenda.plusDays(3))
                .itensCompra(itemCompras)
                .build();
    }

    public void confirmarPagamento(Pedido pedido) {
        if (pedido.getDataPagamento() != null) {
            System.out.println("O pedido ja esta pago!");
        } else if (pedido.getDataPagamento() == null) {
            System.out.println("Pedido ainda não foi pago!");
        } else if (pedido.getDataPagamento() == null && pedido.getDataVencimentoReserva().isAfter(LocalDate.now())) {
            System.out.println("O pagamento do pedido venceu!");
        }
    }

    public void pagarPedido(Pedido pedido) {
        if (LocalDate.now().isBefore(pedido.getDataVencimentoReserva())) {
            pedido.setDataPagamento(LocalDate.now());
            System.out.println("Sucesso! Pedido pago.");
        } else {
            System.out.println("Ops! Seu pedido ja venceu o pagamento.");
        }
    }
}