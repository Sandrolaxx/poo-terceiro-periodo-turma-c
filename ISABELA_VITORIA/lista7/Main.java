package lista7;

import java.util.Date;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Endereco enderecoDoCliente = new Endereco("São Paulo", "São Paulo", "Zona Sul", "Rua São João", 183, null);
        Endereco enderecoDoVendedor = new Endereco("Santa Catarina", "Balneário Camboriú", "Centro", "Avenida Central",
                256, null);
        Float[] salarioRecebido = { 2000.0f, 3000.0f, 5000.0f };
        Vendedor vendedor = new Vendedor("Pedro Henrique", 28, enderecoDoVendedor, salarioRecebido);
        Cliente cliente = new Cliente("Maria Silva", 35, enderecoDoCliente);
        Loja loja = new Loja("SuperStore", "SuperStore LTDA", enderecoDoVendedor, new Vendedor[] { vendedor },
                new Cliente[] { cliente });

        System.out.println("Bem-vindo à SuperStore!");
        vendedor.setLoja(loja);
        vendedor.setSalarioBase(2500.0f);
        vendedor.apresentarse();
        vendedor.calcularMedia();
        vendedor.calcularBonus();

        System.out.println("");
        cliente.apresentarse();

        System.out.println("");
        loja.setCnpj("12.345.678/0001-90");
        loja.apresentarse();
        loja.contarVendedores();
        loja.contarClientes();

        Endereco enderecoDoGerente = new Endereco("Rio de Janeiro", "Rio de Janeiro", "Zona Norte",
                "Avenida das Palmeiras", 67, "Casa Amarela");
        Item item = new Item(0, "Smartphone", "Eletrônicos", 1200.0f);
        Pedido pedido = new Pedido();
        Scanner scannerEmpresa = new Scanner(System.in);

        System.out.println("");
        Gerente gerente = new Gerente("Ana Paula", 40, loja, enderecoDoGerente,
                new Float[] { 2800.0f, 3200.0f, 3500.0f });
        gerente.setSalarioBase(3000.0f);
        gerente.apresentarse();
        gerente.calcularMedia();
        gerente.calcularBonus();
        enderecoDoGerente.apresentarLogradouro();

        System.out.println("");
        item.gerarDescricao();

        System.out.println("");
        Date dataDeHoje = new Date();
        Date dataDaquiTresDias = new Date(dataDeHoje.getTime() + (1000 * 60 * 60 * 24 * 3));
        pedido.setId(0);
        pedido.setDataCriacao(dataDeHoje);
        pedido.setDataPagamento(dataDeHoje);
        pedido.setDataVencimento(dataDaquiTresDias);
        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        pedido.setLoja(loja);
        pedido.calcularValorTotal();

        System.out.print("Qual o nome do parceiro comercial: ");
        String res = scannerEmpresa.nextLine();
        pedido.setEmpresaParceira(res);
        pedido.gerarDescricaoVenda();
        ProcessaPedido processaPedido = new ProcessaPedido();
        processaPedido.processar(pedido);
        processaPedido.confirmaOPagamento(pedido);

        System.out.println("");
        int opcao;
        while (true) {
            mostrarMenu();

            System.out.print("Escolha uma opção através do seu número: ");
            opcao = new Scanner(System.in).nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando o menu, até mais");
                break;
            }
            //cadastro
            switch (opcao) {
                case 1:
                    loja.cadastrarItem(criarItem());
                    break;
                case 2:
                    loja.listarItens();
                    break;
                case 3:
                    Pedido casePedido = new Pedido();
                    casePedido.setDataCriacao(dataDeHoje);
                    casePedido.setDataPagamento(dataDeHoje);
                    casePedido.setDataVencimento(dataDaquiTresDias);
                    casePedido.setCliente(cliente);
                    casePedido.setVendedor(vendedor);
                    casePedido.setLoja(loja);
                    casePedido.calcularValorTotal();

                    while (true) {
                        loja.listarItens();
                        System.out.print("\nDigite o ID do item que deseja comprar: ");
                        int idItem = new Scanner(System.in).nextInt();
                        casePedido.adicionarItem(loja.listarItens(idItem));

                        System.out.print("\nDeseja adicionar mais itens? (s/n): ");
                        String opcaoSair = new Scanner(System.in).next();

                        if (opcaoSair.equalsIgnoreCase("n"))
                            break;
                    }
                    processaPedido.finalizarPedido(casePedido);
                    return;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        }
    }

    public static Item criarItem() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do item: ");
        String nome = sc.nextLine();
        System.out.print("Digite o tipo do item: ");
        String tipo = sc.nextLine();
        System.out.print("Digite o preço do item: ");
        Float valor = sc.nextFloat();

        return new Item(nome, tipo, valor);
    }

    public static void mostrarMenu() {
        System.out.println("############################");
        System.out.println("(1) Cadastrar item          ");
        System.out.println("(2) Exibir itens cadastrados");
        System.out.println("(3) Finalizar pedido        ");
        System.out.println("(0) Sair do menu            ");
        System.out.println("############################");
    }
}
