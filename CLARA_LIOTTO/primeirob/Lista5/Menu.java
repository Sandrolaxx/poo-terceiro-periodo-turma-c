package CLARA_LIOTTO.Lista5;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
        
    public static void main(String[] args, Cliente cliente, Vendedor vendedor, Loja loja) {
        try (Scanner scanner = new Scanner(System.in)) {
            ProcessarPedido processador = new ProcessarPedido();
            ArrayList<Item> itensCadastrados = new ArrayList<>(); 

            while (true) {
                System.out.println("### Menu ###");
                System.out.println("1. Criar Pedido");
                System.out.println("2. Cadastro de Itens");
                System.out.println("3. Listar Itens");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("### Criar Pedido ###");
                        ArrayList<Item> itensSelecionados = new ArrayList<>();
                        Pedido novoPedido = ProcessarPedido.criarNovoPedido (cliente, vendedor, loja, itensSelecionados); 
                        while (true) {
                            System.out.println("### Itens Disponíveis ###");
                            for (Item item : itensCadastrados) {
                                System.out.println(item.getId() + ". " + item.getNome() + " - " + item.getTipo() + " - R$ " + item.getValor());
                            }
                            System.out.print("Selecione o item desejado (0 para sair): ");
                            int idItem = scanner.nextInt();
                            if (idItem == 0) {
                                break;
                            }
                            for (Item item : itensCadastrados) {
                                if (item.getId() == idItem) {
                                    itensSelecionados.add(item); 
                                    break;
                                }
                            }
                        }
                        processador.processar(novoPedido); 
                        break;
                    case 2:
                        System.out.println("### Cadastro de Itens ###");
                        System.out.print("Digite o nome do item: ");
                        String nomeItem = scanner.next();
                        System.out.print("Digite o tipo do item: ");
                        String tipoItem = scanner.next();
                        System.out.print("Digite o valor do item: ");
                        double valorItem = scanner.nextDouble();
                        Item novoItem = new Item(itensCadastrados.size() + 1, nomeItem, tipoItem, valorItem);
                        itensCadastrados.add(novoItem);
                        System.out.println("Item cadastrado com sucesso!");
                        break;
                    case 3:
                        System.out.println("### Listagem de Itens ###");
                        if (itensCadastrados.isEmpty()) {
                            System.out.println("Não há itens cadastrados.");
                        } else {
                            for (Item item : itensCadastrados) {
                                System.out.println(item.getNome() + " - " + item.getTipo() + " - R$ " + item.getValor());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
                
            }
        }
    }
}