package primeirobi.lista05;

public class Teste {
    public static void main(String[] args) {

        Endereco enderecoLoja = new Endereco("Cascavel", "Centro", "Avenida Brasil");
        Endereco enderecoVendedor = new Endereco("Cascavel", "Centro", "Rio de Janeiro");
        Endereco enderecoCliente = new Endereco("Toledo", "Centro", "Avenida Brasil");
        Endereco enderecoJoao = new Endereco("Cascavel", "Centro", "São Paulo");
        Endereco enderecoLuiza = new Endereco("Cascavel", "Floresta", "Manaus");

        Loja lojaEx = new Loja("MyyPlant", "Myy Plant LTDA", "1234567890", enderecoLoja);

        Cliente cliente1 = new Cliente("Joana", 33, enderecoCliente);
        Vendedor vendedor1 = new Vendedor("Jorge", 39, lojaEx, 2500.00, enderecoVendedor);

        Cliente cliente2 = new Cliente("Joao", 40, enderecoJoao);
        Vendedor vendedor2 = new Vendedor("Luiza", 23, lojaEx, 2700.00, enderecoLuiza);
        
        lojaEx.addClientes(cliente1);
        lojaEx.addVendedores(vendedor1);
        lojaEx.addClientes(cliente2);
        lojaEx.addVendedores(vendedor2);

        lojaEx.apresentarse();
        lojaEx.contarClientes();
        lojaEx.contarVendedores();
        System.out.println("-----------------------------------------");

        System.out.println("Vendedor:");
        vendedor1.apresentarse();
        System.out.println("Média dos salários recebidos: " + vendedor1.calcularMedia());
        System.out.println("Bônus do vendedor: " + vendedor1.calcularBonus());
        System.out.println(" --- ");
        vendedor2.apresentarse();
        System.out.println("Média dos salários recebidos: " + vendedor2.calcularMedia());
        System.out.println("Bônus do vendedor: " + vendedor2.calcularBonus());
        System.out.println("-----------------------------------------");

        System.out.println("Clientes:");
        cliente1.apresentarse();
        cliente2.apresentarse();

    }
}
