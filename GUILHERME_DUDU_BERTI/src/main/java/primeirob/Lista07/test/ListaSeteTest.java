package primeirob.Lista07.test;

import primeirob.Lista07.domain.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ListaSeteTest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        ProcessarPedido processador = new ProcessarPedido();

        Endereco enderecoTest = Endereco.EnderecoBuilder.builder()
                .estado("Paraná")
                .cidade("Santa Lúcia")
                .bairro("Centro")
                .rua("Avenida Orlando Luiz Zamp")
                .numero(1456)
                .complemento("Esquina")
                .build();

        Gerente gerente = Gerente.GerenteBuilder.builder()
                .nomePessoa("Vânia")
                .idade(28)
                .endereco(enderecoTest)
                .loja(null)
                .salarioBase(2200.00)
                .salarioRecebido(Arrays.asList(2200.0, 2500.0, 2000.0))
                .build();

        Vendedor vendedor1 = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Guilherme")
                .idade(18)
                .loja(null)
                .endereco(enderecoTest)
                .salarioBase(1800)
                .salarioRecebido(Arrays.asList(1800.0, 1700.0, 1850.0))
                .build();

        Vendedor vendedor2 = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Talita")
                .idade(23)
                .loja(null)
                .endereco(enderecoTest)
                .salarioBase(1900)
                .salarioRecebido(Arrays.asList(1900.0, 1900.0, 2200.0))
                .build();
        Vendedor vendedor3 = Vendedor.VendedorBuilder.builder()
                .nomePessoa("Fran")
                .idade(25)
                .endereco(enderecoTest)
                .loja(null)
                .salarioBase(2000)
                .salarioRecebido(Arrays.asList(2000.0, 2000.0, 2300.0))
                .build();

        Cliente cliente1 = Cliente.ClienteBuilder.builder()
                .nomePessoa("Fátima")
                .idade(54)
                .endereco(enderecoTest)
                .build();

        Cliente cliente2 = Cliente.ClienteBuilder.builder()
                .nomePessoa("Dalci")
                .idade(62)
                .endereco(enderecoTest)
                .build();

        Loja loja = Loja.LojaBuilder.builder()
                .nomeFantasia("Myy Plants")
                .razaoSocial("mypla")
                .cnpj("17235604000110")
                .endereco(enderecoTest)
                .vendedores(Arrays.asList(vendedor1, vendedor2, vendedor3))
                .clientes(Arrays.asList(cliente1, cliente2))
                .build();

        vendedor1.setLoja(loja);
        vendedor2.setLoja(loja);
        vendedor3.setLoja(loja);
        gerente.setLoja(loja);

        Item item1 = Item.ItemBuilder.builder()
                .id(15L)
                .nome("Electrolux LED-17")
                .tipo("Lavadora")
                .valor(2499.00)
                .build();

        Item item2 = Item.ItemBuilder.builder()
                .id(16L)
                .nome("Cafeteira Cadence")
                .tipo("Cafeteira")
                .valor(249.00)
                .build();

        Item item3 = Item.ItemBuilder.builder()
                .id(17L)
                .nome("Sanduicheira Cadence")
                .tipo("Sanduicheira")
                .valor(99.00)
                .build();
        Item item4 = Item.ItemBuilder.builder()
                .id(18L)
                .nome("Microondas Electrolux")
                .tipo("Eletrodoméstico")
                .valor(699.00)
                .build();

        Item item5 = Item.ItemBuilder.builder()
                .id(19L)
                .nome("Liquidificador Philips")
                .tipo("Eletrodoméstico")
                .valor(129.00)
                .build();

        System.out.println("\n==================== LOJA =======================");
        System.out.println(loja.apresentarse());
        System.out.println("Quantidade de clientes: " + loja.contarClientes());
        System.out.println("Quantidade de vendedores: " + loja.contarVendedores());

        System.out.println("\n==================== GERENTES =======================");
        System.out.println(gerente.apresentarse());
        System.out.println("Média salárial: " + df.format(gerente.calcularMedia()));
        System.out.println("Bônus salarial: " + df.format(gerente.calcularBonus()));

        System.out.println("\n==================== VENDEDORES =======================");
        System.out.println("Vendedor 1: ");
        System.out.println(vendedor1.apresentarse());
        System.out.println("Média salárial: " + df.format(vendedor1.calcularMedia()));
        System.out.println("Bônus salarial: " + df.format(vendedor1.calcularBonus()));

        System.out.println("\nVendedor 2: ");
        System.out.println(vendedor2.apresentarse());
        System.out.println("Média salárial: " + df.format(vendedor2.calcularMedia()));
        System.out.println("Bônus salarial: " + df.format(vendedor2.calcularBonus()));

        System.out.println("\nVendedor 3: ");
        System.out.println(vendedor3.apresentarse());
        System.out.println("Média salárial: " + df.format(vendedor3.calcularMedia()));
        System.out.println("Bônus salarial: " + df.format(vendedor3.calcularBonus()));

        System.out.println("\n==================== CLIENTES DA LOJA =======================");
        System.out.println(cliente1.apresentarse());
        System.out.println(cliente2.apresentarse());

        System.out.println("\n==================== ITENS DISPONIVEIS =======================");
        System.out.println(item1.gerarDescricao());
        System.out.println(item2.gerarDescricao());
        System.out.println(item4.gerarDescricao());
        System.out.println(item5.gerarDescricao());

        System.out.println("\n==================== PEDIDOS PROCESSADOS =======================");
        Pedido pedido1 = processador.processar(cliente1, vendedor1, loja, LocalDate.now(),
                List.of(item1, item3, item4, item5));
        Pedido pedido2 = processador.processar(cliente2, vendedor3, loja, LocalDate.now(), List.of(item5, item2));
    }
}