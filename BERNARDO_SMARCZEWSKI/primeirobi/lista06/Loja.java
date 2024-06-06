package primeirobi.lista06;

public class Loja {
    
    String nome;
    String cnpj;
    String razao;
    Endereco endereco;
    Vendedor[] vendedores;
    Cliente[] clientes;
    int nClientes = 0;
    int nVendedores = 0;

    public Loja(String nome, String razao, String cnpj, Endereco endereco) {

        this.nome = nome;
        this.cnpj = cnpj;
        this.razao = razao;
        this.endereco = endereco;
        this.clientes = new Cliente[10];
        this.vendedores = new Vendedor[10];

    }

    public void apresentarse() {

        System.out.println("Loja: " + nome);
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

}
