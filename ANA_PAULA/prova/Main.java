package ANA_PAULA.prova;
import java.util.Scanner;

public class Main {
    public static Scanner ler = new Scanner(System.in);
    public static void main(String[] args) {
        int menu = 0;
        String nome;


        do{
            System.out.println("[1] - Cadastro cliente");
            System.out.println("[2] - Cadastro evento");
            System.out.println("[3] - Listar evento");
            System.out.println("[4] - Comprar ingresso");
            System.out.println("[5] - Utilizar ingresso");
            menu = ler.nextInt();
            
            
            switch(menu){
                case 1:
                Cliente cliente = new Cliente();
                cliente.apresentarse();
                break;
                case 2:
                Eventoo eventoo = new Eventoo();
                eventoo.apresentarse();
                break;


    
            }
        } while (menu != 5);
    }
}
