package primeirobi.lista07;

public class Teste {

    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Vendedor vendedor1;
    private static Vendedor vendedor2;
    private static Loja lojaEx;

    public static void main(String[] args) {

        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", "Avenida Brasil", 1990, "");
        Endereco enderecoVendedor = new Endereco("PR", "Cascavel", "Centro", "Rio de Janeiro", 1911, "");
        Endereco enderecoCliente = new Endereco("PR", "Toledo", "Centro", "Avenida Brasil", 227, "");
        Endereco enderecoJoao = new Endereco("PR", "Cascavel", "Centro", "São Paulo", 301, "");
        Endereco enderecoLuiza = new Endereco("PR", "Cascavel", "Floresta", "Manaus", 2001, "");
        Endereco endGerente = new Endereco("PR", "Cascavel", "Country", "Vicente Machado", 1901, "");
        
        lojaEx = new Loja("MyyPlant", "Myy Plant LTDA", "1234567890", enderecoLoja);

        cliente1 = new Cliente("Joana", 33, enderecoCliente);
        vendedor1 = new Vendedor("Jorge", 39, enderecoVendedor, lojaEx, 2500.00);

        cliente2 = new Cliente("Joao", 40, enderecoJoao);
        vendedor2 = new Vendedor("Luiza", 23, enderecoLuiza, lojaEx, 2700.00);

        Gerente gerente = new Gerente("Lucas", 41, endGerente, lojaEx, 4500.00);

        lojaEx.addClientes(cliente1);
        lojaEx.addVendedores(vendedor1);
        lojaEx.addClientes(cliente2);
        lojaEx.addVendedores(vendedor2);

        System.out.println("=---=---=Loja=---=---=");
        lojaEx.apresentarse();
        lojaEx.contarClientes();
        lojaEx.contarVendedores();

        System.out.println("=---=---=Gerente=---=---=");
        gerente.apresentarse();
        gerente.calcularMedia();
        gerente.calcularBonus();

        System.out.println("=---=---=Vendedor=---=---=");
        vendedor1.apresentarse();
        System.out.println("Média dos salários recebidos: " + vendedor1.calcularMedia());
        System.out.println("Bônus do vendedor: " + vendedor1.calcularBonus());
        System.out.println(" --- ");
        vendedor2.apresentarse();
        System.out.println("Média dos salários recebidos: " + vendedor2.calcularMedia());
        System.out.println("Bônus do vendedor: " + vendedor2.calcularBonus());

        System.out.println("=---=---=Clientes=---=---=");
        cliente1.apresentarse();
        cliente2.apresentarse();

        Menu.exibirMenu();

    }

    public static Cliente getCliente1() {
        return cliente1;
    }

    public static Cliente getCliente2() {
        return cliente2;
    }

    public static Vendedor getVendedor1() {
        return vendedor1;
    }

    public static Vendedor getVendedor2() {
        return vendedor2;
    }

    public static Loja getLojaEx() {
        return lojaEx;
    }

}