package GABRIEL_MARCOLIN.prova;

import java.util.Scanner;

public class ListaEventos {
    private Evento evento;

    private Evento[] eventosCriados;

    private int numEventos;

    Scanner sc = new Scanner(System.in);

    public ListaEventos() {
        this.evento = new Evento();
        this.eventosCriados = new Evento[100];
        this.numEventos = 0;

    }

    public Evento criarEventos() {
        System.out.println("Qual o nome do evento que você quer criar?");
        String nomeEvento = sc.nextLine();

        System.out.println("Quantos dias de duração o evento terá?");
        int dataTermino = sc.nextInt();
        sc.nextLine();

        System.out.println("Qual o valor do ingresso deste evento?");
        double preco = sc.nextDouble();
        sc.nextLine();

        Evento novoEvento = new Evento(nomeEvento, dataTermino, preco);

        eventosCriados[numEventos] = novoEvento;

        numEventos++;

        return novoEvento;
    }

    public void listarEventos() {
        for (int i = 0; i < numEventos; i++) {
            Evento evento = eventosCriados[i];
            System.out.println("Nome do evento: " + evento.getNome() + "\nData de início do evento: "
                    + evento.getDataInicio() + "\nData de término do evento: " + evento.getDataTermino()
                    + "\nValor do ingresso do evento: " + evento.getPreco());
        }
    }

    public void comprarIngresso() {
        System.out.println("Para qual evento você quer comprar seu ingresso?");
        String ingresso = sc.nextLine();
        System.out.println("Ingresso comprado com sucesso");

    }

    public void utilizarIngresso() {
        System.out.println("Você deseja utilizar eu ingresso?\n[1]Sim\n[2]Não");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Ingresso utilizado com sucesso. Bom show!!!");
                break;
            case 2:
                System.out.println("Ingresso não utilizado");
            default:
                break;
        }
    }
}