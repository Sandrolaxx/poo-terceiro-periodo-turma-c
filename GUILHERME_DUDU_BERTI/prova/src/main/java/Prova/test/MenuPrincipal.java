package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.test;

import java.util.Scanner;

import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.utils.MainFunctions;

public class MenuPrincipal {
    public static void main(String[] args) {
        int opcaoMenu;

        while (true) {
            System.out.println("\n\nMenu Eventos: ");
            System.out.println("-----------------");

            System.out.println("1. Cadastrar Novo Cliente");
            System.out.println("2. Cadastrar Novo Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Listar Ingressos Comprados");
            System.out.println("6. Utilizar Ingresso");
            System.out.println("0. Sair do Sistema");

            System.out.print("Digite sua opção: ");

            opcaoMenu = new Scanner(System.in).nextInt();
            if (opcaoMenu == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }
            switch (opcaoMenu) {
                case 1 -> MainFunctions.cadastrarCliente();
                case 2 -> MainFunctions.cadastrarEvento();
                case 3 -> MainFunctions.listarEventos();
                case 4 -> MainFunctions.comprarIngresso();
                case 5 -> MainFunctions.listarIngressos();
                case 6 -> MainFunctions.utilizarIngresso();
                default -> System.out.println("Opcão Inválida...");
            }
        }
    }
}
