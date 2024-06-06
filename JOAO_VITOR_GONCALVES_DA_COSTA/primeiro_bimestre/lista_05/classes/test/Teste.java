package lista_05.classes.test;

import java.util.Date;

import lista_05.classes.cliente.Cliente;
import lista_05.classes.gerente.Gerente;
import lista_05.classes.item.Item;
import lista_05.classes.loja.Loja;
import lista_05.classes.pedido.Pedido;
import lista_05.classes.processa_pedido.ProcessaPedido;
import lista_05.classes.vendedor.Vendedor;

public class Teste {

        public static Long diaDeHoje = new Date().getTime();
        public static Long umDiaEmMs = 86400000l;

        public static void run() {
                // Criação dos clientes
                Cliente cliente_01 = new Cliente("Sandro", 44, "Tropical", "Cascavel", "Amor", "Paraná", "apto 1215",
                                "441");

                Cliente cliente_02 = new Cliente("Pedro", 23, "Santos", "Cascavel", "Gurizes", "Paraná", "casa", "123");

                Cliente cliente_03 = new Cliente("Barcelos", 23, "Inter", "Cascavel", "Gurizas", "Paraná", "casa",
                                "432");

                Cliente cliente_04 = new Cliente("Ben", 35, "Flu", "Cascavel", "Criantes", "Paraná", "apto 512", "111");

                Cliente cliente_05 = new Cliente("Marcio", 32, "Jax", "Cascavel", "Luffy", "Rio Grande do Sul",
                                "apto 543",
                                "244");

                // Fim da criação dos clientes clientes

                // Criando as lojas

                Loja loja_01 = new Loja("As Plantas", "14.645.182/8901-05", "Centro", "Cascavel", "Av. Papi",
                                "Paraná", " 1200", "nenhum complemento", "Plantinhas da veia", 2, 1);

                Loja loja_02 = new Loja("As Plantas", "12.123.182/1512-05", "Centro", "Curitiba", "Av. Nasus",
                                "Paraná", " 1200", "nenhum complemento", "Plantinhas da veia", 2, 2);

                Loja loja_03 = new Loja("As Plantas", "14.131.182/4123-05", "Centro", "Passo Fundo", "Av. Dog",
                                "Rio Grande do Sul", " 256", "nenhum complemento", "Plantinhas da veia", 2, 2);

                // Fim das lojas

                // Criando itens para as lojas

                Item item_01 = new Item(0, "Da braba", "flor", 12.50);
                Item item_02 = new Item(1, "Balinha", "Comida", 0.50);
                Item item_03 = new Item(2, "Boné", "Acessório", 50);

                // Fim da criação dos itens

                // Criação dos vendedores
                Vendedor vendedores_01 = new Vendedor("Naty", 22, "Alvará", "Cascavel", "Pertir", "Paraná", "apto 789",
                                "88", 3, 1250);
                vendedores_01.adicionarSalarios(1250, 1423, 1242);

                Vendedor vendedores_02 = new Vendedor("Mariana", 25, "França", "Cascavel", "AAAA", "Paraná", "apto 222",
                                "534", 5, 1450);
                vendedores_02.adicionarSalarios(1250, 6532, 4959, 1222, 2111);

                Vendedor vendedores_03 = new Vendedor("Sandro", 50, "Pocs", "Cascavel", "Tereza", "Paraná", "apto 89",
                                "42", 4, 2000);
                vendedores_03.adicionarSalarios(1250, 1423, 1432, 1234);

                Vendedor vendedores_04 = new Vendedor("Sandro", 25, "Tropical", "Cascavel", "Fortaleza", "Paraná",
                                "apto 1215",
                                "12", 3, 1250);
                vendedores_04.adicionarSalarios(1250, 6532, 4959);

                Vendedor vendedores_05 = new Vendedor("Sandro", 33, "Caltropil", "Passo fundo", "Fortaleza", "Paraná",
                                "apto 5",
                                "534", 3, 899);
                vendedores_05.adicionarSalarios(1250, 6532, 4959);

                Vendedor vendedores_06 = new Vendedor("Sandro", 44, "Poloas", "Curitiba", "Fortaleza", "Paraná",
                                "apto 321",
                                "413", 3, 789);
                vendedores_06.adicionarSalarios(1250, 1250, 1250);
                // Fim da criação dos vendedores

                // Criando gerentes

                Gerente gerente_01 = new Gerente("Marciso", 50, "Poloas", "Curitiba", "Fortaleza", "Paraná", "apto 321",
                                "413", 3, 1250);

                gerente_01.adicionarSalarios(1250, 1423, 1242);
                gerente_01.setLojaEmqueTrabalha(loja_01);

                Gerente gerente_02 = new Gerente("Cleberilda", 59, "Abare", "Passo Fundo", "Fortaleza",
                                "Rio Grande do Sul",
                                "apto 1",
                                "978", 12, 5000);

                gerente_02.setLojaEmqueTrabalha(loja_02);
                gerente_02.adicionarSalarios(4530, 4323, 6177, 4589, 7894, 4530, 9878, 1587, 4530, 6789, 7989, 2616);

                Gerente gerente_03 = new Gerente("Arnaldo", 28, "Brics", "Cascavel", "Pio X9", "Paraná", "apto 321",
                                "413", 5, 3255);

                gerente_03.setLojaEmqueTrabalha(loja_03);
                gerente_03.adicionarSalarios(6177, 4589, 7894, 6177, 4589);

                // Fim da criação dos gerentes

                // Criando pedidos

                Pedido pedido_01 = new Pedido(0, diaDeHoje, diaDeHoje + umDiaEmMs, cliente_01, vendedores_01, loja_01,
                                item_01, item_01, item_01);

                Pedido pedido_02 = new Pedido(0, diaDeHoje, diaDeHoje + (umDiaEmMs * 4), cliente_02, vendedores_02,
                                loja_01,
                                item_02, item_02, item_02);

                Pedido pedido_03 = new Pedido(0, diaDeHoje, diaDeHoje + umDiaEmMs, cliente_03, vendedores_03, loja_02,
                                item_03, item_03, item_03);

                Pedido pedido_04 = new Pedido(0, diaDeHoje, diaDeHoje + umDiaEmMs, cliente_04, vendedores_03, loja_02,
                                item_01);

                Pedido pedido_05 = new Pedido(0, diaDeHoje, diaDeHoje + umDiaEmMs, cliente_05, vendedores_05, loja_03,
                                item_02);

                // Fim da criação dos pedidos

                // Pedidos processados

                ProcessaPedido processaPedido_01 = new ProcessaPedido(pedido_01);
                ProcessaPedido processaPedido_02 = new ProcessaPedido(pedido_02);
                ProcessaPedido processaPedido_03 = new ProcessaPedido(pedido_03);
                ProcessaPedido processaPedido_04 = new ProcessaPedido(pedido_04);
                ProcessaPedido processaPedido_05 = new ProcessaPedido(pedido_05);

                // Fim dos processos

                // Atribuindo vendedores para as lojas
                loja_01.adicionarVendedores(vendedores_01, vendedores_02);
                loja_01.setGerenteDaLoja(gerente_01);
                loja_02.adicionarVendedores(vendedores_03, vendedores_04);
                loja_02.setGerenteDaLoja(gerente_02);
                loja_03.adicionarVendedores(vendedores_05, vendedores_06);
                loja_03.setGerenteDaLoja(gerente_03);
                // Fim da atribuição de vendedores para as lojas

                // Atribuindo clientes para as lojas
                loja_01.adicionarClientes(cliente_01);
                loja_02.adicionarClientes(cliente_03, cliente_04);
                loja_03.adicionarClientes(cliente_05, cliente_02);
                // Fim da atribuição de clientes para as lojas

                // Atribuindo loja para o vendedor
                vendedores_01.setLojaEmqueTrabalha(loja_01);
                vendedores_02.setLojaEmqueTrabalha(loja_01);
                vendedores_03.setLojaEmqueTrabalha(loja_02);
                vendedores_04.setLojaEmqueTrabalha(loja_02);
                vendedores_05.setLojaEmqueTrabalha(loja_03);
                vendedores_06.setLojaEmqueTrabalha(loja_03);
                // Fim da atribuição da loja para o vendedor

                // Apresentar todos
                System.out.println("<-----------Clientes----------->");
                cliente_01.apresentarse();
                System.out.println("\n");
                cliente_02.apresentarse();
                System.out.println("\n");
                cliente_03.apresentarse();
                System.out.println("\n");
                cliente_04.apresentarse();
                System.out.println("\n");
                cliente_05.apresentarse();
                System.out.println("\n");

                System.out.println("<-----------Lojas----------->");
                loja_01.apresentarse();
                loja_01.contarClientesDaLoja();
                loja_01.contarVendedoresDaLoja();
                System.out.println("\n");

                loja_02.apresentarse();
                loja_02.contarClientesDaLoja();
                loja_02.contarVendedoresDaLoja();
                System.out.println("\n");

                loja_03.apresentarse();
                loja_03.contarClientesDaLoja();
                loja_03.contarVendedoresDaLoja();
                System.out.println("\n");

                System.out.println("<-----------Vendedores----------->");

                vendedores_01.apresentarse();
                vendedores_01.calcularMedia();
                vendedores_01.calcularBonus();

                System.out.println("\n");

                vendedores_02.apresentarse();
                vendedores_02.calcularMedia();
                vendedores_02.calcularBonus();

                System.out.println("\n");

                vendedores_03.apresentarse();
                vendedores_03.calcularMedia();
                vendedores_03.calcularBonus();

                System.out.println("\n");

                vendedores_04.apresentarse();
                vendedores_04.calcularMedia();
                vendedores_04.calcularBonus();

                System.out.println("\n");

                vendedores_05.apresentarse();
                vendedores_05.calcularMedia();
                vendedores_05.calcularBonus();

                System.out.println("\n");

                vendedores_06.apresentarse();
                vendedores_06.calcularMedia();
                vendedores_06.calcularBonus();

                System.out.println("<-----------Itens----------->");

                item_01.gerarDescricao();
                System.out.println("\n");
                item_02.gerarDescricao();
                System.out.println("\n");
                item_03.gerarDescricao();
                System.out.println("\n");

                System.out.println("<-----------Gerentes----------->");

                gerente_01.apresentarse();
                gerente_01.calcularMedia();
                gerente_01.calcularBonus();

                System.out.println("\n");

                gerente_02.apresentarse();
                gerente_02.calcularMedia();
                gerente_02.calcularBonus();

                System.out.println("\n");

                gerente_03.apresentarse();
                gerente_03.calcularMedia();
                gerente_03.calcularBonus();

                System.out.println("\n");

                System.out.println("<-----------Pedidos----------->");

                pedido_01.gerarDescricaoVenda();
                System.out.println("\n");

                pedido_02.gerarDescricaoVenda();
                System.out.println("\n");

                pedido_03.gerarDescricaoVenda();
                System.out.println("\n");

                pedido_04.gerarDescricaoVenda();
                System.out.println("\n");

                pedido_05.gerarDescricaoVenda();
                System.out.println("\n");

                // System.out.println("<-----------Pedidos Processados----------->");

                processaPedido_01.processar();
                System.out.println("\n");

                processaPedido_02.processar();
                System.out.println("\n");

                processaPedido_03.processar();
                System.out.println("\n");

                processaPedido_04.processar();
                System.out.println("\n");

                processaPedido_05.processar();
                System.out.println("\n");

                // Fim do apresentar todos
        }
}
