import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class lista7 {
    static ArrayList<Venda> registroVendas = new ArrayList<>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    static ArrayList<Item> listaItens = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    registrarVendasDoMes();
                    break;
                case 4:
                    registrarVenda(scanner);
                    break;
                case 5:
                    criarPedido(scanner);
                    break;
                case 6:
                    cadastrarItem(scanner);
                    break;
                case 7:
                    listarItens();
                    break;
                case 8:
                    System.out.println("Saindo. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 8.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Registrar Vendas do Mês");
        System.out.println("[4] - Registrar Venda");
        System.out.println("[5] - Criar Pedido");
        System.out.println("[6] - Cadastro de Itens");
        System.out.println("[7] - Listar Itens");
        System.out.println("[8] - Sair");
        System.out.print("Escolha uma opção (1 a 8): ");
    }

    private static void calcularPrecoTotal(Scanner scanner) {
    }

    private static void calcularTroco(Scanner scanner) {
    }

    private static void registrarVendasDoMes() {
    }

    private static void registrarVenda(Scanner scanner) {
    }

    private static void criarPedido(Scanner scanner) {
    }

    private static void cadastrarItem(Scanner scanner) {
        System.out.println("Cadastro de Item:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        Item item = new Item(id, nome, tipo, valor);
        listaItens.add(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    private static void listarItens() {
        System.out.println("Lista de Itens:");
        for (Item item : listaItens) {
            System.out.println(item);
        }
    }
}

class Venda {
}

class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor;
    }
}

class Pedido {
}

class ProcessaPedido {
    public static void processar(int idPedido, Date dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja, Item item) {
    }

    private static boolean confirmarPagamento(Pedido pedido) {
        return false;
    }
}
