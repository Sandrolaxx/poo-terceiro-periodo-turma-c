package RICARDO_DINIZ_SILVA.Lista7;

import java.util.Date;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Endereco enderecoDoCliente = new Endereco("São Paulo", "São Paulo", "Zona Sul", "Rua 7 de Setembro", 183, null);
        Endereco enderecoDoVendedor = new Endereco("Santa Catarina", "Balneario Camboriu", "Centro", "Avenida Principal", 256, null);
        Float[] salarioRecebido = {2450.0f, 3550.0f, 6750.0f};
        Vendedor vendedor = new Vendedor("John Cena", 25, enderecoDoVendedor, salarioRecebido);
        Cliente cliente = new Cliente("Rick Grimes", 30, enderecoDoCliente);
        Loja loja = new Loja("TemdiTudo", "TemdiTudo LTDA", enderecoDoVendedor, new Vendedor[]{vendedor}, new Cliente[]{cliente});
        
        System.out.println("Bem-vindo a loja TemdiTudo");
        vendedor.setLoja(loja);
        vendedor.setSalarioBase(2200.0f);
        vendedor.apresentarse();
        vendedor.calcularMedia();
        vendedor.calcularBonus();

        System.out.println("");
        cliente.apresentarse();

        System.out.println("");
        loja.setCnpj("79.727.846/0002-74");
        loja.apresentarse();
        loja.contarVendedores();
        loja.contarClientes();

        Endereco enderecoDoGerente = new Endereco("Rio de Janeiro", "Rio de Janeiro", "Zona Norte", "Rua da Lorota", 67, "Casinha Humilde");
        Item item = new Item(0, "Kit Turbo pra Gol Bola", "Kit Turbo", 350.0f);
        Pedido pedido = new Pedido();
        Scanner scannerEmpresa = new Scanner(System.in);

        System.out.println("");
        Gerente gerente = new Gerente("Marcos", 40, loja, enderecoDoGerente, new Float[]{2200.0f, 2400.0f, 2600.0f});
        gerente.setSalarioBase(2200.0f);
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

        System.out.print("Qual o nome da empresa parceira: ");
        String res = scannerEmpresa.nextLine();
        pedido.setEmpresaParceira(res);
        pedido.gerarDescricaoVenda();
        ProcessaPedido processaPedido = new ProcessaPedido();
        processaPedido.processar(pedido);
        processaPedido.confirmaOPagamento(pedido);
 
        int opcao;
        while (true) {
            mostrarMenu();

            System.out.print("Escolha uma opção: ");
            opcao = new Scanner(System.in).nextInt();

            if (opcao == 4) {
                System.out.println("Encerrando....");
                break;
            }

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
                        casePedido.adicionarItem(loja.selecionarItem(idItem));

                        System.out.print("\nVocê quer adicionar mais itens? s/n ");
                        String opcaoSair = new Scanner(System.in).next();

                        if (opcaoSair.equalsIgnoreCase("n")) break;
                    }
                    processaPedido.finalizarPedido(casePedido);
                    return;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        }
    }

    public static Item criarItem(){
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
        System.out.println("___ 1. Cadastrar um novo item ___");
        System.out.println("___ 2. Exibir todos os itens  ___");
        System.out.println("___ 3. Finalizar pedido       ___");
        System.out.println("___ 4. Sair do menu           ___");
    }
}
