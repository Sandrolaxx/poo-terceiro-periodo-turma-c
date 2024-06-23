package primeirobi.lista07;

import java.util.Scanner;
import java.util.Date;

public class Menu {

    private static Item[] listaItens = new Item[100];
    private static int nItens;
    private static int nPedidos = 0;

    public static void exibirMenu() {

        Scanner scanner = new Scanner(System.in);

        int escolha;

        Item item = new Item("Cacto", "Planta", 12);
        Item item2 = new Item("Rosa", "Flor", 6);
        listaItens[nItens] = item;
        nItens++;

        item.setId(nItens);

        listaItens[nItens] = item2;
        nItens++;

        item2.setId(nItens);

        do {

            System.out.println();
            System.out.println("<=---=---=>MENU<=---=---=>");
            System.out.println(" [1] Cadastrar Itens ");
            System.out.println(" [2] Listar Itens ");
            System.out.println(" [3] Realizar Pedido ");
            System.out.println(" [0] Sair ");
            System.out.println("<=----------------------=>");
            System.out.print(" -> Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    criarCadastro();
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    fazerPedido();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Por favor, insira uma opção válida!");
                    break;
            }

        } while (escolha != 0);

        scanner.close();
    }

    public static void criarCadastro() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o nome do item: ");
        String nome = scanner.nextLine();

        System.out.print("Insira o tipo do item: ");
        String tipo = scanner.nextLine();

        System.out.print("Insira o valor do item: ");
        double valor = scanner.nextDouble();

        Item item = new Item(nome, tipo, valor);

        System.out.println("Item cadastrado com sucesso: ");
        System.out.println("Nome: " + item.getNome());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Valor: " + item.getValor());

        listaItens[nItens] = item;
        nItens++;

        item.setId(nItens);

    }

    public static void listarItens() {

        for (int i = 0; i < nItens; i++) {
            System.out.print(listaItens[i].getId() + ". " + listaItens[i].getNome());
            System.out.print(" - Valor: " + listaItens[i].getValor() + "R$");
            System.out.println(" - Tipo: " + listaItens[i].getTipo());
        }
    }

    public static void fazerPedido() {

        Scanner scanner = new Scanner(System.in);

        Date dataCriacao = new Date();

        Pedido pedido = new Pedido((nPedidos + 1), dataCriacao, null);
        nPedidos++;
        System.out.println("Qual item deseja incluir? (0 Para sair)");
        while (true) {
            int escolhaItem = scanner.nextInt();
            if (escolhaItem == 0) {
                break;
            }
            if (escolhaItem < 0 || escolhaItem > nItens) {
                System.out.println("Opção inválida. Escolha um item válido.");
                continue;
            }
            Item itemEscolhido = listaItens[escolhaItem - 1];
            pedido.adicionarItem(itemEscolhido);
        }

        pedido.listarPedido();

        double valorTotal = 0;
        for (Item item : pedido.getItens()) {
            if (item != null) {
                valorTotal += item.getValor();
            }
        }

        System.out.println("Valor Total do Pedido: " + valorTotal + "R$");

        pedido.setLoja(Teste.getLojaEx());

        System.out.println("=---=---=Processamento do Pedido=---=---=");
        ProcessarPedido processarPedido = new ProcessarPedido();
        processarPedido.processar(pedido);

    }

}