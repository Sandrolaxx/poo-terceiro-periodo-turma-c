package GUILHERME_DUDU_BERTI.prova.src.main.java.Prova.domain;

public class Cliente {

    private String nome;
    private Integer idade;

    private Cliente(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String apresentarse() {
        return ("Nome: " + nome +
                ", idade: " + idade + ".");
    }

    public String getNome() {
        return nome;
    }

    public static final class ClienteBuilder {
        private String nome;
        private Integer idade;

        private ClienteBuilder() {
        }

        public static ClienteBuilder builder() {
            return new ClienteBuilder();
        }

        public ClienteBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilder idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Cliente build() {
            return new Cliente(nome, idade);
        }
    }
}
