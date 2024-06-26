package primeirob.listas;

import java.util.Scanner;

public class PrimeiraLista {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Double valorUm = 0.0;
        Double valorDois = 0.0;

        System.out.println("Menu Sistema Plantas\n");
        System.out.println("[1] Calcular total");
        System.out.println("[2] Calcular troco");
        System.out.println("[3] Sair");
        
        int opcao = input.nextInt();
        
        if (opcao == 1 || opcao == 2) {
            System.out.println("Insira o primeiro valor:");
            valorUm = input.nextDouble();
            System.out.println("Insira o segundo valor:");
            valorDois = input.nextDouble();
        }
        
        if (opcao == 1) {
            System.out.println("Valor da compra:" + (valorUm + valorDois));
        }
        
        if (opcao == 2) {
            System.out.println("Valor do troco:" + (valorUm + valorDois));
        }

        if (opcao == 3) {
            System.out.println("Obrigado por utilizar o sistema");
        }
        
    }

}
