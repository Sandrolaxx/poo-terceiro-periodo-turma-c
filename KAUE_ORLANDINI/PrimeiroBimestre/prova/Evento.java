package KAUE_ORLANDINI.PrimeiroBimestre.prova;


import java.util.Scanner;

public class Evento {

    

    private String nomeEvento;

   

    Scanner scanner = new Scanner(System.in);

    public Evento(String nome) {
        this.nomeEvento = nome;
    }

    void cadastrarEvento() {
        System.out.println("digite o nome do evento");
         nomeEvento = scanner.next();
        
        
        
       
        System.out.println("O evento: "+getNomeEvento()+" foi cadastrado");
    }

    void mostrarEventos(){
        System.out.println("evento cadastrado: "+getNomeEvento());
    }
   
   
    public String getNomeEvento(){
        return nomeEvento;
    }

}
