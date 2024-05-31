package prova;

import java.util.Scanner;

public class ComprarIngresso {
    private CadastroEvento evento;
    private CadastroCliente cliente;


    public ComprarIngresso() {

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

    public void comprarIngresso(Scanner scanner) {
        if (evento != null) {
            System.out.println("Compra de ingresso para o evento: " + evento.getNomeEvento());
            System.out.println("Dados do cliente:");
            cliente.imprimirInfoCliente();
            System.out.println("Confirma a compra? (S/N)");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                System.out.println("Ingresso comprado com sucesso!");
            } else {
                System.out.println("Compra cancelada.");
            }
        } else {
            System.out.println("Evento não encontrado.");
        }
    }
}
