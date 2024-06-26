/*Dona Gabrielinha ficou muito feliz com o software desenvolvido, porém, na utilização ela observou que poderia melhorar mais o sistema para lhe ajudar em pontos que ela não tinha se atentado no início.

Ela te contatou novamente e pediu as seguintes alterações no sistema:

1. Desconto Especial:
Quando um cliente compra mais de 10 plantas, Dona Gabrielinha oferece um desconto especial de 5% no valor total da compra.

Entrada: Receber dois valores, primeiro a quantidade da referida planta, segundo a valor o preço da mesma.
Saída: Retornar caso a quantidade informada for maior que 10 realizar o desconto.

2. Registro de Vendas:
Dona Gabrielinha deseja manter um registro das vendas, incluindo a quantidade de plantas vendidas, o valor venda e os descontos aplicados.

Entrada: Venda realizada sistema
Saída: Armazenamento desses dados no sistema.

3. Adicionar ao menu existente função 2 e aprimorar cálculo do valor a pagar com a função 1. */
import java.util.Scanner;

public class CalculadoraDonaGabrielaV2 {

  public static Scanner scanner = new Scanner(System.in);

  public static double preçoTotal(double valorPlanta, int nPlantas) {
    if (nPlantas >= 10) {
      System.out.println("\nPor ter comprado 10 ou mais plantas você recebeu 5% de desconto!");
      return ((valorPlanta * nPlantas) / 100 * 95);
    } else {
      return (valorPlanta * nPlantas);
    }
  }

  public static double CalcularTroco(double pagamento, double preçoTotal) {
    return (pagamento - preçoTotal);
  }

  public static void main(String[] args) {
    double valorPlanta, pagamento, preçoTotal, precinho, troquinho;
    double[] vendaArmazenadaValor = new double[99];
    int nPlantas, Calculadora, i=0, indiceVenda=0, compraFeita;
    int[] desconto= new int [99];
    int[] nPlantasVendidas = new int [99];

    do {
      System.out.println("Calculadora da Dona Gabrielinha");
      System.out.println("[1] - Calcular Preço Total");
      System.out.println("[2] - Calcular Troco");
      System.out.println("[3] - Ver histórico de vendas");
      System.out.println("[4] - Sair");

      Calculadora = scanner.nextInt();

      switch (Calculadora) {

        case 1:
          System.out.println("Insira o valor da planta");
          valorPlanta = scanner.nextDouble();
          System.out.println("Insira o número de plantas");
          nPlantas = scanner.nextInt();
          precinho = preçoTotal(valorPlanta, nPlantas);
          System.out.println("\nO valor total é " + precinho + "\n");
          System.out.println("Prosseguir com a compra? Digite \"1\" para sim e \"0\" para não.\n");
          compraFeita = scanner.nextInt();
          if (compraFeita == 1) {
            i=i+1;
            if (nPlantas>=10) {
              desconto[i]=1;
          } else {
              desconto[i]=0;
              }
            System.out.println("A compra foi finalizada com sucesso, e seu índice é " + i);
            vendaArmazenadaValor[i]=precinho;
            nPlantasVendidas[i]=nPlantas;
          break;
        }

        case 2:
          System.out.println("Insira o valor que foi dado pelo cliente");
          pagamento = scanner.nextDouble();
          System.out.println("Insira valor total da compra");
          preçoTotal = scanner.nextInt();
          troquinho = CalcularTroco(pagamento, preçoTotal);
          System.out.println("\nO troco é " + troquinho + "\n");
          break;

        case 3:
          for (indiceVenda=0; indiceVenda<i; indiceVenda++) {
            if (desconto[indiceVenda+1]==1) {
                System.out.println("\nA compra de índice " + (indiceVenda + 1) + " teve o valor total de " + vendaArmazenadaValor[indiceVenda+1] + " reais, foram vendidas " +nPlantasVendidas[indiceVenda+1]+" plantas e houve 5% de desconto.\n");
            } else {
                System.out.println("\nA compra de índice " + (indiceVenda + 1) + " teve o valor total de " + vendaArmazenadaValor[indiceVenda+1] + " reais, foram vendidas " +nPlantasVendidas[indiceVenda+1]+" plantas e não houve desconto.\n");
            }
          }
        break;

        case 4:
          break;

      }
    } while (Calculadora != 4);
  }
}
