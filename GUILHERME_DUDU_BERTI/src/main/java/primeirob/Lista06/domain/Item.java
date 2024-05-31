package primeirob.Lista06.domain;

public class Item {
    private Long id;
    private String nome;
    private String tipo;
    private Double valor;

    private Item(Long id, String nome, String tipo, Double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String gerarDescricao() {
        return ("ID Item: " + id + ", Nome: " + nome + ", Tipo: " + tipo
                + ", Valor: " + valor);
    }

    public static final class ItemBuilder {
        private Long id;
        private String nome;
        private String tipo;
        private Double valor;

        private ItemBuilder() {
        }

        public static ItemBuilder builder() {
            return new ItemBuilder();
        }

        public ItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ItemBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ItemBuilder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public ItemBuilder valor(Double valor) {
            this.valor = valor;
            return this;
        }

        public Item build() {
            return new Item(id, nome, tipo, valor);
        }
    }
}
