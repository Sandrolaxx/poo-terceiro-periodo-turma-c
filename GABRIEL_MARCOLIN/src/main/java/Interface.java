import java.util.Scanner;

public class Interface {
    Item[] itens = new Item[10];

    public static void main(String[] args) {
        int escolha = 0;
        Scanner sc = new Scanner(System.in);
        ProcessaPedido processar = new ProcessaPedido();
        Pedido pedido = new Pedido();

        System.out.println("Olá, o que você deseja fazer?");
        System.out.println("[1]Cadastrar um novo item\n[2]Listar itens\n[3]Criar um pedido\n[4]Sair");
        escolha = sc.nextInt();
        sc.nextLine();

        do {

            switch (escolha) {
                case 1:
                    processar.criarItem();

                    break;
                case 2:
                    processar.listarItensExistentes();
                    break;
                case 3:
                    processar.criarPedido();
                    break;
                case 4:
                    System.out.println("Até logo!!!");
                    break;
                default:
                    System.out.println("Esta não é uma opção válida.");
            }

            System.out.println("O que você deseja fazer a seguir?");
            System.out.println("[1]Cadastrar um novo item\n[2]Listar itens\n[3]Criar um pedido\n[4]Sair");
            escolha = sc.nextInt();
            sc.nextLine();

        } while (escolha != 1 || escolha != 2 || escolha != 3);
    }
}
