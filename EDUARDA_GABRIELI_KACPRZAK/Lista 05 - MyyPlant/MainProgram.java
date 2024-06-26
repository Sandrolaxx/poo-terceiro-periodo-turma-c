import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da loja:");
        String nomeLoja = scanner.nextLine();

        System.out.println("Digite a razão social da loja:");
        String razaoSocial = scanner.nextLine();

        System.out.println("Digite o CNPJ da loja:");
        String cnpj = scanner.nextLine();

        System.out.println("Digite a cidade da loja:");
        String cidade = scanner.nextLine();

        System.out.println("Digite o bairro da loja:");
        String bairro = scanner.nextLine();

        System.out.println("Digite a rua da loja:");
        String rua = scanner.nextLine();

        Loja loja = new Loja(nomeLoja, razaoSocial, cnpj, cidade, bairro, rua);

        System.out.println("Digite o nome do vendedor:");
        String nomeVendedor = scanner.nextLine();

        System.out.println("Digite a idade do vendedor:");
        int idadeVendedor = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o salário base do vendedor:");
        double salarioBaseVendedor = Double.parseDouble(scanner.nextLine());

        Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, nomeLoja, cidade, bairro, rua, salarioBaseVendedor);

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite a idade do cliente:");
        int idadeCliente = Integer.parseInt(scanner.nextLine());

        Cliente cliente = new Cliente(nomeCliente, idadeCliente, cidade, bairro, rua);

        loja.adicionarVendedor(vendedor);
        loja.adicionarCliente(cliente);

        System.out.println("\nInformações da Loja:");
        loja.apresentarSe();
        System.out.println("\nVendedor:");
        vendedor.apresentarSe();
        System.out.println("\nCliente:");
        cliente.apresentarSe();
        System.out.println("\nNúmero de Clientes: " + loja.contarClientes());
        System.out.println("Número de Vendedores: " + loja.contarVendedores());

        scanner.close();
    }
}
