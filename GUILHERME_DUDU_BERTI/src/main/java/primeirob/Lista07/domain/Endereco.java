package primeirob.Lista07.domain;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;

    private Endereco(String estado, String cidade, String bairro, String rua, Integer numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String apresentarLogradouro() {
        return ("Moro no estado de: " + estado + " ,na cidade de: " + cidade + ", no bairro: " + bairro
                + ", na rua: " + rua + ", complemento: " + complemento + ".");
    }

    public static final class EnderecoBuilder {
        private String estado;
        private String cidade;
        private String bairro;
        private String rua;
        private Integer numero;
        private String complemento;

        private EnderecoBuilder() {
        }

        public static EnderecoBuilder builder() {
            return new EnderecoBuilder();
        }

        public EnderecoBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public EnderecoBuilder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public EnderecoBuilder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoBuilder rua(String rua) {
            this.rua = rua;
            return this;
        }

        public EnderecoBuilder numero(Integer numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoBuilder complemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Endereco build() {
            return new Endereco(estado, cidade, bairro, rua, numero, complemento);
        }
    }
}
