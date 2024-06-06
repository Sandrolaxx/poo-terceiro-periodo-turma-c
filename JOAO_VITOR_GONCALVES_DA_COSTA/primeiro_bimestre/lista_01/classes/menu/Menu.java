package lista_01.classes.menu;

import java.util.Locale;
import java.util.Scanner;

import lista_01.classes.calculadora.*;

public class Menu {

  public int user_action;
  public double preco_pago_pelo_cliente;
  public int quantidade_vendida;
  public double preco_do_produto;

  public void iniciarMenu() {
    Calculadora calc = new Calculadora();
    Scanner ler_dados = new Scanner(System.in);
    ler_dados.useLocale(Locale.US);

    do {
      System.out.println("--- Escolha uma opção --- ");
      System.out.println("1 - Calcular preço total da venda");
      System.out.println("2 - Ver último preço calculado");
      System.out.println("3 - Calcular troco do cliente");
      System.out.println("4 - Sair");

      this.user_action = ler_dados.nextInt();

      switch (this.user_action) {
        case 1:
          System.out.println("Quantos produtos foram vendidos?");
          this.quantidade_vendida = ler_dados.nextInt();
          ler_dados.nextLine();
          System.out.println("Qual o valor dos produtos? !(escreva no formato n.n caso seja decimal)!");
          this.preco_do_produto = ler_dados.nextDouble();
          ler_dados.nextLine();
          calc.setPrecoDaVenda(this.quantidade_vendida, this.preco_do_produto);
          break;
        case 2:
          System.out.println("Preço de venda R$ " + calc.verPrecoDaVenda());
          break;
        case 3:
          if (calc.preco_da_venda == 0.0) {
            System.out.println("Primeiro defina o preço de venda");
            break;
          }
          System.out.println("Valor pago pelo cliente? !(escreva no formato n.n caso seja decimal)!");
          this.preco_pago_pelo_cliente = ler_dados.nextDouble();
          ler_dados.nextLine();
          calc.setTrocoDoCliente(this.preco_pago_pelo_cliente);
          break;
        case 4:
          System.out.println("Fechando programa ...");
          break;
        default:
          System.out.println("Opção inválida!!!");
          break;

      }
    } while (this.user_action != 4);

    ler_dados.close();
  }
}
