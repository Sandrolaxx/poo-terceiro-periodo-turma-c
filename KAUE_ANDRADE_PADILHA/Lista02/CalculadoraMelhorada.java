import java.util.Scanner;

public class CalculadoraMelhorada {  

  private static int quantity; // Quantidade comprada
  private static double totalPrice; // Preço * Quantidade
  
  private static double[][] sales = new double[100][3]; // Matriz de vendas
  private static int salesCount = 0; // Quantidade de vendas
  
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    Scanner menu = new Scanner(System.in);
    Scanner flowersQuantity = new Scanner(System.in);
    Scanner pricePaid = new Scanner(System.in);
    
    double price; // Preço da planta
    double amountPaid; // Valor pago pelo cliente

    int option;
    
    while (true) {
      showMenu();

      System.out.print("Digite uma opção: ");
      option = menu.nextInt();

      if (option == 0) {
        System.out.println("Saindo do Menu...");
        menu.close();
        return;
      }

      switch (option) {
        case 1:
          price = 12.00;
          
          System.out.print("Quantas Rosas foram compradas? ");
          quantity = flowersQuantity.nextInt();
          totalPrice = calculateTotal(price, quantity); 
          
          System.out.print("Valor pago pelo cliente: ");
          amountPaid = pricePaid.nextDouble();
          
          calculateTroco(totalPrice, amountPaid);

          saveSell(sales, quantity, totalPrice);
          break;
        case 2:
          price = 10.50;
            
          System.out.print("Quantos Girassóis foram comprados? ");
          quantity = flowersQuantity.nextInt();
          totalPrice = calculateTotal(price, quantity);
          
          System.out.print("Valor pago pelo cliente: ");
          amountPaid = pricePaid.nextDouble();
          calculateTroco(totalPrice, amountPaid);

          saveSell(sales, quantity, totalPrice);
          break;
        case 3:
          price = 15.75;
              
          System.out.print("Quantas Orquídeas foram compradas? ");
          quantity = flowersQuantity.nextInt();
          totalPrice = calculateTotal(price, quantity);
          
          System.out.print("Valor pago pelo cliente: ");
          amountPaid = pricePaid.nextDouble();
          calculateTroco(totalPrice, amountPaid);

          saveSell(sales, quantity, totalPrice);
          break;
        case 4:
          price = 14.00;

          System.out.print("Quantos Lírios foram comprados? ");
          quantity = flowersQuantity.nextInt();
          totalPrice = calculateTotal(price, quantity);
          
          System.out.print("Valor pago pelo cliente: ");
          amountPaid = pricePaid.nextDouble();
          calculateTroco(totalPrice, amountPaid);

          saveSell(sales, quantity, totalPrice);
          break;
        case 5:
          price = 8.50;
              
          System.out.print("Quantas Violetas foram compradas? ");
          quantity = flowersQuantity.nextInt();
          totalPrice = calculateTotal(price, quantity);
          
          System.out.print("Valor pago pelo cliente: ");
          amountPaid = pricePaid.nextDouble();
          calculateTroco(totalPrice, amountPaid);

          saveSell(sales, quantity, totalPrice);
          break;
        case 6:
          showSells(sales, salesCount);
          break;
        default:
          System.out.println("\nOpção Inválida!\n");
          break;
      }
    }
  }

  public static void showMenu() {
    System.out.println("|----------- LOJA DE PLANTAS -----------|");
    System.out.println("|---------------------------------------|");
    System.out.println("|            MENU PRINCIPAL             |");
    System.out.println("|---------------------------------------|");
    System.out.println("| 1 - Rosa:            R$ 12.00         |");
    System.out.println("| 2 - Girassol:        R$ 10.50         |");
    System.out.println("| 3 - Orquídea:        R$ 15.75         |");
    System.out.println("| 4 - Lírio:           R$ 14.00         |");
    System.out.println("| 5 - Violeta:         R$ 8.50          |");
    System.out.println("|---------------------------------------|");
    System.out.println("| 6 - Ver Registro de Vendas            |");
    System.out.println("| 0 - Sair do Menu                      |");
    System.out.println("|---------------------------------------|");
  }

  public static double calculateTotal(double price, int quantity) {
    double totalPrice = price * quantity;

    if (quantity > 10) {
      double priceWithDiscount = totalPrice - (totalPrice * 0.05);
      System.out.println("\nValor a ser pago: R$ " + priceWithDiscount);
      return priceWithDiscount;
    }

    System.out.println("\nValor a ser pago: R$ " + totalPrice);
    return totalPrice;
  }

  public static void calculateTroco(double totalPrice, double amountPaid) {
    double amountReturned = amountPaid - totalPrice;
    if (amountReturned > 0) {
      System.out.println("Troco do cliente: R$ " + amountReturned + "\n");
    } else if (amountReturned < 0) {
      System.out.println("Faltam R$ " + (totalPrice - amountPaid) + "\n");
    } else {
      System.out.println("Não há troco a ser devolvido.\n");
    }
  }

  public static void saveSell(double[][] sales, int quantity, double totalPrice) {
    /*
    Quantidade | Total | Desconto
    */
    sales[salesCount][0] = quantity;
    sales[salesCount][1] = totalPrice;
    sales[salesCount][2] = totalPrice * 0.05;
    salesCount++;
  }

  public static void showSells(double[][] sales, int salesCount) {
    System.out.println("\n---- Registro de Vendas ---- ");
    for (int i = 0; i < salesCount; i++) {
      System.out.println(
        "Venda " + (i + 1) + 
        ": Quantidade: " + sales[i][0] + 
        ", Valor: R$ " + sales[i][1] + 
        ", Desconto: R$" + sales[i][2]
      );
    }
    System.out.println();
  }
}