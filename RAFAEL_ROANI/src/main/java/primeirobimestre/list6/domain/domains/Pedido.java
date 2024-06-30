package primeirobimestre.list6.domain.domains;

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
    private List<ItemCompra> itensCompra = new ArrayList<>();

    private Pedido(
            Long id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva, Cliente cliente,
            Vendedor vendedor, Loja loja, List<ItemCompra> itensCompra
    ) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itensCompra.addAll(itensCompra);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemCompra itemCompra : itensCompra) {
            total += itemCompra.getValor();
        }
        return total;
    }

    public String gerarDescricaoVenda() {
        return "Data da criação: " + dataCriacao + ", valor total: " + calcularValorTotal() + ".";
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

    public static final class PedidoBuilderLista06 {
        private Long id;
        private LocalDate dataCriacao;
        private LocalDate dataPagamento;
        private LocalDate dataVencimentoReserva;
        private Cliente cliente;
        private Vendedor vendedor;
        private Loja loja;
        private List<ItemCompra> itensCompra;

        private PedidoBuilderLista06() {
        }

        public static PedidoBuilderLista06 builder() {
            return new PedidoBuilderLista06();
        }

        public PedidoBuilderLista06 id(Long id) {
            this.id = id;
            return this;
        }

        public PedidoBuilderLista06 dataCriacao(LocalDate dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public PedidoBuilderLista06 dataPagamento(LocalDate dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public PedidoBuilderLista06 dataVencimentoReserva(LocalDate dataVencimentoReserva) {
            this.dataVencimentoReserva = dataVencimentoReserva;
            return this;
        }

        public PedidoBuilderLista06 cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoBuilderLista06 vendedor(Vendedor vendedor) {
            this.vendedor = vendedor;
            return this;
        }

        public PedidoBuilderLista06 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public PedidoBuilderLista06 itensCompra(List<ItemCompra> itensCompra) {
            this.itensCompra = itensCompra;
            return this;
        }

        public Pedido build() {
            return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itensCompra);
        }
    }
}


//5. Criar uma classe Pedido com:
//        - Atributos, id, dataCriacao, dataPagamento, dataVencimentoReserva(a reserva vence depois de 3 dias da criação do pedido),
//        cliente, vendedor, Loja e array de itens.
//        - Método calcularValorTotal, retorna o valor total do pedido.
//- Método gerarDescricaoVenda, retorna o print informando a data de criação do pedido e seu valor total.