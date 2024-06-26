package primeirobi.lista07;

public class Vendedor extends Pessoa {

    private Loja loja;
    private double salarioBase;
    private double[] salarioRecebido;

    public Vendedor(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {

        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[] { 1800.00, 2100.00, 2500.00 };
    }

    public void apresentarse() {
        System.out.print("Sou o " + getNome());
        System.out.print(", tenho " + getIdade());
        System.out.println(" anos e trabalho na " + loja.getNome());
    }

    public double calcularMedia() {
        double soma = 0;
        for (int i = 0; i < salarioRecebido.length; i++) {
            soma = soma + salarioRecebido[i];
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

}