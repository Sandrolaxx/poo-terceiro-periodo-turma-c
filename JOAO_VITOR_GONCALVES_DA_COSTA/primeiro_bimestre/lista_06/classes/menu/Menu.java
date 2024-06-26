package lista_06.classes.menu;

import java.util.Date;
import java.util.Scanner;

import lista_06.classes.item.Item;
import lista_06.classes.pedido.Pedido;
import lista_06.classes.processa_pedido.ProcessaPedido;
import lista_06.classes.test.Teste;

public class Menu {
  private static int userOption;
  public static int itensSalvosLenght = 50;
  public static int itensSalvosPosicaoAtual = 0;
  public static Item[] itensSalvos = new Item[itensSalvosLenght];
  public static int pedidosIds = 0;
  public static Pedido[] pedidos = new Pedido[100];
  public static Scanner entrarDados = new Scanner(System.in);
  public static Long umDiaEmMs = 86400000l;

  public static void iniciarMenu() {

    do {
      menuOptions();
      setUserOption(entrarDados.nextInt());
      processarEscolhaDoUsuario(getUserOption());
    } while (getUserOption() != 6);

    entrarDados.close();
  }

  public static void iniciarVendedor() {
    Teste.vendedores_03.adicionarSalarios(1250, 1423, 1432, 1234);
  }

  private static void menuOptions() {
    System.out.println("\n Escolha uma opção");
    System.out.println("1 - Criar pedido");
    System.out.println("2 - Processar pedido");
    System.out.println("3 - Cadastrar itens");
    System.out.println("4 - Listar itens");
    System.out.println("5 - Cancelar um pedido");
    System.out.println("6 - Sair");
  }

  public static void setUserOption(int opcao) {
    userOption = opcao;
  }

  public static int getUserOption() {
    return userOption;
  }

  public static void processarEscolhaDoUsuario(int opcao) {
    switch (opcao) {
      case 1:
        criarPedido();
        break;
      case 2:
        processarPedido();
        break;
      case 3:
        adicionarItem();
        break;
      case 4:
        listarItens();
        break;
      case 5:
        cancelarPedido();
        break;
      case 6:
        System.out.println("Fechando o programa");
        break;
      default:
        System.out.println("Opção inválida");
        break;
    }
  }

  public static void adicionarItem() {
    entrarDados.nextLine();
    System.out.println("\n Nome do produto");
    String nomeDoProduto = entrarDados.nextLine();
    System.out.println("\n Tipo do produto");
    String tipoDoProduto = entrarDados.nextLine();
    System.out.println("\n Valor do produto");

    // Consume the newline character after reading the type

    double valorDoProduto = entrarDados.nextDouble();

    itensSalvos[itensSalvosPosicaoAtual] = new Item(itensSalvosPosicaoAtual, nomeDoProduto, tipoDoProduto,
        valorDoProduto);
    itensSalvosPosicaoAtual++;
    return;
  }

  public static void listarItens() {
    if (itensSalvos[0] == null || itensSalvos[1] == null) {
      System.out.println("Adicione pelo menos 2 itens");
      return;
    }
    for (int index = 0; index < itensSalvos.length; index++) {
      if (itensSalvos[index] != null) {
        System.out.println((index + 1) + " - " + itensSalvos[index].gerarDescricao());
      }
    }
  }

  public static void criarPedido() {
    if (itensSalvos[0] == null || itensSalvos[1] == null) {
      System.out.println("Adicione pelo menos 2 itens para iniciar as vendas");
      return;
    }

    System.out.println("Quantos dias depois do registro o cliente realizou o pagamento");
    int diasDepoisDaDataDeRegistro = entrarDados.nextInt();

    System.out.println("Quantos produtos o cliente comprou?");
    int quantidadeDeitens = entrarDados.nextInt();

    Item[] itensDoCliente = new Item[quantidadeDeitens];

    for (int i = 0; i < itensDoCliente.length; i++) {
      int item;
      do {
        listarItens();
        System.out.println("\nQual produto ele comprou?");
        item = entrarDados.nextInt();
        if (itensSalvos[item - 1] == null) {
          System.out.println("Item não encontrado");
        }
      } while (itensSalvos[item - 1] == null);

      itensDoCliente[i] = itensSalvos[item - 1];
    }

    Long dataDePagamento = new Date().getTime() + umDiaEmMs * diasDepoisDaDataDeRegistro;

    Pedido pedido = new Pedido(pedidosIds, new Date().getTime(), dataDePagamento, Teste.cliente_01, Teste.vendedores_03,
        Teste.loja_03, itensDoCliente);

    pedidos[pedidosIds] = pedido;
    pedidosIds++;
  }

  public static void processarPedido() {
    if (itensSalvos[0] == null || itensSalvos[1] == null) {
      System.out.println("Adicione pelo menos 2 itens para iniciar as vendas");
      return;
    }
    listarPedidos();
    System.out.println("Qual pedido deseja processar?");
    int pedidoIndex = entrarDados.nextInt();

    if (pedidos[pedidoIndex - 1] == null) {
      System.out.println("Pedido não encontrado");
      return;
    }

    ProcessaPedido pedidoParaProcessar = new ProcessaPedido(pedidos[pedidoIndex - 1]);
    boolean pagamentoOk = pedidoParaProcessar.processar();
    if (pagamentoOk) {
      System.out.println("Pagamento confirmado e pedido removido da fila");
      pedidos[pedidoIndex - 1] = null;
    } else {
      System.out.println("Pagamento não confirmado e pedido removido da fila por cancelamento");
      pedidos[pedidoIndex - 1] = null;
    }
  }

  public static void listarPedidos() {
    for (int i = 0; i < itensSalvos.length; i++) {
      if (pedidos[i] != null) {
        System.out.println((i + 1) + " - " + pedidos[i].gerarDescricaoVenda());
      }
    }
  }

  public static void cancelarPedido() {
    if (itensSalvos[0] == null || itensSalvos[1] == null) {
      System.out.println("Adicione pelo menos 2 itens para iniciar as vendas");
      return;
    }

    listarPedidos();

    System.out.println("Qual pedido deseja cancelar");

    int pedidoIndex = entrarDados.nextInt();

    if (pedidos[pedidoIndex - 1] == null) {
      System.out.println("Pedido não encontrado");
      return;
    } else {
      pedidos[pedidoIndex - 1] = null;
      System.err.println("Pedido cancelado");
    }

  }

}
