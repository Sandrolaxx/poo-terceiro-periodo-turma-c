package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

import java.util.Date;
import java.util.Scanner;

public class Pedido extends Item {

    Scanner scanner = new Scanner(System.in);

    private double[] itens = new double[5];

    private String id;

    private String nome;
    
    private Date dataCriacao = new Date();
    
    private Date dataPagamento = new Date();
    
    private Date dataVencimentoReserva = new Date(); 
    
    private String cliente;
    
    private String loja;

    private double valor;
    
    private String vendedor;

    public String[] itenss = new String[3];

    public Pedido(double[] itens, String id, String nome, String tipo, Double valor, String[] itenss,
             Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, String cliente,
            String loja,  String vendedor) {
        super(itenss, id, nome, tipo, valor);
        this.itens = itens;
        this.itenss = itenss;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.loja = loja;
        
        this.vendedor = vendedor;
    }

    void calcularValorTotal(){
        System.out.println("valor total: " + String.valueOf(valor));
    }

    void criarPedido(){
        System.out.println("qual item deseja comprar?");
        
        System.out.println(itenss[0] + itenss[1] + itenss[2]);
        
        System.out.println("qual o valor do pedido?");
        double valorPedido = scanner.nextInt();
        System.out.println("data de criacao "+ String.valueOf(dataCriacao) + ", valor: " + String.valueOf(valorPedido));
    
    }
    
    
    void gerarDescricaoVenda() {
        System.out.println("data de criacao "+ String.valueOf(dataCriacao) + ", valor: " + String.valueOf(valor));
    }

    public Scanner getScanner() {
        return scanner;
    }

    public double[] getItens() {
        return itens;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public String getLoja() {
        return loja;
    }

  

    public String getVendedor() {
        return vendedor;
    }

    
}