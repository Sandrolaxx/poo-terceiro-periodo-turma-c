package primeirobimetre.lista_1.lista_3;

import java.util.ArrayList;
import java.util.Scanner;


class Calculadoralist3 {

    static class RegistroVendasMensal {
        private ArrayList<Venda>[] vendasPorDia;


        @SuppressWarnings("unchecked")
        public RegistroVendasMensal() {
            vendasPorDia = new ArrayList[30];
            for (int i = 0; i < 30; i++) {
                vendasPorDia[i] = new ArrayList<>();
            }
        }

        public void adicionarVenda(int dia, Venda venda, RegistroVendas registroVendas) {
            vendasPorDia[dia - 1].add(venda);
            registroVendas.atualizarValorTotal(venda.obterValorTotalComDesconto());
        }

        public double[] obterVendasPorDia(int dia) {
            int quantidadeVendas = vendasPorDia[dia - 1].size();
            double valorTotalVendas = 0;
            for (Venda venda : vendasPorDia[dia - 1]) {
                valorTotalVendas += venda.obterValorTotalComDesconto();
            }
            return new double[]{quantidadeVendas, valorTotalVendas};
        }

        public double[] obterVendasPorMes() {
            int quantidadeVendas = 0;
            double valorTotalVendas = 0;
            for (ArrayList<Venda> vendas : vendasPorDia) {
                for (Venda venda : vendas) {
                    quantidadeVendas++;
                    valorTotalVendas += venda.obterValorTotalComDesconto();
                }
            }
            return new double[]{quantidadeVendas, valorTotalVendas};
        }
    }

    static class RegistroVendas {
        private double valorTotal;


        public RegistroVendas() {
            this.valorTotal = 0;
        }

        public void atualizarValorTotal(double valor) {
            this.valorTotal += valor;
        }

        public double obterValorTotal() {
            return valorTotal;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroVendas registroVendas = new RegistroVendas();
        RegistroVendasMensal registroVendasMensal = new RegistroVendasMensal();

        while (true) {
            int opcao = Menu.exibirMenu();

            if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Quantidade de plantas vendidas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    Venda venda = new Venda(quantidade, precoUnitario);
                    System.out.println("Preço total da compra: R$" + venda.obterValorTotalComDesconto());
                    registroVendas.atualizarValorTotal(venda.obterValorTotalComDesconto());
                    registroVendasMensal.adicionarVenda(27, venda, registroVendas);
                    break;
                case 2:
                    System.out.print("Valor total da compra: ");
                    double valorTotalCompra = scanner.nextDouble();
                    System.out.print("Valor pago pelo cliente: ");
                    double valorPago = scanner.nextDouble();
                    double troco = valorPago - valorTotalCompra;
                    if (troco >= 0) {
                        System.out.println("Troco a ser devolvido: R$" + troco);
                    } else {
                        System.out.println("Valor insuficiente. Faltam: R$" + Math.abs(troco));
                    }
                    break;
                case 3:
                    // Venda é registrada automaticamente ao calcular o preço total
                    break;
                case 4:
                    double[] vendasPorMes = registroVendasMensal.obterVendasPorMes();
                    System.out.println("Quantidade de vendas no mês: " + vendasPorMes[0]);
                    System.out.println("Valor total de vendas no mês: R$" + vendasPorMes[1]);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
