package lista2;

import java.util.Scanner;
import java.util.ArrayList;

import lista2.src.PrecoTotal;
import lista2.src.Troco;
import lista2.src.ArmazenarDados;

public class Main {
    public static void main(String[] args) {
        PrecoTotal precoTotal = new PrecoTotal();
        Troco troco = new Troco();
        ArmazenarDados armazenarDados = new ArmazenarDados();
        Scanner option = new Scanner(System.in);
        int optionCliente = 0;
        menu(option, optionCliente, precoTotal, troco, armazenarDados);

    }

    public static void menu(Scanner opcao, int varOpcao, PrecoTotal varPrecoTotal, Troco varTroco, ArmazenarDados varArmazenarDados) {
        do {
            System.out.println("[1] - Calcular Preço Total \n[2] - Calcular Troco \n[3] - Armazenar Dados\n[4] - Sair");
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
                    System.out.println("Calculadora encerrada!");
                    break;

                default:
                    System.out.println("Erro de digitação, escolha uma das opções novamente.");
                    break;
            }
        } while (varOpcao != 4);
    }
}