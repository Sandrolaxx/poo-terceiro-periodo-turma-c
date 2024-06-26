import java.util.Scanner;

public class Meses_plantinhas {
    static class Venda {
        int quantidade;
        double valorTotal;
        int dia;
        int mes;

        public Venda(int quantidade, double valorTotal, int dia, int mes) {
            this.quantidade = quantidade;
            this.valorTotal = valorTotal;
            this.dia = dia;
            this.mes = mes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double desconto = 0;
        Venda[] registroVendas = new Venda[100];
        int vendasRegistradas = 0;
        int[] vendasPorDia = new int[30];
        int[][] vendasPorMesDia = new int[12][30];

        while (true) {
            System.out.println("Ola, seja bem vindo ao menu. :)");
            System.out.println("[1] -  calcular compra");
            System.out.println("[2] - registrar venda");
            System.out.println("[3] - calcular o Troco");
            System.out.println("[4] - buscar por quantidade de vendas /mês e dia");
            System.out.println("[5] - Sair");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    calcularCompra(scanner, desconto);
                    break;

                case 2:
                    registrarVenda(scanner, registroVendas, vendasRegistradas, vendasPorDia, vendasPorMesDia);
                    vendasRegistradas++;
                    break;

                case 3:
                    calcularTroco(scanner);
                    break;

                case 4:
                    buscarQuantidadeVendas(scanner, vendasPorMesDia);
                    break;

                case 5:
                    System.out.println("Encerrando Sessão ");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Use os dígitos dados no menu");
            }
        }
    }

    public static void calcularCompra(Scanner scanner, double desconto) {
        System.out.println("Digite a quantidade da planta:");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço da planta:");
        double precoUni = scanner.nextDouble();
        double total = quantidade * precoUni;

        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
            System.out.println("Desconto Especial de 5% aplicado.");
        }

        System.out.printf("O preço total é: %.2f\n", total);
    }

    public static void registrarVenda(Scanner scanner, Venda[] registroVendas, int vendasRegistradas,
                                      int[] vendasPorDia, int[][] vendasPorMesDia) {
        System.out.println("Registro de Venda:");
        System.out.println("Digite a quantidade de plantas vendidas:");
        int quantidadeVendidaInput = scanner.nextInt();
        System.out.println("Digite o valor total da venda:");
        double valorVenda = scanner.nextDouble();
        System.out.println("Digite o dia da venda:");
        int diaVenda = scanner.nextInt();
        System.out.println("Digite o mês da venda:");
        int mesVenda = scanner.nextInt();

        registroVendas[vendasRegistradas] = new Venda(quantidadeVendidaInput, valorVenda, diaVenda, mesVenda);

        vendasPorDia[diaVenda - 1] += quantidadeVendidaInput;
        vendasPorMesDia[mesVenda - 1][diaVenda - 1] += quantidadeVendidaInput;

        System.out.println("Venda registrada com sucesso.");
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.println("Digite o valor recebido:");
        double valorRecebido = scanner.nextDouble();
        System.out.println("Digite o valor total da compra:");
        double compra = scanner.nextDouble();
        double troco = calcularTroco(valorRecebido, compra);
        System.out.printf("O troco é: %.2f\n", troco);
    }

    public static void buscarQuantidadeVendas(Scanner scanner, int[][] vendasPorMesDia) {
        System.out.println("Digite o mês :");
        int mes = scanner.nextInt();
        System.out.println("Digite o dia :");
        int dia = scanner.nextInt();
        System.out.println("Quantidade de vendas para o dia " + dia + " do mês " + mes + ": " +
                vendasPorMesDia[mes - 1][dia - 1]);
    }

    public static double calcularTroco(double valorRecebido, double valorCompra) {
        return valorRecebido - valorCompra;
    }
}
