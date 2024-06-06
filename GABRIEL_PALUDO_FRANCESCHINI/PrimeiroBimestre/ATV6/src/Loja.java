package ATV6.src;

import java.util.ArrayList;

public class Loja {

    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Gerente> gerentes = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String estado, String cidade, String bairro, String rua, String numeroLugar, String complemento) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = new Endereco(estado, cidade, bairro, rua, numeroLugar, complemento);
    }

    public void apresentarLoja() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro();
    }

    public void apresentarVendedores() {
      System.out.println("\nLista de Vendedores:");
      for (Vendedor vendedor : vendedores) {
          vendedor.apresentarVendedor();
          System.out.println("----------------------");
      }
    }

    public void apresentarClientes() {
        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : clientes) {
            cliente.apresentarCliente();
            System.out.println("----------------------");
        }
    }

    public void apresentarGerentes() {
      System.out.println("\nLista de Gerentes:");
      for (Gerente gerente : gerentes) {
          gerente.apresentarGerente();
          System.out.println("----------------------");
      }
  }

    public int contarVendedores() {
      return vendedores.size();
    }

    public int contarClientes() {
      return clientes.size();
    }

    public String getNomeFantasia() {
      return nomeFantasia;
    }

    public void apresentarEndereco() {
      endereco.apresentarLogradouro();
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

    public Endereco getEndereco() {
      return endereco;
    }

    public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
    }

    public ArrayList<Vendedor> getVendedores() {
      return vendedores;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
      this.vendedores = vendedores;
    }

    public ArrayList<Cliente> getClientes() {
      return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
      this.clientes = clientes;
    }

    public ArrayList<Pedido> getPedidos() {
      return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
      this.pedidos = pedidos;
    }

    public ArrayList<Gerente> getGerentes() {
      return gerentes;
    }

    public void setGerentes(ArrayList<Gerente> gerentes) {
      this.gerentes = gerentes;
    }

}
