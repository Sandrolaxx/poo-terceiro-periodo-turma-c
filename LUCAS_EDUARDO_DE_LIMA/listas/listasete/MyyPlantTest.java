package LUCAS_EDUARDO_DE_LIMA.listas.listasete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyyPlantTest {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Parana", "Cascavel", "Nova Cidade", 123, "Casa");

        Cliente cliente01 = new Cliente("Maria", 82, endereco);
        Cliente cliente02 = new Cliente("Joana", 76, endereco);

        Loja loja = new Loja("Flores do Amanhecer", "FLORES D. A. LTDA", 123400011, endereco, List.of(cliente01, cliente02), null);

        Vendedor vendedor = new Vendedor("Claudia", 55, endereco, loja, 1500, new double[]{1550, 1600, 1650});

        Gerente gerente1 = new Gerente("Cleusa", 45, endereco, loja, 1600, List.of(1700D, 1800D, 1900D));
        Gerente gerente2 = new Gerente("Juliana", 45, endereco, loja, 1600, List.of(1700D, 1800D, 1900D));

        Item item01 = new Item(1, "Lirio", "Flor", 12);
        Item item02 = new Item(2, "Gira Sol", "Flor", 12);

        ProcessaPedido processaPedido = new ProcessaPedido(loja);

        Pedido pedido = processaPedido.processar(null, cliente01, List.of(item01, item02), null);

        System.out.println("\n");
        gerente1.apresentarse();
        gerente1.calcularBonus();
        gerente1.calcularMedia();
        gerente1.setLoja(loja);
        gerente1.endereco.apresentarLogradouro();
        System.out.println("\n");
        gerente2.apresentarse();
        gerente2.calcularBonus();
        gerente2.calcularMedia();
        gerente2.setLoja(loja);
        gerente2.endereco.apresentarLogradouro();
        System.out.println("\n");
        item01.gerarDescricao();
        item02.gerarDescricao();
        System.out.println("\n");
        pedido.gerarDescricaoVenda();
        processaPedido.confirmarPagamento(pedido);
        System.out.println("\n");

        while (true) {
            int opcao = menu();

            switch (opcao) {
                case 1:
                    System.out.println("****** Cadastrar Item ******");
                    System.out.print("Nome: ");
                    String nome = new Scanner(System.in).nextLine();
                    System.out.print("Tipo: ");
                    String tipo = new Scanner(System.in).nextLine();
                    System.out.print("Valor: ");
                    double valor = new Scanner(System.in).nextDouble();

                    Item item = new Item(nome, tipo, valor);
                    loja.cadastrarItem(item);
                    System.out.println("Item cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("***** Itens *****");
                    loja.listarItens();
                    System.out.println("****** ******");
                    break;
                case 3:
                    System.out.println("**** Realizar Pedido ****");
                    List<Item> listaItens = new ArrayList<>();

                    System.out.println("Itens: ");
                    loja.listarItens();
                    System.out.println("**** ****");
                    while (true) {
                        System.out.print("Escolha um Item pelo id: ");
                        int id = new Scanner(System.in).nextInt();
                        listaItens.add(loja.selecionarItem(id));

                        System.out.print("Deseja adicionar mais itens S/N: ");
                        String continuar = new Scanner(System.in).next();

                        if (continuar.equalsIgnoreCase("N")) break;
                    }
                    System.out.print("Tem alguma loja parceira S/N: ");
                    String temLoja = new Scanner(System.in).next();

                    String lojaParceira = null;
                    if (temLoja.equalsIgnoreCase("S")) {
                        System.out.print("Qual o nome da loja parceira: ");
                        lojaParceira = new Scanner(System.in).nextLine();
                    }

                    Pedido pedido1 = processaPedido.processar(vendedor, cliente01, listaItens, lojaParceira);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    public static int menu() {
        System.out.println("****************");
        System.out.println("1 - Cadastrar Item");
        System.out.println("2 - Listar Itens");
        System.out.println("3 - Fazer Pedido");
        System.out.println("0 - Sair");
        System.out.println("****************");
        System.out.print("Selecione uma opção: ");
        return new Scanner(System.in).nextInt();
    }
}

