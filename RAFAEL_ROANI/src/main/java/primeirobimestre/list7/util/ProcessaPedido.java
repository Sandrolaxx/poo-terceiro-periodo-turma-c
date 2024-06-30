package primeirobimestre.list7.util;

import primeirobimestre.list7.domain.domains.*;

import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {
    private Long id = 0L;
    private Loja loja;

    public ProcessaPedido(Loja loja) {
        this.loja = loja;
    }

    public Pedido processar(Cliente cliente, Vendedor vendedor, List<ItemCompra> itemCompras, String lojaPerceira) {
        LocalDate dataVenda = LocalDate.now();

        Pedido pedido = Pedido.PedidoBuilderLista07.builder()
                .id(id++)
                .cliente(cliente)
                .vendedor(vendedor)
                .loja(loja)
                .lojaParceira(lojaPerceira)
                .dataCriacao(dataVenda)
                .dataPagamento(null)
                .dataVencimentoReserva(dataVenda.plusDays(3))
                .itensCompra(itemCompras)
                .build();

        printFinalPedido(pedido);
        return pedido;
    }

    private void printFinalPedido(Pedido pedido) {
        System.out.println("==== Pedido Finalizado com Sucesso! ====");
        System.out.println("Data da criação: " + pedido.getDataCriacao());
        System.out.println("Quantidade de itens: " + pedido.quantidadeItens());
        System.out.println("Total: " + CurrencyFormat07.format(pedido.calcularValorTotal()));
        System.out.println("======= ======== =======");
    }

    public void confirmarPagamento(Pedido pedido) {
        if (pedido.getDataPagamento() != null) {
            System.out.println("O pedido ja esta pago!");
        } else if (pedido.getDataPagamento() == null && pedido.getDataVencimentoReserva().isAfter(LocalDate.now())) {
            System.out.println("O pagamento do pedido venceu!");
        } else if (pedido.getDataPagamento() == null) {
            System.out.println("Pedido ainda não foi pago!");
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