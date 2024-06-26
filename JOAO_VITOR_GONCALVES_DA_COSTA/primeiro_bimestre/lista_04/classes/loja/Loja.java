package lista_04.classes.loja;

import lista_04.classes.cliente.Cliente;
import lista_04.classes.vendedor.Vendedor;

public class Loja {
  private String nomeFantasia;
  private String cnpj;
  private String bairro;
  private String cidade;
  private String rua;
  private String razaoSocial;
  private Vendedor vendedoresDaLoja[];
  private Cliente clientesDaLoja[];

  public Loja(String nomeFantasia, String cnpj, String bairro, String cidade, String rua, String razaoSocial,
      int quantidadeDeVendedores, int quantidadeDeClientes) {
    this.nomeFantasia = nomeFantasia;
    this.cnpj = cnpj;
    this.bairro = bairro;
    this.cidade = cidade;
    this.rua = rua;
    this.razaoSocial = razaoSocial;
    this.vendedoresDaLoja = new Vendedor[quantidadeDeVendedores];
    this.clientesDaLoja = new Cliente[quantidadeDeClientes];
  }

  public void apresentarse() {
    System.out.println("Nome da loja: ".concat(this.getNomeFantasia()));
    System.out.println("CNPJ da loja: ".concat(this.getCnpj()));
    System.out.println("Endereço da loja: ".concat(this.getEndereco()));
  }

  public void contarClientesDaLoja() {
    System.out.println("Quantidade total de clientes: " + clientesDaLoja.length);
  }

  public void contarVendedoresDaLoja() {
    System.out.println("Quantidade total de vendedores: " + vendedoresDaLoja.length);
  }

  // public void mostrarVendedoresDaLoja() {
  // System.out.println("Vendedores da loja
  // ".concat(this.getNomeFantasia()).concat(":"));
  // for (int i = 0; i < this.vendedoresDaLoja.length; i++) {
  // this.vendedoresDaLoja[i].apresentarse();
  // }
  // System.out.println("\n");
  // System.out.println("<------------>");
  // }

  // public void mostrarClientesDaLoja() {
  // System.out.println("Clientes da loja
  // ".concat(this.getNomeFantasia()).concat(":"));
  // for (int i = 0; i < this.clientesDaLoja.length; i++) {
  // this.clientesDaLoja[i].apresentarse();
  // }
  // System.out.println("\n");
  // System.out.println("<------------>");
  // }

  public void adicionarVendedores(Vendedor... vendedores) {
    if (vendedores.length == this.vendedoresDaLoja.length) {
      for (int i = 0; i < this.vendedoresDaLoja.length; i++) {
        this.vendedoresDaLoja[i] = vendedores[i];
      }
    } else {
      System.out.println("Quantidade de vendedores passada não corresponde à quantidade definida anteriormente.");
    }
  }

  public void adicionarClientes(Cliente... clientes) {
    if (clientes.length == this.clientesDaLoja.length) {
      for (int i = 0; i < this.clientesDaLoja.length; i++) {
        this.clientesDaLoja[i] = clientes[i];
      }
    } else {
      System.out.println("Quantidade de clientes passada não corresponde à quantidade definida anteriormente.");
    }
  }

  // GETTERS

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public String getRua() {
    return rua;
  }

  public String getEndereco() {
    String enderco = this.getRua().concat(", " + this.getBairro()).concat(", " + getCidade());
    return enderco;
  }
}
