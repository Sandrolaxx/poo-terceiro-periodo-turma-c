package primeirob.Lista01;

import java.util.Scanner;

public class ListaUm {
    public static double calcularPrecoTotal(int quantidade, double preco) {
        if (quantidade <= 0 || preco <= 0) {
            System.out.println("O valor deve ser maior que zero!");
            return Double.NaN;
        }
        return quantidade * preco;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidade;
        double preco;
        double precoTotal = 0;
        double recebido;
        double troco;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("[1] - Calcular Preço Total.");
            System.out.println("[2] - Calcular Troco.");
            System.out.println("[3] - Sair.");
            System.out.println("---------------------------------");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Quantidade de itens:");
                    quantidade = scanner.nextInt();
                    System.out.print("Preço por item:");
                    preco = scanner.nextDouble();
                    precoTotal = calcularPrecoTotal(quantidade, preco);
                    System.out.println("Preço total: R$" + precoTotal);
                    break;
                case 2:
                    if (precoTotal <= 0) {
                        System.out.println(
                                "AVISO! A compra não existe valor total, favor, utilizar a seção 1 para calcular o preço total!");
                    } else {
                        System.out.println("Valor recebido: ");
                        recebido = scanner.nextDouble();
                        troco = calcularTroco(recebido, precoTotal);
                        System.out.println("Troco a ser entregue para o cliente é: R$" + troco);
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o programa!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
