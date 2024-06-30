package bimestre_1.atividade_3;



import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static String produtosVetor[] = new String[10];
    public static int index = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, Integer> vendasPorDia = new HashMap<>();
    public static int vendasPorMes[] = new int[12];

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
                    verHistorico();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha 1, 2, 3 ou 4.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Ver histórico");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção (1, 2, 3, 4): ");
    }

    public static void calcularPrecoTotal() {
        System.out.print("Digite a quantidade da planta vendida: ");
        double quantidade = scanner.nextDouble();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double resultado = quantidade * precoUnitario;

        if (quantidade > 10) {
            double descontoTotal = resultado * 0.05;
            resultado -= descontoTotal;
            System.out.println("Parabéns, por comprar 10 platinhas você ganhou 5% de desconto!!");
            
        } else {
            System.out.println("O preço total da venda é: " + resultado);
        }

        produtosVetor[index] = "venda " + (index + 1) + ": " + quantidade + " unidades " + " R$" + resultado;
        index++;

    
        String data = java.time.LocalDate.now().toString(); 
        vendasPorDia.put(data, vendasPorDia.getOrDefault(data, 0) + 1);

     
        int mes = java.time.LocalDate.now().getMonthValue(); 
        vendasPorMes[mes - 1]++;
    }

    public static void verHistorico() {
        System.out.println("Histórico de Vendas:");
        for (int i = 0; i < index; i++) {
            System.out.println(produtosVetor[i]);
        }
        System.out.println("\nVendas por Dia:");
        vendasPorDia.forEach((dia, quantidade) -> System.out.println(dia + ": " + quantidade));

        System.out.println("\nVendas por Mês:");
        for (int i = 0; i < vendasPorMes.length; i++) {
            System.out.println("Mês " + (i + 1) + ": " + vendasPorMes[i]);
        }
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
