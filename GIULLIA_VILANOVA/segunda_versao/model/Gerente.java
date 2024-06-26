package segunda_versao.model;

public class Gerente extends Colaborador {
    private static final double BONUS = 0.35;

    public Gerente(String nome, int idade, Endereco endereco, double salarioBase, double[] salarioRecebido, Loja loja) {
        super(nome, idade, endereco, salarioBase, salarioRecebido, loja);
    }

    public void calcularSalario() {
        double salarioTotal = super.calcularMedia() + super.calcularBonus(BONUS);
        System.out.println("Salário total do gerente: " + salarioTotal);
    }
}
