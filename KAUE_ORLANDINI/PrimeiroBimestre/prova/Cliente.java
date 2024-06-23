package KAUE_ORLANDINI.PrimeiroBimestre.prova;

import java.util.Scanner;

public class Cliente {

    private String nome;

    private Double idade;

    Scanner scanner = new Scanner(System.in);


    public Cliente(String nome, Double idade) {
        this.nome = nome;
        this.idade = idade;
    }

  

    public String getNome() {
        return nome;
    }



    public Double getIdade() {
        return idade;
    }



    public Scanner getScanner() {
        return scanner;
    }



    void cadastrarCliente() {
        System.out.println("digite o nome");
        nome = scanner.next();
        System.out.println("digite a idade");
        idade = scanner.nextDouble();
    }

    void mostrarCliente(){
        System.out.println("Nome: "+getNome()+"\nIdade: "+getIdade());
    }
}
