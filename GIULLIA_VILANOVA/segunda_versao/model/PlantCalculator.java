package segunda_versao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import segunda_versao.model.Cliente;
import segunda_versao.model.Item;
import segunda_versao.model.Pedido;
import segunda_versao.model.ProcessaPedido;
import segunda_versao.model.Vendedor;

public class PlantCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Item> itens = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Vendedor> vendedores = new ArrayList<>();
    private static boolean validEntry = false;

    public static void main(String[] args) {
        int option = 0;
        int confirm = 0;

        do {
            exibirMenu();
            option = getValidInputInt("Escolha uma opção:", 5);

            switch (option) {
                case 1:
                    criarPedido();
                    break;
                case 2:
                    cadastrarItem();
                    break;
                case 3:
                    listarItens();
                    break;
                case 4:
                    listarPedidos();
                    break;
                case 5:
                    confirm = getValidInputInt("Você realmente deseja fechar a aplicação?\n[1] - Sim\n[2] - Não", 2);
                    switch (confirm) {
                        case 1:
                            System.out.println("Fechando aplicação.");
                            break;
                        case 2:
                            validEntry = true;
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (!(option == 5 && confirm == 1));

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("[1] - Criar pedido");
        System.out.println("[2] - Cadastrar Item");
        System.out.println("[3] - Listar Itens");
        System.out.println("[4] - Listar Pedidos");
        System.out.println("[5] - Sair");
    }

    private static int getValidInputInt(String prompt) {
        int input = 0;
        validEntry = false;

        while (!validEntry) {
            System.out.println(prompt);

            try {
                input = scanner.nextInt();
                validEntry = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Você precisa digitar um número inteiro.");
                scanner.nextLine();
            }
        }
        return input;
    }

    private static int getValidInputInt(String prompt, int maxOption) {
        int input = getValidInputInt(prompt);

        while (input < 1 || input > maxOption) {
            System.out.println("Opção inválida, tente novamente.");
            input = getValidInputInt(prompt);
        }

        return input;
    }

    private static double getValidInputDouble(String prompt) {
        double input = 0.0;
        validEntry = false;

        while (!validEntry) {
            System.out.println(prompt);

            try {
                input = scanner.nextDouble();
                validEntry = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Você precisa digitar um número decimal.");
                scanner.nextLine();
            }
        }

        return input;
    }
    
    private static void cadastrarItem() {
        System.out.println("\nCadastro de Itens");
        System.out.println("------------------");
        int quantidadeItens = getValidInputInt("Quantidade de itens a serem cadastrados:");
    
        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println("\nItem " + (i + 1));
            scanner.nextLine();
            System.out.print("Nome: ");
            String nomeItem = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Tipo: ");
            String tipoItem = scanner.nextLine();
            scanner.nextLine();
            double valorItem = getValidInputDouble("Valor:");
    
            Item item = new Item(nomeItem, tipoItem, valorItem);

            itens.add(item);
        }
    
        System.out.println("Itens cadastrados com sucesso!");
    }

    private static void criarPedido() {
        System.out.println("\nCriação de pedidos");
        System.out.println("------------------");
        
        System.out.print("Cliente: ");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
    
        Cliente clienteEncontrado = null;
    
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }
    
        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
    
            System.out.print("Deseja cadastrar o Cliente antes de criar o pedido? [1] Sim [2] Não: ");
            int opcao = getValidInputInt("", 2);
    
            if (opcao == 1) {
                cadastrarCliente();
            } else {
                System.out.println("Retornando ao menu principal.");
            }
        }

        System.out.print("Vendedor: ");
        scanner.nextLine();
        String nomeVentedor = scanner.nextLine();
    
        Vendedor vendedorEncontrado = null;
    
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equals(nomeVentedor)) {
                vendedorEncontrado = vendedor;
                break;
            }
        }
    
        if (vendedorEncontrado == null) {
            System.out.println("Vendedor não encontrado.");
    
            System.out.print("Deseja cadastrar o vendedor antes de criar o pedido? [1] Sim [2] Não: ");
            int opcao = getValidInputInt("", 2);
    
            if (opcao == 1) {
                cadastrarVendedor();
            } else {
                System.out.println("Retornando ao menu principal.");
            }
        }

        System.out.print("Item: ");
        String nomeItem = scanner.nextLine();
    
        Item itemEncontrado = null;
    
        for (Item item : itens) {
            if (item.getNome().equals(nomeItem)) {
                itemEncontrado = item;
                break;
            }
        }
    
        if (itemEncontrado != null) {
            System.out.println("Item já cadastrado:");
            System.out.println("Nome: " + itemEncontrado.getNome());
            System.out.println("Tipo: " + itemEncontrado.getTipo());
            System.out.println("Valor unitário (R$): " + itemEncontrado.getValor());
    
            System.out.print("Deseja adicionar o item ao pedido? [1] Sim [2] Não: ");
            int opcao = getValidInputInt("", 2);
    
            if (opcao == 1) {

                System.out.println("Item adicionado ao pedido!");
            } else {
                System.out.println("Retornando ao menu principal.");
            }
        } else {
            System.out.println("Item não encontrado.");
    
            System.out.print("Deseja cadastrar o item antes de criar o pedido? [1] Sim [2] Não: ");
            int opcao = getValidInputInt("", 2);
    
            if (opcao == 1) {
                cadastrarItem();
            } else {
                System.out.println("Retornando ao menu principal.");
            }
        }

        long id = pedidos.size() + 1;

        Pedido pedido = new Pedido(id, clienteEncontrado, itemEncontrado);
    }
    
    private static Cliente cadastrarCliente() {
        System.out.println("\nCadastro de Cliente");
        System.out.println("------------------");
        System.out.println("Nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        int idade = getValidInputInt("Idade:");
        System.out.print("Endereço (rua, número, complemento, cidade, estado): ");
        scanner.nextLine();
        String enderecoCompleto = scanner.nextLine();
        String[] enderecoSplit = enderecoCompleto.split(", ");
        String rua = enderecoSplit[0].trim();
        int numero = Integer.parseInt(enderecoSplit[1].trim());
        String complemento = enderecoSplit[2].trim();
        String cidade = enderecoSplit[3].trim();
        String estado = enderecoSplit[4].trim();
        Endereco endereco = new Endereco(estado, cidade, "", rua, numero, complemento);

        Cliente cliente = new Cliente(nome, idade, endereco);
        System.out.println("Cliente cadastrado com sucesso!");
        return cliente;
    }

    private static Vendedor cadastrarVendedor() {
        System.out.println("\nCadastro de Vendedor");
        System.out.println("------------------");
        System.out.print("Nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        int idade = getValidInputInt("Idade:");
        System.out.print("Endereço (rua, número, complemento, cidade, estado): ");
        scanner.nextLine();
        String enderecoCompleto = scanner.nextLine();
        String[] enderecoSplit = enderecoCompleto.split(", ");
        String rua = enderecoSplit[0].trim();
        int numero = Integer.parseInt(enderecoSplit[1].trim());
        String complemento = enderecoSplit[2].trim();
        String cidade = enderecoSplit[3].trim();
        String estado = enderecoSplit[4].trim();
        Endereco endereco = new Endereco(estado, cidade, "", rua, numero, complemento);

        Vendedor vendedor = new Vendedor(nome, idade, endereco);
        System.out.println("Cliente cadastrado com sucesso!");
        return vendedor;
    }

    private static void listarItens() {
        int n = 1;
        for (Item item : itens) {
            System.out.println(n + ". " + item.getNome());
            n++;
        }
    }

    private static void listarPedidos() {
        int n = 1;
        for (Pedido pedido : pedidos) {
            System.out.println(n + ". Pedido ID: " + pedido.getId());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Itens:");
            for (Item item : pedido.getItens()) {
                System.out.println("  - " + item.getNome() + " (R$" + item.getValor() + ")");
            }
            System.out.println("\n");
            n++;
        }
    }
}
