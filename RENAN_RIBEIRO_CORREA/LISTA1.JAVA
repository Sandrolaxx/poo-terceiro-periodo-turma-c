import java.util.Scanner;

public class LISTA1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Digite a opção desejada: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    calculateTotalPrice(scanner);
                    break;
                case 2:
                    calculateChange(scanner);
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar a calculadora de Dona Gabrielinha! Até a próxima.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 3);
    }

    private static void calculateTotalPrice(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantity = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double unitPrice = scanner.nextDouble();
        double totalPrice = quantity * unitPrice;
        System.out.println("O preço total da venda é: " + totalPrice);
    }

    private static void calculateChange(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: ");
        double receivedValue = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double totalValue = scanner.nextDouble();
        double change = receivedValue - totalValue;
        System.out.println("O troco a ser dado ao cliente é: " + change);
    }
}