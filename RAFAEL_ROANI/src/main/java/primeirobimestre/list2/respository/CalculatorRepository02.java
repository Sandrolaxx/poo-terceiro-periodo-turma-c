package primeirobimestre.list2.respository;

import lombok.extern.log4j.Log4j2;
import primeirobimestre.list2.domain.Sale;
import primeirobimestre.list2.util.CurrencyFormat;

import java.util.ArrayList;
import java.util.List;

@Log4j2

public class CalculatorRepository02 {
    private static List<Sale> listSales = new ArrayList<>();

    public static void save(Sale sale) {
        log.info("Saving sale in the database...");
        listSales.add(sale);
        log.info("salved sale (:");
    }

    public static void printSales() {
        System.out.println("### VENDAS ###");
        for (Sale sale : listSales) {
            System.out.println(
                    "Valor: " + CurrencyFormat.format(sale.getValueSale()) +
                            ", disconto: " + CurrencyFormat.format(sale.getDiscount()) +
                            ", quantidade: " + sale.getQuantity()
            );
        }
    }
}