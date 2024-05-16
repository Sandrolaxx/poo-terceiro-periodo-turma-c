package primeirobimetre.lista_1.lista_3;

import java.util.Scanner;


class Menu {

    public static int exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("[1] - Calcular Preço Total (com desconto especial para mais de 10 plantas)");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Registrar Venda");
        System.out.println("[4] - Exibir Registro de Vendas");
        System.out.println("[5] - Sair");
        System.out.print("Opção: ");
        return new Scanner(System.in).nextInt();
    }
}