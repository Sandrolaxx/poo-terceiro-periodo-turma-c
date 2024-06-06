package lista5;

public class Teste {
    public static void main(String[] args) {

        
        // Definindo endereços
        Endereco enderecoLoja = new Endereco("Estado A", "Cidade A", "Bairro A", "123", "Loja 1");
        Endereco enderecoVendedor1 = new Endereco("Estado B", "Cidade B", "Bairro B", "456", "Apartamento 2A");
        Endereco enderecoVendedor2 = new Endereco("Estado C", "Cidade C", "Bairro C", "789", "Casa 3B");
        Endereco enderecoCliente1 = new Endereco("Estado D", "Cidade D", "Bairro D", "101112", "Bloco E");
        Endereco enderecoCliente2 = new Endereco("Estado E", "Cidade E", "Bairro E", "131415", "Sala 4F");

        // Definindo vendedores
        Vendedor vendedor1 = new Vendedor("João", 30, "Loja A", enderecoVendedor1, 2000.0, new double[]{2200.0, 2300.0, 2400.0});
        Vendedor vendedor2 = new Vendedor("Maria", 35, "Loja B", enderecoVendedor2, 2200.0, new double[]{2400.0, 2500.0, 2600.0});

        // Definindo clientes
        Cliente cliente1 = new Cliente("Carlos", 25, enderecoCliente1);
        Cliente cliente2 = new Cliente("Ana", 40, enderecoCliente2);

        // Definindo gerente
        Gerente gerente = new Gerente("José", 45, "Loja C", enderecoLoja, 3000.0, new double[]{3200.0, 3300.0, 3400.0});

        // Definindo loja
        Loja loja = new Loja("Plantas & Cia", "Plantas e Acessórios Ltda", "123456789", enderecoLoja, new Vendedor[]{vendedor1, vendedor2}, new Cliente[]{cliente1, cliente2});

        // Executando métodos
        System.out.println("Informações da Loja:");
        loja.apresentarSe();
        System.out.println();

        System.out.println("Quantidade de Vendedores na Loja: " + loja.contarVendedores());
        System.out.println("Quantidade de Clientes na Loja: " + loja.contarClientes());
        System.out.println();

        System.out.println("Apresentação dos Vendedores:");
        for (Vendedor vendedor : loja.getVendedores()) {
            vendedor.apresentarSe();
            System.out.println("Média dos Salários Recebidos: " + vendedor.calcularMedia());
            System.out.println("Bônus: " + vendedor.calcularBonus());
            System.out.println();
        }

        System.out.println("Apresentação dos Clientes:");
        for (Cliente cliente : loja.getClientes()) {
            cliente.apresentarSe();
            System.out.println();
        }

        System.out.println("Apresentação do Gerente:");
        gerente.apresentarSe();
        System.out.println("Média dos Salários Recebidos: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());
    }
}
