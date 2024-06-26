package lista1;

import java.util.Scanner;

import lista1.src.PrecoTotal;
import lista1.src.Troco;

public class Main {
    public static void main(String[] args) {
        PrecoTotal teste = new PrecoTotal();
        Troco teste2 = new Troco();
        Scanner option = new Scanner(System.in);
        int optionCliente = 0;
        menu(option, optionCliente, teste, teste2);

    }

    public static void menu(Scanner opcao, int varOpcao, PrecoTotal varPrecoTotal, Troco varTroco) {
        do {
            System.out.println("[1] - Calcular Preço Total \n[2] - Calcular Troco \n[3] - Sair");
            varOpcao = opcao.nextInt();

            switch (varOpcao) {
                case 1:
                    varPrecoTotal.calculaPrecoTotal();
                    break;

                case 2:
                    varTroco.calculaTroco();
                    break;

                case 3:
                    System.out.println("Calculadora encerrada!");
                    break;

                default:
                    System.out.println("Erro de digitação, escolha uma das opções novamente.");
                    break;
            }
        } while (varOpcao != 3);
    }

}