package calculadoraV1;

import java.util.Scanner;

import calculadoraV1.src.ArmazenarDadosNovo;
import calculadoraV1.src.PrecoTotal;
import calculadoraV1.src.Troco;

public class Main {
    public static void main(String[] args) {
        PrecoTotal precoTotal = new PrecoTotal();
        Troco troco = new Troco();
        ArmazenarDadosNovo armazenarDados = new ArmazenarDadosNovo();
        Scanner option = new Scanner(System.in);
        int optionCliente = 0;
        menu(option, optionCliente, precoTotal, troco, armazenarDados);
        
    }

    public static void menu(Scanner opcao, int varOpcao, PrecoTotal varPrecoTotal, Troco varTroco,
            ArmazenarDadosNovo varArmazenarDados) {
        do {
            System.out.println(
                    "[1] - Calcular Preço Total \n[2] - Calcular Troco \n[3] - Armazenar Dados (Dias do Mês)\n[4] - Vendas Dia\n[5] - Sair");
            varOpcao = opcao.nextInt();

            switch (varOpcao) {
                case 1:
                    varPrecoTotal.calculaPrecoTotal();
                    break;

                case 2:
                    varTroco.calculaTroco();
                    break;

                case 3:
                    varArmazenarDados.armazenarDados();
                    break;
                
                case 4:
                    varArmazenarDados.escreverMes();
                    break;

                case 5:
                    System.out.println("Calculadora encerrada!");
                    break;

                default:
                    System.out.println("Erro de digitação, escolha uma das opções novamente.");
                    break;
            }
        } while (varOpcao != 5);
    }
}