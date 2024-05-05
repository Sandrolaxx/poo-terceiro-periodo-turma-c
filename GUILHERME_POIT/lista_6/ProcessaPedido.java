package lista_6;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {
    Loja loja;
    private int proximoIdPedido = 0;
    private static final long DIA = 86400000;

    public ProcessaPedido(Loja loja) {
        this.loja = loja;
    }

    public Pedido processar(Cliente cliente, Vendedor vendedor, List<Item> itens) {
        Date dataAtual = new Date();
        long tempoEmMs = dataAtual.getTime() + DIA;
        Date dataVencimento = new Date(tempoEmMs);

        return new Pedido(proximoIdPedido++, dataAtual,  dataVencimento, cliente, vendedor, loja, itens);
    }

    public void comfirmaPagamento(Pedido pedido) {
        if (pedido.getDataPagamento() != null) {
            System.out.println("O pedido ja esta pago!");
            return;
        } else if (new Date().getTime() > pedido.getDataVencimentoReserva().getTime()) {
            System.out.println("Não foi posivel pagar, o pagamento ja venceu!");
            return;
        }
        pedido.setDataPagamento(new Date());
        System.out.println("Sucesso Pedido pago! valor R$ " + pedido.calcularValorTotal());
    }
}
