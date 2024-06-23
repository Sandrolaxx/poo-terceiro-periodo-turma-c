package KAUE_ORLANDINI.PrimeiroBimestre.Lista1;

import java.util.Scanner;

public class Calculadora {

    private static int[][] vendas = new int[12][30];
    
    
    
    static int i = 0;

    static double indiceVendas = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                calcularpreco(scanner);
                break;
            case 2:
                calculartroco(scanner);
                break;
            case 3:
                mostrarvendas(scanner);
                break;
            case 4:
                registrarvenda(scanner);
                break;
            case 5:
                removervenda(scanner);
                break;
            case 6:
                System.out.println("calculadora encerrada.");
                return;         
            default:
                System.out.println("opcao invalida");
                    
        }
    }
      
    }

public static void exibirMenu(){
    System.out.println("[1]:calcular preco total");
    System.out.println("[2]:calcular troco");
    System.out.println("[3]:mostrar vendas");
    System.out.println("[4]:registrar venda");
    System.out.println("[5]:remover venda");
    System.out.println("[6]:sair");
}
    
public static void calcularpreco(Scanner scanner) {
    
    System.out.println("digite a quantidade de itens: ");
    double quantidade = scanner.nextInt();

    System.out.println("digite o preco do produto: ");
    double precoproduto = scanner.nextDouble();

   

    double valortotal = quantidade * precoproduto;

    if (quantidade>=11) {
        valortotal = valortotal * 0.95;
        double descontoAplicado = valortotal * 0.05;
    } else {
        valortotal = quantidade * precoproduto;
    }

    System.out.println("Valor Total: R$" + valortotal);
    
   
    
}



public static void calculartroco(Scanner scanner){ 
    System.out.println("Digite o valor pago:");
    double valorpago = scanner.nextDouble();
    
    System.out.println("digite o valor da compra");
    double valordacompra = scanner.nextDouble();

    double valortroco = valorpago - valordacompra;
    
    System.out.println("o valor do troco é de: R$" + valortroco);
}



public static void mostrarvendas(Scanner scanner) {
    System.out.println("digite o mes da compra");
    int mes = scanner.nextInt();
    
    System.out.println("digite o dia da compra");
    int dia = scanner.nextInt();

    System.out.printf("quantitade de vendas totais: %d\n", vendas[mes][dia]);
    }






public static void registrarvenda(Scanner scanner) {
    System.out.println("digite o mes da compra");
    int mes = scanner.nextInt();
    
    System.out.println("digite o dia da compra");
    int dia = scanner.nextInt();

    System.out.printf("digite o valor para [%d][%d]:",mes, dia);
    vendas[mes][dia] = new Scanner(System.in).nextInt();
}
 



public static void removervenda(Scanner scanner) {
    System.out.println("digite o mes da compra");
    int mes = scanner.nextInt();
    
    System.out.println("digite o dia da compra");
    int dia = scanner.nextInt();

    vendas[mes][dia] = 0;
}
}
