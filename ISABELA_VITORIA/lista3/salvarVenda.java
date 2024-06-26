package lista3;

import java.util.Scanner;

public class salvarVenda {
    private static double[][] ultimoRegistro = new double[100][5];// matriz
    private static int cont = 0; // contador

    public static void main(String[] args) {
        Scanner opcaoUsuario = new Scanner(System.in);
        Scanner precoPlanta = new Scanner(System.in);
        Scanner quantidadePlantas = new Scanner(System.in);
        Scanner salvarDia = new Scanner(System.in);
        Scanner salvarMes = new Scanner(System.in);

        double total = 0;

        while (true) {
            System.out.println("1 - Calcular total");
            System.out.println("2 - Calcular troco");
            System.out.println("3 - Registro de vendas");
            System.out.println("4 - Buscar venda pela data");
            System.out.println("5 - Sair");

            int opcao;

            System.out.println("Escolha uma opção: ");
            opcao = opcaoUsuario.nextInt();

            if (opcao == 5) {
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

                    System.out.println("Informe o dia: ");
                    int dia = salvarDia.nextInt();

                    System.out.println("Infome o mês: ");
                    int mes = salvarDia.nextInt();

                    System.out.println("O valor total é: " + total);
                    salvarVenda(plantas, total, (total * 0.05), dia, mes);
                    break;
                case 2:
                    calcularTroco(total);

                    break;
                case 3:
                    System.out.println("Ultima venda realizada: ");
                    for (int i = 0; i < cont; i++) {
                        System.out.println(
                                "Venda : " + (i + 1) +
                                        " Quantidade: " + ultimoRegistro[i][0] +
                                        " Valor: " + ultimoRegistro[i][1] +
                                        " Desconto: " + ultimoRegistro[i][2] +
                                        " Dia: " + ultimoRegistro[i][3] +
                                        " Mês: " + ultimoRegistro[i][4]);
                    }
                    break;
                case 4:
                    System.out.println("Informe o dia: ");
                    int _dia = salvarDia.nextInt();

                    System.out.println("Infome o mês: ");
                    int _mes = salvarDia.nextInt();

                    for (int i = 0; i < cont; i++) {
                        if (ultimoRegistro[i][3] == _dia && ultimoRegistro[i][4] == _mes) {
                            System.out.println(
                                    "Venda : " + (i + 1) +
                                            " Quantidade: " + ultimoRegistro[i][0] +
                                            " Valor: " + ultimoRegistro[i][1] +
                                            " Desconto: " + ultimoRegistro[i][2] +
                                            " Dia: " + ultimoRegistro[i][3] +
                                            " Mês: " + ultimoRegistro[i][4]);
                        }

                    }

                    break;
                default:
                    System.out.println("Escolha uma opção valida");
                    break;

            }

        }

    }

    public static void salvarVenda(int quantidade, double valorVenda, double desconto, int dia, int mes) {
        ultimoRegistro[cont][0] = quantidade;
        ultimoRegistro[cont][1] = valorVenda;
        ultimoRegistro[cont][2] = desconto;
        ultimoRegistro[cont][3] = dia;
        ultimoRegistro[cont][4] = mes;
        cont++;

    }

    public static double calcularTotal(double preco, double plantas) {
        double total = preco * plantas;
        if (plantas > 10) {
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
