package KAUE_ORLANDINI.prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

         ArrayList<Cliente> clientes = new ArrayList<>();

        Ingresso ingressoa = new Ingresso(100.00, 0.0);
   
        Evento event = new Evento( null);
        Cliente client = new Cliente(null, null);
        
        
       
    Scanner scanner = new Scanner(System.in);
    
            while (true) {
                exibirMenu();
    
            int opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1:
                ingressoa.comprarIngresso();
                    break;
                case 2:
                event.cadastrarEvento();
                    break;
                case 3:
                event.mostrarEventos();
                  break;
                case 4:
                client.cadastrarCliente();
                  break;
                case 5:
                client.mostrarCliente();
                    break;
                case 6:
                ingressoa.utilizarIngresso();
                    break;
                case 7:
                    System.out.println("software encerrado");
                    return;         
                default:
                    System.out.println("opcao invalida");
                        
            }
        }
          
    }
    
    public static void exibirMenu(){
        System.out.println("[1]: comprar ingresso");
        System.out.println("[2]: cadastar evento");
        System.out.println("[3]: mostrar evento");
        System.out.println("[4]: cadastar cliente");
        System.out.println("[5]: mostrar cliente");
        System.out.println("[6]: utilizar ingresso");
        System.out.println("[7]: encerrar software");
        
    }  
}   
   
   
   
   
   
   
    