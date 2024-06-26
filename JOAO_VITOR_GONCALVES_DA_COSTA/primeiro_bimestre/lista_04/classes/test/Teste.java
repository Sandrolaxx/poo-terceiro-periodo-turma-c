package lista_04.classes.test;

import lista_04.classes.cliente.Cliente;
import lista_04.classes.loja.Loja;
import lista_04.classes.vendedor.Vendedor;

public class Teste {
  public static void run() {
    // Criação dos clientes
    Cliente cliente_01 = new Cliente("Sandro", "Tropical", "Cascavel", "Fortaleza, 312", 25);

    Cliente cliente_02 = new Cliente("Marcio", "Country", "Cascavel", "Guido Viaro, 312", 29);

    Cliente cliente_03 = new Cliente("Marcelo", "Neva", "Cascavel", "Pio XII", 19);

    Cliente cliente_04 = new Cliente("João", "Dos guri", "Curitiba", "Nasus, 312", 23);

    Cliente cliente_05 = new Cliente("Pereira", "Dos gurizes", "Porto Alegre", "Nasus o Grande , 312", 35);

    // Fim da criação dos clientes clientes

    // Criando as lojas

    Loja loja_01 = new Loja("Myy Plant", "51.568.234/0001-05", "Centro", "Cascavel", "Av. Brasil, 1200",
        "Plantinhas da veia", 3, 3);

    Loja loja_02 = new Loja("As Plantas", "14.645.182/8901-05", "Centro", "Curitiba", "Av. Nasus, 1200",
        "Plantinhas da veia", 1, 1);

    Loja loja_03 = new Loja("The Plantas", "95.498.562/4983-12", "Dos gurizes", "Porto Alegre", "Nasus o Gigante , 200",
        "Plantinhas da veia", 2, 1);

    // Fim das lojas

    // Criação dos vendedores
    Vendedor vendedores_01 = new Vendedor("Cleber", "de Cria", "Cascavel", "do mano, 132", 50, 5, 2500);

    Vendedor vendedores_02 = new Vendedor("Kaio", "Country", "Cascavel", "Guido Viaro, 100", 35, 3, 1545);

    Vendedor vendedores_03 = new Vendedor("Rengar", "Manitos", "Cascavel", "Verde, 213", 40, 6, 6000);

    Vendedor vendedores_04 = new Vendedor("Marcos", "Dos piá", "Porto Alegre", "Papi o Melhor, 953", 25, 7, 4000);

    Vendedor vendedores_05 = new Vendedor("Kisame", "Samehada", "Curitiba", "itachi, 1231", 49, 10, 4250);

    Vendedor vendedores_06 = new Vendedor("Itachi", "Uchira", "Curitiba", "Aggron, 1231", 49, 1, 1450.54);
    // Fim da criação dos vendedores

    // Atribuindo vendedores para as lojas
    loja_01.adicionarVendedores(vendedores_01, vendedores_02, vendedores_03);
    loja_02.adicionarVendedores(vendedores_04);
    loja_03.adicionarVendedores(vendedores_05, vendedores_06);
    // Fim da atribuição de vendedores para as lojas

    // Atribuindo clientes para as lojas
    loja_01.adicionarClientes(cliente_01, cliente_02, cliente_03);
    loja_02.adicionarClientes(cliente_04);
    loja_03.adicionarClientes(cliente_05);
    // Fim da atribuição de clientes para as lojas

    // Atribuindo loja para o vendedor
    vendedores_01.setLojaEmqueTrabalha(loja_01);
    vendedores_02.setLojaEmqueTrabalha(loja_01);
    vendedores_03.setLojaEmqueTrabalha(loja_01);
    vendedores_04.setLojaEmqueTrabalha(loja_02);
    vendedores_05.setLojaEmqueTrabalha(loja_03);
    vendedores_06.setLojaEmqueTrabalha(loja_03);
    // Fim da atribuição da loja para o vendedor

    // Apresentar todos
    System.out.println("<-----------Clientes----------->");
    cliente_01.apresentarse();
    System.out.println("\n");
    cliente_02.apresentarse();
    System.out.println("\n");
    cliente_03.apresentarse();
    System.out.println("\n");
    cliente_04.apresentarse();
    System.out.println("\n");
    cliente_05.apresentarse();
    System.out.println("\n");

    System.out.println("<-----------Lojas----------->");
    loja_01.apresentarse();
    loja_01.contarClientesDaLoja();
    loja_01.contarVendedoresDaLoja();
    System.out.println("\n");

    loja_02.apresentarse();
    loja_02.contarClientesDaLoja();
    loja_02.contarVendedoresDaLoja();
    System.out.println("\n");

    loja_03.apresentarse();
    loja_03.contarClientesDaLoja();
    loja_03.contarVendedoresDaLoja();
    System.out.println("\n");

    System.out.println("<-----------Vendedores----------->");

    vendedores_01.apresentarse(); // 5
    vendedores_01.adicionarSalarios(1250, 6532, 4959, 7899, 1234);
    vendedores_01.calcularMedia();
    vendedores_01.calcularBonus();

    System.out.println("\n");

    vendedores_02.apresentarse(); // 3
    vendedores_02.adicionarSalarios(1250, 6532, 4959);
    vendedores_02.calcularMedia();
    vendedores_02.calcularBonus();

    System.out.println("\n");

    vendedores_03.apresentarse(); // 6
    vendedores_03.adicionarSalarios(1250, 6532, 4959, 7899, 1234, 9875);
    vendedores_03.calcularMedia();
    vendedores_03.calcularBonus();

    System.out.println("\n");

    vendedores_04.apresentarse(); // 7
    vendedores_04.adicionarSalarios(1250, 6532, 4959, 7899, 1234, 1264, 7896);
    vendedores_04.calcularMedia();
    vendedores_04.calcularBonus();

    System.out.println("\n");

    vendedores_05.apresentarse(); // 10
    vendedores_05.adicionarSalarios(1250, 6532, 4959, 7899, 1234, 936, 4521, 1245, 1520, 1453);
    vendedores_05.calcularMedia();
    vendedores_05.calcularBonus();

    System.out.println("\n");

    vendedores_06.apresentarse(); // 3
    vendedores_06.adicionarSalarios(1250, 1250, 1250);
    vendedores_06.calcularMedia();
    vendedores_06.calcularBonus();
    // Fim do apresentar todos
  }
}
