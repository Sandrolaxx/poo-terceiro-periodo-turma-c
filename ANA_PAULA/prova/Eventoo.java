package ANA_PAULA.prova;
import java.util.Date;
import java.util.Scanner;

public class Eventoo {
    public static Scanner ler = new Scanner(System.in);
    private String nomeev = "ShowLINDO";
    private String cidade = "São Paulo";
    private Date data;
    

    public Eventoo(String nomeev, String cidade, Date data){
        this.nomeev = nomeev;
        this.cidade = cidade;
        this.data = data;
    }
    public void apresentarse(){
        System.out.println("Nome do evento: " + nomeev);
        System.out.println("Cidade do : " + cidade );
        System.out.println("Data: " + data);
        
    }
    public String getNomeev(){
        return nomeev;
    }
    public void setNomeev(String nomeev){
        this.nomeev = nomeev;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public Date getData(){
        return data;
    }
    public void setData(Date data){
        this.data = data;
    }
    public void Venda(){
        System.out.println("Data do evento: " + data);
    }

}
