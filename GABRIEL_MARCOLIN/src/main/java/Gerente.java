/*
Método apresentarse deve printar o nome, idade e Loja.
*/

public class Gerente extends Pessoa {
    private Loja loja;

    private double salarioBase;

    private double[] salarioRecebido;

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome do gerente: " + getNome());
        System.out.println("Idade do gerente: " + getIdade());
        System.out.println("\nEndereco do gerente: " + getEndereco().apresentarLogradouro());
//        System.out.println("Loja em que o gerente trabalha: " + getLoja().apresentarse());
    }

    public void calcularMedia() {
        double salarios = 0;

        for (int i = 0; i < salarioRecebido.length; i++) {
            salarios += salarioRecebido[i];
        }
        salarios = (salarios / salarioRecebido.length);

        System.out.println("A média dos salários recebidos pelo gerente é de: " + salarios + " reais");
    }

    public void calcularBonus() {
        System.out.println("O bônus que o gerente irá receber é de: " + salarioBase * 0.35 + " reais");
    }
}
