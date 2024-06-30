package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.util.CurrencyFormat07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private LocalDate dataCriacao;
    private LocalDate dataPagamento;
    private LocalDate dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private String lojaParceiraNome;
    private List<ItemCompra> itensCompra = new ArrayList<>();

    private Pedido(
            Long id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva, Cliente cliente,
            Vendedor vendedor, Loja loja, List<ItemCompra> itensCompra, String lojaParceiraNome
    ) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itensCompra.addAll(itensCompra);
        this.lojaParceiraNome = lojaParceiraNome;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemCompra itemCompra : itensCompra) {
            total += itemCompra.getValor();
        }
        return total;
    }

    public int quantidadeItens() {
        return itensCompra.size();
    }

    public String gerarDescricaoVenda() {
        return "Data da criação: " + dataCriacao + ", valor total: " + calcularValorTotal() + ".";
    }

    @Override
    public String toString() {
        return id + " -  Cliente: " + cliente.getNome() + ", Vendedor: " + vendedor.getNome() +
                ", Total: " + CurrencyFormat07.format(calcularValorTotal());
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public List<ItemCompra> getItensCompra() {
        return itensCompra;
    }

    public String getLojaParceiraNome() {
        return lojaParceiraNome;
    }

    public static final class PedidoBuilderLista07 {
        private Long id;
        private LocalDate dataCriacao;
        private LocalDate dataPagamento;
        private LocalDate dataVencimentoReserva;
        private Cliente cliente;
        private Vendedor vendedor;
        private Loja loja;
        private List<ItemCompra> itensCompra;
        private String lojaParceiraNome;

        private PedidoBuilderLista07() {
        }

        public static PedidoBuilderLista07 builder() {
            return new PedidoBuilderLista07();
        }

        public PedidoBuilderLista07 id(Long id) {
            this.id = id;
            return this;
        }

        public PedidoBuilderLista07 dataCriacao(LocalDate dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public PedidoBuilderLista07 dataPagamento(LocalDate dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public PedidoBuilderLista07 dataVencimentoReserva(LocalDate dataVencimentoReserva) {
            this.dataVencimentoReserva = dataVencimentoReserva;
            return this;
        }

        public PedidoBuilderLista07 cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoBuilderLista07 vendedor(Vendedor vendedor) {
            this.vendedor = vendedor;
            return this;
        }

        public PedidoBuilderLista07 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public PedidoBuilderLista07 itensCompra(List<ItemCompra> itensCompra) {
            this.itensCompra = itensCompra;
            return this;
        }

        public PedidoBuilderLista07 lojaParceira(String lojaParceiraNome) {
            this.lojaParceiraNome = lojaParceiraNome;
            return this;
        }

        public Pedido build() {
            return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itensCompra, lojaParceiraNome);
        }
    }
}