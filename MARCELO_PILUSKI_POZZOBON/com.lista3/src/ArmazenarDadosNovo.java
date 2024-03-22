package com.lista3.src;

import java.util.Scanner;

public class ArmazenarDadosNovo {

    protected static Scanner mes = new Scanner(System.in);
    protected static Scanner dia = new Scanner(System.in);
    protected static Scanner quantidadeProdutos = new Scanner(System.in);
    protected static Scanner precoTotal = new Scanner(System.in);

    public int[][][] calendario = new int[12][30][1];

    public void armazenarDados() {
        int cont = 0;
        System.out.print("Digite o mês (1 - 12): ");
        int mesResponse = mes.nextInt();
        System.out.print("Digite o dia (1 - 30): ");
        int diaResponse = dia.nextInt();
        System.out.print("Digite a quantidade de produtos: ");
        int produtosResponse = quantidadeProdutos.nextInt();
      
        if (calendario[mesResponse - 1][diaResponse - 1][cont++] == 0) {
          calendario[mesResponse - 1][diaResponse - 1][cont++] = produtosResponse;
          for (int i = 0; i < calendario[mesResponse - 1].length; i++) {
            for (int j = 0; j < calendario[diaResponse - 1][i].length; j++) {
              System.out.println("Compra " + (j + 1) + ": Você armazenou " + produtosResponse + " vendas dia " + (j + 1) + " do " + (i + 1));
            }
          }
        } else {
          System.out.println("Esse dia já possui as vendas, por favor escolha outro dia.");
        }
      }
}