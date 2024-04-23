package lista_2.classes.menu;

import java.util.Scanner;

import lista_2.classes.calculadora.Calculadora;
import lista_2.classes.produto.Produto;

public class Menu {
    public int user;
    public String nomeProduto;
    public double precoPagoCliente;
    public int quantidadeVendida;
    public double precoProduto;
    public int vetorIndex = 0;
    public Produto produtosVendidos[] = new Produto[20];

    public void iniciarMenu() {
        Calculadora calc = new Calculadora();
        Scanner dados = new Scanner(System.in);

        do {
            System.out.println("--- Escolha uma opção --- ");
            System.out.println("1 - Calcular preço total da venda");
            System.out.println("2 - Ver últimos produtos vendidos");
            System.out.println("3 - Calcular troco do cliente");
            System.out.println("4 - Sair");

            this.user = dados.nextInt();
            dados.nextLine();

            switch (this.user) {
                case 1:
                    Produto produtoVendido = new Produto();
                    System.out.println("Qual o nome do produto?");
                    this.nomeProduto = dados.nextLine();

                    System.out.println("Quantos produtos foram vendidos?");
                    this.quantidadeVendida = dados.nextInt();
                    dados.nextLine();

                    System.out.println("Qual o valor dos produtos? (escreva no formato n.n caso seja decimal)");

                    this.precoProduto = dados.nextDouble();
                    dados.nextLine();
                    calc.setPrecoDaVenda(this.quantidadeVendida, this.precoProduto);

                    produtoVendido.setValues(this.nomeProduto, this.quantidadeVendida,
                            calc.precoVenda, calc.desconto);

                    produtosVendidos[this.vetorIndex] = produtoVendido;
                    this.vetorIndex++;
                    System.out.println("Apenas mais " + (20 - this.vetorIndex) + " produtos podem ser adicionados ao histórico");
                    break;
                case 2:
                    if (this.vetorIndex == 0)
                        System.out.println("Não há produtos adicionados");
                    else
                        for (int num = 0; num < this.vetorIndex; num++) {
                            System.out.println(produtosVendidos[num]);
                        }
                    break;
                case 3:
                    if (calc.precoVenda == 0.0) {
                        System.out.println("Primeiro defina o preço de venda");
                        break;
                    }
                    System.out.println("Valor pago pelo cliente?");
                    this.precoPagoCliente = dados.nextDouble();
                    dados.nextLine();
                    calc.setTrocoDoCliente(this.precoPagoCliente);
                    double troco = calc.calcularTroco(precoPagoCliente);
                    System.out.println("Troco do cliente: " + troco);
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
