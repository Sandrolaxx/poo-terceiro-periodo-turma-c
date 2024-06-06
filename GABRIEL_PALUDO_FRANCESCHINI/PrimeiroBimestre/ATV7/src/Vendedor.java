package ATV7.src;

public class Vendedor extends Pessoa {
    private double salarioBase;
    private double[] salarioRecebido;
    private double valorBonus = 0.2;
    private Loja loja;

    public Vendedor(Loja loja, String nome, int idade, String estado, String cidade, String bairro, String rua, String numero, String complemento, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, estado, cidade, bairro, rua, numero, complemento);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }
    
    public void apresentarVendedor() {
        System.out.println("Nome: " + this.getNome() + " - Idade: " + this.getIdade() + ", vendedor na " + loja.getNomeFantasia());
    }

    public double calcularMediaSalarial() {
        double total = 0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * valorBonus;
    }

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