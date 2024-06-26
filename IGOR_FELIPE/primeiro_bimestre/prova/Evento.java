package primeiro_bimestre.prova;
import java.util.Date;
import java.util.ArrayList;

public class Evento {
    private Integer id;
    private String nome;
    private Date dataEvento;

    public Evento(String nome, String date, ArrayList<Evento> eventos){
        this.id = eventos.size()+1;
        this.nome = nome;
        this.dataEvento = new Date(date);

    }

    public Integer getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void listarEventos(){
        System.out.println("ID DO EVENTO: "+id);
        System.out.println("NOME: "+nome);
        System.out.println("DATA DO EVENTO: "+dataEvento);
        

    }
}
