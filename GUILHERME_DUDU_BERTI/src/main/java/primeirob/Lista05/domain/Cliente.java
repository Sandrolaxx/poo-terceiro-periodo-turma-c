package primeirob.Lista05.domain;

public class Cliente extends Pessoa {

    private Cliente(String nomePessoa, String cidade, String bairro, String rua, Integer idade) {
        super(nomePessoa, cidade, bairro, rua, idade);
    }

    // Met add
    @Override
    public String apresentarse() {
        return ("Meu nome é: "
                .concat(nomePessoa)
                .concat(", minha idade é: ")
                .concat(idade + "."));
    }

    public static final class ClienteBuilder {
        private String nomePessoa;
        private String cidade;
        private String bairro;
        private String rua;
        private Integer idade;

        private ClienteBuilder() {
        }

        public static ClienteBuilder builder() {
            return new ClienteBuilder();
        }

        public ClienteBuilder nomePessoa(String nomePessoa) {
            this.nomePessoa = nomePessoa;
            return this;
        }

        public ClienteBuilder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public ClienteBuilder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public ClienteBuilder rua(String rua) {
            this.rua = rua;
            return this;
        }

        public ClienteBuilder idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Cliente build() {
            return new Cliente(nomePessoa, cidade, bairro, rua, idade);
        }
    }

}
