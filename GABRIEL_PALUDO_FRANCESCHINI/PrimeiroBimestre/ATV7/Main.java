package ATV7;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import ATV7.src.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    Loja myyPlantLoja = new Loja("MyyPlant", "MyyPlant LTDA.", "98765432101234", "Parana", "Cascavel", "FAG", "Av. das Torres", "1", "Loja azul");
    myyPlantLoja.getGerentes().add(new Gerente("Sandro", 25, "Parana", "Cascavel" , "FAG", "AV. das Torres", "100", "Apt. 2", 8000, new double[]{8900, 9600, 8400}));
    myyPlantLoja.getClientes().add(new Cliente("Gabriel", 18, "Parana", "Cascavel" , "FAG", "AV. das Torres", "100", "Apt. 2"));
    myyPlantLoja.getClientes().add(new Cliente("Rafael", 18, "Parana", "Cascavel" , "FAG", "AV. das Torres", "101", "Apt. 3"));
    myyPlantLoja.getVendedores().add(new Vendedor(myyPlantLoja, "Caetano", 54, "Parana", "Cascavel" , "FAG", "AV. da Fag", "102", "Apt. 4", 1000, new double[]{1250, 1150, 1215}));
    myyPlantLoja.getVendedores().add(new Vendedor(myyPlantLoja, "Roberto", 30, "Parana", "Cascavel" , "FAG", "AV. da Fag", "103", "Apt. 5", 1800, new double[]{1975, 2008, 2115}));
    myyPlantLoja.getVendedores().add(new Vendedor(myyPlantLoja, "Cesar", 40, "Parana", "Cascavel" , "FAG", "AV. da Fag", "104", "Apt. 6", 2500, new double[]{2630, 2700, 2720}));

    while (continuar) {
      System.out.println("Loja MyyPlant");
      System.out.println("[1] - Apresentar loja");
      System.out.println("[2] - Apresentar vendedores");
      System.out.println("[3] - Apresentar clientes");
      System.out.println("[4] - Apresentar gerentes");
      System.out.println("[5] - Calcular média salarial dos funcionários");
      System.out.println("[6] - Calcular bônus dos funcionários");
      System.out.println("[7] - Contar vendedores");
      System.out.println("[8] - Contar clientes");
      System.out.println("[9] - Realizar pedido");
      System.out.println("[10] - Cadastrar itens");
      System.out.println("[11] - Listar itens");
      System.out.println("[12] - Sair");
      System.out.println("\nEscolha uma operação:");
      int calculator = scanner.nextInt();

      switch (calculator) {
          case 1:
              myyPlantLoja.apresentarLoja();
              break;

          case 2:
              myyPlantLoja.apresentarVendedores();
              break;

          case 3:
              myyPlantLoja.apresentarClientes();
              break;

          case 4:
              myyPlantLoja.apresentarGerentes();
              break;

          case 5:
              System.out.println("Média de salário dos funcionários:");
              for (Vendedor vendedor : myyPlantLoja.getVendedores()) {
                  System.out.println(vendedor.getNome() + ": " + vendedor.calcularMediaSalarial());
              }
              for (Gerente gerente : myyPlantLoja.getGerentes()) {
                  System.out.println(gerente.getNome() + ": " + gerente.calcularMediaSalarial());
              }
              break;

          case 6:
              System.out.println("Bônus dos funcionários:");
              for (Vendedor vendedor : myyPlantLoja.getVendedores()) {
                  System.out.println(vendedor.getNome() + ": " + vendedor.calcularBonus());
              }
              for (Gerente gerente : myyPlantLoja.getGerentes()) {
                  System.out.println(gerente.getNome() + ": " + gerente.calcularBonus());
              }
              break;

          case 7:
              System.out.println("Total de vendedores: " + myyPlantLoja.contarVendedores());
              break;

          case 8:
              System.out.println("Total de clientes: " + myyPlantLoja.contarClientes());
              break;

          case 9:
              realizarPedido(myyPlantLoja, scanner);
              break;

          case 10:
              cadastrarItem(myyPlantLoja, scanner);
              break;

          case 11:
              listarItens(myyPlantLoja);
              break;

          case 12:
              System.out.println("Saindo...");
              continuar = false;
              break;

          default:
              System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
      }
  }
  scanner.close();
}

private static void realizarPedido(Loja loja, Scanner scanner) {
  System.out.println("Selecione um cliente:");
  for (int i = 0; i < loja.getClientes().size(); i++) {
      System.out.println("[" + (i + 1) + "] - " + loja.getClientes().get(i).getNome());
  }
  int clienteIndex = scanner.nextInt() - 1;
  Cliente cliente = loja.getClientes().get(clienteIndex);

  System.out.println("Selecione um vendedor:");
  for (int i = 0; i < loja.getVendedores().size(); i++) {
      System.out.println("[" + (i + 1) + "] - " + loja.getVendedores().get(i).getNome());
  }
  int vendedorIndex = scanner.nextInt() - 1;
  Vendedor vendedor = loja.getVendedores().get(vendedorIndex);

  System.out.println("Planta disponíveis:");
  for (int i = 0; i < loja.getItens().size(); i++) {
      Item item = loja.getItens().get(i);
      System.out.println("[" + (i + 1) + "] - " + item.getNome() + " - R$" + item.getValor());
  }
  int escolhaPlantaIndex = scanner.nextInt() - 1;
  Item plantaEscolhida = loja.getItens().get(escolhaPlantaIndex);

  System.out.println("Digite a quantidade desejada:");
  int quantidade = scanner.nextInt();

  double totalPedido = plantaEscolhida.getValor() * quantidade;
  System.out.println("Preço total do pedido: R$" + totalPedido);

  Pedido novoPedido = new Pedido(loja.getPedidos().size() + 1, cliente, vendedor, loja, new ArrayList<>(Arrays.asList(plantaEscolhida)));
  ProcessaPedido processador = new ProcessaPedido();
  processador.processar(novoPedido);

  System.out.println("Pedido realizado com sucesso!");
  return;
}

  private static void cadastrarItem(Loja loja, Scanner scanner) {
    System.out.println("Digite o nome do item:");
    String nomeItem = scanner.next();
    System.out.println("Digite o tipo do item:");
    String tipoItem = scanner.next();
    System.out.println("Digite o valor do item:");
    double valorItem = scanner.nextDouble();

    Item novoItem = new Item(loja.getItens().size() + 1, nomeItem, tipoItem, valorItem);
    loja.getItens().add(novoItem);
    System.out.println("Item cadastrado com sucesso!");
  }

  private static void listarItens(Loja loja) {
    System.out.println("Itens cadastrados na loja:");
    for (Item item : loja.getItens()) {
      System.out.println(item.getNome() + " - Tipo: " + item.getTipo() + " - Valor: R$" + item.getValor());
    }
  }
}