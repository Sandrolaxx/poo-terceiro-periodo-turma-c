package primeirob.Lista07.utils;

import primeirob.Lista07.domain.*;
import primeirob.Lista07.test.MenuPrincipal;

import java.time.LocalDate;
import java.util.*;

public class MainFunctions {
    private static Loja lojaGlobal = MenuPrincipal.LojaGlobal.loja;
    private static List<Cliente> clientesDaLoja = new ArrayList<>();
    private static List<Vendedor> vendedoresDaLoja = new ArrayList<>();
    private static List<Gerente> gerentesDaLoja = new ArrayList<>();
    private static List<Item> itensDaLoja = new ArrayList<>();
    private static List<Pedido> pedidosDaLoja = new ArrayList<>();
    private static long proximoIdPedido = 1;
    private static long proximoIdItem = 1;
    private static String empresaParceira;

    public static void ficticios() {
        Endereco enderecoFicticio = Endereco.EnderecoBuilder.builder()
                .estado("Paraná")
                .cidade("Santa Lúcia")
                .bairro("Centro")
                .rua("Rua das Palmeiras")
                .numero(345)
                .complemento("Casa")
                .build();

        Gerente gerente = Gerente.GerenteBuilder.builder()
                .nomePessoa("Sandro Ramos")
                .idade(25)
                .loja(lojaGlobal)
                .salarioBase(15600)
                .salarioRecebido(Arrays.asList(15600.00, 15700.00, 16000.00))
                .endereco(enderecoFicticio)
                .build();

        gerentesDaLoja.add(gerente);

        Vendedor vendedor1 = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Guilherme")
                .idade(18)
                .loja(lojaGlobal)
                .salarioBase(2000)
                .salarioRecebido(Arrays.asList(2100.00, 1950.00, 2150.00))
                .endereco(enderecoFicticio)
                .build();

        Vendedor vendedor2 = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Rafael")
                .idade(18)
                .loja(lojaGlobal)
                .salarioBase(2000)
                .salarioRecebido(Arrays.asList(2100.00, 1950.00, 2150.00))
                .endereco(enderecoFicticio)
                .build();

        Vendedor vendedor3 = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Bernardo")
                .idade(18)
                .loja(lojaGlobal)
                .salarioBase(2000)
                .salarioRecebido(Arrays.asList(2100.00, 1950.00, 2150.00))
                .endereco(enderecoFicticio)
                .build();

        vendedoresDaLoja.add(vendedor1);
        vendedoresDaLoja.add(vendedor2);
        vendedoresDaLoja.add(vendedor3);

        Cliente cliente1 = Cliente.ClienteBuilder.builder()
                .nomePessoa("Kaue")
                .idade(18)
                .endereco(enderecoFicticio)
                .build();

        Cliente cliente2 = Cliente.ClienteBuilder.builder()
                .nomePessoa("Anderson")
                .idade(18)
                .endereco(enderecoFicticio)
                .build();

        Cliente cliente3 = Cliente.ClienteBuilder.builder()
                .nomePessoa("Lucas")
                .idade(18)
                .endereco(enderecoFicticio)
                .build();

        clientesDaLoja.add(cliente1);
        clientesDaLoja.add(cliente2);
        clientesDaLoja.add(cliente3);

        Item item1 = Item.ItemBuilder.builder()
                .id(proximoIdItem++)
                .nome("Notebook Acer I3")
                .tipo("Eletronico")
                .valor(4999.00)
                .build();

        Item item2 = Item.ItemBuilder.builder()
                .id(proximoIdItem++)
                .nome("Notebook Samsung I5")
                .tipo("Eletronico")
                .valor(4999.00)
                .build();

        Item item3 = Item.ItemBuilder.builder()
                .id(proximoIdItem++)
                .nome("Celular Xiaomi 256GB")
                .tipo("Eletronico")
                .valor(4999.00)
                .build();

        itensDaLoja.add(item1);
        itensDaLoja.add(item2);
        itensDaLoja.add(item3);
    }

