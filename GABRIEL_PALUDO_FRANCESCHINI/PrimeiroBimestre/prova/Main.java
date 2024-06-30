package GABRIEL_PALUDO_FRANCESCHINI.prova;

import java.util.Scanner;

import GABRIEL_PALUDO_FRANCESCHINI.prova.src.AnaCastelaEventos;
import GABRIEL_PALUDO_FRANCESCHINI.prova.src.Clientes;
import GABRIEL_PALUDO_FRANCESCHINI.prova.src.Eventos;
import GABRIEL_PALUDO_FRANCESCHINI.prova.src.IngressoComprado;

public class Main {

  public static void main(String[] args) {
    AnaCastelaEventos eventosAnaCastela = new AnaCastelaEventos("Ana", "21312389");
    Scanner scanner = new Scanner(System.in);


    int calculator;
    do {
      System.out.println("Eventos da Ana castela:");
      System.out.println("[1] Cadastrar cliente");
      System.out.println("[2] Cadastrar evento");
      System.out.println("[3] Listar eventos");
      System.out.println("[4] Comprar ingressos");
      System.out.println("[5] Utilizar ingresso");
      System.out.println("[6] Sair");
      System.out.println("Selecione uma opção:");
      calculator = scanner.nextInt();

      switch (calculator) {
        case 1:
        cadastrarCliente(eventosAnaCastela, scanner);
        break;
        case 2:
        cadastrarEvento(eventosAnaCastela, scanner);
        break;
        case 3:
        listarEventos(eventosAnaCastela);
        break;
        case 4:
        }
      } while (calculator != 6);
      scanner.close();
    }
    

    private static void cadastrarCliente(AnaCastelaEventos AnaCastelaEventos, Scanner scanner) {
      System.out.println("Digite o nome do cliente:");
      String nomeClienteArray = scanner.next();
      Clientes novoCliente = new Clientes(AnaCastelaEventos.getClientes().size() + 1, nomeClienteArray);
      AnaCastelaEventos.getClientes().add(novoCliente);
      System.out.println("Cliente cadastrado.");
    }

    private static void cadastrarEvento(AnaCastelaEventos AnaCastelaEventos, Scanner scanner) {
      System.out.println("Digite o nome do evento:");
      String nomeEventoArray = scanner.next();
      System.out.println("Digite a cidade do evento:");
      String cidadeArray = scanner.next();
      System.out.println("Digite a rua do evento:");
      String ruaArray = scanner.next();
      System.out.println("Digite o número do local do evento:");
      int numeroArray = scanner.nextInt();
      System.out.println("Digite o dia do evento:");
      int diaEventoArray = scanner.nextInt();
      System.out.println("Digite o número do mês:");
      int mesEventoArray = scanner.nextInt();
      
        if ((diaEventoArray>0 && diaEventoArray<32) && (mesEventoArray>0 && mesEventoArray<13)) {
          Eventos novoEvento = new Eventos(AnaCastelaEventos.getEventos().size() + 1, ruaArray, numeroArray, cidadeArray, nomeEventoArray, diaEventoArray, mesEventoArray);
          AnaCastelaEventos.getEventos().add(novoEvento);
          System.out.println("Evento cadastrado com sucesso!\n");
          return;
        } else {
          System.out.println("Data inválida, evento não cadastrado.\n");
        }
    }
    
    private static void listarEventos(AnaCastelaEventos AnaCastelaEventos) {
      System.out.println("Eventos cadastrados:");
      for (Eventos eventos : AnaCastelaEventos.getEventos()) {
        System.out.println("Evento: " + eventos.getNomeEvento() + " - Dia: " + eventos.getDiaEvento() + " - Mês: " + eventos.getMesEvento() + " - Rua: " + eventos.getRua() + ", Nº:" + eventos.getNumero() + ", - " + eventos.getCidade());}
    }

    private static void comprarIngresso(AnaCastelaEventos AnaCastelaEventos, IngressoComprado IngressoComprado, Scanner scanner) {
      System.out.println("O ingresso custa 45 reais.");
      System.out.println("Selecione o ID do evento:");
      for (Eventos eventos : AnaCastelaEventos.getEventos()) {
        System.out.println("Nome: " + eventos.getNomeEvento() + " - ID: " + eventos.getIdEvento());
      }
      int idEventoEscolhido = scanner.nextInt();

      System.out.println("Insira o ID do cliente que vai comprar o ingresso:");
      for (Clientes clientes : AnaCastelaEventos.getClientes()) {
        System.out.println("Nome: " + clientes.getNomeCliente() + " - ID: " + clientes.getIdCliente());
    }
    int idClienteEscolhido = scanner.nextInt();
    IngressoComprado = new GABRIEL_PALUDO_FRANCESCHINI.prova.src.IngressoComprado(idClienteEscolhido, idEventoEscolhido);
    IngressoComprado.getIngressoComprados().add(IngressoComprado);
      System.out.println("Cliente cadastrado.");
    }

}