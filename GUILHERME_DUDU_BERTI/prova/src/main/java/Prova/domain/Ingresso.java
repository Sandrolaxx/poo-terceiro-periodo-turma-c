package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain;

import java.time.LocalDate;

public class Ingresso {
    private Long id;
    private LocalDate dataCompraIngresso;

    private Ingresso(Long id, LocalDate dataCompraIngresso) {
        this.id = id;
        this.dataCompraIngresso = dataCompraIngresso;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataCompraIngresso() {
        return dataCompraIngresso;
    }

    public String listarIngressos() {
        return "Ingresso Número: " + id + ", data de compra: " + getDataCompraIngresso();
    }

    public static final class IngressoBuilder {
        private Long id;
        private LocalDate dataCompraIngresso;

        private IngressoBuilder() {
        }

        public static IngressoBuilder builder() {
            return new IngressoBuilder();
        }

        public IngressoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public IngressoBuilder dataCompraIngresso(LocalDate dataCompraIngresso) {
            this.dataCompraIngresso = dataCompraIngresso;
            return this;
        }

        public Ingresso build() {
            return new Ingresso(id, dataCompraIngresso);
        }
    }
}
