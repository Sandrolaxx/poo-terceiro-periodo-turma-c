package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.domain.abstracts.Pessoa;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Cliente extends Pessoa {
    public Cliente(String nome, Integer idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarse() {
        log.info("Meu nome é {} e minha idade é {}", nome, idade);
    }

    public static final class ClienteBuilderLista07 {
        private String nome;
        private Integer idade;
        private Endereco endereco;

        private ClienteBuilderLista07() {
        }

        public static ClienteBuilderLista07 builder() {
            return new ClienteBuilderLista07();
        }

        public ClienteBuilderLista07 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilderLista07 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public ClienteBuilderLista07 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Cliente build() {
            return new Cliente(nome, idade, endereco);
        }
    }
}