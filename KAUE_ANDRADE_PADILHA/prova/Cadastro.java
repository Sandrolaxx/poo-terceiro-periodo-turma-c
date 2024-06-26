package KAUE_ANDRADE_PADILHA.prova;

import java.util.Date;
import java.util.Scanner;

public class Cadastro {
  public Cliente cadastrarCliente() {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    
    System.out.println("--- Cadastro de Cliente ---");
    int id = 0;

    System.out.println("Digite o nome do cliente:");
    String nome = sc.nextLine();

    System.out.println("Digite o CPF do cliente:");
    String cpf = sc.nextLine();

    Cliente cliente = new Cliente(nome, cpf, id++);
    new Evento().adicionarCliente(cliente);
    return cliente;
  }

  public Evento cadastrarEvento() {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    
    System.out.println("--- Cadastro de Evento ---");

    System.out.println("Digite o nome do evento:");
    String nome = sc.nextLine();

    System.out.println("Digite o tipo do evento:");
    String tipo = sc.nextLine();

    Evento evento = new Evento(nome, tipo, new Date());
    return evento;
  }
}
