import LUIZ_COLMAN.src;
public class TesteMyyPlant {

    public static void main(String[] args) {

        // Criar endereço
        Endereco enderecoVendedor = new Endereco("Rua das Flores", "123", "Centro", "Cascavel", "PR");
        Endereco enderecoCliente = new Endereco("Rua das Hortênsias", "1011", "Bairro Alto", "Cascavel", "PR");

        // Criar loja
        Loja myyPlant = new Loja("Myy Plant", "Myy Plant LTDA", "12345678901234", enderecoVendedor);

        // Criar vendedores
        Vendedor vendedor1 = new Vendedor("João", 30, myyPlant, enderecoVendedor, 2000.0);
        vendedor1.adicionarSalario(2100.0);
        vendedor1.adicionarSalario(2200.0);

        Vendedor vendedor2 = new Vendedor("Maria", 25, myyPlant, enderecoVendedor, 1800.0);
        vendedor2.adicionarSalario(1900.0);
        vendedor2.adicionarSalario(2000.0);

        // Criar clientes
        Cliente cliente1 = new Cliente("Ana", 40, enderecoCliente);
        Cliente cliente2 = new Cliente("Pedro", 35, enderecoCliente);

        // Adicionar vendedores e clientes à loja
        myyPlant.adicionarVendedor(vendedor1);
        myyPlant.adicionarVendedor(vendedor2);
        myyPlant.adicionarCliente(cliente1);
        myyPlant.adicionarCliente(cliente2);

        // Apresentar informações da loja
        myyPlant.apresentar();
        System.out.println("Número de vendedores: " + myyPlant.contarVendedores());
        System.out.println("Número de clientes: " + myyPlant.contarClientes());

        // Apresentar informações do vendedor 1
        vendedor1.apresentar();
        System.out.println("Média salarial: R$" + vendedor1.calcularMediaSalario());
        System.out.println("Bônus: R$" + vendedor1.calcularBonus());

        // Apresentar informações do cliente 1
        cliente1.apresentar();

    }
}
