package primeirobimestre.list5.test;

import primeirobimestre.list5.domain.Cliente;
import primeirobimestre.list5.domain.Loja;
import primeirobimestre.list5.domain.Vendedor;

import java.util.concurrent.ThreadLocalRandom;

public class CalduladoraLojaTest01 {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        Loja loja01 = Loja.LojaBuilderLista05.builder()
                .nomeFantasia("Primavera Flores")
                .razaoSocial("Primavera Flores LTDA")
                .cnpj(88765449000191L)
                .rua("Avenida Campo Belo")
                .cidade("Los Satos")
                .bairro("Centro")
                .build();

        Cliente cliente1 = Cliente.ClienteBuilderLista05.builder()
                .nome("Cleber")
                .idade(18)
                .rua("Das balas")
                .cidade("Los Satos")
                .bairro("Getos")
                .build();

        Cliente cliente2 = Cliente.ClienteBuilderLista05.builder()
                .nome("Marcão do Pó")
                .idade(18)
                .rua("Das pedras")
                .cidade("Los Satos")
                .bairro("Getos")
                .build();

        Vendedor vendedor01 = Vendedor.VendedorBuilderLista05.builder()
                .nome("Maria das Graças")
                .idade(63)
                .rua("Das flores")
                .cidade("Maripa")
                .bairro("Jardim europa")
                .salarioBase(1550D)
                .salarioRecebido(
                        random.nextDouble(1550, 5000),
                        random.nextDouble(1550, 5000),
                        random.nextDouble(1550, 5000))
                .loja(loja01)
                .build();

        Vendedor vendedor02 = Vendedor.VendedorBuilderLista05.builder()
                .nome("Joana da Silva")
                .idade(57)
                .rua("Das flores")
                .cidade("Maripa")
                .bairro("Jardim europa")
                .salarioBase(1420D)
                .salarioRecebido(
                        random.nextDouble(1420, 5000),
                        random.nextDouble(1420, 5000),
                        random.nextDouble(1420, 5000))
                .loja(loja01)
                .build();

        loja01.addVendedor(vendedor01);
        loja01.addVendedor(vendedor02);
        loja01.addCliente(cliente1);
        loja01.addCliente(cliente2);

        System.out.println("---------- Apresentar-se ---------");
        loja01.apresentarse();
        vendedor01.apresentarse();
        vendedor02.apresentarse();
        cliente1.apresentarse();
        cliente2.apresentarse();

        System.out.println("\n---------- Calcular Media e Calcular Bonus ---------");
        System.out.println(vendedor01.calcularMedia());
        System.out.println(vendedor02.calcularMedia());

        System.out.println(vendedor01.calcularBonus());
        System.out.println(vendedor02.calcularBonus());


        System.out.println("\n---------- Contar Clientes ---------");
        System.out.println(loja01.contarClientes());

        System.out.println("\n---------- Contar Vendedores ---------");
        System.out.println(loja01.contarVendedores());
    }
}