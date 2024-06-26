import java.util.Scanner;

public class Lista3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroVendas registro = new RegistroVendas();

        while (true) {
            System.out.println("Menu Console:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Registrar Venda");
            System.out.println("[3] - Exibir Registros de Vendas");
            System.out.println("[4] - Registrar total por dia/mes");
            System.out.println("[5] - Exibir registro de venda de algum dia/mes");
            System.out.println("[0] - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade da planta vendida: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();
                double precoTotal = calcularPrecoTotal(quantidade, precoUnitario, registro);
                System.out.println("O preço total da venda é: " + precoTotal);

            } else if (opcao == 2) {
                System.out.print("Digite a quantidade da planta vendida: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();
                registro.registrarVenda(quantidade, precoUnitario);
                System.out.println("Venda registrada com sucesso!");

            } else if (opcao == 3) {
                System.out.println("Registros de Vendas:");
                System.out.println("Total de plantas vendidas: " + registro.getTotalPlantasVendidas());
                System.out.println("Total de vendas: " + registro.getTotalVendas());
                System.out.println("Total de descontos aplicados: " + registro.getTotalDescontos());

            } else if (opcao == 4) {
                System.out.print("Qual dia para registrar: ");
                int dia = new Scanner(System.in).nextInt();

                System.out.print("Qual mes para registrar: ");
                int mes = new Scanner(System.in).nextInt();

                if (dia <= 0 || mes <= 0 || dia > 29 || mes > 12) {
                    System.out.println("Data invalida");
                    return;
                }

                System.out.print("Qual o valor total de vendas do dia: ");
                double valorTotalVenda = new Scanner(System.in).nextDouble();

                System.out.print("Qual o valor total de descontos do dia: ");
                double valorTotalDesconto = new Scanner(System.in).nextDouble();

                System.out.print("Qual a quantidade total de vendas do dia: ");
                int quantidadeTotalVendas = new Scanner(System.in).nextInt();

                RegistroVendas.registrarVendaDiaMes(valorTotalVenda, valorTotalDesconto, quantidadeTotalVendas, dia, mes);

            } else if (opcao == 5) {
                System.out.print("Qual dia do registro: ");
                int dia = new Scanner(System.in).nextInt();

                System.out.print("Qual mes do registro: ");
                int mes = new Scanner(System.in).nextInt();

                if (dia <= 0 || mes <= 0 || dia > 29 || mes > 12) {
                    System.out.println("Data invalida");
                    return;
                }

                System.out.println("### Vendas ###");
                System.out.println("Valor total: R$ " + RegistroVendas.getTotalVendasDiaMes(dia, mes));
                System.out.println("Descontos totais: R$ " + RegistroVendas.getTotalDescontosDiaMes(dia, mes));
                System.out.println("Vendas totais: R$ " + RegistroVendas.getTotalQuantidadesDiaMes(dia, mes));
            } else if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    public static double calcularPrecoTotal(int quantidade, double precoUnitario, RegistroVendas registro) {
        double precoTotal = quantidade * precoUnitario;
        if (quantidade > 10) {
            double desconto = precoTotal * 0.05; // 5% de desconto
            registro.aplicarDesconto(desconto);
            precoTotal -= desconto;
        }
        return precoTotal;
    }
}

class RegistroVendas {
    private static double totalVendasDiaMes[][] = new double[29][12];
    private static double totalDescontosDiaMes[][] = new double[29][12];
    private static int totalQuantidadesDiaMes[][] = new int[29][12];

    private int totalPlantasVendidas;
    private double totalVendas;
    private double totalDescontos;

    public RegistroVendas() {
        totalPlantasVendidas = 0;
        totalVendas = 0.0;
        totalDescontos = 0.0;
    }

    public void registrarVenda(int quantidade, double precoUnitario) {
        totalPlantasVendidas += quantidade;
        double valorVenda = quantidade * precoUnitario;
        totalVendas += valorVenda;
    }

    public void aplicarDesconto(double desconto) {
        totalDescontos += desconto;
    }

    // Getters para os totais
    public int getTotalPlantasVendidas() {
        return totalPlantasVendidas;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public double getTotalDescontos() {
        return totalDescontos;
    }

    public static void registrarVendaDiaMes(double valorTotal, double descontosTotais, int quantidadeVendasTotais, int dia, int mes) {
        totalVendasDiaMes[dia - 1][mes - 1] = valorTotal;
        totalDescontosDiaMes[dia - 1][mes - 1] = descontosTotais;
        totalQuantidadesDiaMes[dia - 1][mes - 1] = quantidadeVendasTotais;
    }

    public static double getTotalVendasDiaMes(int dia, int mes) {
        return totalVendasDiaMes[dia - 1][mes - 1];
    }

    public static double getTotalDescontosDiaMes(int dia, int mes) {
        return totalDescontosDiaMes[dia - 1][mes - 1];
    }

    public static int getTotalQuantidadesDiaMes(int dia, int mes) {
        return totalQuantidadesDiaMes[dia - 1][mes - 1];
    }
}
