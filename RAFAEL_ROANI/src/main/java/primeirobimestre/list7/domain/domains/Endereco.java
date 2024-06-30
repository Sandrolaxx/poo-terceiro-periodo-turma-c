package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.enums.endereco.Estado;

public class Endereco {
    private Estado estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String rua;
    private String complemento;

    private Endereco(Estado estado, String cidade, String bairro, int numero, String rua, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.rua = rua;
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return apresentarLogradouro();
    }

    public String apresentarLogradouro() {
        return rua + ", " + bairro + ", " + numero + ", " + cidade + " - " + estado + "\n" +
                "Complemento: " + complemento;
    }


    public static final class EnderecoBuilderLista07 {
        private Estado estado;
        private String cidade;
        private String bairro;
        private int numero;
        private String rua;
        private String complemento;

        private EnderecoBuilderLista07() {
        }

        public static EnderecoBuilderLista07 builder() {
            return new EnderecoBuilderLista07();
        }

        public EnderecoBuilderLista07 estado(Estado estado) {
            this.estado = estado;
            return this;
        }

        public EnderecoBuilderLista07 cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public EnderecoBuilderLista07 bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoBuilderLista07 numero(int numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoBuilderLista07 rua(String rua) {
            this.rua = rua;
            return this;
        }

        public EnderecoBuilderLista07 complemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Endereco build() {
            return new Endereco(estado, cidade, bairro, numero, rua, complemento);
        }
    }
}