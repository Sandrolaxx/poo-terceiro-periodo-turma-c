package prova;

import java.util.Scanner;

public class UtilizarIngresso {
    private CadastroEvento evento;
    private CadastroCliente cliente;

    public UtilizarIngresso() {

    }

    public CadastroEvento getEvento() {
        return evento;
    }

    public void setEvento(CadastroEvento evento) {
        this.evento = evento;
    }

    public CadastroCliente getCliente() {
        return cliente;
    }

    public void setCliente(CadastroCliente cliente) {
        this.cliente = cliente;
    }

    public void utilizarIngresso(Scanner scanner) {
        System.out.println("Bem-vindo ao evento: " + evento.getNomeEvento());
        System.out.println("Nome do cliente: " + cliente.getNome());

        System.out.println("Deseja utilizar seu ingresso? (S/N)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Ingresso utilizado com sucesso!");
        } else {
            System.out.println("Utilização de ingresso cancelada.");
        }
    }
}
