package primeiro_bimestre.lista7;

public class Cliente extends Pessoa{
    private int id;
    private Loja loja;

    public Cliente(int id,String nome, Integer idade,Loja loja, Endereco endereco){
        this.id = id;
        setNome(nome);
        setIdade(idade);
        this.loja = loja;
        setEndereco(endereco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void apresentarse(){
        System.out.println("Meu nome é "+getNome()+" tenho "+getIdade()+" anos de idade");
    }
}
