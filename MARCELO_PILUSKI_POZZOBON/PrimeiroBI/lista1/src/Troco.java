package lista1.src;

import java.util.Scanner;

public class Troco {
    protected Scanner dinheiroCliente = new Scanner(System.in);
    protected Scanner precoTotal = new Scanner(System.in);

    public void calculaTroco() {
        System.out.print("Digite o dinheiro recebido: ");
        double valor = dinheiroCliente.nextDouble();
        System.out.print("Digite o valor da compra: ");
        double compra = precoTotal.nextDouble();
        System.out.println("Seu troco é de: " + (valor - compra) + " reais.");
    }
}
