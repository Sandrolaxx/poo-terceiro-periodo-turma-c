package bimestre_1.atividade_5;

import java.util.ArrayList;

public class Loja {

  private String fantasyName;
  private String corporateReason;
  private String cnpj;
  private String city;
  private String neighborhood;
  private String street;
  public ArrayList<Vendedor> vendedores;
  public ArrayList<Cliente> clientes;


public Loja(String fantasyName, String corporateReason, String cnpj, String city, String neighborhood, String street){

this.fantasyName = fantasyName;
this.cnpj = cnpj;
this.city = city;
this.neighborhood = neighborhood;
this.street = street;
this.corporateReason = corporateReason;
this.vendedores = new ArrayList<>();
this.clientes = new ArrayList<>();

}

public int contarClientes() {

return clientes.size(); 
}


public int contarVendedores() {

  return vendedores.size();

}

public void apresenteSe() {

  System.out.println("Nome fictício: " + fantasyName);

  System.out.println("CNPJ: " + cnpj);

  System.out.println("Endereço da loja: " + city + ", " + neighborhood + ", " + street);

}

public void incluirVendedor(Vendedor vendedor) {

vendedores.add(vendedor);

}

public void incluirCliente(Cliente cliente) {

clientes.add(cliente);

}









}



