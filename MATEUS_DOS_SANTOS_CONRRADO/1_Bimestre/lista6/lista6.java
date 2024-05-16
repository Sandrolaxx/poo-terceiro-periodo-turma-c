import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class lista6 {
    static ArrayList<Venda> registroVendas = new ArrayList<>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();

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
                    criarPedido();
                    break;
                case 6:
                    System.out.println("Saindo. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 6.");
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
        System.out.println("[6] - Sair");
        System.out.print("Escolha uma opção (1, 2, 3, 4, 5 ou 6): ");
    }

    private static void calcularPrecoTotal(Scanner scanner) {
    }

    private static void calcularTroco(Scanner scanner) {
    }

    private static void registrarVendasDoMes() {
    }

    private static void registrarVenda(Scanner scanner) {
    }

    private static void criarPedido() {
    }
}

class Venda {
}

class Gerente extends Vendedor {
    private double salarioBase;
    private ArrayList<Double> salarioRecebido = new ArrayList<>();

    public Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        super(nome, idade, loja, cidade, bairro, rua);
        this.salarioBase = salarioBase;
        salarioRecebido.add(5000.0);
        salarioRecebido.add(5200.0);
        salarioRecebido.add(5500.0);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(numero + ", " + complemento + ", " + bairro + ", " + cidade + " - " + estado);
    }
}

class Vendedor {
    protected String nome;
    protected int idade;
    protected String loja;
    protected String cidade;
    protected String bairro;
    protected String rua;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }
}

class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + cidade + ", " + bairro + ", " + rua);
    }
}

class Item {
    private int id;
    private String nome;
    private String tipo;
    double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: " + valor);
    }
}

class Pedido {
    private int id;
    private Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    public Pedido(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + (3 * 24 * 60 * 60 * 1000)); // 3 dias após a criação
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.valor;
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Valor Total: " + calcularValorTotal());
    }
}

class ProcessaPedido {
    public static void processar(int idPedido, Date dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        Pedido pedido = new Pedido(idPedido, dataCriacao, cliente, vendedor, loja);
        pedido.itens.addAll(itens);
        if (confirmarPagamento(pedido)) {
            lista6.listaPedidos.add(pedido);
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Não foi possível processar o pedido.");
        }
    }

    private static boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        if (dataAtual.before(pedido.dataVencimentoReserva)) {
            pedido.dataPagamento = dataAtual;
            return true;
        } else {
            return false;
        }
    }
}
