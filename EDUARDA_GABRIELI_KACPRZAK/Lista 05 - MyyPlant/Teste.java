public class Teste {
    public static void main(String[] args) {

        Vendedor vendedor = new Vendedor("João", 30, "Loja A", "Cidade A", "Bairro A", "Rua A", 2000.0);
        Cliente cliente = new Cliente("Maria", 25, "Cidade A", "Bairro B", "Rua B");
        Loja loja = new Loja("Loja XYZ", "XYZ LTDA", "123456789", "Cidade C", "Bairro C", "Rua C");

        loja.adicionarVendedor(vendedor);
        loja.adicionarCliente(cliente);

        System.out.println("Informações do Vendedor:");
        vendedor.apresentarSe();
        System.out.println("Média dos salários recebidos: " + vendedor.calcularMedia());
        System.out.println("Bônus: " + vendedor.calcularBonus());

        System.out.println("\nInformações do Cliente:");
        cliente.apresentarSe();

        System.out.println("\nInformações da Loja:");
        loja.apresentarSe();
        System.out.println("Número de Clientes: " + loja.contarClientes());
        System.out.println("Número de Vendedores: " + loja.contarVendedores());
    }
}
