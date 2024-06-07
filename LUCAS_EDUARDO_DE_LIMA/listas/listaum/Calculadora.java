package listas.listaum;

import java.util.Scanner;

/*Pedir pro usuario digitar o preço da planta

Pedir pro usuário digitar a quantidade de plantas que foi comprada

Multiplicar o preço x quantidade pra obter o valor total da compra

Pedir pro usuario digitar a quantia que foi paga

Calcular o troco que deve ser dado ao cliente

quantidade paga - valor total

Criar um menuzinho com 3 opções
1 - calcular total
2 - calcular troco
3 - sair (exibir uma mensagem e fechar o menu)

NOVAS ALTERAÇÕES: 

Dona Gabrielinha está utilizando o sistema e isso melhorou muito sua produtividade na loja, 
porém ela identificou que apenas salvar aleatoriamente a venda não é algo tão útil. 
Ela então te contacta novamente e realiza o orçamento da alteração. 
Segundo ela, seria ótimo poder salvar a quantidade de vendas totais em um dia de um mês.
 Ela também gostaria de buscar a quantidade de vendas total pelo mês e dia.

1. Identifique as funcionalidades requeridas, entradas e saídas.

2. Implemente as funcionalidades.

3. Adicione ao menu as funcionalidades.*/

//Scanner serve para ler o que o usuario digitar
//system.out mostra no console o que foi escrito

public class Calculadora {

    private static double[] valores = new double[100];

    private static int[] quantidades = new int[100];

    private static double[] descontos = new double[100];
    private static int posicao;

    private static double[][] vendaspordia = new double[29][12];

    public static void main(String[] args) {

        double total = 0;

        while (true) {
            System.out.println("1 - Calcular total");
            System.out.println("2 - Calcular troco");
            System.out.println("3 - Salvar vendas");
            System.out.println("4 - Imprimir vendas");
            System.out.println("5 - Vendas do dia do mês:");
            System.out.println("6 - Imprima as vendas do dia do mês:");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção");
            int opcao = new Scanner(System.in).nextInt();

            if (opcao == 7) {
                System.out.println("Sistema encerrado !!!");
                return;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite o preço da planta:");
                    double preco = new Scanner(System.in).nextDouble();
                    System.out.println("Digite a quantidade de plantas:");
                    int quantidade = new Scanner(System.in).nextInt();

                    if (quantidade > 10) {
                        double descontoEspecial = (preco * quantidade) * 0.05;
                        total = (preco * quantidade) - descontoEspecial;
                        System.out.println("Desconto especial para 10 plantas aplicado!");
                        System.out.println("O valor com desconto é de:" + total);
                    } else {
                        total = preco * quantidade;
                        System.out.println("O valor total é de:" + total);
                    }

                case 2:
                    System.out.println("Digite a quantia que foi paga:");
                    double valor_pagado = new Scanner(System.in).nextDouble();
                    double troco_cliente = valor_pagado - total;
                    System.out.println("O valor de troco é de: " + troco_cliente);
                    break;

                case 3:
                    System.out.println("Digite os valores das compras:");
                    double valor = new Scanner(System.in).nextDouble();

                    System.out.println("Insira a quantidade de itens:");
                    int qnt = new Scanner(System.in).nextInt();

                    System.out.println("Digite o valor do desconto:");
                    double desconto = new Scanner(System.in).nextDouble();

                    valores[posicao] = valor;
                    quantidades[posicao] = qnt;
                    descontos[posicao] = desconto;
                    posicao++;
                    break;

                case 4:
                    for (int i = 0; i < posicao; i++) {
                        System.out.println(
                                "Preço: R$ " + valores[i] +
                                        ", Quantidade: " + quantidades[i] +
                                        ", Desconto: R$ " + descontos[i]);
                    }
                    break;

                case 5:
                    System.out.println("Digite o valor de vendas no dia:");
                    double valortotal = new Scanner(System.in).nextDouble();

                    System.out.println("Digite o dia:");
                    int dia = new Scanner(System.in).nextInt();

                    System.out.println("Digite o mês:");
                    int mes = new Scanner(System.in).nextInt();

                    vendaspordia[dia - 1][mes - 1] = valortotal;

                    break;

                case 6:
                    System.out.println("Digite o dia:");
                    dia = new Scanner(System.in).nextInt();

                    System.out.println("Digite o mês:");
                    mes = new Scanner(System.in).nextInt();

                    System.out.printf("A venda total do dia %d do mês %d foi de: R$ %f\n", dia, mes, vendaspordia[dia-1][mes-1]);

                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

    }
}
