package primeirobi.lista07;

public class Loja {

    private String nome;
    private String cnpj;
    private String razao;
    private Endereco endereco;
    private Vendedor[] vendedores;
    private Cliente[] clientes;
    private int nClientes = 0;
    private int nVendedores = 0;

    public Loja(String nome, String razao, String cnpj, Endereco endereco) {

        this.nome = nome;
        this.razao = razao;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.clientes = new Cliente[10];
        this.vendedores = new Vendedor[10];

    }

    public void apresentarse() {

        System.out.println("Loja: " + nome);
        System.out.println("Razão: " + razao);
        System.out.println("CNPJ: " + cnpj);
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro();
    }

    public void addClientes(Cliente cliente) {
        clientes[nClientes] = cliente;
        this.nClientes++;
    }

    public void addVendedores(Vendedor vendedor) {
        vendedores[nVendedores] = vendedor;
        this.nVendedores++;
    }

    public void contarClientes() {
        System.out.println("Número de clientes " + nClientes);
    }

    public void contarVendedores() {
        System.out.println("Número de Vendedores: " + nVendedores);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}