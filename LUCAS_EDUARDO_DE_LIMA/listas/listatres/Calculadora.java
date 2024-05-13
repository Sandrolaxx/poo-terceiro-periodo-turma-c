package LUCAS_EDUARDO_DE_LIMA.listas.listatres;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        while (true) {
            int opcao = menu();

            switch (opcao) {
                case 1 -> calcularTotal();


                default -> System.out.println("calculadora");

            }
        }
    }

    private static int menu() {
        System.out.println("Escolha uma opção a baixo:");
        System.out.println(" 1- Calcular total:");
        System.out.println(" 2- Calcular troco:");
        System.out.println(" 3- Imprimir vendas do dia do mês:");
        System.out.println(" 0- Sair");
        System.out.print("Opção: ");
        return new Scanner(System.in).nextInt();

    }

    private static int calcularTotal() {
        System.out.println("Digite o valor da planta:");
        double valor = new Scanner(System.in).nextDouble();
        System.out.println("Digite a quantidade da planta:");
        int quantidade = new Scanner(System.in).nextInt();

        double total = (valor * quantidade);
        double desconto = 0;

        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;

            System.out.println("O desconto foi aplicado.");

        }

        System.out.println("Deseja salvar está venda? s/n");
        String salvarVenda = new Scanner(System.in).next();

        if (salvarVenda.equalsIgnoreCase("s")) {

        }


//private static void salvarVendas () {

        //}


        return quantidade;
    }
}
