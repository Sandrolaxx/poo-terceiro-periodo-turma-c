package segunda_versao.model;


public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private long cnpj;
    private Endereco endereco;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Long getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco() {
        this.endereco = endereco;
    }

    public Vendedor[] getVendedores() {
        return this.vendedores;
    }

    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    public Cliente[] getClientes() {
        return this.clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int contarClientes() {
        return clientes.length;
    }

    public int contarVendedores() {
        return vendedores.length;
    }

    public void apresentarSe() {
        System.out.println("Nome fantasia da loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        this.endereco.apresentarLogradouro();
    }
}
