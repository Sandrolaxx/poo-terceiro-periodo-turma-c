package KAUE_ANDRADE_PADILHA.prova;

import java.util.Scanner;

public class Main {
  private static int opcao;
  private static Evento[] eventos = new Evento[3]; // Cabe 3 Eventos
  private static Cliente[] clientes = new Cliente[3]; // Cabe 3 Clientes
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    int idEvento = 0;
    while (true) {
      menu();

      System.out.print("Digite a opção desejada: ");
      opcao = new Scanner(System.in).nextInt();

      if (opcao == 6) {
        System.out.println("Encerrando...");
        break;
      }

      switch (opcao) {
        case 1: // Cadastro de Cliente
          Cliente clienteCadastrado = new Cadastro().cadastrarCliente();
          for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
              clientes[i] = clienteCadastrado;
              System.out.println("Evento cadastrado com sucesso!");
              break;
            }
          }
          System.out.println("Cliente cadastrado com sucesso!");
          break;
        case 2: // Cadastro de Evento
            Evento eventoCadastrado = new Cadastro().cadastrarEvento();
            for (int i = 0; i < eventos.length; i++) {
              if (eventos[i] == null) {
                eventos[i] = eventoCadastrado;
                eventos[i].setId(idEvento++);
                System.out.println("Evento cadastrado com sucesso!");
                break;
              }
            }
          break;
        case 3: // Listar Eventos
            System.out.println("Eventos cadastrados:");
            if (eventos.length == 0) { System.out.println("Nenhum evento cadastrado"); }
            listarEventos();
          break;
        case 4: // Comprar Ingresso do Evento
            System.out.println("\nEventos disponíveis:");
            listarEventos();
            System.out.print("Digite o ID do evento que deseja comprar o ingresso: ");
            idEvento = new Scanner(System.in).nextInt();
            for (int i = 0; i < eventos.length; i++) {
              if (eventos[i] != null && eventos[i].getId() == idEvento) {
                System.out.print("Ingresso comprado com sucesso!");
                System.out.println(", ID do ingresso: " + idEvento);
                eventos[i].setIngressoComprado(true);
                break;
              }
            }
          break;
        case 5: // Utilizar Ingresso em Evento
            System.out.println("\nEventos disponíveis:");
            listarEventos();
            System.out.print("Digite o ID do evento que deseja utilizar o ingresso: ");
            idEvento = new Scanner(System.in).nextInt();
            for (int i = 0; i < eventos.length; i++) {
              if (eventos[i] != null && eventos[i].getId() == idEvento) {
                if (eventos[i].getIngressoComprado()) {
                  System.out.println("Ingresso utilizado com sucesso!");
                  eventos[i].setIngressoComprado(false);
                } else {
                  System.out.println("Você não possui um ingresso para este evento!");
                }
                break;
              }
            }
            break;
          case 7: // listar Clientes (Bônus)
            System.out.println("Clientes cadastrados:");
            if (clientes.length == 0) { System.out.println("Nenhum cliente cadastrado"); }
            listarClientes();
            break;
        default:
          System.out.println("Opção inválida");
          break;
      }
    }
  }

  public static void menu () {
    System.out.println("1 - Cadastro de Cliente");
    System.out.println("2 - Cadastro de Evento");
    System.out.println("3 - Listar Eventos");
    System.out.println("4 - Comprar Ingresso do Evento");
    System.out.println("5 - Utilizar Ingresso em Evento");
    System.out.println("6 - Sair");
    System.out.println("7 - Listar Clientes (Bônus)");
  }

  public static void listarEventos() {
    for (int i = 0; i < eventos.length; i++) {
      if (eventos[i] != null) {
        System.out.print("ID: " + eventos[i].getId());
        System.out.print(", Nome: " + eventos[i].getNome());
        System.out.print(", Tipo: " + eventos[i].getTipo());
        System.out.println(", Data: " + eventos[i].getData());
      }
    }
    System.out.println("");
  }

  public static void listarClientes() {
    for (int i = 0; i < clientes.length; i++) {
      if (clientes[i] != null) {
        System.out.print("Nome: " + clientes[i].getNome());
        System.out.println(", CPF: " + clientes[i].getCpf());
      }
    }
    System.out.println("");
  }
}