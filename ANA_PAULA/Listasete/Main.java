package Listasete;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        Cliente cliente = new Cliente("Ana", 18, "Cascavel", "Rua das Petúnias");
        Vendedor vendedor = new Vendedor();
        Gerente gerente = new Gerente("Loja Central", 3000, new float[]{3000, 3200, 3300});

        Item[] itens = {
            new Item(1, "Camisa", "Vestuário", 50.0),
            new Item(2, "Calça", "Vestuário", 80.0)
        };

        int opcao;
        do {
            menu.exibirMenu();
            opcao = menu.lerOpcao();
            switch (opcao) {
                case 1:
                    cadastrarItem();
                    break;
                case 2:
                    listarItens(itens);
                    break;
                case 3:
                    realizarPedido(cliente, vendedor, itens, scanner);
                    break;
                case 4:
                    System.out.println("Até maisss!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
        
        menu.fecharMenu();
        scanner.close();
    }

    private static void cadastrarItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de novo item:");
        
        System.out.print("ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        
        System.out.print("Tipo do item: ");
        String tipo = scanner.nextLine();
        
        System.out.print("Valor do item: ");
        double valor = scanner.nextDouble();
        
        Item novoItem = new Item(id, nome, tipo, valor);
        System.out.println("Novo item cadastrado com sucesso:\n");
        novoItem.gerarDescricao();
    }
    

    private static void listarItens(Item[] itens) {
        System.out.println("Itens cadastrados:");
        for (Item item : itens) {
            item.gerarDescricao();
            System.out.println();
        }
    }

    private static void realizarPedido(Cliente cliente, Vendedor vendedor, Item[] itens, Scanner scanner) {
        System.out.println("Informações do Cliente:");
        cliente.apresentarse();
        System.out.println();

        System.out.println("Informações do Vendedor:");
        vendedor.apresentarse();
        System.out.println();

        System.out.println("Selecione o número do item que deseja comprar:");
        int escolhaItem = scanner.nextInt();
        Item itemEscolhido = null;
        for (Item item : itens) {
            if (item.getId() == escolhaItem) {
                itemEscolhido = item;
                break;
            }
        }
        

        ProcessaPedido processador = new ProcessaPedido();
        Date dataCriacao = new Date();
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000);
        System.out.println("Processando pedido...");
        processador.processar(1, dataCriacao, null, dataVencimentoReserva, cliente, vendedor, "Minha Loja", itemEscolhido);

    }
    
}
