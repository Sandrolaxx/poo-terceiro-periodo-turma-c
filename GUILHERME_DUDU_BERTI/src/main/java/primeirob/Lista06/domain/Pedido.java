package primeirob.Lista06.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido {
    private Long id;
    private LocalDate dataCriacao;
    private LocalDate dataPagamento;
    private LocalDate dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens;
    private String empresaParceira;

    public Pedido(Long id,
                  Cliente cliente, Vendedor vendedor, LocalDate dataCriacao, Loja loja, List<Item> itens,
                  String empresaParceira) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
        this.dataCriacao = LocalDate.now();
        this.dataPagamento = dataCriacao.plusDays(1);
        this.dataVencimentoReserva = dataCriacao.plusDays(3);
        this.empresaParceira = empresaParceira;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public LocalDate getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public String gerarDescricaoVenda() {
        String descricao = "================== Pedido ======================\n";
        descricao += "ID Pedido: " + id + "\n";
        descricao += "Data de Criação: " + dataCriacao.format(DateTimeFormatter.ISO_DATE) + "\n";
        descricao += "Cliente: " + cliente.getNomePessoa() + "\n";
        descricao += "Vendedor: " + vendedor.getNomePessoa() + "\n";
        descricao += "Loja: " + loja.getNomeFantasia() + "\n";
        if (empresaParceira != null && !empresaParceira.isEmpty()) {
            descricao += "Pedido realizado em parceria com a empresa: " + empresaParceira + "\n";
        }
        descricao += "\n";
        descricao += "Itens:\n";
        for (Item item : itens) {
            descricao += item.gerarDescricao() + "\n";
        }
        descricao += "\n";
        descricao += "Valor Total: R$" + String.format("%.2f", calcularValorTotal());
        descricao += "\n=============================================\n";
        return descricao;
    }


    public static final class PedidoBuilder {
        private Long id;
        private LocalDate dataCriacao;
        private LocalDate dataPagamento;
        private LocalDate dataVencimentoReserva;
        private Cliente cliente;
        private Vendedor vendedor;
        private Loja loja;
        private List<Item> itens;
        private String empresaParceira;

        public PedidoBuilder() {
        }

        public static PedidoBuilder builder() {
            return new PedidoBuilder();
        }

        public PedidoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PedidoBuilder dataCriacao(LocalDate dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public PedidoBuilder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoBuilder vendedor(Vendedor vendedor) {
            this.vendedor = vendedor;
            return this;
        }

        public PedidoBuilder loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public PedidoBuilder itens(List<Item> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoBuilder empresaParceira(String empresaParceira) {
            this.empresaParceira = empresaParceira;
            return this;
        }

        public Pedido build() {
            if (dataCriacao == null) {
                throw new IllegalStateException("Data de criação não pode ser nula");
            }
            return new Pedido(id, cliente, vendedor, dataCriacao, loja, itens, empresaParceira);
        }
    }
}
