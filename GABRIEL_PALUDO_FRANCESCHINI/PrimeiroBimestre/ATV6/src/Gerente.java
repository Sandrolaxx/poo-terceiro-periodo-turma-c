package ATV6.src;

public class Gerente extends Pessoa {
    private double salarioBase;
    private double[] salarioRecebido;
    private double valorBonus = 0.35;
    private Loja loja;

    public Gerente(String nome, int idade, String estado, String cidade, String bairro, String rua, String numero, String complemento, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, estado, cidade, bairro, rua, numero, complemento);
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarGerente() {
        System.out.println("Nome: "
        .concat(this.getNome() + " - Idade: " + this.getIdade())
        .concat(", gerente da myyPlant"));
    }

    public double calcularMediaSalarial() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * valorBonus;
    }

    // Getters e setters
    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