    private static Endereco cadastrarEndereco() {
        System.out.println("Qual estado reside: ");
        String estado = new Scanner(System.in).nextLine();

        System.out.println("Qual cidade reside: ");
        String cidade = new Scanner(System.in).nextLine();

        System.out.println("Qual bairro reside: ");
        String bairro = new Scanner(System.in).nextLine();

        System.out.println("Qual rua reside: ");
        String rua = new Scanner(System.in).nextLine();

        System.out.println("Qual o número da casa em que reside: ");
        Integer numeroCasa = new Scanner(System.in).nextInt();

        System.out.println("Passe um complemento do seu Cliente: ");
        String complemento = new Scanner(System.in).nextLine();

        return Endereco.EnderecoBuilder.builder()
                .estado(estado)
                .cidade(cidade)
                .bairro(bairro)
                .rua(rua)
                .numero(numeroCasa)
                .complemento(complemento)
                .build();
    }

    public static void cadastrarCliente() {
        System.out.println("Insira o nome do seu Cliente: ");
        String nomeCliente = new Scanner(System.in).nextLine();

        System.out.println("Insira a idade do Cliente: ");
        Integer idadeCliente = new Scanner(System.in).nextInt();

        Cliente cliente = Cliente.ClienteBuilder.builder()
                .nomePessoa(nomeCliente)
                .idade(idadeCliente)
                .endereco(cadastrarEndereco())
                .build();

        clientesDaLoja.add(cliente);
        System.out.println("Cliente cadastrado com sucesso...");
    }


    public static void cadastrarNovoItem() {

        System.out.println("Insira o ID do novo Item: ");
        Long idItem = new Scanner(System.in).nextLong();

        System.out.println("Insira o nome do Item: ");
        String nomeItem = new Scanner(System.in).nextLine();

        System.out.println("Insira o tipo do Item: ");
        String tipoItem = new Scanner(System.in).nextLine();

        System.out.println("Insira o valor do Item: ");
        Double valorItem = new Scanner(System.in).nextDouble();

        Item item = Item.ItemBuilder.builder()
                .id(idItem)
                .nome(nomeItem)
                .tipo(tipoItem)
                .valor(valorItem)
                .build();

        itensDaLoja.add(item);
        System.out.println("Item cadastrado com sucesso...");
    }

    public static void listarVendedores() {

        System.out.println("\n\nLista de Vendedores da Loja:" + lojaGlobal.getNomeFantasia());
        System.out.println("----------------------------------");

        if (vendedoresDaLoja.isEmpty()) {
            System.out.println("Ainda não há vendedores cadastrados nessa loja.");
        } else {
            for (Vendedor vendedor : vendedoresDaLoja) {
                System.out.println(vendedor.apresentarse());
            }
        }

        System.out.println("\nTotal de Vendedores:" + vendedoresDaLoja.size());
    }

    public static void listarClientes() {

        System.out.println("\n\nLista de Clientes da Loja:" + lojaGlobal.getNomeFantasia());
        System.out.println("----------------------------------");

        if (clientesDaLoja.isEmpty()) {
            System.out.println("Ainda não há clientes cadastrados nessa loja.");
        } else {
            for (Cliente cliente : clientesDaLoja) {
                System.out.println(cliente.apresentarse());
            }
        }

        System.out.println("\nTotal de Clientes:" + clientesDaLoja.size());
    }

    public static void listarItens() {
        System.out.println("\n\nLista de Itens da Loja:" + lojaGlobal.getNomeFantasia());
        System.out.println("----------------------------------");

        if (itensDaLoja.isEmpty()) {
            System.out.println("Ainda não há itens cadastrados nessa loja.");
        } else {
            for (Item item : itensDaLoja) {
                System.out.println(item.gerarDescricao());
            }
        }

        System.out.println("\nTotal de Itens: " + itensDaLoja.size());
    }

