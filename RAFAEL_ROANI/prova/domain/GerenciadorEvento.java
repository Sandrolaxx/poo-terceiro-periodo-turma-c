package RAFAEL_ROANI.prova.domain;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorEvento {
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static Long proximoIdCliente = 0L;
    private static Long proximoIdEvento = 0L;

    public static boolean listarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return false;
        }
        System.out.println("***** Clientes *****");
        clientes.forEach(System.out::println);
        System.out.println("***** **** *****");
        return true;
    }

    public static boolean listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Não há eventos cadastrados!");
            return false;
        }
        System.out.println("***** Eventos *****");
        eventos.forEach(System.out::println);
        System.out.println("***** **** *****");
        return true;
    }

    public static Cliente findClienteById(Long id) {
        return clientes.get(Math.toIntExact(id));
    }

    public static Evento findEventoById(Long id) {
        return eventos.get(Math.toIntExact(id));
    }

    public static boolean cadastrarCliente(Cliente cliente) {
        cliente.setId(proximoIdCliente++);
        return clientes.add(cliente);
    }

    public static boolean cadastrarEvento(Evento evento) {
        evento.setId(proximoIdEvento++);
        return eventos.add(evento);
    }
}
