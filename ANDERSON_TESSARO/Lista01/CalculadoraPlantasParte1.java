import java.util.Scanner;

public class CalculadoraPlantasParte1 {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção (1, 2 ou 3): ");
            opcao = new Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    System.out.println("Tchau brigado!");
                    break;
                default:
                    System.out.println("Esse numero não. Por favor, escolha 1, 2 ou 3.");
            }

        } while (opcao != 3);


    }

    private static void exibirMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair");
    }

    private static void calcularPrecoTotal() {

            System.out.print("Digite a quantidade da planta vendida: ");
            @SuppressWarnings("resource")
            int quantidade = new Scanner(System.in).nextInt();

            System.out.print("Digite o preço unitário da planta: ");
            @SuppressWarnings("resource")
            double precoUnitario = new Scanner(System.in).nextDouble();

            double precoTotal = quantidade * precoUnitario;

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
}
