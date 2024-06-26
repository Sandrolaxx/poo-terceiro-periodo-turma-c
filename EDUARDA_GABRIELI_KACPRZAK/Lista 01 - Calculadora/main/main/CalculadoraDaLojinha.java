package main;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraDaLojinha {
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        ArrayList<ProductsSale> recordSales = new ArrayList<ProductsSale>();
        SalesSystem system = new SalesSystem();

        int choice = 0;

        String opc = "S";
        while (opc.equals("S") || opc.equals("s")) {
            System.out.println("Bem vindo(a) ao Sistema da Lojinha!");
            System.out.println("Deseja iniciar o programa? ");
            System.out.println("S/N:   ");
            opc = scan.next();

            while (choice != 4) {
                System.out.println("\n");
                System.out.println("\n-------------------------------------------");
                System.out.println("Menu:");
                System.out.println("[1] - Calcular Preço");
                System.out.println("[2] - Calcular Troco");
                System.out.println("[3] - Ver Registro de Vendas");
                System.out.println("[4] - Salvar no histórico.");
                System.out.println("[5] - Ver Histórico de Vendas por dia.");
                System.out.println("[6] - Ver Histórico de Vendas por mês.");
                System.out.println("[7] - Sair");
                System.out.printf("Escolha uma das opções: ");

                try {
                    choice = scan.nextInt();
                    scan.nextLine();

                    switch (choice) {
                        case 1:
                            ProductsSale sale = new ProductsSale(0, 0.0, 0.0);

                            System.out.printf("%nDigite a quantidade de produtos comprados: ");
                            sale.setQuantity(scan.nextInt());

                            System.out.printf("%nDigite o preço unitário do produto: R$");
                            sale.setPrice(scan.nextDouble());

                            double discount = 0;
                            boolean discountApplied = sale.getQuantity() >= 10;
                            if (discountApplied) {
                                discount = 0.05 * sale.totalAmount();
                                sale.setDiscountOffered(sale.totalAmount() - discount);
                                System.out.println("\n-------------------------------------------");
                                System.out.println("\nResumo da compra: ");
                                System.out.println("Obs: Compra atende requisitos para Desconto!");
                                System.out.printf("\nQnt. de produtos comprados: %d ", sale.getQuantity());
                                System.out.printf("\nValor total da compra com desconto: R$%.2f",
                                        sale.getDiscountOffered());
                            } else {
                                System.out.println("\n-------------------------------------------");
                                System.out.println("\nResumo da compra: ");
                                System.out.printf("%nQnt. de produtos comprados: %d ", sale.getQuantity());
                                System.out.printf("%nTotal da compra: R$%.2f ", sale.totalAmount());
                            }
                            recordSales.add(sale);
                            break;

                        case 2:
                            ProductsSale changeSale = new ProductsSale(0, 0, 0.0);
                            System.out.printf("%nDigite o valor da compra: R$");
                            changeSale.setPrice(scan.nextDouble());

                            System.out.printf("%nDigite o valor recebido pelo cliente: R$");
                            double amountReceived = scan.nextDouble();

                            double change = changeSale.calculateChange(amountReceived);
                            if (amountReceived < changeSale.getPrice()) {
                                System.out.println("\n-------------------------------------------");
                                System.out.printf("\nAviso: Faltam R$%.2f para completar o pagamento",
                                        (changeSale.getPrice() - amountReceived));
                            } else {
                                System.out.println("\n-------------------------------------------");
                                System.out.printf("%nResumo da operação: ");
                                System.out.printf("%nValor da compra: R$%.2f ", changeSale.getPrice());
                                System.out.printf("%nValor recebido pelo cliente: R$%.2f ", amountReceived);
                                System.out.printf("%nTroco do cliente: R$%.2f ", change);
                            }
                            recordSales.add(changeSale);
                            break;

                        case 3:
                            System.out.println("\n-------------------------------------------");
                            System.out.println("\n Registro de vendas:");
                            System.out.println("\n-------------------------------------------");
                            for (int i = 0; i < recordSales.size(); i++) {
                                ProductsSale currentSale = recordSales.get(i);
                                System.out.printf("%nVenda %d:", (i + 1));
                                System.out.printf("%nQuantidade de produtos vendidos: %d%n", currentSale.getQuantity());
                                System.out.printf("Valor de venda por produto: R$%.2f%n", currentSale.getPrice());

                                if (currentSale.getChange() > 0) {
                                    System.out.printf("Troco do cliente: R$%.2f%n", currentSale.getChange());
                                }

                                if (currentSale.getDiscountOffered() > 0) {
                                    System.out.println("Esta venda atendeu requisitos para DESCONTO!");
                                    System.out.printf("Valor total com Desconto Aplicado: R$%.2f%n ",
                                            currentSale.getDiscountOffered());
                                } else {
                                    System.out.println("\nSem desconto.");
                                    System.out.printf("Total da venda: R$%.2f%n", currentSale.totalAmount());
                                    System.out.printf("%n");
                                }
                            }
                            break;

                        case 4:
                            System.out.println("Digite o mês:");
                            String month = scan.nextLine().toLowerCase();
                            System.out.println("Digite o dia:");
                            int day = scan.nextInt();

                            System.out.println("Digite o valor da venda:");
                            double value = scan.nextDouble();

                            system.AddSales(month, day, value);
                            System.out.println("Venda adicionada!");
                            break;

                        case 5:
                            System.out.println("Digite o mês para consultar o histórico: ");
                            month = scan.nextLine().toLowerCase();
                            double totalByMonth = system.getTotalMonthSales(month);

                            System.out.println("Total de vendas em " + month + " foi de: " + totalByMonth);
                            break;

                        case 6:
                            System.out.println("Digite o mês para consultar o histórico: ");
                            month = scan.nextLine().toLowerCase();
                            System.out.println("Digite o dia para consultar o histórico: ");
                            day = scan.nextInt();

                            double totalByDay = system.getTotalDaySales(month, day);

                            System.out.println("Total de vendas em " + day + " de " + month + " foi de: " + totalByDay);
                            break;

                        case 7:
                            System.out.println("\n-------------------------------------------");
                            System.out.println("Obrigado por utilizar o Sistema da Lojinha!");
                            System.out.println("Fechando...");
                            System.out.println("\n-------------------------------------------");
                            System.out.printf("%n%n");
                            break;

                        default:
                            System.out.printf("%n%n%n");
                            System.out.printf("Opção inválida. Por favor, escolha uma opção válida.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("%n%n%n");
                    System.out.println("Erro! Por favor, insira os dados numéricos utilizando '.' ");
                    scan.nextLine();
                }
            }
            break;
        }
        scan.close();
    }
}
