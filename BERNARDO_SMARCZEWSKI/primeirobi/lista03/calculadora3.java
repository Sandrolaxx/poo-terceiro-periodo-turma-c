package primeirobi.lista03;

import java.util.Scanner;

public class calculadora3 {

    static int x = 0;
    static double soma = 0, quantDia = 0;
    static double[] vendas   = new double[20];
    static double[] descontos = new double[20];
    static double[] nPlantas = new double[20];

    static double[][] calendario = new double[30][12];
    static double[][] calendario2 = new double[30][12];
    
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("------------> Menu <------------");
            System.out.println(" [1] - Calcular preço da venda ");
            System.out.println(" [2] - Calcular troco ");
            System.out.println(" [3] - Registro de venda do dia");
            System.out.println(" [4] - Salvar vendas do dia");
            System.out.println(" [5] - Ver vendas salvas");
            System.out.println(" [0] - Sair ");
            System.out.println("--------------------------------");
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
                    salvarDia();
                    break;
                case 5:
                    vendasDia();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }
        } while (escolha != 0);

        scanner.close();
    }

    public static void calculartotal() {

        Scanner scanner = new Scanner(System.in);
        double total, desconto;

        System.out.print("Qual o preço da planta? ");
        double preco = scanner.nextDouble();
        System.out.print("Qual a quantidade de plantas? ");
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

        System.out.print("Qual o valor pago? ");
        double pago = scanner.nextDouble();
        System.out.print("Qual o valor da compra? ");
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

        if (nPlantas[0] != 0) {
        
            System.out.print("Vendas realizadas:   | ");
            imprimirVetor(vendas, x);

            System.out.print("Plantas vendidas:    | ");
            imprimirVetor(nPlantas, x);

            System.out.print("Descontos aplicados: | ");
            imprimirVetor(descontos, x);
        } else {

            System.out.println("Não foi feita nenhuma venda hoje");
        }

    }   

    public static void imprimirVetor(double[] vetor, int x) {

        for (int i = 0; i < x; i++) {
            System.out.print(vetor[i]);
            System.out.print(" | ");
        }

        System.out.println();
    }

    public static void zerarVetor(double[] vetor) {

        for (int z = 0; z < vetor.length; z++) {
            vetor[z] = 0;
        }
    }

    public static void salvarDia() {

        int mes, dia;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Que mês você está? ");
        mes = scanner.nextInt();
        mes--;

        System.out.print("Que dia do mês? ");
        dia = scanner.nextInt();
        dia--;

        for (int i = 0; i < vendas.length; i++) {

            soma = soma + vendas[i];
        }

        calendario[dia][mes] = soma;

        for (int i = 0; i < nPlantas.length; i++) {

            quantDia = quantDia + nPlantas[i];
        }

        calendario2[dia][mes] = quantDia;
     
        x = 0;
        soma = 0;
        quantDia = 0;
        zerarVetor(vendas);
        zerarVetor(nPlantas);
        zerarVetor(descontos);

        System.out.println("*ALERTA* Vendas do dia zeradas!");
    }

    public static void vendasDia() {

        int mes, dia;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Que mês deseja ver? ");
        mes = scanner.nextInt();
        mes = mes - 1;

        System.out.print("Que dia do mês? ");
        dia = scanner.nextInt();
        dia = dia - 1;

        System.out.println("Valor das vendas do dia " + (dia + 1) + "/" + (mes + 1) + ": " + calendario[dia][mes]);
        System.out.println("Plantas vendidas no dia " + (dia + 1) + "/" + (mes + 1) + ": " + calendario2[dia][mes]);
    }

}
