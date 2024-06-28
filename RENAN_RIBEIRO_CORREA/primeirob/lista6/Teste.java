import java.util.Calendar;
import java.util.Date;

public class Teste {
  public static void main(String[] args) {

    // Teste 1

    System.out.println("\nTESTE 1\n");

    Loja lojaDoRenan = new Loja();
    lojaDoRenan.nomeDaLoja = "Loja do Renan";
    lojaDoRenan.razaoSocial = "Renan LTDA";
    lojaDoRenan.cnpjDaLoja = 845834867;
    lojaDoRenan.cidade = "Cascavel";
    lojaDoRenan.bairro = "Centro";
    lojaDoRenan.rua = "Rua Paraná";
    
    Vendedor vendedorRenan = new Vendedor();
    vendedorRenan.nomeVendedor = "Renan";
    vendedorRenan.idadeVendedor = 20;
    vendedorRenan.loja = lojaDoRenan;
    vendedorRenan.salarioBaseVendedor = 2000f;
    vendedorRenan.salarioRecebidoVendedor[0] = 2000f;
    vendedorRenan.salarioRecebidoVendedor[1] = 3000f;
    vendedorRenan.salarioRecebidoVendedor[2] = 4000f;
    vendedorRenan.cidade = "Cascavel";
    vendedorRenan.bairro = "Centro";
    vendedorRenan.rua = "Rua Paraná";



    Vendedor vendedorTeste1 = new Vendedor();
    vendedorTeste1.nomeVendedor = "RenanTeste";
    vendedorTeste1.idadeVendedor = 67;
    vendedorTeste1.loja = lojaDoRenan;
    vendedorTeste1.salarioBaseVendedor = 2200f;
    vendedorTeste1.salarioRecebidoVendedor[0] = 2400f;
    vendedorTeste1.salarioRecebidoVendedor[1] = 3600f;
    vendedorTeste1.salarioRecebidoVendedor[2] = 4700f;
    vendedorTeste1.cidade = "Curitiba";
    vendedorTeste1.bairro = "Centro";
    vendedorTeste1.rua = "Rua Da Liberdade";

    

    Cliente clienteAlberto = new Cliente();
    clienteAlberto.nomeCliente = "Alberto Junior";
    clienteAlberto.idadeCliente = 20;
    clienteAlberto.cidade = "Cascavel";
    clienteAlberto.bairro = "Centro";
    clienteAlberto.rua = "Rua Paraná";

    lojaDoRenan.clientes[0] = clienteAlberto;
    lojaDoRenan.vendedores[0] = vendedorRenan;
    lojaDoRenan.vendedores[1] = vendedorTeste1;
    
    lojaDoRenan.apresentacao();
    vendedorRenan.apresentacao();
    vendedorTeste1.apresentacao();
    clienteAlberto.apresentacao();
    lojaDoRenan.contarNumeroClientes();
    lojaDoRenan.contarNumeroVendedores();
    vendedorRenan.calculoBonusSalario();
    vendedorRenan.calcularMediaSalario();

    // Teste 2  
    System.out.println("\nTESTE 2\n");



    Loja lojaDoFulano = new Loja();
    lojaDoFulano.nomeDaLoja = "Loja do Fulano";
    lojaDoFulano.razaoSocial = "Fulano LTDA";
    lojaDoFulano.cnpjDaLoja = 245639160;
    lojaDoFulano.cidade = "Cascavel";
    lojaDoFulano.bairro = "Centro";
    lojaDoFulano.rua = "Rua Paraná";
    
    Vendedor vendedorFulano = new Vendedor();
    vendedorFulano.nomeVendedor = "Fulano";
    vendedorFulano.idadeVendedor = 20;
    vendedorFulano.loja = lojaDoFulano;
    vendedorFulano.salarioBaseVendedor = 2000f;
    vendedorFulano.salarioRecebidoVendedor[0] = 2000f;
    vendedorFulano.salarioRecebidoVendedor[1] = 3000f;
    vendedorFulano.salarioRecebidoVendedor[2] = 4000f;
    vendedorFulano.cidade = "Cascavel";
    vendedorFulano.bairro = "Centro";
    vendedorFulano.rua = "Rua Paraná";
    

    Cliente clienteArlindo = new Cliente();
    clienteArlindo.nomeCliente = "Arlindo Souza";
    clienteArlindo.idadeCliente = 20;
    clienteArlindo.cidade = "Cascavel";
    clienteArlindo.bairro = "Centro";
    clienteArlindo.rua = "Rua Paraná";

    Cliente clienteTeste1 = new Cliente();
    clienteTeste1.nomeCliente = "Arlindo Souza";
    clienteTeste1.idadeCliente = 20;
    clienteTeste1.cidade = "Cascavel";
    clienteTeste1.bairro = "Centro";
    clienteTeste1.rua = "Rua Paraná";

    lojaDoFulano.clientes[0] = clienteArlindo;
    lojaDoFulano.clientes[1] = clienteTeste1;
    lojaDoFulano.vendedores[0] = vendedorFulano;
    
    lojaDoFulano.apresentacao();
    vendedorFulano.apresentacao();
    clienteArlindo.apresentacao();
    clienteTeste1.apresentacao();


    lojaDoFulano.contarNumeroClientes();
    lojaDoFulano.contarNumeroVendedores();
    vendedorFulano.calculoBonusSalario();
    vendedorFulano.calcularMediaSalario();


    // Teste 3

    System.out.println("\nTESTE 3\n");

    Gerente gerenteMark = new Gerente();
    gerenteMark.nome = "Mark";
    gerenteMark.idade = 30;
    gerenteMark.loja = lojaDoRenan;
    gerenteMark.salarioBase = 5000f;
    gerenteMark.salarioRecebido[0] = 5000f;
    gerenteMark.salarioRecebido[1] = 6000f;
    gerenteMark.salarioRecebido[2] = 7000f;
    gerenteMark.cidade = "Cascavel";
    gerenteMark.bairro = "Country";
    gerenteMark.rua = "Coisas da vida";
    gerenteMark.apresentar();
    gerenteMark.calculoBonusSalario();
    gerenteMark.calcularMediaSalario();

    Endereco endereco = new Endereco();
    endereco.cidade = "Cascavel";
    endereco.bairro = "Country";
    endereco.rua = "Coisas da vida";
    endereco.apresentarLocalizacao();


    Item itemQualquer = new Item();
    itemQualquer.id = 2984;
    itemQualquer.nome = "Kit Turbo Gol Bola";
    itemQualquer.tipo = "Kit Turbo";
    itemQualquer.preco = 2000f;
    itemQualquer.gerarDescricao();

    Pedido pedido = new Pedido();
    pedido.id = 1536;
    pedido.dataCriacao = new Date();
    
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.DAY_OF_YEAR, -1);
    pedido.dataPagamento = c.getTime();
    pedido.dataVencimentoReserva = new Date();
    pedido.cliente = clienteAlberto;
    pedido.vendedor = vendedorRenan;
    pedido.loja = lojaDoRenan;
    pedido.itens[0] = itemQualquer;
    pedido.itens[1] = itemQualquer;
    pedido.itens[2] = itemQualquer;
    pedido.itens[3] = itemQualquer;
    pedido.calcularValor();
    pedido.descricaoVenda();



    ProcessaPedido processaPedido = new ProcessaPedido();
    processaPedido.processar(pedido);
    processaPedido.teste(pedido);


  }

  
}