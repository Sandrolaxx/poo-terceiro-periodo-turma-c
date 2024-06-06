package ATV3;

public class Compra {

  private int month;
  private int day;
  private int index;
  private int quantity;
  private double price;
  private double totalPrice;

  public Compra(int month, int day, int index, int quantity, double price) {
    this.month = month;
    this.day = day;
    this.index = index;
    this.quantity = quantity;
    this.price = price;
    this.totalPrice = totalPrice();
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public int getIndex() {
    return index;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }

  public double totalPrice() {
    if (quantity >= 10) {
      return price * quantity * 0.95;
    } else {
      return price * quantity;
    }
  }

  @Override
  public String toString() {
    if (quantity>=10) {
        return "Compra " + (index + 1) + " - Preço: " + String.format("%.2f", price) + "R$ - Quantidade de Plantas: " + quantity + " - Preço total: " + String.format("%.2f", totalPrice) + "R$ - 5% de desconto";
    }
     else {
        return "Compra " + (index + 1) + " - Preço: " + String.format("%.2f", price) + "R$ - Quantidade de Plantas: " + quantity + " - Preço total: " + String.format("%.2f", totalPrice) + "R$ - Não houve desconto";
    }
  }
}
