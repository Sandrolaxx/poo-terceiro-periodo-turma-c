package primeiro_bimestre.lista5;

public class Endereco {
    public String estado;
    public String cidade;
    public String bairro;
    public String logradouro;
    public String numero;
    public String complemento;

    public String apresentarLogradouro(){
        return cidade+"-"+estado+" "+bairro+" "+logradouro+","+numero+" "+complemento;
    }

    /*/public Infos(String nome,Integer idade, String cidade, String bairro, String rua){
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }/*/ 
}
