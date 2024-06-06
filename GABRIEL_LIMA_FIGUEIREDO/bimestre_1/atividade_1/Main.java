package bimestre_1.atividade_1;


import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);;

    public static void main(String[] args) {

        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();
            System.out.println(escolha);
            switch (escolha) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
            }
        }

    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair");
        System.out.print("Escolha uma opção (1, 2, ou 3): ");
    }

    public static void calcularPrecoTotal() {

        System.out.print("Digite a quantidade da planta vendida: ");
        double quantidade = scanner.nextDouble();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double resultado = quantidade * precoUnitario;
        System.out.println("O preço total da venda é: " + resultado);

    }

    public static void calcularTroco() {

        System.out.print("Digite o valor recebido pelo cliente: ");
        double valorPago = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();

        double troco = valorPago - valorTotalCompra;
        System.out.println("O troco a ser dado ao cliente é: " + troco);
    }
}
