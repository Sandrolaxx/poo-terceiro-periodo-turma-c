package primeirobimestre.list5.domain;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;

@Log4j2
public class Cliente extends Pessoa {
    private Cliente(String nome, Integer idade, String cidade, String bairro, String rua) {
        super(nome, idade, cidade, bairro, rua);
    }

    @Override
    public void apresentarse() {
        log.info("Meu nome é {} e minha idade é {}", nome, idade);
    }

    @Override
    public String toString() {
        return "Vendedor: " + "\n" +
                "Nome: " + nome + "\n" +
                "Idade" + idade + "\n" +
                "Endereço: " + rua + ", " + bairro + " - " + cidade + "\n";
    }


    public static final class ClienteBuilderLista05 {
        private Logger log;
        private String cidade;
        private String bairro;
        private String rua;
        private String nome;
        private Integer idade;

        private ClienteBuilderLista05() {
        }

        public static ClienteBuilderLista05 builder() {
            return new ClienteBuilderLista05();
        }

        public ClienteBuilderLista05 log(Logger log) {
            this.log = log;
            return this;
        }

        public ClienteBuilderLista05 cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public ClienteBuilderLista05 bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public ClienteBuilderLista05 rua(String rua) {
            this.rua = rua;
            return this;
        }

        public ClienteBuilderLista05 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilderLista05 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);
            return cliente;
        }
    }
}