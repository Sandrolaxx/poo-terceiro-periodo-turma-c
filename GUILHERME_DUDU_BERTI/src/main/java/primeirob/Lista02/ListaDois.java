package primeirob.Lista02;

import java.util.Scanner;

public class ListaDois {
    public static void main(String[] args) {

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("[1] - Calcular Preço Total.");
            System.out.println("[2] - Calcular Troco.");
            System.out.println("[3] - Registrar Venda.");
            System.out.println("[4] - Exibir Total de Vendas");
            System.out.println("[0] - Sair.");
            System.out.println("---------------------------------");

            int opcao = new Scanner(System.in).nextInt();
            if (opcao == 0)
                break;

            switch (opcao) {
                case 1 -> calcularPrecoTotal();
                case 2 -> calcularTroco();
                case 3 -> salvar();
                case 4 -> exibirTotalVenda();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void calcularPrecoTotal() {
        System.out.print("Quantidade de itens:");
        int quantidade = new Scanner(System.in).nextInt();
        System.out.print("Preço por item:");
        double preco = new Scanner(System.in).nextDouble();
        double precoTotal = CalculadoraFuncoes.calcularPrecoTotal(quantidade, preco);
        System.out.println("Preço total: R$" + precoTotal);
    }

    private static void calcularTroco() {
        System.out.print("Valor Total da Compra: ");
        double total = new Scanner(System.in).nextDouble();
        System.out.print("Valor recebido: ");
        double recebido = new Scanner(System.in).nextDouble();
        double troco = CalculadoraFuncoes.calcularTroco(recebido, total);
        System.out.println("Troco a ser entregue para o cliente é: R$ " + troco);
    }

    private static void salvar() {
        System.out.print("Insira o valor da venda: ");
        double valorDeVenda = new Scanner(System.in).nextDouble();
        CalculadoraFuncoes.salvar(valorDeVenda);
    }

    private static void exibirTotalVenda() {
        CalculadoraFuncoes.exibirTotalVenda();
    }

    private class CalculadoraFuncoes {

        private static final double[] LISTA_VENDAS = new double[100];
        private static int size = 0;
        private static double valorTotalDeVenda = 0;

        public static double calcularPrecoTotal(int quantidade, double preco) {
            if (quantidade <= 0 || preco <= 0) {
                System.out.println("O valor deve ser maior que zero!");
                return Double.NaN;
            }
            return calcularDescontoEspecial(quantidade, preco);
        }

        private static double calcularDescontoEspecial(int quantidade, double preco) {
            if (quantidade > 10) {
                return (quantidade * preco) * 0.95;
            } else {
                return quantidade * preco;
            }
        }

        public static double calcularTroco(double recebido, double total) {
            if (recebido <= 0 || total <= 0) {
                System.out.println("O valor total da compra deve ser maior que zero, e o que você repassar também!");
                return Double.NaN;
            } else if (recebido < total) {
                System.out.println("O valor que você der de dinheiro, deve ser igual ou maior que o total da compra!");
                return Double.NaN;
            }
            return recebido - total;
        }

        public static void salvar(double valorVenda) {
            LISTA_VENDAS[size++] = valorVenda;
            valorTotalDeVenda += valorVenda;
        }

        public static void exibirTotalVenda() {
            System.out.println("Total de Vendas: " + size);
            System.out.println("Valor Total de Vendas: " + valorTotalDeVenda);
            System.out.print("Vendas: ");
            for (int i = 0; i < size; i++) {
                System.out.print(LISTA_VENDAS[i] + ", ");
            }
        }
    }
}
