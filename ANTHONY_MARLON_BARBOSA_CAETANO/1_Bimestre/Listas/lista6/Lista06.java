import java.util.Date;

class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private double[] salarioRecebido;

    public Gerente(String nome, int idade, String loja, double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
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
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;

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

    public void gerarDescricao() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: " + valor);
    }

    public double getValor() {
        return valor;
    }
}

class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataVencimentoReserva;
    private Item[] itens;

    public Pedido(int id, Date dataCriacao, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.itens = itens;

        long tresDias = 3 * 24 * 60 * 60 * 1000L;
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + tresDias);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
}

class ProcessaPedido {
    public void processar(Pedido pedido) {
        if (confirmarPagamento(pedido)) {
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Falha ao processar pedido: reserva vencida.");
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        return !dataAtual.after(pedido.getDataVencimentoReserva());
    }
}

class Vendedor {
}

public class Lista06 {
    public static void main(String[] args) {
        Item[] itens = {new Item(1, "Produto 1", "Eletrônico", 100.00), new Item(2, "Produto 2", "Móvel", 200.00)};
        Date dataCriacao = new Date();

        Pedido pedido = new Pedido(1, dataCriacao, itens);

        ProcessaPedido processador = new ProcessaPedido();
        processador.processar(pedido);
    }
}
