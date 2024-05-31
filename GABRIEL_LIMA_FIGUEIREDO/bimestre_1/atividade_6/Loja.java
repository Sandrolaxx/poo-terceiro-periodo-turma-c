package bimestre_1.atividade_6;

import java.util.ArrayList;

public class Loja {

  private String fantasyName;
  private String cnpj;
  public ArrayList<Vendedor> vendedores;
  public ArrayList<Cliente> clientes;
 public Endereco endereco;

public Loja(String fantasyName, String cnpj, String state, String city, String neighborhood, String number, String complement){

this.fantasyName = fantasyName;
this.cnpj = cnpj;
this.vendedores = new ArrayList<>();
this.clientes = new ArrayList<>();
this.endereco = new Endereco(state, city, neighborhood, number, complement);


}

public int contarClientes() {

return clientes.size(); 
}


public int contarVendedores() {

  return vendedores.size();

}

public void apresenteSe() {
  System.out.println("          ENDEREÇO DA LOJA:           ");
  System.out.println(" ");
  System.out.println("Nome fictício: " + fantasyName);
  System.out.println("CNPJ: " + cnpj);
  System.out.println("endereço da Matriz:");
 this.endereco.apresentarLogradouro();
 System.out.println("-----------------------------------------");
}

public void incluirVendedor(Vendedor vendedor) {

vendedores.add(vendedor);

}

public void incluirCliente(Cliente cliente) {

clientes.add(cliente);

}









}

