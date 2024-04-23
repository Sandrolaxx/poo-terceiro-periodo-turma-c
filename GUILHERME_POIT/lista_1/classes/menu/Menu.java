package lista_1.classes.menu;

import java.util.Locale;
import java.util.Scanner;
import lista_1.classes.calculadora.*;

public class Menu {

  public int user;
  public double valor_pago;
  public int quant_vendida;
  public double preco_produto;

  public void iniMenu() {
    Calculadora calc = new Calculadora();
    Scanner dados = new Scanner(System.in);
    dados.useLocale(Locale.US);

    do {
      
      System.out.println("Escolha uma opção ");
      System.out.println("1:Calcular preço total da venda");
      System.out.println("2:Ver último preço calculado");
      System.out.println("3:Calcular troco do cliente");
      System.out.println("4:Sair");

      this.user = dados.nextInt();

      switch (this.user) {

        case 1:
          System.out.println("Quantidade de itens vendidos?");
          this.quant_vendida = dados.nextInt();
          dados.nextLine();
          System.out.println("Valor dos produtos? ");
          this.preco_produto = dados.nextDouble();
          dados.nextLine();
          calc.setPrecoDaVenda(this.quant_vendida, this.preco_produto);
          break;

        case 2:
          System.out.println("Preço de venda R$ " + calc.verPrecoDaVenda());
          break;

        case 3:
          if (calc.preco_venda == 0.0) {
            System.out.println("Defina o preço de venda");
            break;
          }
          System.out.println("Valor pago pelo cliente?");
          this.valor_pago = dados.nextDouble();
          dados.nextLine();
          calc.setTrocoDoCliente(this.valor_pago);
          break;

        case 4:
          System.out.println("Fechando programa ...");
          break;
        default:
          System.out.println("Opção inválida!!!");
          break;

      }
    } while (this.user != 4);

    dados.close();
  }
}
