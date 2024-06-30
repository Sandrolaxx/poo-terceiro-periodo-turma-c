package bimestre_1.atividade_5;

public class Main {

  public static void main(String[] args) {

    double[] salary1 = {2500, 2800, 1500};
    Vendedor vendedor1 = new Vendedor("Cleber", 15, "Myy Plant", "Cascavel", "Country", "Londrina" , 2500, salary1);

    double[] salary2 = {1600, 1900, 2100};
    Vendedor vendedor2 = new Vendedor("Zorro", 19, "Myy Plant", "Cascavel", "Santo Inacio", "João Padilha", 1600, salary2);

  

   Cliente cliente1 = new Cliente("Jefferson", 14, "São  João", "centralito", "Silver");
   Cliente cliente2 = new Cliente("Marcia", 65, "Toledo", "Naumsey", "toled");
 
  Loja minhaLoja = new Loja("Myy Plant", "Myy Plant Ltda", "003349857", "Cascavel", "Centro", "Av Brasil");

  minhaLoja.incluirVendedor(vendedor1);
  minhaLoja.incluirVendedor(vendedor2);
  minhaLoja.incluirCliente(cliente1);
  minhaLoja.incluirCliente(cliente2);


  minhaLoja.apresenteSe();

  System.out.println("Número de vendedores: " + minhaLoja.contarVendedores()) ;

  System.out.println("Número de clientes: " + minhaLoja.contarClientes()) ;

  for (Vendedor vendedor : minhaLoja.vendedores) {
    vendedor.apresentarSe();
    System.out.println("Média de salários: " + vendedor.calcularMedia());
    System.out.println("Bônus: " + vendedor.calcularBonus());
    System.out.println();

  }

  for(Cliente cliente : minhaLoja.clientes) {
    cliente.apresenteSe();
    System.out.println();
  }




  }
}
