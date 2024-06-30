package bimestre_1.prova;
import java.util.Scanner;

public class Main {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
       GestorEvento gestorEventos = new GestorEvento();

       boolean executando = true;
       while (executando) {
           System.out.println("\n### Menu ###");
           System.out.println("1. Cadastrar novo cliente");
           System.out.println("2. Cadastrar novo evento");
           System.out.println("3. Listar eventos que já ocorreram");
           System.out.println("4. Comprar ingresso");
           System.out.println("5. Inserir ingresso");
           System.out.println("6. Sair");
           System.out.print("Escolha uma ação por gentileza: ");

           int opcao = Integer.parseInt(scanner.nextLine());
           switch (opcao) {
               case 1:
                   Cliente novoCliente = Cliente.cadastrarNovoCliente(scanner);
                   System.out.println("------------------------------ ");
                   System.out.println("CLIENTE FOI CADASTRADO, OBRIGADO PELA PREFERÊNCIA!");
                   System.out.println(" ");
                   novoCliente.exibirDadosCliente();
                   break;
               case 2:
                   Evento novoEvento = Evento.cadastrarNovoEvento(scanner);
                   gestorEventos.adicionarEvento(novoEvento);
                   System.out.println("Evento cadastrado, boas festas!");
                   novoEvento.exibirDadosEvento();
                   break;
               case 3:
                   gestorEventos.listarEventos();
                   break;
               case 4:
                   gestorEventos.comprarIngresso(scanner);
                   break;
               case 5:
                   gestorEventos.utilizarIngresso(scanner);
                   break;
               case 6:
                   executando = false;
                   System.out.println("Saindo...");
                   break;
               default:
                   System.out.println(" ");
                   System.out.println("Essa opção não existe campeão, tente denovo pfv!");
                   System.out.println("-----------------------");
           }
       }

       scanner.close();
   }
}

