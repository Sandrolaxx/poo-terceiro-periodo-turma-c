package RAFAEL_ROANI.prova.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private Long id;
    private String titulo;
    private String local;
    private LocalDateTime datEHorario;
    private List<Cliente> clientes = new ArrayList<>();

    private Evento(Long id, String titulo, String local, LocalDateTime datEHorario) {
        this.id = id;
        this.titulo = titulo;
        this.local = local;
        this.datEHorario = datEHorario;
    }

    @Override
    public String toString() {
        return "Id: " + id + ".\n" +
                "Titulo: " + titulo  + ".\n" +
                "Local: " + local  + ".\n" +
                "Data e Horario: " + datEHorario + "\n" +
                "Numero de Pessoas: " + clientes.size() + "\n";
    }

    public boolean addParticipante(Cliente cliente) {
        return clientes.add(cliente);
    }

    public void listPessoasComIngresso() {
        System.out.println("***** Participantes *****");
        clientes.forEach(System.out::println);
        System.out.println("***** **** *****");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public LocalDateTime getDatEHorario() {
        return datEHorario;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String getTitulo() {
        return titulo;
    }


    public static final class EventoBuilder {
        private Long id;
        private String titulo;
        private String local;
        private LocalDateTime datEHorario;

        private EventoBuilder() {
        }

        public static EventoBuilder builder() {
            return new EventoBuilder();
        }

        public EventoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EventoBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public EventoBuilder local(String local) {
            this.local = local;
            return this;
        }

        public EventoBuilder datEHorario(LocalDateTime datEHorario) {
            this.datEHorario = datEHorario;
            return this;
        }

        public Evento build() {
            return new Evento(id, titulo, local, datEHorario);
        }
    }
}
