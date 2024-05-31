package lista_06.classes.loja;

import lista_06.classes.cliente.Cliente;
import lista_06.classes.endereco.Endereco;
import lista_06.classes.gerente.Gerente;
import lista_06.classes.vendedor.Vendedor;

public class Loja {
  private String nomeFantasia;
  private String cnpj;
  private Endereco endereco;
  private String razaoSocial;
  private Vendedor vendedoresDaLoja[];
  private Gerente gerenteDaLoja;
  private Cliente clientesDaLoja[];

  public Loja(String nomeFantasia, String cnpj, String bairro, String cidade, String rua, String estado, String numero,
      String complemento, String razaoSocial,
      int quantidadeDeVendedores, int quantidadeDeClientes) {
    this.nomeFantasia = nomeFantasia;
    this.cnpj = cnpj;
    this.endereco = new Endereco(rua, estado, cidade, bairro, numero, complemento);
    this.razaoSocial = razaoSocial;
    this.vendedoresDaLoja = new Vendedor[quantidadeDeVendedores];
    this.clientesDaLoja = new Cliente[quantidadeDeClientes];
  }

  public void apresentarse() {
    System.out.println("Nome da loja: ".concat(this.getNomeFantasia()));
    System.out.println("CNPJ da loja: ".concat(this.getCnpj()));
    System.out.println("Endereço da loja: ");
    this.endereco.apresentarLogradouro();
  }

  public void contarClientesDaLoja() {
    System.out.println("Quantidade total de clientes: " + clientesDaLoja.length);
  }

  public void contarVendedoresDaLoja() {
    if (this.gerenteDaLoja != null) {
      System.out.println("Quantidade total de vendedores: " + (vendedoresDaLoja.length + 1));
      return;
    }
    System.out.println("Quantidade total de vendedores: " + vendedoresDaLoja.length);
  }

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

  public String getRazaoSocial() {
    return razaoSocial;
  }

  // SETTERS

  public void setGerenteDaLoja(Gerente gerenteDaLoja) {
    this.gerenteDaLoja = gerenteDaLoja;
  }
}
