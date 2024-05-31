package prova;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListarEventos listaEventos = new ListarEventos();

        int opcao;

        do {

            System.out.println("\nMenu de Escolha:");
            System.out.println("[1] - Cadastro de Cliente");
            System.out.println("[2] - Cadastro de Evento");
            System.out.println("[3] - Utilizar Ingresso em Evento");
            System.out.println("[4] - Comprar Ingresso para Evento");
            System.out.println("[5] - Listar Eventos");
            System.out.println("[0] - Sair");

            System.out.print("Digite a opção desejada(Após escolher a opção aperte enter novamente): ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:

                    CadastroCliente cliente = new CadastroCliente();
                    cliente.lerInfoCliente(scanner);
                    cliente.imprimirInfoCliente();
                    break;
                case 2:

                    CadastroEvento evento = new CadastroEvento();
                    evento.lerInfoEvento(scanner);
                    evento.imprimirInfoEvento();
                    listaEventos.adicionarEvento(evento);
                    break;
                case 3:
  
                    listaEventos.listarEventos();
                    System.out.println("Digite o nome do evento para utilizar o ingresso:");
                    String nomeEventoUtilizar = scanner.nextLine();
                    CadastroEvento eventoUtilizar = listaEventos.selecionarEvento(nomeEventoUtilizar);
                    if (eventoUtilizar != null) {
                        CadastroCliente clienteUtilizar = new CadastroCliente();
                        clienteUtilizar.lerInfoCliente(scanner);
                        UtilizarIngresso utilizacao = new UtilizarIngresso();
                        utilizacao.utilizarIngresso(scanner);
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 4:
        
                    listaEventos.listarEventos();
                    System.out.println("Digite o nome do evento para comprar o ingresso:");
                    String nomeEventoComprar = scanner.nextLine();
                    CadastroEvento eventoComprar = listaEventos.selecionarEvento(nomeEventoComprar);
                    if (eventoComprar != null) {
                        CadastroCliente clienteComprar = new CadastroCliente();
                        clienteComprar.lerInfoCliente(scanner);
                        ComprarIngresso compra = new ComprarIngresso();
                        compra.comprarIngresso(scanner);
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 5:

                    listaEventos.listarEventos();
                    break;
                case 0:
   
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
