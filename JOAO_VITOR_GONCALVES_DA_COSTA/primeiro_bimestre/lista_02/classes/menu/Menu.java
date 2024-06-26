package lista_02.classes.menu;

import java.util.Scanner;

import lista_02.classes.calculadora.Calculadora;
import lista_02.classes.produto.Produto;

public class Menu {

  public int user_action;
  public String nome_do_produto;
  public double preco_pago_pelo_cliente;
  public int quantidade_vendida;
  public double preco_do_produto;
  public int vetor_index = 0;
  public Produto produtos_vendidos[] = new Produto[20];

  public void iniciarMenu() {
    Calculadora calc = new Calculadora();
    Scanner ler_dados = new Scanner(System.in);

    do {
      System.out.println("--- Escolha uma opção --- ");
      System.out.println("1 - Calcular preço total da venda");
      System.out.println("2 - Ver últimos produtos vendidos");
      System.out.println("3 - Calcular troco do cliente");
      System.out.println("4 - Sair");

      this.user_action = ler_dados.nextInt();
      ler_dados.nextLine();

      switch (this.user_action) {
        case 1:
          Produto produto_vendido = new Produto();
          System.out.println("Qual o nome do produto?");
          this.nome_do_produto = ler_dados.nextLine();

          System.out.println("Quantos produtos foram vendidos?");
          this.quantidade_vendida = ler_dados.nextInt();
          ler_dados.nextLine();

          System.out.println("Qual o valor dos produtos? !(escreva no formato n,n caso seja decimal)!");

          this.preco_do_produto = ler_dados.nextDouble();
          ler_dados.nextLine();
          calc.setPrecoDaVenda(this.quantidade_vendida, this.preco_do_produto);

          produto_vendido.setValues(this.nome_do_produto, this.quantidade_vendida,
              calc.preco_da_venda, calc.desconto_em_reais);

          produtos_vendidos[this.vetor_index] = produto_vendido;
          this.vetor_index++;
          System.out.println("Apenas mais " + (20 - this.vetor_index) + " produtos podem ser adicionados ao histórico");
          break;
        case 2:
          if (this.produtos_vendidos.length == 0)
            System.out.println("Não há produtos adicionados");
          else
            for (int num = 0; num < this.vetor_index; num++) {
              System.out.println(produtos_vendidos[num]);
            }
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
