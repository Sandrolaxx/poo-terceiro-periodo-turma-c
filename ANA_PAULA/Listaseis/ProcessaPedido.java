package Listaseis;
import java.util.Date;

public class ProcessaPedido {
    public void processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, String loja, Item[] itens){
        Pedido pedido = new Pedido();
        pedido.id = id;
        pedido.dataCriacao = dataCriacao;
        pedido.dataPagamento = dataPagamento;
        pedido.dataVencimentoReserva = dataVencimentoReserva;
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.loja = loja;
        pedido.itens = itens;

        if(confirmarPagamento(pedido.dataVencimentoReserva)){
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
