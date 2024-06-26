package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain;

public class IngressoUtilizado {
    private Long idIngresso;

    private IngressoUtilizado(Long idIngresso) {
        this.idIngresso = idIngresso;
    }

    public Long getIdIngresso() {
        return idIngresso;
    }

    public String utilizarIngresso() {
        return "Número do Ingresso: " + getIdIngresso() + ".\n Ingresso utilizado com sucesso...";
    }


    public static final class IngressoUtilizadoBuilder {
        private Long idIngresso;

        private IngressoUtilizadoBuilder() {
        }

        public static IngressoUtilizadoBuilder builder() {
            return new IngressoUtilizadoBuilder();
        }

        public IngressoUtilizadoBuilder idIngresso(Long idIngresso) {
            this.idIngresso = idIngresso;
            return this;
        }

        public IngressoUtilizado build() {
            return new IngressoUtilizado(idIngresso);
        }
    }
}
