package primeiro_bimestre.lista5;

public class Gerente extends Endereco{
    public int id;
    public String nome;
    public Integer idade;
    public Loja loja;
    public Float salarioBase;
    public Float[] salarioRecebido = new Float[3];

    public Gerente(int id,String nome, Integer idade, String estado, String cidade, String bairro, String logradouro, String numero, String complemento, Loja loja, float salarioBase, float sal1, float sal2, float sal3) {
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
        this.salarioBase = salarioBase;
        this.salarioRecebido[0] = sal1;
        this.salarioRecebido[1] = sal2;
        this.salarioRecebido[2] = sal3;
    }



    public void apresentarse(){
        System.out.println("Meu nome é "+nome+" tenho "+idade+" anos e sou gerente na loja "+loja.nomeFantasia);
    }
    public void calcularMedia(){
        System.out.println("A média do salário é de R$"+(salarioRecebido[0]+salarioRecebido[1]+salarioRecebido[2])/3);
    }
    public void calcularBonus(){
        System.out.println("O bonus do salário será de R$"+salarioBase*0.35);
    }
}
