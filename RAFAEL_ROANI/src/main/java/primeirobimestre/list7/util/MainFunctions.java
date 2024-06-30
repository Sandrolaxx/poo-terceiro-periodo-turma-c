package primeirobimestre.list7.util;

import primeirobimestre.list7.domain.domains.*;
import primeirobimestre.list7.generated_class.GeneretedClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFunctions {
    private static Long genereteIdOfItemCompra = 0L;

    public static void realizarPedido(Loja loja) {
        if (loja.getItensCadastrados().isEmpty()) {
            System.out.println("ERRO! Não ha itens para comprar, por favor cadastre itens!");
            return;
        }
        List<ItemCompra> listaCompra = new ArrayList<>();
        System.out.println("\n========= Realizar Pedido =========");
        System.out.println("Itens: ");
        listarItens(loja);

        while (true) {
            System.out.print("Selecione um item pelo id: ");
            Long id = new Scanner(System.in).nextLong();
            listaCompra.add(loja.findItemCompraById(id));

            System.out.print("Deseja adicionar mais itens? S/N: ");
            String optionContinueOrNot = new Scanner(System.in).next();
            if (optionContinueOrNot.equalsIgnoreCase("n")) break;
        }

        System.out.println("\nClientes: ");
        listarClientes(loja);
        System.out.print("Escolha o cliente pelo id que esta fazendo a copra: ");
        long posicaoList = new Scanner(System.in).nextLong();
        Cliente cliente = loja.findClienteByPosicaoList(posicaoList);

        System.out.println("\nVendedores: ");
        listarVendedores(loja);
        System.out.print("Escolha o vendedor pelo id que esta fazendo a copra: ");
        posicaoList = new Scanner(System.in).nextLong();
        Vendedor vendedor = loja.findVendedorByPosicaoList(posicaoList);

        String lojaParceira = null;
        System.out.print("Deseja adicionar uma Loja parceira? S/N: ");
        String opcaoLojaParceira = new Scanner(System.in).next();

        if (opcaoLojaParceira.equalsIgnoreCase("S")) {
            System.out.print("Digite o nome da Loja parceira: ");
            lojaParceira = new Scanner(System.in).nextLine();
        }

        ProcessaPedido processaPedido = new ProcessaPedido(loja);
        Pedido pedido = processaPedido.processar(cliente, vendedor, listaCompra, lojaParceira);
        loja.addPedido(pedido);
    }

    public static void vizualizarPedidos(Loja loja) {
        System.out.println("\n========= Pedidos =========");
        loja.getPedidosFeitos().forEach(System.out::println);
        System.out.println("========= ======= =========");
    }

    public static void vizualizarItensCadastrados(Loja loja) {
        if (loja.getItensCadastrados().isEmpty()) {
            System.out.println("Não há Itens cadastrados!");
            return;
        }
        System.out.println("\n========= Itens =========");
        listarItens(loja);
        System.out.println("========= ======= =========");
    }

    private static void listarItens(Loja loja) {
        loja.getItensCadastrados().forEach(System.out::println);
    }

    public static void cadastrarItem(Loja loja) {
        loja.addItem(createItemCompra());
        System.out.println("Item cadastrado com sucesso!");
    }

    private static ItemCompra createItemCompra() {
        System.out.println("\n========= Cadastrar Item =========");
        System.out.print("Nome: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Tipo: ");
        String tipo = new Scanner(System.in).nextLine();
        System.out.print("Valor: ");
        Double valor = new Scanner(System.in).nextDouble();

        return ItemCompra.ItemCompraBuilderLista07.builder()
                .id(genereteIdOfItemCompra++)
                .nome(nome)
                .tipo(tipo)
                .valor(valor)
                .build();
    }

    public static void vizualizarClientesCadastrados(Loja loja) {
        if (loja.getClientes().isEmpty()) {
            System.out.println("Não há Clientes cadastrados!");
            return;
        }
        System.out.println("\n========= Clientes Cadastrados =========");
        listarClientes(loja);
        System.out.println("========= ======= =========");
    }

    private static void listarClientes(Loja loja) {
        int id = 0;
        for (Cliente cliente : loja.getClientes()) {
            System.out.println(id + " - " + cliente);
            id++;
        }
    }

    public static void cadastrarCliente(Loja loja) {
        System.out.println("\n========= Cadastrar Cliente =========");
        System.out.print("Nome: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Idade: ");
        Integer idade = new Scanner(System.in).nextInt();

        Cliente cliente = Cliente.ClienteBuilderLista07.builder()
                .nome(nome)
                .idade(idade)
                .endereco(GeneretedClass.gerarEndereco())
                .build();
    }

    public static void vizualizarVendedoresCadastrados(Loja loja) {
        if (loja.getVendedores().isEmpty()) {
            System.out.println("Não há Vendedores cadastrados!");
            return;
        }
        System.out.println("\n========= Vendedores Cadastrados =========");
        listarVendedores(loja);
        System.out.println("========= ======= =========");
    }

    public static void listarVendedores(Loja loja) {
        int id = 0;
        for (Vendedor vendedor : loja.getVendedores()) {
            System.out.println(id + " - " + vendedor);
            id++;
        }
    }

    public static void cadastrarVendedor(Loja loja) {
        System.out.println("\n========= Cadastrar Vendedor =========");
        System.out.print("Nome: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Idade: ");
        Integer idade = new Scanner(System.in).nextInt();
        System.out.print("Salario base: ");
        Double salarioBase = new Scanner(System.in).nextDouble();
        System.out.print("Salario mes 1: ");
        Double salarioMes1 = new Scanner(System.in).nextDouble();
        System.out.print("Salario mes 2: ");
        Double salarioMes2 = new Scanner(System.in).nextDouble();
        System.out.print("Salario mes 3: ");
        Double salarioMes3 = new Scanner(System.in).nextDouble();

        Vendedor vendedor = Vendedor.VendedorBuilderLista07.builder()
                .nome(nome)
                .idade(idade)
                .salarioBase(salarioBase)
                .salarioRecebido(List.of(salarioMes1, salarioMes2, salarioMes3))
                .endereco(GeneretedClass.gerarEndereco())
                .loja(loja)
                .build();

        loja.addVendedor(vendedor);
    }

    public static void vizualizarGerentesCadastrados(Loja loja) {
        if (loja.getGerentes().isEmpty()) {
            System.out.println("Não há Gerentes cadastrados!");
            return;
        }
        System.out.println("\n========= Gerentes Cadastrados =========");
        loja.getGerentes().forEach(System.out::println);
        System.out.println("========= ======= =========");
    }

    private static void listarGerentes(Loja loja) {
        int id = 0;
        for (Gerente gerente : loja.getGerentes()) {
            System.out.println(id + " - " + gerente);
            id++;
        }
    }

    public static void cadastrarGerente(Loja loja) {
        System.out.println("\n========= Cadastrar Gerente =========");
        System.out.print("Nome: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Idade: ");
        Integer idade = new Scanner(System.in).nextInt();
        System.out.print("Salario base: ");
        Double salarioBase = new Scanner(System.in).nextDouble();
        System.out.print("Salario mes 1: ");
        Double salarioMes1 = new Scanner(System.in).nextDouble();
        System.out.print("Salario mes 2: ");
        Double salarioMes2 = new Scanner(System.in).nextDouble();
        System.out.print("Salario mes 3: ");
        Double salarioMes3 = new Scanner(System.in).nextDouble();

        Gerente gerente = Gerente.GerenteBuilderLista07.builder()
                .nome(nome)
                .idade(idade)
                .salarioBase(salarioBase)
                .salarioRecebido(List.of(salarioMes1, salarioMes2, salarioMes3))
                .endereco(GeneretedClass.gerarEndereco())
                .loja(loja)
                .build();

        loja.addGerente(gerente);
    }
}