package prova.classes.menu;

import java.util.Date;
import java.util.Scanner;

import prova.classes.cliente.Cliente;
import prova.classes.endereco.Endereco;
import prova.classes.eventinho.Eventinho;
import prova.classes.ingresso.Ingresso;
import prova.classes.limpar_console.LimparConsole;

public class Menu {

  public static Scanner lerDados = new Scanner(System.in);
  private static Long umDiaEmMs = 86400000l;
  private static Cliente clientes[] = new Cliente[100];
  private static int quantidadeDeClientesAtual = 0;
  private static Eventinho eventos[] = new Eventinho[50];
  private static int quantidadeDeEventosAtual = 0;

  public static void inciarAplicacao() {
    int escolharDoUsuario;
    do {
      opcoesDoMenu();
      escolharDoUsuario = lerDados.nextInt();
      processarEscolhaDoUsuario(escolharDoUsuario);
    } while (escolharDoUsuario != 6);
    lerDados.close();
  }

  public static void opcoesDoMenu() {
    System.out.println("\n Escolha uma opção");
    System.out.println("1 - Cadastrar evento");
    System.out.println("2 - Listar evento");
    System.out.println("3 - Cadastrar cliente");
    System.out.println("4 - Comprar ingresso");
    System.out.println("5 - Utilizar ingresso");
    System.out.println("6 - Sair");
  }

  public static void processarEscolhaDoUsuario(int opcao) {
    LimparConsole.limparConsole();
    switch (opcao) {
      case 1:
        lerDados.nextLine();
        cadastrarEvento();
        break;
      case 2:
        listarEvento();
        break;
      case 3:
        lerDados.nextLine();
        cadastrarCliente();
        break;
      case 4:
        comprarIngresso();
        break;
      case 5:
        usarIngresso();
        break;
      case 6:
        System.out.println("Fechando o programa");
        break;
      default:
        System.out.println("Opção inválida");
        break;
    }
  }

  public static void cadastrarEvento() {
    System.out.println("Informe o nome do evento");
    String nomeDoEvento = lerDados.nextLine();

    System.out.println("Informe a rua do evento");
    String ruaDoEvento = lerDados.nextLine();

    System.out.println("Informe o estado do evento");
    String estadoDoEvento = lerDados.nextLine();

    System.out.println("Informe a cidade do evento");
    String cidadeDoEvento = lerDados.nextLine();

    System.out.println("Informe o bairro do evento");
    String bairroDoEvento = lerDados.nextLine();

    System.out.println("Informe o númermo da rua do evento");
    String numeroDoEvento = lerDados.nextLine();

    System.out.println("Daqui quantos dia a partir de hoje vai ser o evento (números inteiros!)");
    int diaDoEvento = lerDados.nextInt();

    System.out.println("Quantidade de ingressos disponíveis");
    int totalDeIngressos = lerDados.nextInt();

    Endereco enderecoDoEvento = new Endereco(ruaDoEvento, estadoDoEvento, cidadeDoEvento, bairroDoEvento,
        numeroDoEvento);

    Eventinho novoEventinho = new Eventinho(enderecoDoEvento, nomeDoEvento,
        new Date().getTime() + (diaDoEvento * getUmDiaEmMs()),
        totalDeIngressos);

    setEventos(novoEventinho);
  }

  public static void listarEvento() {
    for (int i = 0; i < eventos.length; i++) {
      if (eventos[i] != null) {
        System.out.println("\n");
        System.out.println("Evento número: " + (i + 1));
        eventos[i].mostrarEvento();
        System.out.println("\n");
      }
    }
  }

  public static void listarCliente() {
    for (int i = 0; i < clientes.length; i++) {
      if (clientes[i] != null) {
        System.out.println("\n");
        System.out.println("Cliente número: " + (i + 1));
        clientes[i].apresentarSe();
        System.out.println("\n");

      }
    }
  }

  public static void cadastrarCliente() {
    System.out.println("Informe o nome do cliente");
    String nomeDoCliente = lerDados.nextLine();

    System.out.println("Informe a rua do cliente");
    String ruaDoCliente = lerDados.nextLine();

    System.out.println("Informe o estado do cliente");
    String estadoDoCliente = lerDados.nextLine();

    System.out.println("Informe a cidade do cliente");
    String cidadeDoCliente = lerDados.nextLine();

    System.out.println("Informe o bairro do cliente");
    String bairroDoCliente = lerDados.nextLine();

    System.out.println("Informe o númermo da rua do cliente");
    String numeroDoCliente = lerDados.nextLine();

    System.out.println("Informe a idade do cliente");
    int idadeDoCliente = lerDados.nextInt();

    Endereco enderecoDoCliente = new Endereco(ruaDoCliente, estadoDoCliente, cidadeDoCliente, bairroDoCliente,
        numeroDoCliente);

    Cliente novoCliente = new Cliente(nomeDoCliente, idadeDoCliente, enderecoDoCliente);

    setClientes(novoCliente);
  }

  public static void comprarIngresso() {
    listarEvento();
    System.out.println("Escolha um evento pelo número antes");
    int eventoIndex = lerDados.nextInt() - 1;
    LimparConsole.limparConsole();
    listarCliente();
    System.out.println("Qual o comprador, esolher pelo número antes");
    int comprador = lerDados.nextInt() - 1;
    if (clientes[comprador] == null || eventos[eventoIndex] == null) {
      System.out.println("Cliente ou evento inválido");
      return;
    }
    if (eventos[comprador].getIngressosDisponiveis() <= 0) {
      System.out.println("Ingressos esgotados");
      return;
    }
    Ingresso novoIngresso = new Ingresso(eventos[eventoIndex]);
    clientes[comprador].comprarIngresso(novoIngresso);
    System.out.println("Ingresso comprado");
  }

  public static void usarIngresso() {
    listarCliente();
    System.out.println("Qual o cliente, esolher pelo número antes");
    int cliente = lerDados.nextInt() - 1;
    if (clientes[cliente] == null) {
      System.out.println("Cliente inválido");
      return;
    }
    clientes[cliente].listarIngressos();
    System.out.println("Qual o ingresso a ser usado, esolher pelo número antes");
    int indexDoIngresso = lerDados.nextInt() - 1;
    clientes[cliente].usarIngresso(indexDoIngresso);

  }

  // getters

  public static Long getUmDiaEmMs() {
    return umDiaEmMs;
  }

  public static int getQuantidadeDeEventosAtual() {
    return quantidadeDeEventosAtual;
  }

  public static int getQuantidadeDeClientesAtual() {
    return quantidadeDeClientesAtual;
  }

  public static Cliente[] getClientes() {
    return clientes;
  }

  public static Eventinho[] getEventos() {
    return eventos;
  }

  // setters

  public static void setQuantidadeDeClientesAtual() {
    quantidadeDeClientesAtual++;
  }

  public static void setClientes(Cliente cliente) {
    System.out.println(quantidadeDeClientesAtual);
    clientes[getQuantidadeDeClientesAtual()] = cliente;
    setQuantidadeDeClientesAtual();
  }

  public static void setEventos(Eventinho evento) {
    System.out.println(getQuantidadeDeEventosAtual());
    eventos[getQuantidadeDeEventosAtual()] = evento;
    setQuantidadeDeEventosAtual();
  }

  public static void setQuantidadeDeEventosAtual() {
    quantidadeDeEventosAtual++;
  }
}
