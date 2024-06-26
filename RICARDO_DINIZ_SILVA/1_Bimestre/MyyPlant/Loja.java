package RICARDO_DINIZ_SILVA.MyyPlant;

public class Loja {
    public String nomeFantasia;
    public String razaoSocial;
    public Long cnpj;
    public String cidade;
    public String bairro;
    public String rua;
    public Vendedor[] vendedores;
    public Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, Long cnpj, String cidade, String bairro, String rua, Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: ".concat(nomeFantasia).concat(", CNPJ: ".concat(cnpj.toString())).concat(", Endereço: ").concat(rua).concat(", ").concat(bairro).concat(" - ").concat(cidade));
    }

    public int contarClientes() {
        return clientes.length;
    }
    public int contarVendedores() {
        return vendedores.length;
    }

}
