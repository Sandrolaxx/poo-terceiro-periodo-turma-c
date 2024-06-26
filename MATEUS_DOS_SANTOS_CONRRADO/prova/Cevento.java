import java.util.ArrayList;
import java.util.List;

public class Cevento {
    private List<Cevento> eventos;

    public Cevento() {
        this.eventos = new ArrayList<>();
    }

    public void cadastrarEvento(String nome, String data, String local, int ingressosDisponiveis) {
        Cevento evento = new Evento(nome, data, local, ingressosDisponiveis);
        eventos.add(evento);
    }

    public void listarEventos() {
        System.out.println("Lista de Eventos:");
        for (Cevento evento : eventos) {
            System.out.println(evento);
        }
    }
}
