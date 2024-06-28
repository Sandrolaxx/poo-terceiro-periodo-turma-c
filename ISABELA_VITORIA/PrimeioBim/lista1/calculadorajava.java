package PrimeioBim.lista1;

import java.util.Scanner;

public class calculadorajava { // classe tem que ter o mesmo nome do arquivo
    public static void main(String[] args) { // void não retorna (mmetodo que vou executar o cod)
        Scanner opcaoUsuario = new Scanner(System.in);
        Scanner precoPlanta = new Scanner(System.in);
        Scanner quantidadePlantas = new Scanner(System.in);

        double total = 0; // pra zerar

        while (true) { // true para repetir
            System.out.println("1 - Calcular total"); // mostrar na tela (powershell)
            System.out.println("2 - calcular troco");
            System.out.println("3 - Sair");

            int opcao;

            System.out.println("Escolha uma opção: ");
            opcao = opcaoUsuario.nextInt();

            if (opcao == 3) {
                System.out.println("Encerrando...");
                opcaoUsuario.close();
                return;
            }

            switch (opcao) {
                case 1:
                    double preco; // tipo um float só que maior
                    System.out.println("Digite o valor das plantas");
                    preco = precoPlanta.nextDouble();

                    int plantas;
                    System.out.println("Digite a quantidade de plantas");
                    plantas = quantidadePlantas.nextInt();
                    total = calcularTotal(preco, plantas);
                    System.out.println("O valor total é: " + total);

                    break;
                case 2:
                    calcularTroco(total);

                    break;
                default:
                    System.out.println("Escolha uma opção valida");
                    break;
            }

        }

    }

    public static double calcularTotal(double preco, double plantas) {
        double total = preco * plantas;
        return total;

    }

    public static void calcularTroco(double total) {
        Scanner quantiaUsuario = new Scanner(System.in);

        double quantiaPaga;
        System.out.println("Digite a quantia paga");
        quantiaPaga = quantiaUsuario.nextDouble();

        double troco = quantiaPaga - total;
        System.out.println("Seu troco é: " + troco);

    }
}