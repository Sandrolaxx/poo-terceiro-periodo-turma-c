package lista5;

import java.time.LocalDate;

public class ProcessaPedido {
    
    // Método para processar o pedido
    public void processar(int idPedido, LocalDate dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        Pedido pedido = new Pedido(idPedido, dataCriacao, cliente, vendedor, loja, itens);
        if (confirmarPagamento(pedido)) {
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Não foi possível processar o pedido. A reserva está vencida.");
        }
    }

    // Método privado para confirmar o pagamento
    private boolean confirmarPagamento(Pedido pedido) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isAfter(pedido.getDataVencimentoReserva())) {
            return false; // Reserva vencida
        } else {
            // Simulação de confirmação do pagamento
            // Neste exemplo, a reserva é confirmada se a data atual não for superior à data de vencimento da reserva
            // Aqui você pode adicionar lógica para processar a confirmação de pagamento com outros sistemas ou serviços externos
            return true;
        }
    }
}
