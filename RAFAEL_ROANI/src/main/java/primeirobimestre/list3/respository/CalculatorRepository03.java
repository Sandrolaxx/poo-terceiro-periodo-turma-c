package primeirobimestre.list3.respository;

import primeirobimestre.list3.domain.Sale03;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
public class CalculatorRepository03 {
    private static List<Sale03> listSales = new ArrayList<>();

    public static void save(Sale03 sale) {
        log.info("Saving sale in the database...");
        listSales.add(sale);
        log.info("salved sale (:");
    }

    public static void printSales() {
        System.out.print("Qual o dia da venda: ");
        int day = new Scanner(System.in).nextInt();

        System.out.print("Qual o mes da venda: ");
        int month = new Scanner(System.in).nextInt();

        System.out.println("### VENDAS ###");
        listSales.stream()
                .filter(sale -> sale.equalsLocalDate(LocalDate.of(2024, month, day)))
                .forEach(System.out::println);
    }
}