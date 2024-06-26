package RICARDO_DINIZ_SILVA.Calculadoras.calculadora2;

import java.util.Scanner;

public class Calculadora2 {
    private static double[] vendas = new double[200];
    private static double[] descontos = new double[200];
    private static int[] quantidades = new int[200];
    private static int posicaoVetor = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    salvarVenda();
                    break;
                case 4:
                    imprimirVendas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Menu Console:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Salvar venda");
        System.out.println("[4] - Imprimir vendas");
        System.out.println("[0] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void calcularPrecoTotal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade da planta vendida: ");
        double quantidade = scanner.nextDouble();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        if (quantidade <= 0 || precoUnitario <= 0) {
            System.out.println("Os valores devem ser maiores que 0!");
            return;
        }

        double precoTotal = quantidade * precoUnitario;
        if (quantidade > 10) {
            double desconto = precoTotal * 5 / 100;
            precoTotal -= desconto;
            System.out.println("Desconto de 5% aplicado!");
        } else {
            System.out.println("Nenhum desconto aplicado!");
        }

        System.out.println("O preço total da venda é: " + precoTotal);
    }

    private static void calcularTroco() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor recebido pelo cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();

        if (valorRecebido <= 0 || valorTotalCompra <= 0) {
            System.out.println("Os valores devem ser maiores que 0!");
            return;
        }
        double troco = valorRecebido - valorTotalCompra;

        if (troco < 0) {
            System.out.println("Erro: O valor recebido é insuficiente.");
        } else {
            System.out.println("O troco a ser dado ao cliente é: " + troco);
        }
    }

    private static void salvarVenda() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da venda com desconto(se tiver) para salvar: ");
        double valorParaSalvar = scanner.nextDouble();

        System.out.print("Teve desconto? caso não tenha coloque 0: ");
        double valorDesconto = scanner.nextDouble();

        System.out.print("Digite a quantidade de flores compradas: ");
        int quantidadeParaSalvar = scanner.nextInt();

        if (valorParaSalvar <= 0 || quantidadeParaSalvar <= 0) {
            System.out.println("O valor deve ser maior que 0!");
            return;
        }


        vendas[posicaoVetor] = valorParaSalvar;
        descontos[posicaoVetor] = valorDesconto;
        quantidades[posicaoVetor] = quantidadeParaSalvar;

        posicaoVetor++;
    }

    private static void imprimirVendas() {
        System.out.println("* Vendas *");
        double totalVendas = 0;
        double totalDesconto = 0;
        int totalQuantidade = 0;

        for (int i = 0; i < posicaoVetor; i++) {
            System.out.println("Valor: R$ " + vendas[i] + ", quantidade: " + quantidades[i] + ", desconto: R$ " + descontos[i]);
            totalVendas += vendas[i];
            totalDesconto += descontos[i];
            totalQuantidade += quantidades[i];
        }
        System.out.println("Quantidades de vendas: " + posicaoVetor);
        System.out.println("Total de vendas: R$ " + totalVendas);
        System.out.println("Total de descontos: R$ " + totalDesconto);
    }
}