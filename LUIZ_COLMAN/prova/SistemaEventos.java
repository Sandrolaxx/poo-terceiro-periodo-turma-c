package LUIZ_COLMAN.prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEventos {
    private List<Cliente> clientes;
    private List<Evento> eventos;

    public SistemaEventos() {
        this.clientes = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        this.clientes.add(cliente);
    }

    public void cadastrarEvento(String nome, String data, String local) {
        Evento evento = new Evento(nome, data, local);
        this.eventos.add(evento);
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println("Nome: " + evento.getNome() + ", Local: " + evento.getLocal());
        }
    }

    public void comprarIngresso(String nomeEvento, String nomeCliente) {
        Evento evento = eventos.stream()
                .filter(e -> e.getNome().equals(nomeEvento))
                .findFirst()
                .orElse(null);

        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equals(nomeCliente))
                .findFirst()
                .orElse(null);

        if (evento != null && cliente != null) {
            evento.adicionarParticipante(cliente);
            System.out.println("Ingresso comprado com sucesso!");
        } else {
            System.out.println("Evento ou cliente não encontrado.");
        }
    }

    public void utilizarIngresso(String nomeEvento, String nomeCliente) {
        Evento evento = eventos.stream()
                .filter(e -> e.getNome().equals(nomeEvento))
                .findFirst()
                .orElse(null);
    
        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equals(nomeCliente))
                .findFirst()
                .orElse(null);
    
        if (evento != null && cliente != null) {
            boolean ingressoUtilizado = evento.getParticipantes().remove(cliente);
            if (ingressoUtilizado) {
                System.out.println("Ingresso utilizado com sucesso!");
            } else {
                System.out.println("Cliente não está na lista de participantes do evento.");
            }
        } else {
            System.out.println("Evento ou cliente não encontrado.");
        }
    }
    

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 = Cadastrar Cliente");
            System.out.println("2 = Cadastrar Evento");
            System.out.println("3 = Listar eventos");
            System.out.println("4 = Comprar Ingresso");
            System.out.println("5 = Utilizar ingresso");
            System.out.println("6 = Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.next();
                    System.out.print("Email do cliente: ");
                    String emailCliente = scanner.next();
                    cadastrarCliente(nomeCliente, emailCliente);
                    break;
                case 2:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.next();
                    System.out.print("Data do evento: ");
                    String dataEvento = scanner.next();
                    System.out.print("Local do evento: ");
                    String localEvento = scanner.next();
                    cadastrarEvento(nomeEvento, dataEvento, localEvento);
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    System.out.print("Nome do evento: ");
                    nomeEvento = scanner.next();
                    System.out.print("Nome do cliente: ");
                    nomeCliente = scanner.next();
                    comprarIngresso(nomeEvento, nomeCliente);
                    break;
                case 5:
                    System.out.print("Nome do evento: ");
                    nomeEvento = scanner.next();
                    System.out.print("Nome do cliente: ");
                    nomeCliente = scanner.next();
                    utilizarIngresso(nomeEvento, nomeCliente);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        sistema.menu();
    }
}

