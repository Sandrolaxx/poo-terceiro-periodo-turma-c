package LUCAS_EDUARDO_DE_LIMA.listas.listasete;

import java.util.List;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    long cnpj;
    Endereco endereco;
    List<Cliente> clientes;
    List<Vendedor> vendedors;

    public Loja(String nomeFantasia, String razaoSocial, long cnpj, Endereco endereco, List<Cliente> clientes, List<Vendedor> vendedors) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.clientes = clientes;
        this.vendedors = vendedors;
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedors.size();
    }

    public void apresentarse() {
        System.out.println(nomeFantasia + " do CNPJT " + cnpj + " no endereço: " + endereco);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}