import java.util.ArrayList;
import java.util.Date;

// Classe Endereco
class Endereco {
    String estado;
    String cidade;
    String bairro;
    int numero;
    String complemento;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(numero + ", " + complemento + ", " + bairro + ", " + cidade + ", " + estado);
    }
}

// Classe Pessoa (para ser usada como superclasse de Cliente, Vendedor e Gerente)
class Pessoa {
    String nome;
    int idade;
    String loja;

    public Pessoa(String nome, int idade, String loja) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }
}

// Classe Gerente
class Gerente extends Pessoa {
    String rua;
    double salarioBase;
    ArrayList<Double> salarioRecebido;

    public Gerente(String nome, int idade, String loja, String rua, double salarioBase, ArrayList<Double> salarioRecebido) {
        super(nome, idade, loja);
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
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

// Classe Item
class Item {
    int id;
    String nome;
    String tipo;
    double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor);
    }
}

// Classe Pedido
class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    String loja;
    ArrayList<Item> itens;

    public Pedido(int id, Cliente cliente, Vendedor vendedor, String loja, ArrayList<Item> itens) {
        this.id = id;
        this.dataCriacao = new Date();
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + (3 * 24 * 60 * 60 * 1000)); // 3 dias em milissegundos
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.valor;
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de criação: " + dataCriacao);
        System.out.println("Valor total do pedido: " + calcularValorTotal());
    }
}

// Classe ProcessaPedido
class ProcessaPedido {
    public void processar(int id, Cliente cliente, Vendedor vendedor, String loja, ArrayList<Item> itens) {
        Pedido pedido = new Pedido(id, cliente, vendedor, loja, itens);
        // Realizar processamento do pedido...
        confirmarPagamento(pedido);
    }

    private void confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        if (dataAtual.before(pedido.dataVencimentoReserva)) {
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida. Não é possível confirmar o pagamento.");
        }
    }
}

// Classe Cliente
class Cliente extends Pessoa {
    public Cliente(String nome, int idade, String loja) {
        super(nome, idade, loja);
    }
}

// Classe Vendedor
class Vendedor extends Pessoa {
    public Vendedor(String nome, int idade, String loja) {
        super(nome, idade, loja);
    }
}

// Classe principal (Main)
public class Main {
    public static void main(String[] args) {
        // Exemplo de uso das classes
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", 123, "Rua A");
        endereco.apresentarLogradouro();

        ArrayList<Double> salarios = new ArrayList<>();
        salarios.add(3000.0);
        salarios.add(3200.0);
        salarios.add(3100.0);
        Gerente gerente = new Gerente("Carlos", 40, "Loja 1", "Rua B", 5000, salarios);
        gerente.apresentarSe();
        System.out.println("Média salarial: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        Item item = new Item(1, "Camisa", "Vestuário", 50.0);
        item.gerarDescricao();

        Cliente cliente = new Cliente("João", 30, "Loja 1");
        Vendedor vendedor = new Vendedor("Maria", 25, "Loja 1");

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Camisa", "Vestuário", 50.0));
        itens.add(new Item(2, "Calça", "Vestuário", 80.0));

        ProcessaPedido processador = new ProcessaPedido();
        processador.processar(1, cliente, vendedor, "Loja 1", itens);
    }
}

