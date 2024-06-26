package Listasete;

public class Loja {
    private String nomeFantasia = "Loja da Dona Gabrielinha1";
    private String razaoSocial = "Vender plantas";
    private String cnpj = "38.647.222/0001-73";
    private String cidade = "Cascavel";
    private String bairro = "Parque Vender";
    private String rua = "Jacarandá";
    private String endereco = "Rua Jacarandá 628";
    private String[] vendedores = {"Joao", "Murilo", "Gabriel"};
    private String[] clientes = {"Jorge", "Ana", "Sofia"};


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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String[] getVendedores() {
        return vendedores;
    }

    public void setVendedores(String[] vendedores) {
        this.vendedores = vendedores;
    }

    public String[] getClientes() {
        return clientes;
    }

    public void setClientes(String[] clientes) {
        this.clientes = clientes;
    }


    public void apresentarse(){
        System.out.println("Nome de fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + endereco);
    }

    public void contarClientes(){
        System.out.println("A quantidade de clientes é: " + clientes.length);
    }

    public void contarVendedores(){
        System.out.println("A quantidade de vendedores é: " + vendedores.length);
    }
}
