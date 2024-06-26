package lista04;

public class Main {
  public static void main(String[] args) {
    Loja lojaA = new Loja();
    Loja lojaB = new Loja();

    Vendedor vendedorA = new Vendedor();
    Vendedor vendedorB = new Vendedor();

    Cliente clienteA = new Cliente();
    Cliente clienteB = new Cliente();

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
    
    vendedorB.nome = "Vendedor B";
    vendedorB.idade = 30;
    vendedorB.loja = lojaB;
    vendedorB.cidade = "Cidade B";
    vendedorB.bairro = "Bairro B";
    vendedorB.rua = "Rua B";
    vendedorB.salarioBase = 1450.0f;
    vendedorB.salarioRecebido[0] = 1500.0f;
    vendedorB.salarioRecebido[1] = 1700.0f;
    vendedorB.salarioRecebido[2] = 1850.0f;
    
    // Clientes
    clienteA.nome = "Cliente A";
    clienteA.idade = 30;
    clienteA.cidade = "Cidade A";
    clienteA.bairro = "Bairro A";
    clienteA.rua = "Rua A";
    
    clienteB.nome = "Cliente B";
    clienteB.idade = 35;
    clienteB.cidade = "Cidade B";
    clienteB.bairro = "Bairro B";
    clienteB.rua = "Rua B";
    
    // Lojas
    lojaA.nome = "Loja A";
    lojaA.razaoSocial = "Loja A LTDA";
    lojaA.cnpj = 123456789;
    lojaA.cidade = "Cidade A";
    lojaA.bairro = "Bairro A";
    lojaA.rua = "Rua A";
    lojaA.vendedores[0] = vendedorA;    
    lojaA.clientes[0] = clienteA;

    lojaB.nome = "Loja B";
    lojaB.razaoSocial = "Loja B LTDA";
    lojaB.cnpj = 987654321;
    lojaB.cidade = "Cidade B";
    lojaB.bairro = "Bairro B";
    lojaB.rua = "Rua B";
    lojaB.vendedores[0] = vendedorB;
    lojaB.clientes[0] = clienteB;

    // Métodos
    lojaA.apresentarse();
    lojaB.apresentarse();

    vendedorA.apresentarse();
    vendedorB.apresentarse();

    clienteA.apresentarse();
    clienteB.apresentarse();

    lojaA.contarVendedores();
    lojaB.contarVendedores();

    lojaA.contarClientes();
    lojaB.contarClientes();

    vendedorA.calcularMedia();
    vendedorB.calcularMedia();

    vendedorA.calcularBonus();
    vendedorB.calcularBonus();
  }
}