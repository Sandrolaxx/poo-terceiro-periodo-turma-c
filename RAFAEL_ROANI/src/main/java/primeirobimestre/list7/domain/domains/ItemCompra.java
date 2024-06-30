package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.util.CurrencyFormat07;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCompra that)) return false;
        return this.id.equals(that.getId()) ||
                this.nome.equals(that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return id + " - " + nome + ", valor: " + CurrencyFormat07.format(valor);
    }

    public String gerarDescricao() {
        return "\nID Produto ---------- " + id + "\n" +
                "Nome ---------------- " + nome + "\n" +
                "Tipo ---------------- " + tipo + "\n" +
                "Valor --------------- " + CurrencyFormat07.format(valor) + "\n";
    }

    public Double getValor() {
        return valor;
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

    public void setId(Long id) {
        this.id = id;
    }

    public static final class ItemCompraBuilderLista07 {
        private Long id;
        private String nome;
        private String tipo;
        private Double valor;

        private ItemCompraBuilderLista07() {
        }

        public static ItemCompraBuilderLista07 builder() {
            return new ItemCompraBuilderLista07();
        }

        public ItemCompraBuilderLista07 id(Long id) {
            this.id = id;
            return this;
        }

        public ItemCompraBuilderLista07 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ItemCompraBuilderLista07 tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public ItemCompraBuilderLista07 valor(Double valor) {
            this.valor = valor;
            return this;
        }

        public ItemCompra build() {
            return new ItemCompra(id, nome, tipo, valor);
        }
    }
}