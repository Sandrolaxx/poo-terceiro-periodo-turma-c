package EDUARDA_GABRIELI_KACPRZAK.prova;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        CadastroCliente cadastro = new CadastroCliente();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarClientes();
                    break;
                case 2:
                    cadastrarEventos();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                  
                    break;
                case 5:
                   
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scan.close();
    }
    private static void exibirMenu() {
        System.out.println("\nSistema de Cadastro de Eventos");
        System.out.println("-----------------------------");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Evento");
        System.out.println("3. Listar Eventos");
        System.out.println("4. Comprar Ingresso");
        System.out.println("5. Utilizar Ingresso");
        System.out.println("6. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static void listarEventos() {
        throw new UnsupportedOperationException("Unimplemented method 'listarEventos'");
    }

    private static void cadastrarEventos() {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarEventos'");
    }

    private static void cadastrarClientes() {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarClientes'");
    }

}
