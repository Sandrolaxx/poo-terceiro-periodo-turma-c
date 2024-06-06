package primeirobi.lista07;

import java.util.Date;
import java.util.Scanner;

public class Pedido {

    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimento;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private Item[] itens = new Item[100];
    private int quant = 0;

    public Pedido(int id, Date dataCriacao, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        calcularDataVencimentoReserva();
    }

    private void calcularDataVencimentoReserva() {
        long tresDiasMs = 3 * 24 * 60 * 60 * 1000;
        long dataCriacaoMs = dataCriacao.getTime();
        dataVencimento = new Date(dataCriacaoMs + tresDiasMs);
    }

    public void gerarDescricaoVenda() {
        this.cliente = acharCliente();
        this.vendedor = acharVendedor();
        System.out.println("Empresa parceira: " + empresaParceira());
        System.out.println("Loja: " + loja.getNome());
        System.out.println("ID do Pedido: " + id);
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Data de Pagamento: " + dataPagamento);
        System.out.println("Data de Vencimento da Reserva: " + dataVencimento);
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Comprador: " + cliente.getNome());
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void adicionarItem(Item item) {
        itens[quant] = item;
        quant++;
    }

    public void listarPedido() {
        System.out.println("Itens adicionados ao pedido: ");
        for (int i = 0; i < quant; i++) {
            System.out.print(itens[i].getId() + ". " + itens[i].getNome());
            System.out.print(" - Valor: " + itens[i].getValor() + "R$");
            System.out.println(" - Tipo: " + itens[i].getTipo());
        }
    }

    public static String empresaParceira() {

        Scanner scanner = new Scanner(System.in);
        int empresa;

        do {
            System.out.println();
            System.out.println("=== Empresas Parceiras ===");
            System.out.println(" [1] BioTechnica");
            System.out.println(" [2] Arasaka");
            System.out.println(" [3] Militech");
            System.out.println(" [4] Nenhuma ");
            System.out.println("==========================");

            System.out.print(" -> Qual foi a empresa parceira nesse pedido?: ");
            empresa = scanner.nextInt();

            switch (empresa) {
                case 1:
                    return "BioTechnica";
                case 2:
                    return "Arasaka";
                case 3:
                    return "Militech";
                case 4:
                    return "Nenhuma";
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }

        } while (true);
    }

    public static Cliente acharCliente() {

        Scanner scanner = new Scanner(System.in);
        int cEscolhido;

        System.out.println("Qual é o cliente responsável pelo pedido? ");
        System.out.println(" [1] " + Teste.getCliente1().getNome());
        System.out.println(" [2] " + Teste.getCliente2().getNome());

        do {
            cEscolhido = scanner.nextInt();

            switch (cEscolhido) {
                case 1:
                    return Teste.getCliente1();
                case 2:
                    return Teste.getCliente2();
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }
        } while (true);

    }

    public static Vendedor acharVendedor() {

        Scanner scanner = new Scanner(System.in);
        int vEscolhido;

        System.out.println("Qual é o vendedor responsável pelo pedido? ");
        System.out.println(" [1] " + Teste.getVendedor1().getNome());
        System.out.println(" [2] " + Teste.getVendedor2().getNome());

        do {
            vEscolhido = scanner.nextInt();

            switch (vEscolhido) {
                case 1:
                    return Teste.getVendedor1();
                case 2:
                    return Teste.getVendedor2();
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }
        } while (true);
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    
}