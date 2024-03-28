package main;

import java.util.ArrayList;
import java.util.Scanner;

public class PlantCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean validEntry = false;
    private static ArrayList<SalesRecord> salesRecords = new ArrayList<>();

    private static final int MAX_MONTH = 12;
    private static final int MAX_DAY = 31;

    private static double[][] salesCalendar = new double[MAX_MONTH][MAX_DAY];

    public static void main(String[] args) {
        int option = 0;
        int confirm = 0;

        do {
            validEntry = false;

            while (!validEntry) {
                exibitMenu();
                option = getValidInputInt("Escolha uma opção:", 6);

                switch (option) {
                    case 1 -> {
                        calculateTotalPrice(); 
                        validEntry = true;
                    }

                    case 2 -> calculateChange();

                    case 3 -> exibitSalesRecord();

                    case 4 -> saveTotalSales();

                    case 5 -> viewDailyTotalSales();

                    case 6 -> {
                        confirm = getValidInputInt("Você realmente deseja fechar a aplicação?\n[1] - Sim\n[2] - Não", 2);
                        switch (confirm) {
                            case 1 -> System.out.println("Fechando aplicação.");
                            case 2 -> validEntry = true;
                            default -> System.out.println("Opção inválida, tente novamente.");
                        }                            
                    }

                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            }
        } while (!(option == 6 && confirm == 1));

        scanner.close();
    }

    private static void exibitMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registro de Vendas");
        System.out.println("[4] - Salvar Vendas Totais em Um Dia");
        System.out.println("[5] - Consultar Vendas Totais em Um Dia");
        System.out.println("[6] - Sair");
    }

    private static int getValidInputInt(String prompt) {
        int input = 0;
        validEntry = false;

        while (!validEntry) {
            System.out.println(prompt);

            try {
                input = scanner.nextInt();
                validEntry = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Você precisa digitar um número inteiro.");
                scanner.nextLine();
            }
        }

        return input;
    }

    private static double getValidInputDouble(String prompt) {
        double input = 0.0;
        validEntry = false;

        while (!validEntry) {
            System.out.println(prompt);

            try {
                input = scanner.nextDouble();
                validEntry = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Você precisa digitar um número decimal.");
                scanner.nextLine();
            }
        }

        return input;
    }

    @SuppressWarnings({ "unused", "resource" })
    private static String getValidInputStr(String prompt) {
        String input = "";
        validEntry = false;

        while (!validEntry) {
            System.out.println(prompt);

            try {
                input = new Scanner(System.in).next();
                validEntry = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Você precisa digitar 's' ou 'n'");
                scanner.nextLine();
            }
        }

        return input;
    }

    private static int getValidInputInt(String prompt, int maxOption) {
        int input = getValidInputInt(prompt);

        while (input < 1 || input > maxOption) {
            System.out.println("Opção inválida, tente novamente.");
            input = getValidInputInt(prompt);
        }

        return input;
    }

    private static void calculateTotalPrice() {
        int quantity = getValidInputInt("Digite a quantidade da planta:");
        double price = getValidInputDouble("Digite o preço unitário da planta:");

        double total = quantity * price;

        SalesRecord salesRecord = new SalesRecord(quantity, total);

        if(quantity >= 10) {
            double discountValue = total;
            total = total - (total * 0.05);

            discountValue = discountValue - total;

            salesRecord.getDiscount().setTheresDiscount(true);
            salesRecord.getDiscount().setDiscountValue(discountValue);

            salesRecord.setProductPrice(total);

            System.out.println("A quantidade de plantas compradas é maior que 10, portanto será concedido um desconto ao cliente.");
        }
        
        System.out.printf("O preço total da venda é: %.2f\n", total);

        salesRecords.add(salesRecord);

        validEntry = false;
    }

    private static void calculateChange() {
        System.out.print("Digite o valor recebido pelo cliente: R$ ");
        double amountReceived = getValidInputDouble("");
        double totalValue = getValidInputDouble("Digite o valor total da compra: R$ ");

        double change = amountReceived - totalValue;

        if (amountReceived > totalValue) {
            System.out.printf("O troco a ser dado ao cliente é: %.2f\n", change);
        } else if (amountReceived == totalValue) {
            System.out.println("Não será necessário dar troco ao cliente");
        } else if (amountReceived < totalValue) {
            System.out.printf("Falta %.2f para o valor total. Peça ao cliente que complete o valor\n", totalValue - amountReceived);
        }

        validEntry = false;
    }

    public static void exibitSalesRecord() {
        for (int i = 0; i < salesRecords.size(); i++) {
            SalesRecord salesRecord = salesRecords.get(i);
            int SaleId = i + 1;
            System.out.println("Venda número " + SaleId + ":");
            System.out.println();
            System.out.println("Quantidade de plantas vendidas: " + salesRecord.getAmountSold());
            System.out.printf("Valor da venda: R$%.2f\n", salesRecord.getProductPrice());
            
            if (salesRecord.getDiscount().isThereDiscount()){
                System.out.printf("Desconto: R$%.2f\n", salesRecord.getDiscount().getDiscountValue());
            } else {
                System.out.println("Não houve desconto nesta venda.");
            }
            System.out.println("\n");
        }
    }

    private static void saveTotalSales() {
        int day = getValidInputInt("Informe o dia da venda: ", 30) - 1;
        int month = getValidInputInt("Informe o mês da venda: ", 12) - 1;
        double value = getValidInputDouble("Informe o valor total feito em vendas neste dia: R$");

        salesCalendar[month][day] = value;
    }

    private static void viewDailyTotalSales() {
        int day = getValidInputInt("Informe o dia das vendas que deseja consultar o valor: ", 30) - 1;
        int month = getValidInputInt("Informe o mês da vendas que deseja consultar o valor: ", 12) - 1;
        
        if (salesCalendar[month][day] == 0) {
            System.out.println("Nenhum valor foi passado para o dia que você selecionou.");
        } else {
            System.out.printf("O valor total vendido no dia informado é: R$%.2f\n", salesCalendar[month][day]);
        }
    }
}