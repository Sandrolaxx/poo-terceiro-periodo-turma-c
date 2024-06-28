package primeirobimestre.list1.util;

import java.text.NumberFormat;

public class Calculator01 {
    public static String calculatePriceTotal(int quantity, double unitaryValue) {
        if (quantity <= 0 || unitaryValue <= 0) {
            throw new IllegalArgumentException("Os valores devem ser maiores que 0");
        }
        double total = quantity * unitaryValue;
        return currencyFormatter(total);
    }

    public static String calculateChange(double amountReceived, double amount) {
        if (amountReceived <= 0 || amount <= 0) {
            throw new IllegalArgumentException("Os valores devem ser maiores que 0!");
        }
        if (amount > amountReceived) {
            throw new IllegalArgumentException("O valor recebido deve ser igual ou maior ao total!");
        }

        double change = amountReceived - amount;
        return currencyFormatter(change);
    }

    private static String currencyFormatter(double value) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(value);
    }
}