import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista02 {
    static class Venda {
        int quantidade;
        double precoUnitario;
        double desconto;
        double valorTotal;

        public Venda(int quantidade, double precoUnitario, double desconto, double valorTotal) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.desconto = desconto;
            this.valorTotal = valorTotal;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> registroVendas = new ArrayList<>();

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarVenda(scanner, registroVendas);
                    break;
                case 2:
                    exibirRegistroVendas(registroVendas);
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar a calculadora de plantas. Volte sempre!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("[1] - Calcular Preço Total e Aplicar Desconto Especial (se aplicável)");
        System.out.println("[2] - Exibir Registro de Vendas");
        System.out.println("[3] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void registrarVenda(Scanner scanner, List<Venda> registroVendas) {
        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        double desconto = 0.0;

        if (quantidade > 10) {
            desconto = precoTotal * 0.05;
            precoTotal -= desconto;
        }

        registroVendas.add(new Venda(quantidade, precoUnitario, desconto, precoTotal));

        System.out.println("O preço total da venda é: " + precoTotal);
        System.out.println("Desconto aplicado: " + desconto);
        System.out.println("Venda registrada com sucesso.");
    }

    private static void exibirRegistroVendas(List<Venda> registroVendas) {
        System.out.println("===== Registro de Vendas =====");
        for (Venda venda : registroVendas) {
            System.out.println("Quantidade: " + venda.quantidade);
            System.out.println("Preço Unitário: " + venda.precoUnitario);
            System.out.println("Desconto: " + venda.desconto);
            System.out.println("Valor Total: " + venda.valorTotal);
            System.out.println("-----------------------------");
        }
    }
}