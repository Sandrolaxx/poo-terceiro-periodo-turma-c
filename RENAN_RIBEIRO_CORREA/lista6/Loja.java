
public class Loja extends Endereco {
  private int tamanhoVetor = 99;
  String nomeDaLoja;
  String razaoSocial;
  Integer cnpjDaLoja;
  Vendedor[] vendedores = new Vendedor[tamanhoVetor];
  Cliente[] clientes = new Cliente[tamanhoVetor];
  
  public void contarNumeroClientes() {
    int contador = 0;
    for (int i = 0; i < tamanhoVetor; i++) {
      if (clientes[i] != null) {
        contador++;
      }
    }
    System.out.println("Quantidade de clientes " + contador);
  }
  public void contarNumeroVendedores() {
    int contador = 0;
    for (int i = 0; i < tamanhoVetor; i++) {
      if (vendedores[i] != null) {
        contador += 1;
      }
    }
    System.out.println("Quantidade de vendedores: " + contador);
  }
  public void apresentacao() {
    System.out.println(
      "Loja: " + nomeDaLoja + "\nRazão Social: " + razaoSocial + "\nCNPJ: " + cnpjDaLoja + "\nCidade de " + cidade + ",\nBairro: " + bairro + "\nRua " + rua
    );
  }
}