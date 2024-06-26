package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Evento {
    private DecimalFormat df = new DecimalFormat("0.00");
    private Long idEvento;
    private String nomeEvento;
    private Double valorIngresso;
    private LocalDate dataEvento;

    private Evento(Long idEvento, String nomeEvento, Double valorIngresso, LocalDate dataEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.valorIngresso = valorIngresso;
        this.dataEvento = dataEvento;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public Double getValorIngresso() {
        return valorIngresso;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String gerarDescricaoEvento() {
        return ("Evento: " + idEvento + ", nome do evento: " + nomeEvento + ", valor do ingresso: R$" +
                df.format(valorIngresso) + ", data do evento: " + dataEvento);
    }


    public static final class EventoBuilder {
        private Long idEvento;
        private String nomeEvento;
        private Double valorIngresso;
        private LocalDate dataEvento;

        private EventoBuilder() {
        }

        public static EventoBuilder builder() {
            return new EventoBuilder();
        }

        public EventoBuilder idEvento(Long idEvento) {
            this.idEvento = idEvento;
            return this;
        }

        public EventoBuilder nomeEvento(String nomeEvento) {
            this.nomeEvento = nomeEvento;
            return this;
        }

        public EventoBuilder valorIngresso(Double valorIngresso) {
            this.valorIngresso = valorIngresso;
            return this;
        }

        public EventoBuilder dataEvento(LocalDate dataEvento) {
            this.dataEvento = dataEvento;
            return this;
        }

        public Evento build() {
            return new Evento(idEvento, nomeEvento, valorIngresso, dataEvento);
        }
    }
}
