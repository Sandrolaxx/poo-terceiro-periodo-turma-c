package main;

public class ProductsSale {
    private int quantity;
    private double price;
    private double change;
    private double discountOffered;

    public ProductsSale(int quantity, double price, double discountOffered) {
        this.quantity = quantity;
        this.price = price;
        this.discountOffered = discountOffered;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getChange() {
        return change;
    }

    public void setDiscountOffered(double discountOffered) {
        this.discountOffered = discountOffered;
    }

    public double getDiscountOffered() {
        return discountOffered;
    }

    public double totalAmount() {
        return quantity * price;
    }

    public double calculateChange(double amountReceived) {
        return price - amountReceived;
    }
    
    public class ShowDiscount {
        private boolean discountApplied;

        public ShowDiscount(boolean b) {
            this.discountApplied = false;
        }

        public boolean isDiscountApplied() {
            return discountApplied;
        }

        public void setDiscountApplied(boolean discountApplied) {
            this.discountApplied = discountApplied;
        }
    }
}
