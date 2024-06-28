package primeirobimestre.list2.util;

import java.text.NumberFormat;

public class CurrencyFormat {
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();

    public static String format(double valueToFormat) {
        return CURRENCY_FORMAT.format(valueToFormat);
    }
}