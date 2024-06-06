package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

import java.util.Date;
import java.util.Scanner;

public class ProcessaPedido extends Pedido {

    Date dataAtual = new Date();

    

    
    
    public ProcessaPedido(double[] itens, String id, String nome, String tipo, Double valor, String[] itenss,
            Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, String cliente, String loja,
            String vendedor, Date dataAtual) {
        super(itens, id, nome, tipo, valor, itenss, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, loja,
                vendedor);
        this.dataAtual = dataAtual;
    }
    void processar() {
        System.out.print("valor: " + String.valueOf(getValor()) + ", data de criacao: " + String.valueOf(getDataCriacao()) + ", item: " + String.valueOf(getNome()) + ", cliente: " + String.valueOf(getCliente()));
    }
    private void confirmarPagamento() {
        if (getDataVencimentoReserva().before(dataAtual)) {
            System.out.println("Reserva vencida");
        } else {
            System.out.println("pagamento aprovado");
        }
    }
    public Date getDataAtual() {
        return dataAtual;
    }

    
}