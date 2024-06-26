package Listasete;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Criar Pedido");
        System.out.println("2. Sair");
        System.out.println("Escolha uma opção:");
    }

    public int lerOpcao() {
        return scanner.nextInt();
    }

    public void fecharMenu() {
        scanner.close();
    }
}
