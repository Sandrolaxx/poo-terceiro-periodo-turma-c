package primeiro_bimestre.lista7;

public class Vendedor extends Pessoa{
    private int id;
    private Loja loja;
    private Float salarioBase;
    private Float[] salarioRecebido = new Float[3];

    public Vendedor(int id, String nome, Integer idade, Endereco endereco,Loja loja, Float salarioBase, Float sal1, Float sal2, Float sal3){
        this.id = id;
        setNome(nome); 
        setIdade(idade);
        setEndereco(endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido[0] = sal1;
        this.salarioRecebido[1] = sal2;
        this.salarioRecebido[2] = sal3;
    }

    public Integer getId(){
        return this.id;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Float[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(Float[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarse(){
        System.out.println("Meu nome é "+getNome()+" tenho "+getIdade()+" anos e trabalho na loja "+loja.getNomeFantasia());
    }
    public void calcularMedia(){
        System.out.println("A média do salário é de R$"+(salarioRecebido[0]+salarioRecebido[1]+salarioRecebido[2])/3);
    }
    public void calcularBonus(){
        System.out.println("O bonus do salário será de R$"+salarioBase*0.2);
    }
}


