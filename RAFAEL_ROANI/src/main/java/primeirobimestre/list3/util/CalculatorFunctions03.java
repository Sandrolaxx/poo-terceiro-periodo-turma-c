package primeirobimestre.list3.util;

import lombok.extern.log4j.Log4j2;
import primeirobimestre.list3.domain.Sale03;
import primeirobimestre.list3.respository.CalculatorRepository03;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

@Log4j2
public class CalculatorFunctions03 {
    private static final double DISCOUNT = 0.05; // discount / 100;

    public static double calculatePriceTotal(int quantity, double unitaryValue) throws IllegalArgumentException, DateTimeException {
        if (quantity <= 0 || unitaryValue <= 0) {
            throw new IllegalArgumentException("Os valores devem ser maiores que 0");
        }
        log.info("calculating total price...");
        return calculateDiscountOrReturnTotal(quantity, unitaryValue);
    }

    private static double calculateDiscountOrReturnTotal(int quantity, double unitaryValue) throws DateTimeException, IllegalArgumentException {
        log.info("checking if there is a discount...");
        if (quantity <= 0 || unitaryValue <= 0)
            throw new IllegalArgumentException("Os valores devem ser maiores que 0");

        double discount = 0;
        double total;

        if (quantity > 10) {
            log.info("applying discount :)");
            discount = (quantity * unitaryValue) * DISCOUNT;
            total = (quantity * unitaryValue) - discount;
        } else {
            log.info("discount not available :|");
            total = quantity * unitaryValue;
        }
        System.out.println("Deseja salvar a venda? S/N");
        String option = new Scanner(System.in).next();

        if (option.equalsIgnoreCase("S")) {
            saveSaleByDayAndMonth(quantity, total, discount);
        }
        return total;
    }

    private static void saveSaleByDayAndMonth(int quantity, double total, double discount) throws DateTimeException {
        System.out.print("Qual o dia da venda: ");
        int day = new Scanner(System.in).nextInt();

        System.out.print("Qual o mes da venda: ");
        int month = new Scanner(System.in).nextInt();

        Sale03 sale = Sale03.Sale03Builder.builder()
                .quantity(quantity)
                .valueSale(total)
                .discount(discount)
                .dateOfSale(LocalDate.of(2024, month, day))
                .build();

        CalculatorRepository03.save(sale);
    }

    public static double calculateChange(double amountReceived, double amount) throws IllegalArgumentException {
        if (amountReceived <= 0 || amount <= 0) {
            throw new IllegalArgumentException("Os valores devem ser maiores que 0!");
        } else if (amount > amountReceived) {
            throw new IllegalArgumentException("O valor recebido deve ser igual ou maior ao total!");
        }

        return amountReceived - amount;
    }
}