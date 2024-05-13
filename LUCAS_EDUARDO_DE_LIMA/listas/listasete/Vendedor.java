package LUCAS_EDUARDO_DE_LIMA.listas.listasete;

 /*1. Crie uma classe Vendedor com:

Com os atributos nome, idade, Loja, cidade, rua, bairro,  salarioBase e salarioRecebido.
Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.(Pode colocar no código os valores*)
Métodos apresentarse calcularMedia e calcularBonus.
Método apresentarse deve printar o nome, idade e Loja.
calcularMedia deve trazer a média dos salários.
calcularBonus onde a formulá é [salarioBase * 0.2]*/

public class Vendedor extends Pessoa {

    Loja loja;
    double salarioBase;
    double[] salarioRecebido = new double[3];

    public Vendedor(String nome, Integer idade, Endereco endereco, Loja loja, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void adicionarSalarioRecebido(double salarioum, double salariodois, double salariotres) {
        salarioRecebido[0] = salarioum;
        salarioRecebido[1] = salariodois;
        salarioRecebido[2] = salariotres;

    }

    public double calcularMedia() {
        return (salarioRecebido[0] + salarioRecebido[1] + salarioRecebido[2]) / 3;
    }

    public double calcularBonus() {
        return (salarioBase * 0.02);
    }


    @Override
    public void apresentarse() {
        System.out.println("O meu nome é " + nome + " eu tenho " + idade + " anos e trabalho na loja " + loja.getNomeFantasia());
    }

}
