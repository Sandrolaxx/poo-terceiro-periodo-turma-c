package lista04;

public class Loja {
  String nome;
  String cidade;
  String bairro;
  String rua;
  String razaoSocial;
  Integer cnpj;
  Vendedor[] vendedores = new Vendedor[10];
  Cliente[] clientes = new Cliente[10];

  public void contarVendedores() {
    int cont = 0;

    for (int i = 0; i < vendedores.length; i++) {
      if (vendedores[i] != null) {
        cont++;
      }
    }

    System.out.println("Número de vendedores " + nome + ": " + cont);
  }

  public void contarClientes() {
    int cont = 0;

    for (int i = 0; i < clientes.length; i++) {
      if (clientes[i] != null) {
        cont++;
      }
    }

    System.out.println("Número de clientes: " + nome + ": " + cont);
  }

  public void apresentarse() {
    String msg = "Olá, somos a loja ".concat(nome)
    .concat(", Razão Social: ").concat(razaoSocial)
    .concat(", CNPJ: ").concat(cnpj.toString())
    .concat(", Localizada na cidade: ").concat(cidade)
    .concat(", Bairro: ").concat(bairro)
    .concat(", Rua: ").concat(rua);
    System.out.println(msg);
  }
}