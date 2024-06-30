package bimestre_1.prova;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorEvento {
    private ArrayList<Evento> eventos;

    public GestorEvento() {
        this.eventos = new ArrayList<>();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Não há eventos cadastrados.");
        } else {
            System.out.println("Eventos cadastrados:");
            for (Evento evento : eventos) {
                evento.exibirDadosEvento();
                System.out.println("------------------------");
            }
        }
    }

    public void comprarIngresso(Scanner scanner) {
        System.out.println("Digite o nome do evento para comprar ingresso:");
        String nomeEvento = scanner.nextLine();
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                if (evento.getIngressosVendidos() < evento.getCapacidade()) {
                    evento.setIngressosVendidos(evento.getIngressosVendidos() + 1);
                    System.out.println("Ingresso comprado com sucesso para o evento: " + nomeEvento);
                } else {
                    System.out.println("Não há mais ingressos disponíveis para o evento: " + nomeEvento);
                }
                return;
            }
        }
        System.out.println("Evento não encontrado.");
    }

    public void utilizarIngresso(Scanner scanner) {
        System.out.println("Digite o nome do evento para utilizar o ingresso:");
        String nomeEvento = scanner.nextLine();
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                if (evento.getIngressosVendidos() > 0) {
                    evento.setIngressosVendidos(evento.getIngressosVendidos() - 1);
                    System.out.println("Ingresso utilizado com sucesso para o evento: " + nomeEvento);
                } else {
                    System.out.println("Não há ingressos para serem utilizados neste evento: " + nomeEvento);
                }
                return;
            }
        }
        System.out.println("Evento não encontrado.");
    }
}
