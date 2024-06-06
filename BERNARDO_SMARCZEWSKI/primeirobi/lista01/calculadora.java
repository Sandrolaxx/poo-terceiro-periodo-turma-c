package primeirobi.lista01;

import java.util.Scanner;

public class calculadora {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("----------------------------");
            System.out.println(" -> Menu ");
            System.out.println(" Escolha uma opção: ");
            System.out.println(" [1] - Calcular preço total ");
            System.out.println(" [2] - Calcular troco ");
            System.out.println(" [3] - Sair ");
            System.out.println("----------------------------");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    calculartotal();
                    break;
                case 2:
                    calculartroco();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }
        } while (escolha != 3);

        scanner.close();
    }

    public static void calculartotal() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o preço da planta?");
        double preco = scanner.nextDouble();
        System.out.println("Qual a quantidade de plantas?");
        int quant = scanner.nextInt();

        double total = quant * preco;

        System.out.println("Preço Total: " + total);

    }

    public static void calculartroco() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor pago?");
        double pago = scanner.nextDouble();
        System.out.println("Qual o valor da compra?");
        double valor = scanner.nextDouble();

        double troco = pago - valor;
        if (troco > 0) {
            System.out.println("Troco: " + troco);
        } else if (troco == 0) {
            System.out.println("Não é necessário troco.");
        } else {
            System.out.println("O valor pago não cobre o custo!!");
        }

    }
}
