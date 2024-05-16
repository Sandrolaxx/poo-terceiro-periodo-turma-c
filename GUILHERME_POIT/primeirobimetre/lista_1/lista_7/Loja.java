package primeirobimetre.lista_1.lista_7;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private long cnpj;
    private Endereco endereco;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Gerente> gerentes = new ArrayList<>();
    private List<Item> itens = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, long cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public int contarClientes(){
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + endereco.apresentarLogradouro());
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
    public void cadastrarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public void cadastrarItem(Item item) {
        item.setId(itens.size());
        itens.add(item);
    }

    public void cadastrarPedido(Pedido pedido) {
        pedido.setId(pedidos.size());
        pedidos.add(pedido);
    }

    public Item buscarItem(int id) {
        return itens.get(id);
    }

    public void listarItens() {
        for (Item item : itens) {
            item.gerarDescricao();
        }
    }

    public void listarPedidos() {
        for (Pedido pedido : pedidos) {
            pedido.gerarDescricaoVenda();
        }
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public List<Item> getItens() {
        return itens;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
