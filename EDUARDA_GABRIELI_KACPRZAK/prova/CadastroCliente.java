package EDUARDA_GABRIELI_KACPRZAK.prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente {
    
    private static List<Cliente> clientes = new ArrayList<>();
    static void cadastrarClientes() {
    @SuppressWarnings("resource")
    Scanner entrada = new Scanner(System.in);
    class Cliente {
        private String nome;
        private String cpf;
        private String email;
        private String telefone;
    
        public Cliente(String nome, String cpf, String email, String telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.telefone = telefone;
        }

        public static void add(Cliente cliente) {
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }
    }
        System.out.println("----------------------");
        System.out.println("\nCadastro de Clientes");
        System.out.println("----------------------");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("CPF: ");
        String cpf = entrada.nextLine();

        System.out.print("E-mail: ");
        String email = entrada.nextLine();

        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        Cliente.add(cliente);

    }
}

