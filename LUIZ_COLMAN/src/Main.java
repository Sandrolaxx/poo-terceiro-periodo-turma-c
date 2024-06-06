import java.util.Date;
import java.util.ArrayList;
import src.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.nome = "Maria";
        cliente.idade = 25;
        cliente.cidade = "Cidade A";
        cliente.bairro = "Centro";
        cliente.rua = "Rua 2";

        Vendedor vendedor = new Vendedor();
        vendedor.nome = "João";
        vendedor.idade = 30;
        vendedor.loja = "Myy Plant";
        vendedor.cidade = "Cidade A";
        vendedor.bairro = "Centro";
        vendedor.rua = "Rua 1";
        vendedor.salarioBase = 2000;

        Loja loja = new Loja();
        loja.nomeFantasia = "Myy Plant";
        loja.cnpj = "123456789";
        loja.cidade = "Cidade A";
        loja.bairro = "Centro";
        loja.rua = "Rua 3";

        Item item1 = new Item();
        item1.id = 1;
        item1.nome = "Produto 1";
        item1.tipo = "Tipo A";
        item1.valor = 50.0;

        Item item2 = new Item();
        item2.id = 2;
        item2.nome = "Produto 2";
        item2.tipo = "Tipo B";
        item2.valor = 70.0;

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        ProcessaPedido processador = new ProcessaPedido();

        int idPedido = 1;
        Date dataCriacao = new Date();
        Date dataPagamento = null; // null para simular pagamento ainda não realizado

        processador.processar(idPedido, dataCriacao, dataPagamento, cliente, vendedor, loja, itens);
    }
}
