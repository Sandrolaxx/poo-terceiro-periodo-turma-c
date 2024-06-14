package segundob.aulas.aulacinco;

public class SrpMain {
    
    public static void main(String[] args) {
        
        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = new Pedido();

        processaPedido.processa(pedido);
    }

}
