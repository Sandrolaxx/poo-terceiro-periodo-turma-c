package lista2;

import java.util.Scanner;

public class calculadora2Java { 
    private static double [] ultimoRegistro = new double[3];

    public static void main(String[] args) { 
        Scanner opcaoUsuario = new Scanner(System.in);
        Scanner precoPlanta = new Scanner(System.in);  
        Scanner quantidadePlantas = new Scanner(System.in);

        double total = 0; 

        while (true) { 
            System.out.println("1 - Calcular total"); 
            System.out.println("2 - Calcular troco");
            System.out.println("3 - Registro de vendas");
            System.out.println("4 - Sair");

            int opcao;

            System.out.println("Escolha uma opção: ");
            opcao = opcaoUsuario.nextInt();

            if (opcao == 4) {
                System.out.println("Encerrando...");
                opcaoUsuario.close();
                return;
            }

            switch (opcao) {
                case 1:
                    double preco; 
                    System.out.println("Digite o valor das plantas");
                    preco = precoPlanta.nextDouble();

                    int plantas;
                    System.out.println("Digite a quantidade de plantas");
                    plantas = quantidadePlantas.nextInt();
                    total = calcularTotal(preco, plantas);
                    System.out.println("O valor total é: " + total);
                    
                    salvarVenda(plantas, total, (total * 0.05));
                    break;
                case 2:
                    calcularTroco(total);

                    break;
                case 3:
                    System.out.println("Ultima venda realizada: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(ultimoRegistro[i]);
                      }
                    break;
                default:
                    System.out.println("Escolha uma opção valida");
                    break;
                
            }

        }

    }

    public static void salvarVenda(int quantidade, double valorVenda, double desconto) {
        ultimoRegistro[0] = quantidade;
        ultimoRegistro[1] = valorVenda;
        ultimoRegistro[2] = desconto;
        
    }
    public static double calcularTotal(double preco, double plantas) {
        double total = preco * plantas;
        if (plantas > 10){
            double totalDesconto = total - (total * 0.05);
            return totalDesconto;
        }
        
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