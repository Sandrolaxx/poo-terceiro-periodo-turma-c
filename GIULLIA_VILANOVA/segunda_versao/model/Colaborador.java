package segunda_versao.model;

public class Colaborador extends Pessoa {
    protected double salarioBase;
    protected double[] salarioRecebido = new double[3];
    protected Loja loja;

    public Colaborador() {
        
    }

    public Colaborador(String nome, int idade, Endereco endereco, double salarioBase, double[] salarioRecebido, Loja loja) {
        super(nome, idade, endereco);
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
        this.loja = loja;
    }

    public double calcularMedia() {
        double somaSalarios = 0;
        for (double salario : salarioRecebido) {
            somaSalarios += salario;
        }
        return somaSalarios / salarioRecebido.length;
    }

    public double calcularBonus(double bonus) {
        return salarioBase * bonus;
    }

    @Override
    public void apresentarSe() {
        super.apresentarSe();
        System.out.println("Loja onde trabalha: " + getLoja());
    }

    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
