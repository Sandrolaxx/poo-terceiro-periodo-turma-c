# Resumo Lista 3

package exercicio3;

import java.util.Scanner; ---> //importar o scanner

public class Main {

---

**variaveis**

    public static String qualPlanta;
    public float qntdPlanta;
    public float valorPlanta;
    public float valorFinal;
    public Scanner scanner;
    public float recebido;
    public float produto;
    public float trocoFalta;
    public float trocoSobra;
    public String escolha;
    public static String vetorNomes[] = new String[10];
    public static int vetor_index = 0;
    public static float vendasTotais;
    public static float vendasPorDia[][] = new float[31][12];

**variaveis**

---
  
**instância**

    public static void main(String[] args) {
        Main main = new Main();
        main.scanner = new Scanner(System.in);
---

**instância**

---

        do { ---> fazer todo esse código, com a determinação de quando para no while
---

**menu de opções**

            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Histórico de Vendas");
            System.out.println("[4] - Ver Vendas por Dia e Mês");
            System.out.println("[5] - Sair");
            main.escolha = main.scanner.nextLine();

**menu de opções**

---

**Se a pessoa escolhar calcular o preço**

            if (main.escolha.equals("1")) {
                System.out.println("Qual planta foi vendida?");
                Main.qualPlanta = main.scanner.nextLine();

                System.out.println("Quantas " + Main.qualPlanta + "(s) foram vendidas?");
                main.qntdPlanta = main.scanner.nextFloat();
                main.scanner.nextLine();

                System.out.println("Qual é o valor da(o) " + Main.qualPlanta + "? (Caso seja valor quebrado use 'n,n') ");
                main.valorPlanta = main.scanner.nextFloat();
                main.scanner.nextLine();

                main.valorFinal = main.qntdPlanta * main.valorPlanta;

                if (main.qntdPlanta > 10) {
                    main.valorFinal = (float) (main.valorFinal - (main.valorFinal * 0.05));
                    System.out.println("Parabéns! Por comprar mais de 10 " + Main.qualPlanta + "(s) você ganhou 5% de desconto, o valor é de: " + main.valorFinal);
                } else {
                    System.out.println("O valor da(o) " + Main.qualPlanta + " é " + main.valorFinal + " reais");
                }

                vetorNomes[vetor_index] = "venda " + (vetor_index + 1) + ": " + " planta: " + qualPlanta + ", " + main.qntdPlanta + " unidades, " + main.valorFinal + " reais ";
                vetor_index++;

                int dia = 21;
                int mes = 3; 
                vendasPorDia[dia][mes] += main.valorFinal;

**Se a pessoa escolher calcular o preço**

---

**Se a pessoa ecolher calcular o troco**

            } else if (main.escolha.equals("2")) {
                System.out.println("Qual valor recebido? ");
                main.recebido = main.scanner.nextFloat();
                main.scanner.nextLine();

                System.out.println("Qual o valor do produto? ");
                main.produto = main.scanner.nextFloat();
                main.scanner.nextLine();

                if (main.recebido < main.produto) {
                    main.trocoFalta = main.produto - main.recebido;
                    System.out.println("Ainda falta " + main.trocoFalta + " reais!");
                } else if (main.recebido == main.produto) {
                    System.out.println("Não precisa de troco!");
                } else {
                    main.trocoSobra = main.recebido - main.produto;
                    System.out.println("O troco é de " + main.trocoSobra + " reais!");
                }
**Se a pessoa escolher calcular o troco**

---

**Se a pessoa escolher ver o histórico de vendas**

            } else if (main.escolha.equals("3")) {
                for (int i = 0; i < vetor_index; i++) {
                    System.out.println(vetorNomes[i]);
                }

**Se a pessoa escolher ver o histórico de vendas**

---

**Se a pessoa escolher ver as vendas de determinado dia e mês**


            } else if (main.escolha.equals("4")) {
                System.out.println("Digite o dia e mês para verificar as vendas (no formato dd/mm): ");
                String data = main.scanner.nextLine();
                String[] partes = data.split("/");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                System.out.println("As vendas totais para o dia " + dia + " do mês " + mes + " foram de: " + vendasPorDia[dia][mes] + " reais");

**Se a pessoa escolher ver as vendas de determinado dia e mês**

---

**Se a pessoa escolher sair**

            } else if (main.escolha.equals("5")) {

                System.out.println("Saindo...");
**Se a pessoa escolher sair**

---

**Se a pessoa escolher uma opçõa que não tem no menu**

            } else {
                System.out.println("Opção inválida");
            }
**Se a pessoa escolher uma opçõa que não tem no menu**

---
        } while (!main.escolha.equals("5")); 
        
**continuação do "do", se a pessoa escolher uma opção que não seja o 5 ira fazer (do) alguma coisa, po exemplo: opção 1 = calcular preço / opção 2 = calcular troco / opção 3 = ver o histórico / opção 4 = ver o historico de um dia e mês especifico / opção diferente de qualquer uma desseas = opção invalida / e se a pessoa escolher 5 vai sair / ou seja do(faça o codigo) while(com o "!" que é para dizer (enquanto não for)) a opção  cinco**

    }
}
