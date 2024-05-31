//Dona Gabrielinha é uma senhora apaixonada por plantas e recentemente abriu uma encantadora loja de venda de plantas exóticas. 
//Ela descobriu que quando um cliente entra em seu estabelecimento e toma uma xícara de café, a conversão da venda sobe para 80%, assim descobrindo um negócio muito rentável.
//Para facilitar o gerenciamento de suas vendas e o cálculo dos preços, ela decidiu procurar a sua ajuda para desenvolver uma calculadora especializada.
//Por ser idosa e antiquada, um de seus requisitos é que a solução seja em Java.

// A calculadora deve ser capaz de realizar as seguintes operações:

// 1. Cálculo de Preço Total:
//     Dona Gabrielinha deseja calcular o preço total da venda de um item, considerando a quantidade de uma planta vendida vezes seu preço unitário.
   
//     Entrada: Receber dois valores, primeiro a quantidade da referida planta, segundo a valor o preço da mesma.
//     Saída: Retornar o resultado do cálculo.
   
// 2. Cálculo de Troco:
//     A calculadora deve calcular o troco a ser dado ao cliente, considerando o valor pago.
   
//     Entrada: Receber dois valores, primeiro o valor recebido pelo cliente, segundo o valor total da compra.
//     Saída: Retornar o resultado do cálculo.

// 3. Criar Menu Console:
//     [1] - Calcular Preço Total
//     [2] - Calcular Troco    
//     [3] - Sair   
import java.util.Scanner;

public class CalculadoraDonaGabriela {

    public static Scanner scanner = new Scanner(System.in);

    public static double PreçoTotal(double ValorPlanta, int NPlantas) {
        return (ValorPlanta * NPlantas);
    }

    public static double CalcularTroco(double Pagamento, double PreçoTotal) {
        return (Pagamento - PreçoTotal);
    }


    public static void main(String[] args) {
        double ValorPlanta, Pagamento, PreçoTotal, Precinho, Troquinho;
        int NPlantas, Calculadora;

      
        do {
            System.out.println("Calculadora da Dona Gabrielinha");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
    
            Calculadora = scanner.nextInt();

            switch (Calculadora) {

                case 1:
                    System.out.println("Insira o valor da planta");
                    ValorPlanta = scanner.nextDouble();
                    System.out.println("Insira o número de plantas");
                    NPlantas = scanner.nextInt();
                    Precinho = PreçoTotal(ValorPlanta, NPlantas);
                    System.out.println("\nO valor total é " + Precinho + "\n");
                    break;
    
                case 2:
                    System.out.println("Insira o valor que foi dado pelo cliente");
                    Pagamento = scanner.nextDouble();
                    System.out.println("Insira valor total da compra");
                    PreçoTotal = scanner.nextInt();
                    Troquinho = CalcularTroco(Pagamento, PreçoTotal);
                    System.out.println("\nO troco é " + Troquinho + "\n");
                    break;
    
                case 3:
                    break;
    
            }
        } while (Calculadora != 3);   
    }
}

