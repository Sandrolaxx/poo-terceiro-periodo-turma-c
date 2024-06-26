package RAFAEL_ROANI.prova.domain;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MainFunctions {
    public static void cadastrarCliente() {
        System.out.println("***** Cadastrar Cliente ****");
        System.out.print("Nome: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = new Scanner(System.in).nextLine();
        System.out.print("Idade: ");
        int idade = new Scanner(System.in).nextInt();

        Cliente cliente = Cliente.ClienteBuilder.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .idade(idade)
                .build();

        GerenciadorEvento.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }
    public static void cadastrarEvento() {
        System.out.println("***** Cadastrar Evento ****");
        System.out.print("Titulo: ");
        String titulo = new Scanner(System.in).nextLine();
        System.out.print("Local: ");
        String local = new Scanner(System.in).nextLine();
        System.out.print("Mes: ");
        int mes = new Scanner(System.in).nextInt();
        System.out.print("Dia do Mes: ");
        int dia = new Scanner(System.in).nextInt();
        System.out.print("Hora do Dia: ");
        int hora = new Scanner(System.in).nextInt();
        System.out.print("Minutos: ");
        int minutos = new Scanner(System.in).nextInt();

        LocalDateTime dataEvento = LocalDateTime.of(2024, mes, dia, hora, minutos);

        Evento evento = Evento.EventoBuilder.builder()
                .titulo(titulo)
                .local(local)
                .datEHorario(dataEvento)
                .build();

        GerenciadorEvento.cadastrarEvento(evento);
    }
    public static boolean listarEventos() {
        return GerenciadorEvento.listarEventos();
    }

    public static boolean listarClientes() {
        return GerenciadorEvento.listarCliente();
    }
    public static void comprarIngresso() {
        if (!listarEventos()) return;
        System.out.print("Escolha um evento para comprar o ingreço: ");
        Long idEvento = new Scanner(System.in).nextLong();
        Evento evento = GerenciadorEvento.findEventoById(idEvento);

        if (!listarClientes()) return;
        System.out.print("Escolha o cliente que vai comprar o ingresso: ");
        Long idCliente = new Scanner(System.in).nextLong();
        Cliente cliente = GerenciadorEvento.findClienteById(idCliente);
        if (cliente.getIngresso() != null) {
            System.out.println("O cliente já possui um ingresso!");
            return;
        }

        Ingresso ingresso = new Ingresso(evento, cliente);
        cliente.setIngresso(ingresso);
        System.out.println("Ingresso Comprado com Sucesso!");
    }
    public static void utilizarIngresso() {
        if (!listarClientes()) return;
        System.out.print("Escolha o cliente que vai utilizar o ingresso: ");
        Long idCliente = new Scanner(System.in).nextLong();
        Cliente cliente = GerenciadorEvento.findClienteById(idCliente);
        if (cliente.getIngresso() != null) {
            cliente.getIngresso().usar();
            cliente.setIngresso(null);
        } else {
            System.out.println("Erro! você não tem nenhum ingresso!");
        }
    }
}
