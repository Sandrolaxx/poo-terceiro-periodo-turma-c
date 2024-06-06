package PrimeiroB.Dona_Gabi;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 3);
        
        scanner.close();
    }
    
    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta vendida: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        
        double precoTotal = quantidade * precoUnitario;
        System.out.println("Preço total da venda: R$ " + precoTotal);
    }
    
    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();
        
        double troco = valorRecebido - valorTotalCompra;
        System.out.println("Troco a ser dado ao cliente: R$ " + troco);
    }
}