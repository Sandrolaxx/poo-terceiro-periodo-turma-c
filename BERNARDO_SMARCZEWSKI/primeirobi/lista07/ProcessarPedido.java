package primeirobi.lista07;

import java.util.Date;

public class ProcessarPedido {

    public void processar(Pedido pedido) {
        pedido.setDataPagamento(new Date());
        if (confirmarPagamento(pedido.getDataCriacao())) {
            System.out.println("Pedido processado com sucesso!");
            pedido.gerarDescricaoVenda();
        } else {
            System.out.println("Erro ao processar o pedido: Reserva vencida.");
        }
    }

    private boolean confirmarPagamento(Date dataCriacao) {
        Date dataAtual = new Date();
        Date dataVencimento = new Date(dataCriacao.getTime() + (3 * 24 * 60 * 60 * 1000));
        return dataAtual.before(dataVencimento);
    }

}