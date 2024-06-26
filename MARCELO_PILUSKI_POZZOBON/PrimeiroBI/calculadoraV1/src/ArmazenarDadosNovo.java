package calculadoraV1.src;

import java.util.Scanner;

public class ArmazenarDadosNovo {

  protected static Scanner mes = new Scanner(System.in);
  protected static Scanner dia = new Scanner(System.in);
  protected static Scanner quantidadeProdutos = new Scanner(System.in);
  protected static Scanner precoTotal = new Scanner(System.in);

  public int[][][] calendario = new int[12][30][99];

  public void armazenarDados() {
    int cont = 0;
    System.out.print("Digite o mês (1 - 12): ");
    int mesResponse = mes.nextInt();
    System.out.print("Digite o dia (1 - 30): ");
    int diaResponse = dia.nextInt();
    System.out.print("Digite a quantidade de produtos: ");
    int produtosResponse = quantidadeProdutos.nextInt();

    calendario[mesResponse - 1][diaResponse - 1][cont++] += produtosResponse;
  }

  public void escreverMes() {
    System.out.print("Digite o mês (1 - 12): ");
    int mesResponse = mes.nextInt();
    System.out.print("Digite o dia (1 - 30): ");
    int diaResponse = dia.nextInt();

    for (int i = 0; i < mesResponse; i++) {
      for (int j = 0; j < diaResponse; j++) {
        for (int j2 = 0; j2 < calendario[i].length; j2++) {
          if (calendario[i][j][j2] != 0) {
            System.out.println("Dia " + diaResponse + " do mês " + mesResponse + ": Vendeu " + calendario[i][j][j2]);
          }

        }
      }
    }
  }

}