package lista2.src;

import java.util.Scanner;

public class PrecoTotal {
    protected Scanner preco = new Scanner(System.in);
    protected Scanner quantidade = new Scanner(System.in);

    public void calculaPrecoTotal() {
        System.out.print("Digite a quantidade: ");
        int quantidadeProdutos = quantidade.nextInt();
        System.out.print("Digite o preço: ");
        double valor = preco.nextDouble();
        double preco = valor * quantidadeProdutos;
        if (quantidadeProdutos > 10) {
            double valorDescontado = descontoEspecial(preco);
            System.out.println("Desconto de 10% aplicado!");
            System.out.println("R$" + valorDescontado);
        } else{
            System.out.println("R$" + preco);
        }
        ;
    }

    public static double descontoEspecial(double preco) {
        return preco * 0.9; // coloca 10% a menos no preço
    }
}
