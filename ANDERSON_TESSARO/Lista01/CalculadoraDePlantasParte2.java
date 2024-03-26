import java.util.Scanner;

public class CalculadoraDePlantasParte2 {

    private static int quantidadeTotalVendida = 0;
    private static double valorTotalVendas = 0;
    private static double totalDescontos = 0;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção (1, 2, 3 ou 4): ");
            opcao = new Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    exibirRegistrosVendas();
                    break;
                case 4:
                    System.out.println("Tchau brigado!");
                    break;
                default:
                    System.out.println("Esse numero não. Por favor, escolha 1, 2, 3 ou 4.");
            }

        } while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registros de Vendas");
        System.out.println("[4] - Sair");
    }

    private static void calcularPrecoTotal() {
        System.out.print("Digite a quantidade da planta vendida: ");
        @SuppressWarnings("resource")
        int quantidade = new Scanner(System.in).nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        @SuppressWarnings("resource")
        double precoUnitario = new Scanner(System.in).nextDouble();

        double precoTotal = quantidade * precoUnitario;

        // Verificar se há desconto especial
        if (quantidade > 10) {
            double desconto = 0.05 * precoTotal;
            precoTotal -= desconto;
            totalDescontos += desconto;
            System.out.println("Desconto especial de 5% aplicado!");
        }

        // Atualizar registros de vendas
        quantidadeTotalVendida += quantidade;
        valorTotalVendas += precoTotal;

        System.out.println("O preço total da venda é: R$" + precoTotal);
    }

    private static void calcularTroco() {
        System.out.print("Digite o valor recebido pelo cliente: R$");
        @SuppressWarnings("resource")
        double valorRecebido = new Scanner(System.in).nextDouble();

        System.out.print("Digite o valor total da compra: R$");
        @SuppressWarnings("resource")
        double valorTotalCompra = new Scanner(System.in).nextDouble();

        double troco = valorRecebido - valorTotalCompra;

        if (troco >= 0) {
            System.out.println("O troco a ser dado ao cliente é: R$" + troco);
        } else {
            System.out.println("O valor recebido é insuficiente. Não há troco a ser dado.");
        }
    }

    private static void exibirRegistrosVendas() {
        System.out.println("\n----- Registros de Vendas -----");
        System.out.println("Quantidade total vendida: " + quantidadeTotalVendida);
        System.out.println("Valor total das vendas: R$" + valorTotalVendas);
        System.out.println("Total de descontos aplicados: R$" + totalDescontos);
    }
}
