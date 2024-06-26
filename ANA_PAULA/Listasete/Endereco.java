package Listasete;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;
    
    public Endereco(String estado, String cidade, String bairro, int numero, String complemento){
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro(){
        String enderecoCompleto = numero + " " + complemento + ", " + bairro + ", " + cidade + ", " + estado;
        System.out.println("Endereço: " + enderecoCompleto);
    }
    
    public String getestado(){
        return estado;
    }
    public void setestado(String estado){
        this.estado = estado;
    }
    public String getcidade(){
        return cidade;
    }
    public void setcidade(String cidade){
        this.cidade = cidade;
    }
    public String getbairro(){
        return bairro;
    }
    public void setbairro(String bairro){
        this.bairro = bairro;
    }
    public int getnumero(){
        return numero;
    }
    public void setnumero(int numero){
        this.numero = numero;
    }
    public String getcomplemento(){
        return complemento;
    }
    public void setcomplemento(String complemento){
        this.complemento = complemento;
    }
}
