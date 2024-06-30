package RICARDO_DINIZ_SILVA.Calculadoras.Calculadora4;

import java.util.Scanner;

public class Calculadora4 {
    private static final int MAX_VENDAS = 200;
    private static final int MAX_DIAS = 29;
    private static final int MAX_MESES = 12;
    
    private static final double[][] VENDAS_DIA_MES = new double[MAX_DIAS][MAX_MESES];
    private static final double[][] DESCONTOS_DIA_MES = new double[MAX_DIAS][MAX_MESES];
    private static final int[][] QUANTIDADES_DIA_MES = new int[MAX_DIAS][MAX_MESES];
    
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
                    // Adicionar nova venda
                    break;
                case 4:
                    salvarVendasTotaisDoDia();
                    break;
                case 5:
                    imprimirVendas();
                    break;
                case 6:
                    imprimirVendasDeCertoDia();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void menu() {
        System.out.println("Menu Console:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Adicionar Nova Venda");
        System.out.println("[4] - Salvar vendas do dia");
        System.out.println("[5] - Imprimir vendas do dia");
        System.out.println("[6] - Imprimir vendas de certo dia");
        System.out.println("[0] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void calcularPrecoTotal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade da planta vendida: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        if (quantidade <= 0 || precoUnitario <= 0) {
            System.out.println("Os valores devem ser maiores que 0!");
            return;
        }

        double precoTotal = quantidade * precoUnitario;
        double desconto = 0;
        if (quantidade > 10) {
            desconto = precoTotal * 5 / 100;
            precoTotal -= desconto;
            System.out.println("Desconto de 5% aplicado!");
        } else {
            System.out.println("Nenhum desconto aplicado!");
        }
        System.out.println("O preço total da venda é: " + precoTotal);

        System.out.println("Deseja salvar a venda: S/N");
        String opcao = scanner.next();
        if (opcao.equalsIgnoreCase("s")) {
            // Adicionar a lógica para salvar a venda
        }
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

    private static void salvarVendasTotaisDoDia() {
        // Adicionar a lógica para salvar as vendas do dia
    }

    private static void imprimirVendas() {
        // Adicionar a lógica para imprimir as vendas do dia
    }

    private static void imprimirVendasDeCertoDia() {
        // Adicionar a lógica para imprimir as vendas de certo dia
    }
}