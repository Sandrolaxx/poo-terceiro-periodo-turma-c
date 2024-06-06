package primeirob.atividadeObjeto;
// 5. Criar uma classe Pedido com:
// - Atributos, id, dataCriacao, dataPagamento, dataVencimentoReserva(a reserva vence depois de 3 dias da criação do pedido), cliente, vendedor, Loja e array de itens.
// - Método calcularValorTotal, retorna o valor total do pedido.
// - Método gerarDescricaoVenda, retorna o print informando a data de criação do pedido e seu valor total.
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String idPedido;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private  Cliente cliente;
    private  Vendedor vendedor;
    private Loja loja;
    private  ArrayList<Item> itens = new ArrayList<>();

    public Pedido(String idPedido, String dataPagamento, String dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja){
        this.idPedido = idPedido;
        this.dataCriacao = new Date();
        this.dataPagamento = parseDate(dataPagamento);
        this.dataVencimentoReserva = parseDate(dataVencimentoReserva);
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
    }

    public String getIdPedido() {
        return idPedido;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    

    private Date parseDate(String dateString){
        String dataString = dateString;
        
        String[] partes = dataString.split("/");
        
        int ano = Integer.parseInt(partes[0]) - 1900;
        int mes = Integer.parseInt(partes[1]) + 1;
        int dia = Integer.parseInt(partes[2]);
        Date dataConvertida = new Date(ano, mes, dia); // soma x + 1900 (abril ==05)
        return dataConvertida;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }
    

    public void gerarDescricaoVenda() {
        System.out.println("Data de criação do pedido: " + getDataCriacao());
        System.out.println("Valor total do pedido: " + calcularValorTotal());
    }
}
