import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Item[] itens = {
            new Item(1, "Planta 1", "Planta", 50.00),
            new Item(2, "Planta 2", "Planta", 40.00)
        };

        Date dataCriacao = new Date();
        Pedido pedido = new Pedido(1, dataCriacao, itens);

        ProcessaPedido processador = new ProcessaPedido();
        processador.processar(pedido);
    }
}
