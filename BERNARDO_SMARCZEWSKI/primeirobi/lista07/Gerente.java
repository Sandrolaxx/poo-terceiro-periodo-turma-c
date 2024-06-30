package primeirobi.lista07;

public class Gerente extends Pessoa {

    private double[] salarioRecebido;
    private double salarioBase;
    private Loja loja;

    public Gerente(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {

        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[] { 1800.00, 2100.00, 2500.00 };
    }

    public void apresentarse() {
        System.out.println("Gerente: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}