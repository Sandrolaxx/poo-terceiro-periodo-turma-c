import java.util.Scanner;

public class Calcular_plantinhas{
    public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
        while (true) {
            System.out.println("Ola, seja bem vindo ao menu. :)");
            System.out.println("[1] - Digite para calcular a compra");
            System.out.println("[2] - Digite para calcularTroco");
            System.out.println("[3] - Sair");

            int menu = scanner.nextInt(); 
            switch (menu) {
                case 1:
                    System.out.println("Digite a quantidade da planta:");
                    int quantidade = scanner.nextInt(); 
                    System.out.println("Digite o preço planta:");
                    double precoUni = scanner.nextDouble(); 
                    double Total = quantidade * precoUni; 
                    System.out.println("O preço total é: " + Total);
                    break;
                case 2:
                    System.out.println("Digite o valor recebido:");
                    double valorRecebido = scanner.nextDouble(); 
                    System.out.println("Digite o valor total da compra:");
                    double Compra = scanner.nextDouble(); 
                    double troco = valorRecebido - Compra; 
                    System.out.println("O troco é: " + troco);
                    break;
                case 3:
                    System.out.println("Encerrando Sessão ");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Use os digitos dado no menu");
            }
        }
    }
    }
}

