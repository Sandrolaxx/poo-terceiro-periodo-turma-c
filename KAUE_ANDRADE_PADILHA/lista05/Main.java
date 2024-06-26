package lista05;

import java.util.Date;

public class Main {
  public static void main(String[] args) {
    Loja lojaA = new Loja();
    Vendedor vendedorA = new Vendedor();
    Cliente clienteA = new Cliente();

    // Vendedores
    vendedorA.nome = "Vendedor A";
    vendedorA.idade = 25;
    vendedorA.loja = lojaA;
    vendedorA.cidade = "Cidade A";
    vendedorA.bairro = "Bairro A";
    vendedorA.rua = "Rua A";
    vendedorA.salarioBase = 1150.0f;
    vendedorA.salarioRecebido[0] = 1200.0f;
    vendedorA.salarioRecebido[1] = 1350.0f;
    vendedorA.salarioRecebido[2] = 1450.0f;
    
    // Clientes
    clienteA.nome = "Cliente A";
    clienteA.idade = 30;
    clienteA.cidade = "Cidade A";
    clienteA.bairro = "Bairro A";
    clienteA.rua = "Rua A";
    
    // Lojas
    lojaA.nome = "Loja A";
    lojaA.razaoSocial = "Loja A LTDA";
    lojaA.cnpj = 123456789;
    lojaA.cidade = "Cidade A";
    lojaA.bairro = "Bairro A";
    lojaA.rua = "Rua A";
    lojaA.vendedores[0] = vendedorA;    
    lojaA.clientes[0] = clienteA;

    // Métodos
    lojaA.apresentarse();
    vendedorA.apresentarse();
    clienteA.apresentarse();
    lojaA.contarVendedores();
    lojaA.contarClientes();
    vendedorA.calcularMedia();
    vendedorA.calcularBonus();
    
    System.out.println("\n");
    // Lista 06 Testes
    Gerente gerenteA = new Gerente();
    gerenteA.nome = "Gerente A";
    gerenteA.idade = 40;
    gerenteA.loja = lojaA;
    gerenteA.cidade = "Cidade A";
    gerenteA.bairro = "Bairro A";
    gerenteA.rua = "Rua A";
    gerenteA.salarioBase = 2000.0f;
    gerenteA.salarioRecebido[0] = 2200.0f;
    gerenteA.salarioRecebido[1] = 2400.0f;
    gerenteA.salarioRecebido[2] = 2600.0f;
    gerenteA.apresentarse();
    gerenteA.calcularMedia();
    gerenteA.calcularBonus();

    Endereco endereco = new Endereco();
    endereco.cidade = "Cascavel";
    endereco.bairro = "Centro";
    endereco.rua = "Almirante Barroso";
    endereco.numero = 2000;
    endereco.complemento = "Apartamento";
    endereco.estado = "Paraná";
    endereco.apresentarLogradouro();

    Item itemA = new Item();
    itemA.id = 1;
    itemA.nome = "Item A";
    itemA.tipo = "Tipo A";
    itemA.valor = 10.0f;
    itemA.gerarDescricao();

    Pedido pedidoA = new Pedido();
    pedidoA.id = 1;
    pedidoA.dataCriacao = new Date();
    pedidoA.dataPagamento = new Date();
    pedidoA.dataVencimento = new Date();
    pedidoA.cliente = clienteA;
    pedidoA.vendedor = vendedorA;
    pedidoA.loja = lojaA;
    pedidoA.itens[0] = itemA;
    pedidoA.itens[1] = itemA;
    pedidoA.itens[2] = itemA;
    pedidoA.calcularValorTotal();
    pedidoA.gerarDescricaoVenda();

    System.out.println("\n");
    ProcessaPedido processaPedido = new ProcessaPedido();
    processaPedido.processar(pedidoA);
    processaPedido.testarMetodo(pedidoA);
  }
}