package ATV5.src;

import java.util.ArrayList;

public class Loja {
  
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    ArrayList<Vendedor> vendedores;
    ArrayList<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarLoja() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void apresentarClientes() {
        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : clientes) {
            cliente.apresentarCliente();
            System.out.println("----------------------");
        }
    }

    public void apresentarVendedores() {
        System.out.println("\nLista de Vendedores:");
        for (Vendedor vendedor : vendedores) {
            vendedor.apresentarVendedor();
            System.out.println("----------------------");
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

    public ArrayList<Vendedor> getVendedores() {
      return vendedores;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
      this.vendedores = vendedores;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
      this.clientes = clientes;
    }

}