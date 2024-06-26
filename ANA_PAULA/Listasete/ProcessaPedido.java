package Listasete;

import java.util.Date;

public class ProcessaPedido {
    public void processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, String loja, Item itemEscolhido){
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setDataCriacao(dataCriacao);
        pedido.setDataPagamento(dataPagamento);
        pedido.setDataVencimentoReserva(dataVencimentoReserva);
        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        pedido.setLoja(loja);
        pedido.setItens(new Item[]{itemEscolhido});

        if(confirmarPagamento(pedido.getDataVencimentoReserva())){
            System.out.println("Pedido processado com sucesso.");
        } else {
            System.out.println("Falha ao processar pedido: reserva vencida.");
        }
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva){
        Date dataAtual = new Date();
        return dataAtual.before(dataVencimentoReserva);
    }
}
