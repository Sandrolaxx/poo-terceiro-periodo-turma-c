package EDUARDA_GABRIELI_KACPRZAK.prova;

import java.util.List;
import EDUARDA_GABRIELI_KACPRZAK.prova.CadastroEvento.Evento;

public class ComprarIngresso {
    
public class Ingresso {
    public Ingresso(Evento evento2, Cliente cliente2) {
    }
    private Evento evento;
    private Cliente cliente;
    private int numeroAssento;
}

    public class GerenciadorIngresso {
    private List<Evento> eventos;
    private List<Cliente> clientes;
    private List<Ingresso> ingressos;
    

    public void comprarIngresso(Cliente cliente, Evento evento) {
        if (evento.getIngressosDisponiveis() > 0) {
            Ingresso ingresso = new Ingresso(evento, cliente);

            evento.getIngressosDisponiveis();
            ingressos.add(ingresso);
            System.out.println("Ingresso comprado com sucesso para " + cliente.getNome() + " para o evento " + evento.getNomeEvento());
        } else {
            System.out.println("Não há ingressos disponíveis para o evento " + evento.getNomeEvento());
        }
    }
}

