package primeirob.Lista03;

import java.text.NumberFormat;
import java.util.Scanner;

public class ListaTresEntrega {
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        while (true) {
            impressaoConsole();

            int opcao = new Scanner(System.in).nextInt();
            if (opcao == 0)
                break;

            switch (opcao) {
                case 1 -> ExibirFuncoes.exibirPrecoTotal();
                case 2 -> ExibirFuncoes.exibirTroco();
                case 3 -> ExibirFuncoes.exibirTotalVenda();
                case 4 -> SalvarFuncoes.salvarDiaMes();
                case 5 -> ExibirFuncoes.exibirVendaDiaEscolhido();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void impressaoConsole() {
        System.out.println("|----------------------------------------------|");
        System.out.println("|          CALCULADORA DONA GABRIELINHA        |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| Escolha uma das opções abaixo:               |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| [1] - Calcular Preço Total.                  |");
        System.out.println("| [2] - Calcular Troco.                        |");
        System.out.println("| [3] - Exibir Vendas Do Dia Atual             |");
        System.out.println("| [4] - Registrar Venda - Selecionar Dia/Mês   |");
        System.out.println("| [5] - Verificar Vendas - Selecionar Dia/Mês  |");
        System.out.println("| [0] - Sair.                                  |");
        System.out.println("|----------------------------------------------|");
        System.out.print("Insira a opção: ");
    }

    private static class CalcularFuncoes {
        public static double calcularPrecoTotal(int quantidade, double preco) {
            double total;
            if (quantidade > 10) {
                total = (quantidade * preco) * 0.95;
            } else {
                total = quantidade * preco;
            }
            SalvarFuncoes.salvar(total);
            return total;

        }

        public static double calcularTroco(double recebido, double total) {
            return recebido - total;
        }
    }

    private static class ExibirFuncoes {
        private static void exibirPrecoTotal() {
            System.out.print("Quantidade de itens:");
            int quantidade = new Scanner(System.in).nextInt();
            System.out.print("Preço por item:");
            double preco = new Scanner(System.in).nextDouble();
            if (quantidade <= 0 || preco <= 0) {
                System.out.print("Os valores devem ser maiores que zero!");
                return;
            }
            double precoTotal = CalcularFuncoes.calcularPrecoTotal(quantidade, preco);
            System.out.println("Preço total: " + CURRENCY_FORMAT.format(precoTotal));
        }

        private static void exibirTroco() {
            System.out.print("Valor Total da Compra: ");
            double total = new Scanner(System.in).nextDouble();
            System.out.print("Valor recebido: ");
            double recebido = new Scanner(System.in).nextDouble();
            if (total <= 0 || recebido <= 0) {
                System.out.print("Os valores devem ser maiores que 0");
                return;
            } else if (recebido < total) {
                System.out.print("O valor que você repassar, deve ser igual ou maior que o valor total da compra!");
                return;
            }
            double troco = CalcularFuncoes.calcularTroco(recebido, total);
            System.out.println("Troco a ser entregue para o cliente é: " + CURRENCY_FORMAT.format(troco));
        }

        public static void exibirTotalVenda() {
            SalvarFuncoes.salvarTotalVenda();
        }

        private static void exibirVendaDiaEscolhido() {
            System.out.println("Digite o dia e o mês para obter o valor da venda (dia mês):");
            System.out.print("Qual dia?: ");
            int diaEsc = new Scanner(System.in).nextInt();
            System.out.print("Qual mês?: ");
            int mesEsc = new Scanner(System.in).nextInt();
            if (diaEsc < 1 || diaEsc > 29 || mesEsc < 1 || mesEsc > 12) {
                System.out.println("Dia ou mês inválido. Tente novamente.");
                return;
            }
            SalvarFuncoes.exibirVendaDiaEscolhido(diaEsc, mesEsc);
        }
    }

    private static class SalvarFuncoes {
        private static final double[] LISTA_VENDAS = new double[100];
        private static int size = 0;
        private static double valorTotalDeVenda = 0;
        private static final double[][] LISTA_MENSAL = new double[29][12];

        public static void salvar(double valorVenda) {
            LISTA_VENDAS[size++] = valorVenda;
            valorTotalDeVenda += valorVenda;
        }

        public static void salvarTotalVenda() {
            System.out.println("Total de Vendas: " + size);
            System.out.println("Valor Total de Vendas: " + CURRENCY_FORMAT.format(valorTotalDeVenda));
            System.out.print("Vendas: ");
            for (int i = 0; i < size; i++) {
                System.out.print(CURRENCY_FORMAT.format(LISTA_VENDAS[i]) + ", ");
            }
        }

        private static void salvarDiaMes() {
            System.out.print("Qual dia?: ");
            int dia = new Scanner(System.in).nextInt();
            System.out.print("Qual mês?: ");
            int mes = new Scanner(System.in).nextInt();
            if (dia < 1 || dia > 29 || mes < 1 || mes > 12) {
                System.out.println("Dia ou mês inválido. Tente novamente.");
                return;
            }
            System.out.print("Qual o valor total da venda?: ");
            double valorDeVenda = new Scanner(System.in).nextDouble();
            salvarDiaMes(dia, mes, valorDeVenda);
            System.out.println("Valor da venda " + CURRENCY_FORMAT.format(valorDeVenda) + " salvo para o dia " + dia
                    + " do mês " + mes + ".");
        }

        public static void salvarDiaMes(int dia, int mes, double valorDeVenda) {
            LISTA_MENSAL[dia - 1][mes - 1] = valorDeVenda;
            // Aqui ele vai zerar as váriaveis (como se tivesse inicializado novo dia)
            valorTotalDeVenda = 0;
            for (int i = size; i >= 0; i--) {
                LISTA_VENDAS[i] = 0;
            }
            size = 0;
        }

        public static void exibirVendaDiaEscolhido(int diaEsc, int mesEsc) {
            System.out.println("O valor total de vendas para o dia escolhido foi dê: "
                    + CURRENCY_FORMAT.format(LISTA_MENSAL[diaEsc - 1][mesEsc - 1]));
        }

    }
}
