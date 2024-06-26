package RAFAEL_ROANI.prova.domain;

public class Cliente {
    private Long id;
    private String nome;
    private String sobrenome;
    private int idade;
    private Ingresso ingresso;

    private Cliente(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return id + " - Nome: " + nome + " " + sobrenome + ", Idade: " + idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public static final class ClienteBuilder {
        private Long id;
        private String nome;
        private String sobrenome;
        private int idade;

        private ClienteBuilder() {
        }

        public static ClienteBuilder builder() {
            return new ClienteBuilder();
        }

        public ClienteBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClienteBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public ClienteBuilder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Cliente build() {
            return new Cliente(nome, sobrenome, idade);
        }
    }
}
