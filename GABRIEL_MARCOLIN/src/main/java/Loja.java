public class Loja {
    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private Endereco endereco;

    private Vendedor[] vendedor;

    private Cliente[] cliente;

    public Loja(){
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Cliente[] getCliente() {
        return cliente;
    }

    public void setCliente(Cliente[] cliente) {
        this.cliente = cliente;
    }

    public Vendedor[] getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor[] vendedor) {
        this.vendedor = vendedor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String apresentarse() {
        String apresentandoLoja = "\nNome fantasia da loja: " + getNomeFantasia() +
                "\nCNPJ da loja: " + getCnpj() +
                "\nEndereco da loja: " + getEndereco().apresentarLogradouro();
        return apresentandoLoja;
    }

    public void contarClientes() {
        System.out.println("A quantidade de clientes desta loja é " + cliente.length);
    }

    public void contarVendedores() {
        System.out.println("A quantidade de vendedores desta loja é " + vendedor.length);
    }
}
