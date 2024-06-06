package PrimeiroB.Dona_Gabi.Myy_Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Endereco endereco = new Endereco("PR", "Cascavel", "Neva", "Rua Marechal Floriano", 1748, "casa");
        Cliente cliente = new Cliente("Maria", 18, endereco);
        List<Item> listaItens = new ArrayList<>(); 

        ProcessaPedido processaPedido = new ProcessaPedido();

        int opcao;
        do {
            System.out.println();
            System.out.println("=== MENU ===");
            System.out.println("1. Realizar pedido");
            System.out.println("2. Cadastro de itens");
            System.out.println("3. Listar itens");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o item desejado:");
                    for (Item item : listaItens) {
                        System.out.println(item.getId() + ". " + item.getNome());
                    }
                    int escolha = scanner.nextInt();
                    scanner.nextLine(); 

                    Item itemEscolhido = null;
                    for (Item item : listaItens) {
                        if (item.getId() == escolha) {
                            itemEscolhido = item;
                            break;
                        }
                    }

                    if (itemEscolhido != null) {
                        System.out.println("Informe o nome da empresa parceira:");
                        String empresaParceira = scanner.nextLine();

                        Pedido pedido = processaPedido.processaPedido(cliente, new Item[]{itemEscolhido}, empresaParceira);
                        processaPedido.confirmarPagamento(pedido);

                        System.out.println();
                        System.out.println("==== informações do pedido ====");
                        System.out.println("Valor Total do Pedido: " + pedido.calcularValorTotal());
                        System.out.println("Data de Vencimento da Reserva: " + pedido.getDataVencimentoReserva());
                        System.out.println();
                    }
                    break;
                case 2:
                    cadastrarItem(scanner, listaItens);
                    break;
                case 3:
                    listarItens(listaItens);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarItem(Scanner scanner, List<Item> listaItens) {
        System.out.println();
        System.out.println("=== CADASTRO DE ITENS ===");
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo do item: ");
        String tipo = scanner.nextLine();
        System.out.print("Valor do item: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        int novoId = listaItens.size() + 1; 
        Item novoItem = new Item(novoId, nome, tipo, valor);
        listaItens.add(novoItem);
        System.out.println("Item cadastrado com sucesso!");
    }

    private static void listarItens(List<Item> listaItens) {
        System.out.println();
        System.out.println("=== LISTA DE ITENS ===");
        if (listaItens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (Item item : listaItens) {
                System.out.println("ID: " + item.getId() + ", Nome: " + item.getNome() + ", Tipo: " + item.getTipo() + ", Valor: " + item.getValor());
            }
        }
    }
}