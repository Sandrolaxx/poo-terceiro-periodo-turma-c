package PrimeiroB.Dona_Gabi;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora2 {
    static ArrayList<Venda> vendas = new ArrayList<>();

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
                    exibirRegistros();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida. Por Favor, escolha uma opção válida.");
            }
        } while (opcao != 4);
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("[1] - Calcular Preço Total e Registrar Venda");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registros de Vendas");
        System.out.println("[4] - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.println("Digite a quantidade de planta vendida: ");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        double desconto = 0.0;

        if (quantidade >= 10) {
            desconto = 0.05 * precoTotal;
            precoTotal -= desconto;
            System.out.println("Desconto de 5% aplicado!");
        }

        System.out.println("Preço total da venda: R$ " + precoTotal);

        // Registro automático da venda
        Venda venda = new Venda(quantidade, precoUnitario, precoTotal, desconto);
        vendas.add(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.println("Digite o valor recebido pelo cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.println("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();

        double troco = valorRecebido - valorTotalCompra;
        System.out.println("Troco a ser dado ao cliente: R$ " + troco);
    }

    public static void exibirRegistros() {
        if (vendas.isEmpty()) {
            System.out.println("Não há registros de vendas.");
        } else {
            System.out.println("Registros de Vendas:");
            for (Venda venda : vendas) {
                System.out.println("Quantidade: " + venda.getQuantidade() +
                                   " | Preço Unitário: " + venda.getPrecoUnitario() +
                                   " | Desconto: R$ " + venda.getDesconto() +
                                   " | Preço Total: R$ " + venda.getPrecoTotal());
            }
        }
    }
}

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;
    private double desconto;

    public Venda(int quantidade, double precoUnitario, double precoTotal, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public double getDesconto() {
        return desconto;
    }
}