    public static Cliente encontrarClientePorNome(String nomeCliente) {
        for (Cliente cliente : clientesDaLoja) {
            if (cliente.getNomePessoa().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public static Vendedor encontrarVendedorPorNome(String nomeVendedor) {
        for (Vendedor vendedor : vendedoresDaLoja) {
            if (vendedor.getNomePessoa().equalsIgnoreCase(nomeVendedor)) {
                return vendedor;
            }
        }
        return null;
    }

    public static Item encontrarItemPorId(long idItem) {
        for (Item item : itensDaLoja) {
            if (item.getId() == idItem) {
                return item;
            }
        }
        return null;
    }

    public static void criarNovoPedido() {
        listarClientes();
        listarVendedores();
        listarItens();

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = new Scanner(System.in).nextLine();
        Cliente cliente = encontrarClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Pedido não pode ser criado.");
            return;
        }

        System.out.println("Digite o nome do vendedor: ");
        String nomeVendedor = new Scanner(System.in).nextLine();
        Vendedor vendedor = encontrarVendedorPorNome(nomeVendedor);
        if (vendedor == null) {
            System.out.println("Vendedor não encontrado. Pedido não pode ser criado.");
            return;
        }

        List<Item> itensSelecionados = new ArrayList<>();
        boolean continuarAdicionandoItens = true;
        while (continuarAdicionandoItens) {
            System.out.println("Digite o ID do item a ser adicionado ao pedido (ou 0 para sair): ");
            long idItem = new Scanner(System.in).nextLong();
            if (idItem == 0) {
                continuarAdicionandoItens = false;
            } else {
                Item itemEncontrado = encontrarItemPorId(idItem);
                if (itemEncontrado != null) {
                    itensSelecionados.add(itemEncontrado);
                    System.out.println("Item adicionado ao pedido com sucesso!");
                } else {
                    System.out.println("Item não encontrado na loja. Tente novamente.");
                }
            }
        }

        System.out.println("Deseja fazer a venda em parceria com alguma empresa? Opções a seguir: \n1. Sim.\n2. Não.");
        int opcaoParceria = new Scanner(System.in).nextInt();
        if (opcaoParceria == 2) {
            System.out.println("A venda será realizada sem parceria com empresa.");
            empresaParceira = null;
        }
        if (opcaoParceria == 1) {
            System.out.print("Insira o nome da empresa parceira: ");
            empresaParceira = new Scanner(System.in).nextLine();
        }

        Pedido pedido = new Pedido.PedidoBuilder()
                .id(proximoIdPedido++)
                .cliente(cliente)
                .vendedor(vendedor)
                .loja(lojaGlobal)
                .itens(itensSelecionados)
                .dataCriacao(LocalDate.now())
                .empresaParceira(empresaParceira)
                .build();

        pedidosDaLoja.add(pedido);

        System.out.println("Pedido criado com sucesso!");
    }

    public static void listarPedidos() {
        System.out.println("\n\nLista de Pedidos gerados na Loja:" + lojaGlobal.getNomeFantasia());
        System.out.println("----------------------------------");

        if (pedidosDaLoja.isEmpty()) {
            System.out.println("Ainda não há pedidos gerados na loja.");
        } else {
            for (Pedido pedido : pedidosDaLoja) {
                System.out.println(pedido.gerarDescricaoVenda());
            }
        }

        System.out.println("\nTotal de Pedidos: " + pedidosDaLoja.size());
    }

    public static void processarNovoPedido() {
        listarPedidos();

        System.out.println("Digite o ID do pedido que deseja processar (ou 0 para sair): ");
        Long idPedido = new Scanner(System.in).nextLong();
        if (idPedido == 0) {
            System.out.println("Saindo do processamento de pedidos....");
            return;
        }

        Pedido pedidoSelecionado = null;
        for (Pedido pedido : pedidosDaLoja) {
            if (Objects.equals(pedido.getId(), idPedido)) {
                pedidoSelecionado = pedido;
                break;
            }
        }

        if (pedidoSelecionado == null) {
            System.out.println("Pedido não encontrado. Verifique o ID e tente novamente.");
            return;
        }

        ProcessarPedido processador = new ProcessarPedido();
        processador.processar(pedidoSelecionado);

        pedidosDaLoja.remove(pedidoSelecionado);
    }
}


