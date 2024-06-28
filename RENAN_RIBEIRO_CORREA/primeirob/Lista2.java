import java.util.Scanner;

public class Lista2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroVendas registro = new RegistroVendas();

        while (true) {
            System.out.println("Menu Console:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Registrar Venda");
            System.out.println("[3] - Exibir Registros de Vendas");
            System.out.println("[4] - Sair");

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
}