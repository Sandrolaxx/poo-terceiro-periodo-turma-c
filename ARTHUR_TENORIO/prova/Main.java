package ARTHUR_TENORIO.prova;

import java.util.Scanner;

public class Main {

    private static GerenciadorDeEventos gerenciador = new GerenciadorDeEventos();

    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente(scanner);
                    break;
                case 2:
                    eventos(scanner);
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    ingresso(scanner);
                    break;
                case 5:
                    utiliza(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Criar Evento");
        System.out.println("3. Listar Eventos");
        System.out.println("4. Comprar Ingresso");
        System.out.println("5. Utilizar Ingresso");
        System.out.println("0. Sair");
        System.out.print("Digite sua opção: ");
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        int cpf  = scanner.nextLine();
        System.out.print("Digite o contato do cliente: ");
        String contato = scanner.nextLine();

        gerenciador.cadastrarCliente(nome, endereco, contato, cpf);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarEvento(Scanner scanner) {
        System.out.print("Digite o nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a data do evento (DD/MM/AAAA): ");
        String data = scanner.nextLine();
        System.out.print("Digite a hora do evento (HH:MM): ");
        String hora = scanner.nextLine();
        System.out.print("Digite o local do evento: ");
        String local = scanner.nextLine();
        System.out.print("Digite a descrição do evento: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o valor do ingresso: ");
        double valorIngresso = scanner.nextDouble();

        gerenciador.cadastrarEvento(nome, data, hora, local, descricao, valorIngresso);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos() {
        System.out.println("\nLista de Eventos:");
        for (Evento evento : gerenciador.getEventos()) {
            System.out.println(evento);
        }
    }

    private static void comprarIngresso(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();

        Cliente cliente = gerenciador.buscarClientePorNome(nomeCliente);
        Evento evento = gerenciador.buscarEventoPorNome(nomeEvento);

        if (cliente != null && evento != null) {
            gerenciador.venderIngresso(cliente, evento);
            System.out.println("Ingresso comprado com sucesso!");
        } else {
            System.out.println("Cliente ou evento não encontrado.");
        }
    }

    private static void utilizarIngresso(Scanner scanner) {
        System.out.print("Digite o código do ingresso: ");
        String codigoIngresso = scanner.nextLine();

        gerenciador.utilizarIngresso(codigoIngresso);
    }
}
 