package primeirob.atividadeObjeto;
import java.util.*;
import java.text.ParseException;
import java.util.Scanner;

public class Teste { 
    public static void main(String[] args) throws ParseException {
        // Criar objetos de teste
        Random ran = new Random();

        ArrayList<Item> itensCadastrados = new ArrayList<>();


        Loja loja = new Loja("Rua vermelha", "Brasilia", "Cascavel", "PR", "Loja A", "razao social 1", "1029.019201/022");
        
        Cliente cliente = new Cliente("Maria Júlia", 19,"SP","Cascavel", "Maria Luiza", "rua vermelha");

        Cliente cliente2 = new Cliente("Maria Luiza", 15,"SP","Cascavel", "Maria Luiza", "rua vermelha");

        loja.setClientes(cliente);
        loja.setClientes(cliente2);



        Vendedor vendedor = new Vendedor("Joao", 19, "SP", "Lorena", "Vila nunes", "Dolores florenzano vidal", loja.getNomeFantasia(), 10000.0);
        Vendedor vendedor2 = new Vendedor("Pedro", 19, "SP", "Lorena", "Vila nunes", "Dolores florenzano vidal", loja.getNomeFantasia(), 10000.0);

        loja.setVendedores(vendedor);
        loja.setVendedores(vendedor2);

        Gerente gerente = new Gerente("Roberta", 34,"SP","Cascavel", "Brasília", "rua 909",loja.getNomeFantasia(), 20000.0);


        Item item1 = new Item(001, "Produto A", "Produto", 50.0);
        Item item2 = new Item(002, "Produto B", "Produto", 30.0);
        itensCadastrados.add(item1);
        itensCadastrados.add(item2);
        Pedido pedido1 = new Pedido("PED123", "2021/08/12", "2021/08/12", cliente,
        vendedor, loja);


        ProcessaPedido processador = new ProcessaPedido();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int opcao;
        int idUser = 1;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar items");
            System.out.println("2. Ver items");
            System.out.println("3. Ver pedido");
            System.out.println("4. Ver clientes");
            System.out.println("5. Ver vendedorres");
            System.out.println("6. Ver gerentes");
            System.out.println("7. Ver loja");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("----- Cadastrar item -----");
                    System.out.println("----- Nome do item");
                    String opcaoCadastro = scanner2.nextLine();
                    System.out.println("----- Tipo do item");
                    String opcaoCadastro2 = scanner2.nextLine();
                    System.out.println("----- Valor do item");
                    double opcaoCadastro3 = scanner2.nextDouble();
                    scanner2.nextLine(); 
                    int id = ran.nextInt(1000);
                    Item itemX = new Item(id, opcaoCadastro, opcaoCadastro2, opcaoCadastro3);
                    itensCadastrados.add(itemX);
                    break;

                case 2:
                    System.out.println("----- items Cadastrados -----");
                    for (Item item : itensCadastrados) {
                        String idString =String.valueOf(item.getId());
                        String valor = String.valueOf(item.getValor());
                        System.out.println("ID: "
                        + idString + "\nNome: " + item.getNome() + "\nTipo: " + item.getTipo() + "\nValor: " + valor);
                        System.out.println("----");
                    }
                    break;
                case 3:
                    System.out.println("----- Pedido -----");
                    for (Item item : itensCadastrados) {
                        String idString =String.valueOf(item.getId());
                        String valor = String.valueOf(item.getValor());
                        System.out.println("ID: "
                        + idString + "\nNome: " + item.getNome() + "\nTipo: " + item.getTipo() + "\nValor: " + valor);
                        System.out.println("----");
                    }
                    while (idUser != 0){
                        System.out.println("----- COM BASE NOS ITENS INSIRA O ID DO ITEM ESCOLHIDO"); 
                        idUser = scanner.nextInt();
                        for (Item item : itensCadastrados) {
                            if (idUser == item.getId()){
                                pedido1.adicionarItem(item);
                            }
                        }
                        System.out.println("----- Insira 0 para processar o pedido ou selecione outro id ");
                    } 
                    processador.processar(pedido1);
                    break;
                case 4:
                    System.out.println("----- cliente -----");
                    cliente.apresentarse();
                    cliente2.apresentarse();
                    break;
                case 5:
                    System.out.println("----- vendedor -----");
                    vendedor.apresentarse();
                    vendedor.calcularMedia();
                    vendedor.calcularBonus();
                    vendedor2.apresentarse();
                    vendedor2.calcularMedia();
                    vendedor2.calcularBonus();
                    break;
                case 6:
                    System.out.println("----- gerente -----");
                    gerente.apresentarse();
                    gerente.calcularMedia();
                    gerente.calcularBonus();
                    break;
                case 7:
                    System.out.println("----- loja -----");
                    loja.contarVendedores();
                    loja.contarClientes();
                    loja.apresentarse();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
        scanner2.close();
        scanner.close();
    }

}
