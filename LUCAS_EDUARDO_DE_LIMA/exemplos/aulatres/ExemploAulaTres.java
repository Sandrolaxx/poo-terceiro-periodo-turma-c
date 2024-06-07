package exemplos.aulatres;

import java.util.Scanner;

public class ExemploAulaTres {

    public static void main (String[] args){
       
       Scanner idade_digitada= new Scanner(System.in);
       System.out.println("Digite o valor da sua idade:");
       int idade = idade_digitada.nextInt();

       String valorPrint = idade >= 18 ? "É maior de idade" : "É menor de idade";

       System.out.println(valorPrint);
    }
}



