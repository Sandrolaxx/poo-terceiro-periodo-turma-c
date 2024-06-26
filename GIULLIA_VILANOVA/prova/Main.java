package GIULLIA_VILANOVA.prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static boolean validEntry = false;
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Ingresso> ingressos = new ArrayList<>();
    private static int id = 0;

    public static void main(String[] args) {

        int option = 0;
        int confirm = 0;

        do {
            exibirMenu();
            option = getValidInputInt("Escolha uma opção:", 6);

            switch (option) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarEvento();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    comprarIngresso();
                    break;
                case 5:
                    utilizarIngressoEmEvento();
                    break;
                case 6:
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
        System.out.println("[1] - Cadastrar cliente");
        System.out.println("[2] - Cadastrar Evento");
        System.out.println("[3] - Listar Eventos");
        System.out.println("[4] - Comprar Ingressos do Evento");
        System.out.println("[5] - Utilizar Ingresso em Evento");
        System.out.println("[6] - Sair");
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

    private static Evento cadastrarEvento() {
        System.out.println("\nCadastro de Evento");
        System.out.println("------------------");

        System.out.println("Nome do Evento: ");
        scanner.nextLine();
        String nomeEvento = scanner.nextLine();

        System.out.println("Data do Evento: (dd/mm/aaaa)");
        scanner.nextLine();
        String dataEvento = scanner.nextLine();

        System.out.print("Endereço (bairro, rua, número, complemento, cidade, estado): ");
        scanner.nextLine();
        String enderecoCompleto = scanner.nextLine();
        String[] enderecoSplit = enderecoCompleto.split(", ");
        String bairro = enderecoSplit[0].trim();
        String rua = enderecoSplit[1].trim();
        int numero = Integer.parseInt(enderecoSplit[2].trim());
        String complemento = enderecoSplit[3].trim();
        String cidade = enderecoSplit[4].trim();
        String estado = enderecoSplit[5].trim();
        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero, complemento);


        Evento evento = new Evento(nomeEvento, dataEvento, endereco);
        System.out.println("Evento cadastrado com sucesso!");
        return evento;
    }

    private static void listarEventos() {
        for (Evento evento : eventos) {
            int n = 1;
            System.out.println(n + ". " + evento.getNomeEvento());
            n++;
        }
    }

    private static void comprarIngresso() {
        System.out.println("\nCompra de Ingresso");
        System.out.println("------------------");
        
        System.out.print("Evento: ");
        scanner.nextLine();
        String nomeEvento = scanner.nextLine();

        Evento eventoEncontrado = null;
    
        for (Evento evento : eventos) {
            if (!(evento.getNomeEvento().equals(nomeEvento))) {
                System.out.println("Evento não encontrado.");
                System.out.print("Você precisa cadastrar o evento antes de processar a compra.");
                System.out.println("Retornando ao menu principal.");
                break;
            } else {
                eventoEncontrado = evento;
            }
        }

        System.out.print("Preço do ingresso: ");
        scanner.nextLine();
        double preco = getValidInputDouble("");

        System.out.print("Cliente: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        Cliente clienteEncontrado = null;
    
        for (Cliente cliente : clientes) {
            if (!(cliente.getNome().equals(nome))) {
                System.out.println("Cliente não encontrado.");
                System.out.print("Você precisa cadastrar o cliente antes de processar a compra.");
                System.out.println("Retornando ao menu principal.");
                break;
            } else {
                clienteEncontrado = cliente;
                System.out.println("Compra Processada!");
                Ingresso ingresso = new Ingresso(eventoEncontrado, preco, clienteEncontrado, id++);
                System.out.println("Id do ingresso: " + ingresso.getId());
            }
        }


    }

    private static void utilizarIngressoEmEvento() {
        System.out.println("\nUtilização de Ingresso");
        System.out.println("------------------");
        
        System.out.print("Id do Ingresso: ");
        scanner.nextLine();
        int id = scanner.nextInt();

        int idEncontrado = 0;
    
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId() != id) {
                System.out.println("Ingresso não encontrado.");
                System.out.println("Retornando ao menu principal.");
                break;
            } else {
                idEncontrado = id;
            }
        }
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
}
