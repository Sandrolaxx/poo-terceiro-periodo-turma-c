package primeiro_bimestre.prova;
import java.util.ArrayList;

public class Ingresso {

    private Integer id;
    private Cliente cliente;
    private Evento evento;
    private Float valor;
    private String tipo;
    private boolean utilizado = false;

    public Ingresso(Cliente cliente, Evento evento, int tipo, ArrayList<Ingresso> ingressos){
        this.id = ingressos.size()+1;
        this.cliente = cliente;
        this.evento = evento;
        if(tipo == 1){
            this.tipo = "Básico";
            this.valor = 100f;
        }
        if(tipo == 2){
            this.tipo = "Vip";
            this.valor = 200f;
        }
        if(tipo == 3){
            this.tipo = "Backstage";
            this.valor = 500f;
        }
    }

    public Integer getId(){
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void utilizarIngresso(){
        if(this.utilizado = false){
            System.out.println("INGRESSO JÁ FOI UTILIZADO!");
        }else{
            this.utilizado = true;
            System.out.println("INGRESSO UTILIZADO");
        }

    }
}
