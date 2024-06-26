package Listaseis;
import java.util.Date;

public class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    String loja;
    Item[] itens;

    public double calcularValorTotal(){
        double total = 0;
        for(Item item : itens){
            total += item.valor;
        }
        return total;
    }

    public void gerarDescricaoVenda(){
        System.out.println("Data de criação do pedido: " + dataCriacao);
        System.out.println("Valor total do pedido: " + calcularValorTotal());
    }
}
