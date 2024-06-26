package GABRIEL_MARCOLIN.prova;
import java.util.Scanner;

public class Cliente {
    private String nome;

    private int idade;

    private String sexo;

    Scanner sc = new Scanner(System.in);

    public  Cliente(){
    }

    public Cliente (String nome, int idade, String sexo){
     this.nome = nome;
     this.idade = idade;
     this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(int idade) {
        this.idade = idade;
    }

   public String getSexo(){
    return sexo;
   }

   public void setSexo(String sexo) { 
    this.sexo = sexo;
   }

   public void criarCliente(){
    System.out.println("Qual o nome do cliente?");
    String nome = sc.nextLine();

    System.out.println("Qual a idade do cliente?");
    int idade = sc.nextInt();

    System.out.println("Qual o sexo do cliente?");
    String sexo = sc.nextLine();

    Cliente novoCliente = new Cliente(nome,idade,sexo);
   }
}