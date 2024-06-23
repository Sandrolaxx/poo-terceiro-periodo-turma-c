package lista1.src;

import java.util.Scanner;

public class PrecoTotal {
    protected Scanner preco = new Scanner(System.in);
    protected Scanner quantidade = new Scanner(System.in);

    public void calculaPrecoTotal() {
        System.out.print("Digite a quantidade: ");
        int quantidadeProdutos = quantidade.nextInt();
        System.out.print("Digite o preço: ");
        double valor = preco.nextDouble();
        System.out.println("R$" + (valor * quantidadeProdutos));
    }
}
