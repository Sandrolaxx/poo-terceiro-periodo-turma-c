package primeirobimestre.list1.test;

import lombok.extern.log4j.Log4j2;
import primeirobimestre.list1.util.Calculator01;

import java.util.Scanner;

@Log4j2
public class CalculatorTest01 {

    public static void main(String[] args) {
        log.info("Starting program...");
        while (true) {
            int option = menu();
            if (option == 3) break;
            switchOptionsCalculator(option);
        }
        log.info("Ending program...");
    }

    private static int menu() {
        System.out.println("#####  Menu  #####");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair ");
        System.out.print("opção: ");

        return new Scanner(System.in).nextInt();
    }

    private static void switchOptionsCalculator(int option) {
        switch (option) {
            case 1 -> caseOptionOne();
            case 2 -> caseOptionTwo();
            default -> throw new IllegalArgumentException("Opção invalida!");
        }
    }

    private static void caseOptionOne() {
        System.out.print("Quantidade: ");
        int quantity = new Scanner(System.in).nextInt();
        System.out.print("Preço unitario: ");
        double unitaryValue = new Scanner(System.in).nextDouble();

        String value = Calculator01.calculatePriceTotal(quantity, unitaryValue);
        System.out.println("Valor total: " + value);
    }

    private static void caseOptionTwo() {
        System.out.print("Valor recebido: ");
        double amountReceived = new Scanner(System.in).nextDouble();
        System.out.print("Valor total da compra: ");
        double amount = new Scanner(System.in).nextDouble();

        String value = Calculator01.calculateChange(amountReceived, amount);
        System.out.println("Valor do troco: " + value);
    }
}