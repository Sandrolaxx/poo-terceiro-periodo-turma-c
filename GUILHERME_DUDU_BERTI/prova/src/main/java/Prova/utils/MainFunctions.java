package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.utils;

import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain.Cliente;
import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain.Evento;
import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain.Ingresso;
import GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain.IngressoUtilizado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFunctions {
    private static List<Cliente> clientesDoEvento = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Ingresso> ingressos = new ArrayList<>();

    private static long proximoIdIngresso = 1;

    public static void cadastrarCliente() {
        System.out.print("Insira o nome do seu Cliente: ");
        String nomeCliente = new Scanner(System.in).nextLine();

        System.out.print("Insira a idade do Cliente: ");
        Integer idadeCliente = new Scanner(System.in).nextInt();

        Cliente cliente = Cliente.ClienteBuilder.builder()
                .nome(nomeCliente)
                .idade(idadeCliente)
                .build();

        clientesDoEvento.add(cliente);
        System.out.println("Cliente cadastrado com sucesso...");

    }

    public static void cadastrarEvento() {
        System.out.print("Insira o ID do novo evento: ");
        Long idEvento = new Scanner(System.in).nextLong();

        System.out.print("Insira o nome do novo evento: ");
        String nomeEvento = new Scanner(System.in).nextLine();

        System.out.print("Insira o valor do ingresso: ");
        Double valorIngresso = new Scanner(System.in).nextDouble();

        System.out.println("Insira a data do evento: ");
        System.out.print("Dia: ");
        int diaEvento = new Scanner(System.in).nextInt();
        System.out.print("Mês: ");
        int mesEvento = new Scanner(System.in).nextInt();
        System.out.print("Ano: ");
        int anoEvento = new Scanner(System.in).nextInt();

        Evento evento = Evento.EventoBuilder.builder()
                .idEvento(idEvento)
                .nomeEvento(nomeEvento)
                .valorIngresso(valorIngresso)
                .dataEvento(LocalDate.of(anoEvento, mesEvento, diaEvento))
                .build();

        eventos.add(evento);
        System.out.println("Evento cadastrado com sucesso...");
    }

    public static void listarEventos() {
        System.out.println("\n\nLista de Eventos");
        System.out.println("----------------------------------");

        if (eventos.isEmpty()) {
            System.out.println("Ainda não há eventos cadastrados.");
        } else {
            for (Evento evento : eventos) {
                System.out.println(evento.gerarDescricaoEvento());
            }
        }

        System.out.println("\nTotal de Eventos: " + eventos.size());
    }

    public static void listarClientes() {
        System.out.println("\n\nLista de Clientes");
        System.out.println("----------------------------------");

        if (clientesDoEvento.isEmpty()) {
            System.out.println("Ainda não há clientes cadastrados.");
        } else {
            for (Cliente cliente : clientesDoEvento) {
                System.out.println(cliente.apresentarse());
            }
        }

        System.out.println("\nTotal de Clientes: " + clientesDoEvento.size());
    }


    public static Cliente encontrarClientePorNome(String nomeCliente) {
        for (Cliente cliente : clientesDoEvento) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public static Evento encontrarEventoPorId(long idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == idEvento) {
                return evento;
            }
        }
        return null;
    }

    public static Ingresso encontrarIngressoPorId(long idIngresso) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId() == idIngresso) {
                return ingresso;
            }
        }
        return null;
    }

    public static void comprarIngresso() {
        listarClientes();
        listarEventos();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = new Scanner(System.in).nextLine();
        Cliente cliente = encontrarClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Pedido não pode ser criado.");
            return;
        }

        System.out.print("Insira o ID do evento: ");
        long idEvento = new Scanner(System.in).nextLong();
        Evento eventoEncontrar = encontrarEventoPorId(idEvento);
        if (eventoEncontrar == null) {
            System.out.println("Evento não encontrado. Pedido não pode ser criado.");
            return;
        }

        Ingresso ingresso = Ingresso.IngressoBuilder.builder()
                .id(proximoIdIngresso++)
                .dataCompraIngresso(LocalDate.now())
                .build();

        ingressos.add(ingresso);
        System.out.println("Ingresso comprado com sucesso...");
    }

    public static void listarIngressos() {

        if (ingressos.isEmpty()) {
            System.out.println("Ainda não há ingressos comprados.");
        } else {
            for (Ingresso ingresso : ingressos) {
                System.out.println(ingresso.listarIngressos());
            }
        }

        System.out.println("\n\nTotal de ingressos comprados: " + ingressos.size());
    }

    public static void utilizarIngresso() {
        listarIngressos();

        System.out.println("Insira qual o número do seu ingresso: ");
        long idIngresso = new Scanner(System.in).nextLong();
        Ingresso ingressoEncontrado = encontrarIngressoPorId(idIngresso);
        if (ingressoEncontrado != null) {
            System.out.println("Ingresso encontrado!");
        } else {
            System.out.println("Ingresso não encontrado. Tente novamente.");
            return;
        }

        IngressoUtilizado ingressoUtilizado = IngressoUtilizado.IngressoUtilizadoBuilder.builder()
                .idIngresso(idIngresso)
                .build();
        ingressos.remove(ingressoEncontrado);
        System.out.println(ingressoUtilizado.utilizarIngresso());
    }
}
