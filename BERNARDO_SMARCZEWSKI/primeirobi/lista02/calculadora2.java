package primeirobi.lista02;

import java.util.Scanner;

public class calculadora2 {

    static int x = 0;
    static double[] vendas   = new double[20];
    static double[] descontos = new double[20];
    static double[] nPlantas = new double[20];

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("----------- Menu -----------");
            System.out.println(" [1] - Calcular preço total ");
            System.out.println(" [2] - Calcular troco ");
            System.out.println(" [3] - Registros de venda ");
            System.out.println(" [4] - Sair ");
            System.out.println("----------------------------");
            System.out.print(" Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    calculartotal();
                    break;
                case 2:
                    calculartroco();
                    break;
                case 3:
                    registroVenda();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }
        } while (escolha != 4);

        scanner.close();
    }

    public static void calculartotal() {

        Scanner scanner = new Scanner(System.in);
        double total, desconto;

        System.out.println("Qual o preço da planta?");
        double preco = scanner.nextDouble();
        System.out.println("Qual a quantidade de plantas?");
        int quant = scanner.nextInt();

        if (quant > 10) {
            desconto = quant * preco * 0.05;
            total = quant * preco - desconto;
            System.out.println("Foram descontados: " + desconto + "R$");
            System.out.println("Preço com desconto de 5%: " + total + "R$");
        } else {
            desconto = 0;
            total = quant * preco;
            System.out.println("Preço Total: " + total + "R$");
        }

        System.out.println("Venda realizada com sucesso!");

        vendas[x] = total;
        descontos[x] = desconto;
        nPlantas[x] = quant;

        x++;

    }

    public static void calculartroco() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor pago?");
        double pago = scanner.nextDouble();
        System.out.println("Qual o valor da compra?");
        double valor = scanner.nextDouble();

        double troco = pago - valor;
        if (troco > 0) {
            System.out.println("Troco: " + troco);
        } else if (troco == 0) {
            System.out.println("Não é necessário troco.");
        } else {
            System.out.println("O valor pago não cobre o custo!!");
        }

    }

    public static void registroVenda() {
        
        System.out.print("Vendas realizadas:   | ");
        imprimirVetor(vendas, x);

        System.out.print("Plantas vendidas:    | ");
        imprimirVetor(nPlantas, x);

        System.out.print("Descontos aplicados: | ");
        imprimirVetor(descontos, x);

    }   

    public static void imprimirVetor(double[] vetor, int x) {

        for (int i = 0; i < x; i++) {
            System.out.print(vetor[i]);
            System.out.print(" | ");
        }

        System.out.println();

    }

}