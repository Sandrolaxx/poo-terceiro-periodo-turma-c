package primeiro_bimestre.lista5;

public class Cliente extends Endereco{
    public int id;
    public String nome;
    public Integer idade;
    
    public Loja loja;
    public Cliente(int id,String nome, Integer idade,String estado, String cidade, String bairro, String logradouro, String numero, String complemento,Loja loja){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.loja = loja;
    };

    public void apresentarse(){
        System.out.println("Meu nome é "+nome+" tenho "+idade+" anos de idade");
    }
}
