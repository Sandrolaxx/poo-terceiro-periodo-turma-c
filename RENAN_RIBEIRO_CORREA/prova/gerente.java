package RENAN_RIBEIRO_CORREA.prova;

import java.util.ArrayList;
import java.util.List;

public class gerente {
    private List<Cliente> clientes;
    private List<Evento> eventos;
    private List<Ingresso> ingressos;

    public GerenciadorDeEventos() {
        this.clientes = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.ingressos = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void comprarIngresso(Cliente cliente, Evento evento) {
        Ingresso ingresso = new Ingresso(ingressos.size() + 1, evento, cliente);
        ingressos.add(ingresso);
        evento.addIngresso(ingresso);
    }

    public void utilizarIngresso(Ingresso ingresso) {
        ingresso.setUtilizado(true);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}
