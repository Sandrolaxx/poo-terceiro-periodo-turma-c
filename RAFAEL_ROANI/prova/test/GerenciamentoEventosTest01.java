package RAFAEL_ROANI.prova.test;

import RAFAEL_ROANI.prova.domain.MainFunctions;

import java.util.Scanner;

public class GerenciamentoEventosTest01 {
    public static void main(String[] args) {
        while (true) {
            int opcao = menu();

            switch (opcao) {
                case 1 -> MainFunctions.cadastrarCliente();
                case 2 -> MainFunctions.cadastrarEvento();
                case 3 -> MainFunctions.listarEventos();
                case 4 -> MainFunctions.comprarIngresso();
                case 5 -> MainFunctions.utilizarIngresso();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
            }
        }
    }

    private static int menu() {
        System.out.println("##### Menu #####");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Evento");
        System.out.println("3 - Listar Eventos");
        System.out.println("4 - Comprar Ingresso");
        System.out.println("5 - Utilizar Ingresso");
        System.out.println("0 - Sair");
        System.out.println("##### #### #####");

        System.out.print("Escolha uma opção: ");
        return new Scanner(System.in).nextInt();
    }
}
