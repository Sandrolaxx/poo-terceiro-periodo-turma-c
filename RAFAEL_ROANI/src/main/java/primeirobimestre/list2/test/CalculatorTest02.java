package primeirobimestre.list2.test;

import lombok.extern.log4j.Log4j2;
import primeirobimestre.list2.respository.CalculatorRepository02;
import primeirobimestre.list2.util.CalculatorFunctions02;
import primeirobimestre.list2.util.CurrencyFormat;

import java.util.Scanner;

@Log4j2
public class CalculatorTest02 {

    public static void main(String[] args) {
        log.info("Starting program...");
        while (true) {
            int option = menuAndReturnOption();
            if (option == 0) break;
            try {
                switchOptionsCalculator(option);
            } catch (IllegalArgumentException e) {
                log.warn(e.getMessage());
            }
        }
        log.info("Ending program...");
    }

    private static int menuAndReturnOption() {
        System.out.println("#####  Menu  #####");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registros de Venda");
        System.out.println("[0] - Sair ");
        System.out.print("opção: ");
        return new Scanner(System.in).nextInt();
    }

    private static void switchOptionsCalculator(int option) throws IllegalArgumentException {
        switch (option) {
            case 1 -> calculatePriceTotal();
            case 2 -> calculateChange();
            case 3 -> printSales();
            default -> throw new IllegalArgumentException("Opção invalida");
        }
    }

    private static void calculatePriceTotal() {
        System.out.print("Quantidade: ");
        int quantity = new Scanner(System.in).nextInt();

        System.out.print("Preço unitario: ");
        double unitaryValue = new Scanner(System.in).nextDouble();

        double value = CalculatorFunctions02.calculatePriceTotal(quantity, unitaryValue);
        String valueFormat = CurrencyFormat.format(value);
        System.out.println("Valor total: " + valueFormat);
    }

    private static void calculateChange() {
        System.out.print("Valor recebido: ");
        double amountReceived = new Scanner(System.in).nextDouble();

        System.out.print("Valor total da compra: ");
        double amount = new Scanner(System.in).nextDouble();

        double value = CalculatorFunctions02.calculateChange(amountReceived, amount);
        String valueFormat = CurrencyFormat.format(value);
        System.out.println("Valor do troco: " + valueFormat);
    }
    private static void printSales() {
        CalculatorRepository02.printSales();
    }
}