package PrimeiroB.Ana_Castela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Evento> listaEventos = new ArrayList<>();


        int opcao;
        do {
            System.out.println();
            System.out.println("=== MENU ====");
            System.out.println("1. Cadastro de cliente.");
            System.out.println("2. Cadastro de evento");
            System.out.println("3. Listar eventos");
            System.out.println("4. Comprar ingresso do evento");
            System.out.println("5. Utilizar ingresso em evento");
            System.out.println("0. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner, listaClientes);
                    break;
            
                case 2:
                    cadastrarEvento(scanner, listaEventos);
                    break;
                    
                case 3:
                    listarEventos(listaEventos);
                    break;

                case 4:
                    break;
                
                case 5:
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

    private static void cadastrarCliente(Scanner scanner, List
        <Cliente> listaClientes) {
        System.out.println();
        System.out.println("=== CADASTRO DE CLIENTE ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        Integer idade = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, idade, cpf);
        listaClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarEvento(Scanner scanner, List<Evento> listaEventos) {
        System.out.println();
        System.out.println("=== CADASTRO DE EVENTO ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cantor: ");
        String cantor = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Valor: ");
        Double valor = scanner.nextDouble();
        scanner.nextLine(); 

        Evento novoEvento = new Evento(nome, cantor, tipo, valor);
        listaEventos.add(novoEvento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos(List<Evento> listaEventos) {
        System.out.println();
        System.out.println("=== LISTA DE EVENTOS ===");
        if (listaEventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
           for (Evento evento : listaEventos) {
                System.out.println("Nome: " + evento.getNome() + ", Cantor: " + evento.getCantor() + ", Tipo: " + evento.getTipo() + ", Valor: " + evento.getValor());
            }
        }
    }
}