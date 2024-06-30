package KAUE_ORLANDINI.prova;

import java.util.Scanner;

public class Ingresso {
    private Double precoIngresso;

    private Double decisaoCompra;

    private double utilIngresso;
   
    Scanner scanner = new Scanner(System.in);

    public Ingresso(Double precoIngresso, Double decisaoCompra) {
        this.precoIngresso = precoIngresso;
        this.decisaoCompra = decisaoCompra;
    }

    public Double getPrecoIngresso() {
        return precoIngresso;
    }
   
    void utilizarIngresso(){
        System.out.println("deseja utilizar o ingresso? [1]sim  [2]Não");
        
        utilIngresso = scanner.nextDouble();

        if (utilIngresso == 1) {
            System.out.println("ingresso usado.");
        } else if (utilIngresso == 2) {
            System.out.println("uso cancelada.");
        } {
            
        }
    }
    
    
    void comprarIngresso(){
        System.out.println("Preço do ingresso: " + String.valueOf(precoIngresso) + String.valueOf(", deseja comprar o ingresso? [1]Sim, [2]Não"));
        decisaoCompra = scanner.nextDouble();

        if (decisaoCompra == 1) {
            System.out.println("ingresso comprado.");
        } else if (decisaoCompra == 2) {
            System.out.println("compra cancelada.");
        } {
            
        }

    
    
    
    }



}
