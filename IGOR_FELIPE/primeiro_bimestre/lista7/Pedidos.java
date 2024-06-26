package primeiro_bimestre.lista7;
import java.util.Date;
import java.util.ArrayList;

public class Pedidos {
    private Integer id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private ArrayList<Item> itens = new ArrayList<>();

    public Pedidos(Integer id, Cliente cliente, ArrayList<Item> itens){
        Long diaMs = (long) 864000001;
        Long msAgora = new Date().getTime();
        Long msDaquiTresDias = msAgora + (3 * diaMs);
        
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.dataCriacao = new Date();
        this.dataVencimentoReserva = new Date(msDaquiTresDias);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
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

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public float calcularValorTotal(){
        float valorTotal = 0;
        for(int i = 0;i < itens.size();i++){
            valorTotal += itens.get(i).getValor();
        }
        System.out.println("O valor total da compra é de:"+valorTotal);
        return valorTotal;
    }

    public void descricaoVenda(){

        System.out.println("ID:"+id);
        System.out.println("Data de criação:"+dataCriacao);
        calcularValorTotal();
        if(dataPagamento == null){
            System.out.println("Pagamento não realizado!");
        }else{
            System.out.println("Pagamento realizado!");
        }
        System.out.println("------------------------");
    }
}
