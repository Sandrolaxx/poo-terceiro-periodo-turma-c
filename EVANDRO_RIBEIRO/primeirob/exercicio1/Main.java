package exercicio1;

import java.util.Scanner;

public class Main {
    String qualPlanta;
    float qntdPlanta;
    float valorPlanta;
    float valorFinal;
    Scanner scanner;
    float recebido;
    float produto;
    float trocoFalta;
    float trocoSobra;
    String escolha;
    float desconto;

    //cadastro de cliente, cadastro de evento, listar evnetos, comprar inbgresso do evento, utilizar ingresso em evento, utilização de conceitos de pOO, separação de classes e encapsulamento

    public static void main(String[] args) {
        Main main = new Main();
        main.scanner = new Scanner(System.in);

        do{
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Histórico de vendas");
            System.out.println("[4] - Sair");
            main.escolha = main.scanner.nextLine();
            
            if (main.escolha.equals("1")) {
            System.out.println("Qual planta foi vendida?");
            main.qualPlanta = main.scanner.nextLine();

            System.out.println("Quantas " + main.qualPlanta + "(s) foram vendidas?");
            main.qntdPlanta = main.scanner.nextFloat();
            main.scanner.nextLine();

            System.out.println("Qual é o valor da(o) " + main.qualPlanta + "? (Caso seja valor quebrado use 'n,n') ");
            main.valorPlanta = main.scanner.nextFloat();
            main.scanner.nextLine();    

            main.valorFinal = main.qntdPlanta * main.valorPlanta;

                if(main.qntdPlanta > 10) {
                    main.valorFinal = (float) (main.valorFinal - (main.valorFinal * 0.05));
                    System.out.println("Parabéns, por comprar mais de 10 plantas você recebeu um desconto! ");
                    System.out.println("O valor das(os) " + main.qualPlanta + " com desconto é de " + main.valorFinal + " reais");
                } else {

                    System.out.println("O valor das(os) " + main.qualPlanta + " é de " + main.valorFinal + " reais");
                  }
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Histórico de vendas");
            System.out.println("[4] - Sair");
            main.escolha = main.scanner.nextLine();

            if (main.escolha.equals("2")) {
                System.out.println("Qual o valor de dinheiro recebido?");
                float valorRece = main.scanner.nextFloat();
                main.scanner.nextLine();
                if (valorRece < main.valorFinal) {
                    float trocoFalta = main.valorFinal - valorRece;
                    System.out.println("Ainda falta " + trocoFalta + " reais!");
                } else if (valorRece == main.valorFinal) {
                    System.out.println("Não precisa de troco! ");
                } else {
                    float troco1 = valorRece - main.valorFinal;
                    System.out.println("O troco é de: " + troco1 + " reais!");
                }
                
            } else if (main.escolha.equals("4")) {
                System.out.println("Obrigado por usar a calculadora! Saindo...");
                
            } else {
                System.out.println("Opção inválida!");
            }
            } else if (main.escolha.equals("2")){
                System.out.println("Qual valor recebido? ");
                main.recebido = main.scanner.nextFloat();
                main.scanner.nextLine();

                System.out.println("Qual o valor do produto? ");
                main.produto = main.scanner.nextFloat();
                main.scanner.nextLine();

                if (main.recebido < main.produto){
                    main.trocoFalta = main.produto - main.recebido;
                    System.out.println("Ainda falta " + main.trocoFalta + " reais!" );
                } else if (main.recebido == main.produto) {
                    System.out.println("Não precisa de troco!");
                } else{
                    main.trocoSobra = main.recebido - main.produto;
                    System.out.println("O troco é de " + main.trocoSobra + " reais!");
                }
            } else if (main.escolha.equals("4")){
                System.out.println("Obrigado por usar a calculadora, saindo...");
            } else {
                System.out.println("Opção inválida");
            }
        } while (!main.escolha.equals("4"));
    }
}
