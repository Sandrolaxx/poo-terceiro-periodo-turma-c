import java.util.Scanner;

public class CalculadoraDePlantasParte3 {

    private static int quantidadeTotalVendida = 0;
    private static double valorTotalVendas = 0;
    private static double totalDescontos = 0;
    private static int[][] vendasPorDiaEMes = new int[31][12]; // Matriz para armazenar as vendas por dia e mês

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção (1, 2, 3, 4 ou 5): ");
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
                    registrarVendasDiaMes();
                    break;
                case 5:
                    buscarVendasDiaMes();
                    break;
                case 6:
                    System.out.println("Tchau brigado!");
                    break;
                default:
                    System.out.println("Esse número não. Por favor, escolha 1, 2, 3, 4 ou 5.");
            }

        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registros de Vendas");
        System.out.println("[4] - Registrar Vendas do Dia e Mês");
        System.out.println("[5] - Buscar Vendas por Dia e Mês");
        System.out.println("[6] - Sair");
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

    private static void registrarVendasDiaMes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia (1-31): ");
        int dia = lerNumero(scanner, 1, 31);

        System.out.print("Digite o mês (1-12): ");
        int mes = lerNumero(scanner, 1, 12);

        System.out.print("Digite a quantidade de vendas: ");
        int quantidade = scanner.nextInt();

        vendasPorDiaEMes[dia - 1][mes - 1] += quantidade;

        System.out.println("Vendas registradas com sucesso para o dia " + dia + " do mês " + mes + ".");
    }

    private static void buscarVendasDiaMes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia (1-31): ");
        int dia = lerNumero(scanner, 1, 31);

        System.out.print("Digite o mês (1-12): ");
        int mes = lerNumero(scanner, 1, 12);

        int vendas = vendasPorDiaEMes[dia - 1][mes - 1];

        System.out.println("Quantidade de vendas para o dia " + dia + " do mês " + mes + ": " + vendas);
    }

    private static int lerNumero(Scanner scanner, int min, int max) {
        int numero;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next();
            }
            numero = scanner.nextInt();
            if (numero < min || numero > max) {
                System.out.println("Número fora do intervalo válido [" + min + ", " + max + "]. Tente novamente.");
            }
        } while (numero < min || numero > max);
        return numero;
    }
}
