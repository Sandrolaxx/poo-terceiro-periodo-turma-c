package RICARDO_DINIZ_SILVA.Calculadoras.Calculadora3;

import java.util.Scanner;

public class Calculadora3 {
    private static final double[][] VENDAS_DIA_MES = new double[29][12];
    private static final double[][] DESCONTOS_DIA_MES = new double[29][12];
    private static final int[][] QUANTIDADES_DIA_MES = new int[29][12];
    private static final double[] VENDAS_DO_DIA = new double[200];
    private static final double[] DESCONTOS = new double[200];
    private static final int[] QUANTIDADES = new int[200];
    private static int posicaoVetor = 0;

    private static double totalVendasDoDia = 0;
    private static double totalDescontoDoDia = 0;
    private static int totalQuantidadeDoDia = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> calcularPrecoTotal();
                case 2 -> calcularTroco();
                case 4 -> salvarVendasTotaisDoDia();
                case 5 -> imprimirVendas();
                case 6 -> imprimirVendasDeCertoDia();
                case 0 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void menu() {
        System.out.println("Menu Console:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
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
            VENDAS_DO_DIA[posicaoVetor] = precoTotal;
            DESCONTOS[posicaoVetor] = desconto;
            QUANTIDADES[posicaoVetor] = quantidade;

            totalVendasDoDia += precoTotal;
            totalDescontoDoDia += desconto;
            totalQuantidadeDoDia += quantidade;

            posicaoVetor++;

            System.out.println("Venda salva!");
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
        imprimirVendas();

        System.out.println("Deseja realmente salvar as vendas: S/N");
        String opcao = new Scanner(System.in).next();

        if (opcao.equalsIgnoreCase("s")) {
            System.out.print("Qual o dia para salvar: ");
            int dia = new Scanner(System.in).nextInt();

            System.out.print("Qual o mes para salvar: ");
            int mes = new Scanner(System.in).nextInt();

            if (dia <= 0 || dia > 29 || mes <= 0 || mes > 12) {
                System.out.println("Dia ou mes invalidos!!");
                return;
            }

            VENDAS_DIA_MES[dia - 1][mes - 1] = totalVendasDoDia;
            DESCONTOS_DIA_MES[dia - 1][mes - 1] = totalDescontoDoDia;
            QUANTIDADES_DIA_MES[dia - 1][mes - 1] = totalQuantidadeDoDia;

            totalVendasDoDia = 0;
            totalDescontoDoDia = 0;
            totalQuantidadeDoDia = 0;

            posicaoVetor = 0;
        }
    }

    private static void imprimirVendas() {
        System.out.println("* Vendas *");

        for (int i = 0; i < posicaoVetor; i++) {
            System.out.println("Valor: R$ " + VENDAS_DO_DIA[i] + ", quantidade: " + QUANTIDADES[i] + ", desconto: R$ " + DESCONTOS[i]);
        }
        System.out.println("Quantidades de vendas: " + posicaoVetor);
        System.out.println("Total de vendas: R$ " + totalVendasDoDia);
        System.out.println("Total de descontos: R$ " + totalDescontoDoDia);
    }

    private static void imprimirVendasDeCertoDia() {
        System.out.print("Qual dia da venda: ");
        int dia = new Scanner(System.in).nextInt();

        System.out.print("Qual mes da venda: ");
        int mes = new Scanner(System.in).nextInt();

        if (dia <= 0 || dia > 29 || mes <= 0 || mes > 12) {
            System.out.println("Dia ou mes invalidos!!");
            return;
        }

        System.out.printf("* Vendas de %d/%d * \n", dia, mes);
        System.out.println("Valor total: " + VENDAS_DIA_MES[dia - 1][mes - 1]);
        System.out.println("Valor de descontos: " + DESCONTOS_DIA_MES[dia - 1][mes - 1]);
        System.out.println("Quantidade de venda: " + QUANTIDADES_DIA_MES[dia - 1][mes - 1]);
    }
}