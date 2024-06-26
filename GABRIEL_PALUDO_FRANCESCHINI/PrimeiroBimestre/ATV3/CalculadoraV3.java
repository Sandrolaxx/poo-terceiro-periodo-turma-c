/* Dona Gabrielinha está utilizando o sistema e isso melhorou muito sua produtividade na loja, porém ela identificou que apenas salvar aleatoriamente a venda não é algo tão útil.
Ela então te contacta novamente e realiza o orçamento da alteração. Segundo ela, seria ótimo poder salvar a quantidade de vendas totais(valor) em um dia de um mês.
Ela também gostaria de buscar a quantidade de vendas total pelo mês e dia.

1. Identifique as funcionalidades requeridas, entradas e saídas.

2. Implemente as funcionalidades.

3. Adicione ao menu as funcionalidades.

Obs(Digamos que todos os meses do ano tem 30 dias*) */
package ATV3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraV3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Compra> history = new ArrayList<>();
    int[][][] purchase;

    System.out.println("Loja da Dona Gabrielinha");
    System.out.println("[1] - Calcular Preço/Registrar venda");
    System.out.println("[2] - Calcular Troco");
    System.out.println("[3] - Ver histórico de vendas");
    System.out.println("[4] - Sair");
    System.out.println("\nInsira o número do mês atual:");
    int indexMonth = scanner.nextInt();
    if (indexMonth > 12 || indexMonth < 1) {
      System.out.println("Número inválido, insira um número entre 1 e 12.");
      scanner.close();
      return;
    }

    System.out.println("Insira o dia de hoje:");
    int indexDay = scanner.nextInt();
    if (indexDay > 30 || indexDay < 1) {
      System.out.println("Número inválido, insira um número entre 1 e 30");
      scanner.close();
      return;
    }

    int indexPurchase = 0;

    int calculator;
    do {
      System.out.println("\nEscolha uma operação:");
      calculator = scanner.nextInt();

      switch (calculator) {
        case 1:
            System.out.println("\nInsira o preço da planta:");
            double price = scanner.nextDouble();
            System.out.println("Insira a quantidade de plantas:");
            int quantity = scanner.nextInt();
            System.out.println("\nDeseja registrar compra? Insira 1 para sim e 0 para não:");
            int register = scanner.nextInt();

          if (register == 1) {
            System.out.println("Compra registrada com sucesso!");

            Compra compra = new Compra(indexMonth, indexDay, indexPurchase, quantity, price);
            System.out.println("\nDetalhes da compra:");
            System.out.println(compra);
            history.add(compra);

            purchase[indexMonth - 1][indexDay - 1][indexPurchase++] = quantity;
            } else {
            System.out.println("O valor é de " + (quantity*price) + "R$");
            System.out.println("Compra cancelada.");
            }
        break;

        case 2:
            System.out.println("\nInsira o valor pago pelo cliente:");
            double payment = scanner.nextDouble();
            System.out.println("\nInsira o valor da compra:");
            double priceChange = scanner.nextDouble();
            System.out.println("O troco é de " + (payment-priceChange) + "R$");
        break;

        case 3:
            System.out.println("\nInsira o número do mês:");
            int selectedMonth = scanner.nextInt();
            System.out.println("\nInsira o dia:");
            int selectedDay = scanner.nextInt();

            System.out.println("\nHistórico de vendas do dia " + selectedDay + " do mês " + selectedMonth + ":");

            for (Compra compra : history) {
                if (compra.getMonth() == selectedMonth && compra.getDay() == selectedDay) {
                    System.out.println(compra);
                }
            }
        break;

        case 4:
        break;
      }
    } while (calculator != 4);
    scanner.close();
  }
}