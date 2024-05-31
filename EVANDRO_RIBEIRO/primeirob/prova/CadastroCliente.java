package prova;

import java.util.Scanner;

public class CadastroCliente {
    private String nome;
    private String email;
    private String telefone;

    public CadastroCliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void lerInfoCliente(Scanner scanner) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do cliente:");
        setNome(scanner.nextLine());
        System.out.println("Digite o email do cliente:");
        setEmail(scanner.nextLine());
        System.out.println("Digite o telefone do cliente:");
        setTelefone(scanner.nextLine());
    }

    public void imprimirInfoCliente() {
        System.out.println("Nome do Cliente: " + getNome());
        System.out.println("Email do Cliente: " + getEmail());
        System.out.println("Telefone do Cliente: " + getTelefone());
    }
}

