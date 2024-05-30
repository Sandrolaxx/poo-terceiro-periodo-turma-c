package primeirobimestre.list2.util;

import lombok.extern.log4j.Log4j2;
import primeirobimestre.list2.domain.Sale;
import primeirobimestre.list2.respository.CalculatorRepository02;

@Log4j2
public class CalculatorFunctions02 {
    private static final double DISCOUNT = 0.05; // discount / 100;

    public static double calculatePriceTotal(int quantity, double unitaryValue) throws IllegalArgumentException {
        if (quantity <= 0 || unitaryValue <= 0) {
            throw new IllegalArgumentException("Os valores devem ser maiores que 0");
        }
        log.info("calculating total price...");
        return calculateDiscountOrReturnTotal(quantity, unitaryValue);
    }

    private static double calculateDiscountOrReturnTotal(int quantity, double unitaryValue) {
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

        Sale sale = Sale.SaleBuilder.builder()
                .valueSale(total)
                .quantity(quantity)
                .discount(discount)
                .build();

        CalculatorRepository02.save(sale);
        return total;
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