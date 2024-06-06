package lista_05.classes.test;

import java.util.Date;

import lista_05.classes.cliente.Cliente;
import lista_05.classes.item.Item;
import lista_05.classes.loja.Loja;
import lista_05.classes.pedido.Pedido;
import lista_05.classes.processa_pedido.ProcessaPedido;
import lista_05.classes.vendedor.Vendedor;

public class TestarData {
    public static Long diaDeHoje = new Date().getTime();
    public static Long umDiaEmMs = 86400000l;

    public static void run() {
        Item item_01 = new Item(0, "aaaaaaa", "dois", 123);
        Cliente cliente_01 = new Cliente("Sandro", 44, "Tropical", "Cascavel", "Amor", "Paraná", "apto 1215", "441");
        Vendedor vendedores_01 = new Vendedor("Naty", 22, "Alvará", "Cascavel", "Pertir", "Paraná", "apto 789",
                "88", 3, 1250);
        Loja loja_03 = new Loja("As Plantas", "14.131.182/4123-05", "Centro", "Passo Fundo", "Av. Dog",
                "Rio Grande do Sul", " 256", "nenhum complemento", "Plantinhas da veia", 2, 2);

        Pedido pedido_01 = new Pedido(0, diaDeHoje, diaDeHoje, cliente_01, vendedores_01, loja_03, item_01);
        pedido_01.gerarDescricaoVenda();
        ProcessaPedido processo_01 = new ProcessaPedido(pedido_01);

        processo_01.processar();
    }
}
