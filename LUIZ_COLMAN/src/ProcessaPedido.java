import java.util.Date;

class ProcessaPedido {
    // Método para processar o pedido
    void processar(int idPedido, Date dataCriacao, Date dataPagamento, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        Pedido pedido = new Pedido();
        pedido.id = idPedido;
        pedido.dataCriacao = dataCriacao;
        pedido.dataPagamento = dataPagamento;
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.loja = loja;
        pedido.itens = itens;

        if (confirmarPagamento(pedido.dataCriacao, pedido.dataVencimentoReserva)) {
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Falha ao processar pedido: reserva vencida.");
        }
    }

    private boolean confirmarPagamento(Date dataCriacao, Date dataVencimentoReserva) {
        Date dataAtual = new Date();
        return dataAtual.before(dataVencimentoReserva);
    }
}
