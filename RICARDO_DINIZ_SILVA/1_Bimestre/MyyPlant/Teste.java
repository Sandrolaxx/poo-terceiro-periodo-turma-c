package RICARDO_DINIZ_SILVA.MyyPlant;

public class Teste {
    public static void main(String[] args) {
        Cliente cliente01 = new Cliente("Joana", 45, "Florandia", "Agua Rosa", "Av. Europa");
        Cliente cliente02 = new Cliente("Claudia", 39, "Florandia", "Agua Rosa", "Av. Atlantida");

        Vendedor vendedor01 = new Vendedor("Maria", 54, "Florandia", "Agua Rosa", "João pedro II", 1600, new double[]{1600, 1699, 1857});
        Vendedor vendedor02 = new Vendedor("Elizabete", 37, "Florandia", "Agua Rosa", "XV de novenbro", 1550, new double[]{1550, 1632, 1748});

        Loja loja = new Loja("Flor da Terra", "Flor da Terra LTDA", 88736957000141L, "Florandia", "Centro", "Rua da Conceição",
                new Vendedor[]{vendedor01, vendedor02},
                new Cliente[]{cliente01, cliente02});

        vendedor01.setLoja(loja);
        vendedor02.setLoja(loja);

        System.out.println("###### Apresentarse #######");
        System.out.println("Loja:");
        loja.apresentarse();

        System.out.println("\nVendedores:");
        vendedor01.apresentarse();
        vendedor02.apresentarse();

        System.out.println("\nClientes:");
        cliente01.apresentarse();
        cliente02.apresentarse();

        System.out.println("\n###### Contar Clientes e Vendedores #######");
        System.out.println("Clientes: ".concat(String.valueOf(loja.contarClientes())));
        System.out.println("Vendedores: ".concat(String.valueOf(loja.contarVendedores())));

        System.out.println("\n###### Calcular media e Calcular bonus #######");
        System.out.println("Calcular media:");
        System.out.println("Vendedor 1: ".concat(String.valueOf(vendedor01.calcularMedia())));
        System.out.println("Vendedor 2: ".concat(String.valueOf(vendedor02.calcularMedia())));

        System.out.println("\nCalcular bonus:");
        System.out.println("Vendedor 1: ".concat(String.valueOf(vendedor01.calcularBonus())));
        System.out.println("Vendedor 2: ".concat(String.valueOf(vendedor02.calcularBonus())));
    }
}
