import java.util.ArrayList;
import java.util.Scanner;

public class lista3 {
    static ArrayList<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    registrarVendasDoMes();
                    break;
                case 4:
                    System.out.println("Saindo. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 4.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Registrar Vendas do Mês");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção (1, 2, 3 ou 4): ");
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        if (quantidade > 10) {
            double desconto = precoTotal * 0.05;
            precoTotal -= desconto;
            System.out.println("Desconto de 5% aplicado.");
        }

        System.out.println("O preço total da venda é: " + precoTotal);
        registrarVenda(quantidade, precoTotal);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();

        double troco = valorRecebido - valorTotalCompra;
        System.out.println("O troco a ser dado ao cliente é: " + troco);
    }

    private static void registrarVendasDoMes() {
        double totalVendas = 0;
        for (Venda venda : registroVendas) {
            totalVendas += venda.getPrecoTotal();
        }
        System.out.println("Total de vendas do mês: R$" + totalVendas);
    }

    private static void registrarVenda(int quantidade, double precoTotal) {
        Venda venda = new Venda(quantidade, precoTotal);
        registroVendas.add(venda);
    }
}

class Venda {
    private int quantidade;
    private double precoTotal;

    public Venda(int quantidade, double precoTotal) {
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
