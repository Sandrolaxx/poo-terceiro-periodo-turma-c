package ERIKA_SARTORELLI.prova.Menu;
import java.util.ArrayList;
import java.util.Scanner;

import ERIKA_SARTORELLI.prova.Evento.Evento;

@SuppressWarnings("unused")
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ListaEventos listaEventos = new ListaEventos();

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar evento");
            System.out.println("3. Listar eventos");
            System.out.println("4. Comprar ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
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
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        scanner.nextLine(); 
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void cadastrarEvento() {
        scanner.nextLine(); 
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine(); 
        System.out.print("Digite o preço do ingresso: ");
        double precoEvento = scanner.nextDouble();
        Evento evento = new Evento(nomeEvento, precoEvento);
        listaEventos.adicionarEvento(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private void listarEventos() {
        System.out.println("=== Eventos Cadastrados ===");
        listaEventos.listarEventos();
    }

    private void comprarIngresso() {
       
        System.out.println("Funcionalidade de compra de ingresso ainda não implementada.");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ListaEventos getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(ListaEventos listaEventos) {
        this.listaEventos = listaEventos;
    }

}

