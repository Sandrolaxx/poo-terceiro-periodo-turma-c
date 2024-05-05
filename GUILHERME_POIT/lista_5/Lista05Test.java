package lista_5;

public class Lista05Test {
    public static void main(String[] args) {
        Loja loja = new Loja("Beija Flor", "Beija Flor LTDA", 1234567892323L, "Cascavel", "Santa Cruz", "Av Brasil");

        Cliente cliente01 = new Cliente("Claudineia", 57, "Cascavel", "Cascavel Velho", "XV de Novembro");
        Cliente cliente02 = new Cliente("Angela", 45, "Cascavel", "Cascavel Velho", "XV de Novembro");

        Vendedor vendedor01 = new Vendedor("Maria", 34, "Cascavel", "Cascavel Velho", "XV de Novembro", loja, 1530);
        Vendedor vendedor02 = new Vendedor("Joana", 34, "Cascavel", "Cascavel Velho", "XV de Novembro", loja, 1680);

        loja.cadastrarCliente(cliente01);
        loja.cadastrarCliente(cliente02);
        loja.cadastrarVendedor(vendedor01);
        loja.cadastrarVendedor(vendedor02);

        vendedor01.adicionarSalarioRecebido(1590);
        vendedor01.adicionarSalarioRecebido(1635);
        vendedor01.adicionarSalarioRecebido(1650);

        vendedor02.adicionarSalarioRecebido(1640);
        vendedor02.adicionarSalarioRecebido(1675);
        vendedor02.adicionarSalarioRecebido(1700);

        System.out.println("----- Clientes ------");
        cliente01.apresentarse();
        cliente02.apresentarse();

        System.out.println("----- Vendedores ------");
        vendedor01.apresentarse();
        vendedor02.apresentarse();
        System.out.println("Calcular media: ");
        System.out.println("Media: " + vendedor01.calcularMedia());
        System.out.println("Media: " + vendedor01.calcularMedia());
        System.out.println("Calcular bonus: ");
        System.out.println("Bonus: " + vendedor01.calcularBonus());
        System.out.println("Bonus: " + vendedor02.calcularBonus());

        System.out.println("----- Loja ------");
        loja.apresentarse();
        System.out.println("Clientes: " + loja.contarClientes());
        System.out.println("Vendedores: " + loja.contarVendedores());
    }
}
