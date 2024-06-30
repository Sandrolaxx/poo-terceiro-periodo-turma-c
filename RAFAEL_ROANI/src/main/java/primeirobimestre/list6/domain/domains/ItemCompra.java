package primeirobimestre.list6.domain.domains;

public class ItemCompra {
    private Long id;
    private String nome;
    private String tipo;
    private Double valor;

    private ItemCompra(Long id, String nome, String tipo, Double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String gerarDescricao() {
        return "Id: " + id + ".\n" +
                "Nome: " + nome + ".\n" +
                "Tipo: " + tipo + ".\n" +
                "Valor: " + valor + ".\n";
    }

    public Double getValor() {
        return valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static final class ItemCompraBuilderLista06 {
        private Long id;
        private String nome;
        private String tipo;
        private Double valor;

        private ItemCompraBuilderLista06() {
        }

        public static ItemCompraBuilderLista06 builder() {
            return new ItemCompraBuilderLista06();
        }

        public ItemCompraBuilderLista06 id(Long id) {
            this.id = id;
            return this;
        }

        public ItemCompraBuilderLista06 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ItemCompraBuilderLista06 tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public ItemCompraBuilderLista06 valor(Double valor) {
            this.valor = valor;
            return this;
        }

        public ItemCompra build() {
            return new ItemCompra(id, nome, tipo, valor);
        }
    }
}