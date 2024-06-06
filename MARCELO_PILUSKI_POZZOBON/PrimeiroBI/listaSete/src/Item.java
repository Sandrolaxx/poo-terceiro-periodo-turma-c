package listaSete.src;

import java.util.Scanner;

public class Item {
    public int id;
    public String nome;
    public String tipo;
    public int valor;

    protected static Scanner idScanner = new Scanner(System.in);
    protected static Scanner nomeScanner = new Scanner(System.in);
    protected static Scanner tipoScanner = new Scanner(System.in);
    protected static Scanner valorScanner = new Scanner(System.in);

    public void gerarDescricao() {
        System.out.println("Id: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\nValor: " + valor);
    }

    public void cadastrarItem() {
        System.out.print("Id: ");
        idScanner.nextInt(); 
        System.out.print("Nome: ");
        nomeScanner.nextLine();
        System.out.print("Tipo: ");
        tipoScanner.nextLine();
        System.out.print("Valor: ");
        valorScanner.nextInt();
    }
}
