package primeirobimestre.list3.domain;

import list3.util.CurrencyFormat03;

import java.time.LocalDate;
import java.util.Objects;


public class Sale03 {
    private double valueSale;
    private double discount;
    private int quantity;
    private LocalDate dateOfSale;

    private Sale03() {}

    public boolean equalsLocalDate(LocalDate localDate) {
        return dateOfSale.equals(localDate);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "Valor: " + CurrencyFormat03.format(valueSale) +
                ", desconto: " + CurrencyFormat03.format(discount) +
                ", quantidade: " + quantity +
                ", data da venda: " + dateOfSale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale03 sale03)) return false;
        return Double.compare(valueSale, sale03.valueSale) == 0 &&
                Double.compare(discount, sale03.discount) == 0 &&
                quantity == sale03.quantity &&
                Objects.equals(dateOfSale, sale03.dateOfSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueSale, discount, quantity, dateOfSale);
    }

    public double getValueSale() {
        return valueSale;
    }

    public double getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }


    public static final class Sale03Builder {
        private double valueSale;
        private double discount;
        private int quantity;
        private LocalDate dateOfSale;

        private Sale03Builder() {
        }

        public static Sale03Builder builder() {
            return new Sale03Builder();
        }

        public Sale03Builder valueSale(double valueSale) {
            this.valueSale = valueSale;
            return this;
        }

        public Sale03Builder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public Sale03Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Sale03Builder dateOfSale(LocalDate dateOfSale) {
            this.dateOfSale = dateOfSale;
            return this;
        }

        public Sale03 build() {
            Sale03 sale03 = new Sale03();
            sale03.quantity = this.quantity;
            sale03.valueSale = this.valueSale;
            sale03.discount = this.discount;
            sale03.dateOfSale = this.dateOfSale;
            return sale03;
        }
    }
}