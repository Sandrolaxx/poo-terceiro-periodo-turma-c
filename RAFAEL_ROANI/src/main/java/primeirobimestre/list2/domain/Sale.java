package primeirobimestre.list2.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Sale {
    double valueSale;
    double discount;
    int quantity;


    public static final class SaleBuilder {
        private double valueSale;
        private double discount;
        private int quantity;

        private SaleBuilder() {
        }

        public static SaleBuilder builder() {
            return new SaleBuilder();
        }

        public SaleBuilder valueSale(double valueSale) {
            this.valueSale = valueSale;
            return this;
        }

        public SaleBuilder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public SaleBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Sale build() {
            Sale sale = new Sale();
            sale.quantity = this.quantity;
            sale.valueSale = this.valueSale;
            sale.discount = this.discount;
            return sale;
        }
    }
}