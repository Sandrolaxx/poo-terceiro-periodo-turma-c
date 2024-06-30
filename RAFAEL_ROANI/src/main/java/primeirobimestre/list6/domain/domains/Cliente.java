package primeirobimestre.list6.domain.domains;

import lombok.extern.log4j.Log4j2;
import primeirobimestre.list6.domain.abstracts.Endereco;
import primeirobimestre.list6.domain.abstracts.Pessoa;

@Log4j2
public class Cliente extends Pessoa {
    public Cliente(String nome, Integer idade, Endereco endereco) {
        super(nome, idade, endereco);
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
                "Endereço: " + endereco + "\n";
    }


    public static final class ClienteBuilderLista06 {
        private String nome;
        private Integer idade;
        private Endereco endereco;

        private ClienteBuilderLista06() {
        }

        public static ClienteBuilderLista06 builder() {
            return new ClienteBuilderLista06();
        }

        public ClienteBuilderLista06 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilderLista06 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public ClienteBuilderLista06 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Cliente build() {
            return new Cliente(nome, idade, endereco);
        }
    }
}