package bimestre_1.atividade_6;

public class zteste {

 public static void run(){
  
  
    
    float[] salary1 = {2600, 2800, 1500};
    Vendedor vendedor1 = new Vendedor("Cleber", 15, "Myy Plant", 1200, salary1, "São Paulo" , "São Paulo", "Ipanema","120", "perto do shopping");

    float[] salary2 = {1600, 1800, 2000};
    Vendedor vendedor2 = new Vendedor("Zorro", 19, "Myy Plant",1200, salary2, "PR", "Cascavel", "consolata","105", "ao lado do beco,");

  

   Cliente cliente1 = new Cliente("Jefferson", 14, "São  João", "centralito", "Silver", "20", "ao lado da escola");
   Cliente cliente2 = new Cliente("Marcia", 65, "Toledo", "Naumsey", "toled", "439", "apto 320");
 
  Loja minhaLoja = new Loja("Myy Plant", "003349857", "PR", "Cascavel", "Centro", "120","AAAAAAAAAAAA");

  Gerente gerente1 = new Gerente("Junior", 45, "Myy Plant", 3000, salary2, "PR", "Cascavel", "Centro", "127", "ao lado do shopping");

gerente1.apresentarse();

  minhaLoja.incluirVendedor(vendedor1);
  minhaLoja.incluirVendedor(vendedor2);
  minhaLoja.incluirCliente(cliente1);
  minhaLoja.incluirCliente(cliente2);


  minhaLoja.apresenteSe();
  System.out.println("    NUMERO DE VENDEDORES E CLIENTELA      ");
  System.out.println(" ");
  System.out.println("vendedores: " + minhaLoja.contarVendedores()) ;

  System.out.println("clientes: " + minhaLoja.contarClientes()) ;

  System.out.println("-----------------------------------------");
  System.out.println("     FICHA DE CADASTRO - VENDEDORES         ");
  System.out.println(" ");

  for (Vendedor vendedor : minhaLoja.vendedores) {
    vendedor.apresentarSe();
    System.out.println("Média de salários: " + vendedor.calcularMedia());
    System.out.println("Bônus: " + vendedor.calcularBonus());
    System.out.println();
   
  }
  

  for(Cliente cliente : minhaLoja.clientes) {
    System.out.println("-----------------------------------------");
    System.out.println("     FICHA DE CADASTRO - CLIENTES         ");
    System.out.println(" ");

    cliente.apresenteSe();
    System.out.println();
  }






  } 
 
  }
  

