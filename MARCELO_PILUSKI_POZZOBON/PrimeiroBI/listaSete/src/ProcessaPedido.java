package listaSete.src;

public class ProcessaPedido extends Pedido{
    public int valorPago;

    public void processar() {
        if(valorPago >= totalVenda) {
            if(confirmaPagamento()) {
                System.out.println("Pagamento Aceito!");
            } else {
                System.out.println("Pagamento Nagado! Passou da data limite.");
            }
        } else {
            System.out.println("Pagamento Nagado! Valor pago menor que valor da venda!");
        }
    }

    private boolean confirmaPagamento() {
        Long diaAtual = data.getTime();
        if(diaAtual < dataVencimentoReserva) {
            return true;
        } else {
            return false;
        }
    }
}
