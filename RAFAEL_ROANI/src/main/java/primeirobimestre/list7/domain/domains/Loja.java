package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.generated_class.GeneretedClass;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Loja {
    private Long id;
    private Endereco endereco;
    private String nomeFantasia;
    private String razaoSocial;
    private Long cnpj;
    private final List<Vendedor> vendedores = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Gerente> gerentes = new ArrayList<>();
    private final List<ItemCompra> itensCadastrados = new ArrayList<>();
    private final List<Pedido> pedidosFeitos = new ArrayList<>();

    {
        vendedores.add(GeneretedClass.vendedor());
        clientes.add(GeneretedClass.cliente());
        gerentes.add(GeneretedClass.gerente());
    }

    private Loja(
            Endereco endereco, String nomeFantasia, String razaoSocial, Long cnpj
    ) {
        this.endereco = endereco;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public void apresentarse() {
        log.info("Nome da empresa: {}, CNPJ: {}, Endereço: {}", nomeFantasia, cnpj, endereco.apresentarLogradouro());
    }

    @Override
    public String toString() {
        return id + " - " + nomeFantasia + ", CNPJ: " + cnpj + ". \n";
    }

    public ItemCompra findItemCompraById(Long id) {
        return itensCadastrados.get(id.intValue());
    }

    public Cliente findClienteByPosicaoList(Long posicaoList) {
        return clientes.get(id.intValue());
    }
    public Vendedor findVendedorByPosicaoList(Long posicaoList) {
        return vendedores.get(id.intValue());
    }

    public void addPedido(Pedido pedido) {
        pedidosFeitos.add(pedido);
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void addItem(ItemCompra itemCompra) {
        itensCadastrados.add(itemCompra);
    }

    public void addGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public List<ItemCompra> getItensCadastrados() {
        return itensCadastrados;
    }

    public List<Pedido> getPedidosFeitos() {
        return pedidosFeitos;
    }

    public static final class LojaBuilderLista07 {
        Endereco endereco;
        private String nomeFantasia;
        private String razaoSocial;
        private Long cnpj;

        private LojaBuilderLista07() {
        }

        public static LojaBuilderLista07 builder() {
            return new LojaBuilderLista07();
        }

        public LojaBuilderLista07 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public LojaBuilderLista07 nomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
            return this;
        }

        public LojaBuilderLista07 razaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public LojaBuilderLista07 cnpj(Long cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Loja build() {
            return new Loja(endereco, nomeFantasia, razaoSocial, cnpj);
        }
    }
}