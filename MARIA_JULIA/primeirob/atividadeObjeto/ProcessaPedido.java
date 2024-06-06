package primeirob.atividadeObjeto;
// 6. Criar uma classe ProcessaPedido com:
// - Método processar, que recebe os dados necessários para criação do pedido.
// - Método privado confirmarPagamento(confirma caso a reserva não esteja vencida, verificar se data atual não é superior a dataVencimentoReserva).
// - Criar teste para verificar método.


public class ProcessaPedido {

    public void processar(Pedido pedido) {
        pedido.gerarDescricaoVenda();
        confirmarPagamento(pedido);
    }

    private void confirmarPagamento(Pedido pedido) {
        if (Util.isDataMaior(pedido.getDataPagamento(), pedido.getDataVencimentoReserva() )) {
            System.out.println("Confirmado");
        } else {
            System.out.println("Recusado");
        }
    }
}
