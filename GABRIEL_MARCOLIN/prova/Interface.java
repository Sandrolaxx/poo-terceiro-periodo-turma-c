package GABRIEL_MARCOLIN.prova;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {

        ListaEventos eventos = new ListaEventos();
        Cliente clientes = new Cliente();

        int escolha = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá, o que você deseja fazer?");
        System.out.println("[1]Cadastrar um cliente\n[2]Cadastrar evento\n[3]Listar eventos");
        System.out.println("[4]Comprar um ingresso\n[5]Utilizar seu ingresso\n[6]Sair");
        escolha = sc.nextInt();
        sc.nextLine();

        do {

            switch (escolha) {
                case 1:
                    clientes.criarCliente();
                    break;
                case 2:
                    eventos.criarEventos();
                    break;
                case 3:
                    eventos.listarEventos();
                    break;
                case 4:
                    eventos.comprarIngresso();
                    break;
                case 5:
                    eventos.utilizarIngresso();
                    break;
                case 6:
                    System.out.println("Até logo!!!");
                    break;
                default:
                    System.out.println("Esta não é uma opção válida.");
            }

            System.out.println("[1]Cadastrar um cliente\n[2]Cadastrar evento\n[3]Listar eventos");
            System.out.println("[4]Comprar um ingresso\n[5]Utilizar seu ingresso\n[6]Sair");
            escolha = sc.nextInt();
            sc.nextLine();

        } while (escolha != 1 || escolha != 2 || escolha != 3);
    }
}