package ATV6.src;

public class Vendedor extends Pessoa {
    private double salarioBase;
    private double[] salarioRecebido;
    private double valorBonus = 0.2;
    private Loja loja;

    public Vendedor(Loja loja, String nome, int idade, String estado, String cidade, String bairro, String rua, String numero, String complemento, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, estado, cidade, bairro, rua, numero, complemento);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[salarioRecebido.length];
        System.arraycopy(salarioRecebido, 0, this.salarioRecebido, 0, salarioRecebido.length);
    }
    
    public void apresentarVendedor() {
        super.apresentarPessoa();
        System.out.println("trabalha na " + loja.getNomeFantasia() + ", localizada na ");
        loja.apresentarEndereco();
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

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
