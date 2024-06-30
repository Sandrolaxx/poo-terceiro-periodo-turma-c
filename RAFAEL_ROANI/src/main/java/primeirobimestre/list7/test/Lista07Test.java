package primeirobimestre.list7.test;

import primeirobimestre.list7.domain.domains.Loja;
import primeirobimestre.list7.generated_class.GeneretedClass;
import primeirobimestre.list7.service.LojaService;
import primeirobimestre.list7.util.MainFunctions;

import java.util.Scanner;

public class Lista07Test {
    private static Loja loja;
    private static final LojaService LOJA_SERVICE = new LojaService();
    public static void main(String[] args) {
        while (true) {
            int opcao = menuInicialLojas();

            switch (opcao) {
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                case 1 -> switchLojasCadastradas();
                case 2 -> cadastrarLoja();
            }
        }
    }

    private static int menuInicialLojas() {
        System.out.println("\n======= Menu Lojas =======");
        System.out.println("1 - Ver Lojas Cadastradas");
        System.out.println("2 - Cadastrar Loja");
        System.out.println("0 - Sair");
        System.out.println("======= ===== =======");
        System.out.println("Escolha uma opção: ");
        return new Scanner(System.in).nextInt();
    }

    private static void switchLojasCadastradas() {
        Integer opcao = menuLojasCadastradas();
        if (opcao == 0) return;
        loja = LOJA_SERVICE.findByIdOrThrowIllegalArgumentException(opcao.longValue());
        System.out.println(loja);

        while (true) {
            int opcao2 = menuInterno();
            switch (opcao2) {
                case 1 -> MainFunctions.realizarPedido(loja);
                case 2 -> MainFunctions.vizualizarPedidos(loja);
                case 3 -> MainFunctions.vizualizarItensCadastrados(loja);
                case 4 -> MainFunctions.cadastrarItem(loja);
                case 5 -> MainFunctions.vizualizarClientesCadastrados(loja);
                case 6 -> MainFunctions.cadastrarCliente(loja);
                case 7 -> MainFunctions.vizualizarVendedoresCadastrados(loja);
                case 8 -> MainFunctions.cadastrarVendedor(loja);
                case 9 -> MainFunctions.vizualizarGerentesCadastrados(loja);
                case 10 -> MainFunctions.cadastrarGerente(loja);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void cadastrarLoja() {
        System.out.println("##### Cadastrar Loja #####");
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = new Scanner(System.in).nextLine();
        System.out.print("Razão Social: ");
        String razaoSocial = new Scanner(System.in).nextLine();
        System.out.print("CNPJ: ");
        Long cnpj = new Scanner(System.in).nextLong();

        Loja loja02 = Loja.LojaBuilderLista07.builder()
                .nomeFantasia(nomeFantasia)
                .razaoSocial(razaoSocial)
                .cnpj(cnpj)
                .endereco(GeneretedClass.gerarEndereco())
                .build();

        LOJA_SERVICE.cadastrarLoja(loja02);
    }

    private static int menuLojasCadastradas() {
        System.out.println("\n======= Menu Lojas =======");
        LOJA_SERVICE.printListLojas();
        System.out.println("0 - Sair");
        System.out.println("======= ===== =======");
        System.out.println("Selecione uma loja: ");
        return new Scanner(System.in).nextInt();
    }

    private static int menuInterno() {
        System.out.println("\n####### Menu " + loja.getNomeFantasia() + " #######");
        System.out.println("1 - Realizar um Pedido");
        System.out.println("2 - Vizualizar Pedidos");
        System.out.println("3 - Visualizar Itens Cadastrados");
        System.out.println("4 - Cadastrar Item");
        System.out.println("5 - Visualizar Clientes Cadastrados");
        System.out.println("6 - Cadastrar Cliente");
        System.out.println("7 - Visualizar Vendedores Cadastrados");
        System.out.println("8 - Cadastrar Vendedor");
        System.out.println("9 - Visualizar Gerentes Cadastrados");
        System.out.println("10 - Cadastrar Gerente");
        System.out.println("0 - Voltar para Lojas");
        System.out.println("#####################");
        System.out.print("Escolha uma opção: ");
        return new Scanner(System.in).nextInt();
    }
}