package lista_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista07Test {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Parana", "Cascavel", "Centro", 246, "Predio");
        Loja loja = new Loja("Beija Flor", "Beija Flor LTDA", 1234567892323L, endereco);

        Cliente cliente01 = new Cliente("Claudineia", 57, endereco);
        Cliente cliente02 = new Cliente("Angela", 45, endereco);

        Vendedor vendedor01 = new Vendedor("Maria", 34, endereco, loja, 1530);
        Vendedor vendedor02 = new Vendedor("Joana", 34, endereco, loja, 1680);

        Gerente gerente = new Gerente("Lucimar", 40, endereco, loja, 2200);

        loja.cadastrarCliente(cliente01);
        loja.cadastrarCliente(cliente02);
        loja.cadastrarVendedor(vendedor01);
        loja.cadastrarVendedor(vendedor02);
        loja.cadastrarGerente(gerente);

        vendedor01.adicionarSalarioRecebido(1590);
        vendedor01.adicionarSalarioRecebido(1635);
        vendedor01.adicionarSalarioRecebido(1650);

        vendedor02.adicionarSalarioRecebido(1640);
        vendedor02.adicionarSalarioRecebido(1675);
        vendedor02.adicionarSalarioRecebido(1700);

        ProcessaPedido processaPedido = new ProcessaPedido(loja);

        System.out.println("----- Clientes ------");
        cliente01.apresentarse();
        cliente02.apresentarse();

        System.out.println("----- Vendedores ------");
        vendedor01.apresentarse();
        vendedor02.apresentarse();
        System.out.println("Calcular media: ");
        System.out.println("Media: " + vendedor01.calcularMedia());
        System.out.println("Media: " + vendedor01.calcularMedia());
        System.out.println("Calcular bonus: ");
        System.out.println("Bonus: " + vendedor01.calcularBonus());
        System.out.println("Bonus: " + vendedor02.calcularBonus());

        System.out.println("----- Gerente ------");
        gerente.apresentarse();
        System.out.println("Calcular media: ");
        System.out.println("Media: " + gerente.calcularMedia());
        System.out.println("Calcular bonus: ");
        System.out.println("Bonus: " + gerente.calcularBonus());

        System.out.println("----- Loja ------");
        loja.apresentarse();
        System.out.println("Clientes: " + loja.contarClientes());
        System.out.println("Vendedores: " + loja.contarVendedores());

        System.out.println("----- Pedido e Item ------");
        Item item01 = new Item("Gira Sol", "Flor", 35.99);
        item01.gerarDescricao();
        Item item02 = new Item("Orquidea", "Flor", 75.49);
        item02.gerarDescricao();
        Pedido pedido = processaPedido.processar(cliente01, vendedor01, List.of(item01, item02));
        pedido.gerarDescricaoVenda();
        processaPedido.comfirmaPagamento(pedido);

        while (true) {
            menu();
            System.out.print("Escolha uma opção: ");
            int opcao = new Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("----- Realizar Pedido -----");
                    if (loja.getItens().isEmpty()) {
                        System.out.println("Não ha itens cadastrados, por favor cadastre itens para poder realizar um pedido!");
                        break;
                    }
                    List<Item> itens = new ArrayList<>();

                    while (true) {
                        loja.listarItens();
                        System.out.print("Escolha um item pelo id: ");
                        int idItem = new Scanner(System.in).nextInt();
                        Item item = loja.buscarItem(idItem);
                        itens.add(item);

                        System.out.print("Deseja escolher mais itens? S/N: ");
                        String continuar = new Scanner(System.in).next();

                        if (continuar.equalsIgnoreCase("n")) break;
                    }
                    Pedido pedido2 = processaPedido.processar(cliente02, vendedor02, itens);
                    loja.cadastrarPedido(pedido2);
                    System.out.println("--- Pedido Criado com Sucesso! ---");
                    pedido2.gerarDescricaoVenda();
                    break;
                case 2:
                    System.out.println("----- Cadastrar Item -----");
                    System.out.print("Nome: ");
                    String nome = new Scanner(System.in).nextLine();
                    System.out.print("Tipo: ");
                    String tipo = new Scanner(System.in).nextLine();
                    System.out.print("Valor: ");
                    double valor = new Scanner(System.in).nextDouble();

                    Item item = new Item(nome, tipo, valor);
                    loja.cadastrarItem(item);
                    break;
                case 3:
                    loja.listarPedidos();
                    break;
                case 4:
                    loja.listarItens();
                    break;
                case 0:
                    System.out.println("Saindo!");
                    return;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("----- Menu -----");
        System.out.println("1 - Realizar Pedido");
        System.out.println("2 - Cadastrar Item");
        System.out.println("3 - Listar Pedidos");
        System.out.println("4 - Listar Itens");
        System.out.println("0 - Sair");
    }
}
