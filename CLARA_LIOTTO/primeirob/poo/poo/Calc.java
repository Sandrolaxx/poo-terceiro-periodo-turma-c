package poo;

import java.util.Scanner;

public class Calc {
    static class Sale {
        int quantidade;
        double precoTotal;
        double desconto;

        Sale(int quantidade, double precoTotal, double desconto) {
            this.quantidade = quantidade;
            this.precoTotal = precoTotal;
            this.desconto = desconto;
        }
    }

    
    static int[][] vendasDiarias = new int[30][12]; 
    static int[] vendasMensais = new int[12]; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            exibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    registrarVenda();
                    break;
                case 2:
                    buscarVendasDiarias();
                    break;
                case 3:
                    buscarVendasMensais();
                    break;
                case 4:
                    calcularPrecoTotal();
                    break;
                case 5:
                    calcularDesconto();
                    break;
                case 6:
                    calcularTroco();
                    break;
                case 7:
                    System.out.println("Saindo da calculadora. ");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 7);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("[1] - Registrar Venda");
        System.out.println("[2] - Buscar Vendas Diárias");
        System.out.println("[3] - Buscar Vendas Mensais");
        System.out.println("[4] - Calcular Preço Total");
        System.out.println("[5] - Calcular Desconto");
        System.out.println("[6] - Calcular Troco");
        System.out.println("[7] - Sair");
        System.out.print("Escolha a opção desejada: ");
    }

    private static void registrarVenda() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia da venda (1 a 30): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês da venda (1 a 12): ");
        int mes = scanner.nextInt();

        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();

        vendasDiarias[dia - 1][mes - 1] += quantidade;

        vendasMensais[mes - 1] += quantidade;

        System.out.println("Venda registrada com sucesso!");

        scanner.close();
    }

    private static void buscarVendasDiarias() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia que deseja buscar (1 a 30): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês que deseja buscar (1 a 12): ");
        int mes = scanner.nextInt();

        int vendas = vendasDiarias[dia - 1][mes - 1];
        System.out.println("Quantidade de vendas no dia " + dia + "/" + mes + ": " + vendas);
        scanner.close();
    }

    private static void buscarVendasMensais() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o mês que deseja buscar (1 a 12): ");
        int mes = scanner.nextInt();

        int vendas = vendasMensais[mes - 1];
        System.out.println("Quantidade de vendas no mês " + mes + ": " + vendas);
        scanner.close();
    }

    private static void calcularPrecoTotal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        System.out.println("O preço total da venda é: R$ " + precoTotal);
        scanner.close();
    }

    private static void calcularDesconto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        if (quantidade >= 10) {
            double desconto = precoTotal * 0.05; 
            precoTotal -= desconto;
            System.out.println("O valor com desconto vai ser: R$ " + precoTotal);
        } else {
            System.out.println("Não há desconto para essa quantidade de plantas.");
        }
        scanner.close();
    }

    private static void calcularTroco() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor recebido pelo cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();

        if (valorRecebido >= valorTotalCompra) {
            double troco = valorRecebido - valorTotalCompra;
            System.out.println("O troco a ser dado ao cliente é: R$ " + troco);
        } else {
            System.out.println("Valor insuficiente. O cliente deve pagar mais.");
        }
        scanner.close();
    }
}