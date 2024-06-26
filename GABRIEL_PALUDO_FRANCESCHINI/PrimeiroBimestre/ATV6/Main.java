package ATV6;

import java.util.Scanner;
import java.util.ArrayList;

import ATV6.src.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Loja myyPlantLoja = new Loja("MyyPlant", "MyyPlant LTDA.", "98765432101234", "Parana", "Cascavel", "FAG", "Av. das Torres", "1", "Loja azul");
    myyPlantLoja.getGerentes().add(new Gerente("Sandro", 25, "Parana", "Cascavel" , "FAG", "AV. das Torres", "100", "Apt. 2", 8000, new double[]{8900, 9600, 8400}));
    myyPlantLoja.getClientes().add(new Cliente("Gabriel", 18, "Parana", "Cascavel" , "FAG", "AV. das Torres", "100", "Apt. 2"));
    myyPlantLoja.getClientes().add(new Cliente("Rafael", 18, "Parana", "Cascavel" , "FAG", "AV. das Torres", "101", "Apt. 3"));
    myyPlantLoja.getVendedores().add(new Vendedor(myyPlantLoja, "Caetano", 54, "Parana", "Cascavel" , "FAG", "AV. da Fag", "102", "Apt. 4", 1000, new double[]{1250, 1150, 1215}));
    myyPlantLoja.getVendedores().add(new Vendedor(myyPlantLoja, "Roberto", 30, "Parana", "Cascavel" , "FAG", "AV. da Fag", "103", "Apt. 5", 1800, new double[]{1975, 2008, 2115}));
    myyPlantLoja.getVendedores().add(new Vendedor(myyPlantLoja, "Cesar", 40, "Parana", "Cascavel" , "FAG", "AV. da Fag", "104", "Apt. 6", 2500, new double[]{2630, 2700, 2720}));
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
    System.out.println("[10] - Sair");

    int calculator;
    do {
      System.out.println("\nEscolha uma operação:");
      calculator = scanner.nextInt();

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
        }
      } while (calculator != 10);
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

    ArrayList<Item> itens = new ArrayList<>();
    itens.add(new Item(1, "Tulipa", "Flor", 70));
    itens.add(new Item(2, "Samambaia", "Planta", 60));

    double totalPedido = 0.0;

    System.out.println("Deseja adicionar a Tulipa ou Samambaia ao pedido? (Tulipa/Samambaia)");
    String escolhaPlanta = scanner.next();

    Item itemEscolhido = null;
    if (escolhaPlanta.equalsIgnoreCase("Tulipa")) {
        itemEscolhido = itens.get(0);
    } else if (escolhaPlanta.equalsIgnoreCase("Samambaia")) {
        itemEscolhido = itens.get(1);
    } else {
        System.out.println("Opção inválida.");
        return;
    }

    System.out.println("Digite a quantidade desejada:");
    int quantidade = scanner.nextInt();

    totalPedido = itemEscolhido.getValor() * quantidade;

    System.out.println("Preço total do pedido: R$" + totalPedido);

    Pedido novoPedido = new Pedido(loja.getPedidos().size() + 1, cliente, vendedor, loja, itens);
    ProcessaPedido processador = new ProcessaPedido();
    processador.processar(novoPedido);
    System.out.println("Pedido realizado com sucesso!");
  }
}